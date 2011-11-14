package com.openxc.remote;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import java.net.URISyntaxException;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multimap;

import com.openxc.remote.RemoteVehicleServiceListenerInterface;

import com.openxc.remote.sources.ManualVehicleDataSource;
import com.openxc.remote.sources.VehicleDataSourceCallbackInterface;
import com.openxc.remote.sources.VehicleDataSourceInterface;

import android.app.Service;

import android.content.Intent;

import java.net.URI;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import android.util.Log;

public class RemoteVehicleService extends Service {
    private final static String TAG = "RemoteVehicleService";
    public final static String DATA_SOURCE_NAME_EXTRA = "data_source";
    public final static String DATA_SOURCE_RESOURCE_EXTRA =
            "data_source_resource";
    private final static String DEFAULT_DATA_SOURCE =
        ManualVehicleDataSource.class.getName();

    private Map<String, Double> mNumericalMeasurements;
    private Map<String, String> mStateMeasurements;
    private VehicleDataSourceInterface mDataSource;

    private Multimap<String, RemoteVehicleServiceListenerInterface> mListeners;

    VehicleDataSourceCallbackInterface mCallback =
        new VehicleDataSourceCallbackInterface() {
            public void receive(String name, double value) {
                mNumericalMeasurements.put(name, value);
            }

            public void receive(String name, String value) {
                mStateMeasurements.put(name, value);
            }
        };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service starting");
        mNumericalMeasurements = new HashMap<String, Double>();
        mStateMeasurements = new HashMap<String, String>();

        mListeners = HashMultimap.create();
        mListeners = Multimaps.synchronizedMultimap(mListeners);
    }

    @Override
    public void onDestroy() {
        if(mDataSource != null) {
            mDataSource.stop();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "Service binding in response to " + intent);
        Bundle extras = intent.getExtras();
        String dataSource = DEFAULT_DATA_SOURCE;
        String resource = null;
        if(extras != null) {
            dataSource = intent.getExtras().getString(
                    DATA_SOURCE_NAME_EXTRA);
            resource = intent.getExtras().getString(
                    DATA_SOURCE_RESOURCE_EXTRA);
        }
        initializeDataSource(dataSource, resource);
        return mBinder;
    }

    private void initializeDataSource(String dataSourceName, String resource) {
        Class<? extends VehicleDataSourceInterface> dataSourceType;
        try {
            dataSourceType = Class.forName(dataSourceName).asSubclass(
                    VehicleDataSourceInterface.class);
        } catch(ClassNotFoundException e) {
            Log.w(TAG, "Couldn't find data source type " + dataSourceName, e);
            return;
        }

        Constructor<? extends VehicleDataSourceInterface> constructor;
        try {
            constructor = dataSourceType.getConstructor(
                    VehicleDataSourceCallbackInterface.class, URI.class);
        } catch(NoSuchMethodException e) {
            Log.w(TAG, dataSourceType + " doesn't have a proper constructor");
            return;
        }

        URI resourceUri = null;
        if(resource != null) {
            try {
                resourceUri = new URI(resource);
            } catch(URISyntaxException e) {
                Log.w(TAG, "Unable to parse resource as URI " + resource);
            }
        }

        try {
            mDataSource = constructor.newInstance(mCallback, resourceUri);
        } catch(InstantiationException e) {
            Log.w(TAG, "Couldn't instantiate data source " + dataSourceType, e);
        } catch(IllegalAccessException e) {
            Log.w(TAG, "Default constructor is not accessible on " +
                    dataSourceType, e);
        } catch(InvocationTargetException e) {
            Log.w(TAG, dataSourceType + "'s constructor threw an exception",
                    e);
        }

        if(mDataSource != null) {
            Log.i(TAG, "Initializing vehicle data source " + mDataSource);
            new Thread(mDataSource).start();
        }
    }

    private final RemoteVehicleServiceInterface.Stub mBinder =
        new RemoteVehicleServiceInterface.Stub() {
            public RawNumericalMeasurement getNumericalMeasurement(
                    String measurementType) throws RemoteException {
                return new RawNumericalMeasurement(mNumericalMeasurements.get(
                        measurementType));
            }

            public RawStateMeasurement getStateMeasurement(
                    String measurementType) throws RemoteException {
                return new RawStateMeasurement(
                        mStateMeasurements.get(measurementType));
            }

            public void addListener(String measurementType,
                    RemoteVehicleServiceListenerInterface listener) {
                Log.i(TAG, "Adding listener " + listener + " to " +
                        measurementType);
                mListeners.put(measurementType, listener);
            }

            public void removeListener(String measurementType,
                    RemoteVehicleServiceListenerInterface listener) {
                Log.i(TAG, "Removing listener " + listener + " from " +
                        measurementType);
                mListeners.put(measurementType, listener);
            }
        };
}
