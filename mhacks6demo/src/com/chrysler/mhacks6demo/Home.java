package com.chrysler.mhacks6demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import com.chrysler.t0826mr.mhacks6demo.R;
import com.openxc.VehicleManager;

public class Home extends Activity {
    private VehicleConnection vehicleConnection;
    private UserInterface ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        vehicleConnection = new VehicleConnection();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ui = new UserInterface(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (vehicleConnection.getVehicleManager() == null) {
            Intent intent = new Intent(this, VehicleManager.class);
            bindService(intent, vehicleConnection, Context.BIND_AUTO_CREATE);
        }
        startRepeatingTask();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (vehicleConnection.getVehicleManager() != null) {
            vehicleConnection.removeListeners();
            unbindService(vehicleConnection);
            vehicleConnection.setVehicleManager(null);
        }
        stopRepeatingTask();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startRepeatingTask() { mHandlerTask.run(); }
    private void stopRepeatingTask() { mHandler.removeCallbacks(mHandlerTask); }

    private final static int INTERVAL = 250;
    private Handler mHandler = new Handler();

    Runnable mHandlerTask = new Runnable() {
        @Override
        public void run() {
            CarListener task = new CarListener();
            task.execute();
            mHandler.postDelayed(mHandlerTask, INTERVAL);
        }
    };

    private class CarListener extends AsyncTask<Void, Void, CarDataPacket> {
        @Override
        protected CarDataPacket doInBackground(Void...params) {
            return vehicleConnection.getCarDataPacket();
        }

        @Override
        protected void onPostExecute(CarDataPacket cdp) {
            ui.simulateTouch(findViewById(R.id.container));

            //TODO utilize information from the Car data packet
            ui.updateCarDataPacket(cdp);
            ui.refreshScreen();
        }
    }
}
