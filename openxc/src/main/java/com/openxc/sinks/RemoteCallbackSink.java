package com.openxc.sinks;

import java.util.Map;

import com.google.common.base.Objects;

import com.openxc.remote.RawMeasurement;

import com.openxc.remote.RemoteVehicleServiceListenerInterface;

import android.os.RemoteCallbackList;
import android.os.RemoteException;

import android.util.Log;

/**
 * A data sink that sends new measurements through an AIDL interface.
 *
 * This sink is used to send all new measurements over an AIDL interface in
 * Android to applications using {@link com.openxc.VehicleService}. Once
 * registered, a receiver gets all measurements regardless of their type or
 * value.
 */
public class RemoteCallbackSink extends AbstractQueuedCallbackSink {
    private final static String TAG = "RemoteCallbackSink";

    private int mListenerCount;
    private RemoteCallbackList<RemoteVehicleServiceListenerInterface>
            mListeners;

    public RemoteCallbackSink() {
        super();
        mListeners = new RemoteCallbackList<
            RemoteVehicleServiceListenerInterface>();
    }

    public synchronized void register(
            RemoteVehicleServiceListenerInterface listener) {
        synchronized(mListeners) {
            mListeners.register(listener);
            ++mListenerCount;
        }

        // send the last known value of all measurements to the new listener
        for(Map.Entry<String, RawMeasurement> entry :
                mMeasurements.entrySet()) {
            try {
                listener.receive(entry.getKey(), entry.getValue());
            } catch(RemoteException e) {
                Log.w(TAG, "Couldn't notify application " +
                        "listener -- did it crash?", e);
                break;
            }
        }
    }

    public void unregister(RemoteVehicleServiceListenerInterface listener) {
        synchronized(mListeners) {
            mListeners.unregister(listener);
            --mListenerCount;
        }
    }

    public int getListenerCount() {
        return mListenerCount;
    }


    protected void propagateMeasurement(String measurementId,
            RawMeasurement measurement) {
        synchronized(mListeners) {
            int i = mListeners.beginBroadcast();
            while(i > 0) {
                i--;
                try {
                    mListeners.getBroadcastItem(i).receive(measurementId,
                            measurement);
                } catch(RemoteException e) {
                    Log.w(TAG, "Couldn't notify application " +
                            "listener -- did it crash?", e);
                }
            }
            mListeners.finishBroadcast();
        }
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("numListeners", getListenerCount())
            .toString();
    }
};
