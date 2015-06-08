package com.chrysler.t0826mr.mhacks6demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.openxc.VehicleManager;

public class Home extends Activity {
    private com.chrysler.t0826mr.mhacks6demo.VehicleConnection vehicleConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        vehicleConnection = new com.chrysler.t0826mr.mhacks6demo.VehicleConnection();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
            Listen task = new Listen();
            task.execute();
            mHandler.postDelayed(mHandlerTask, INTERVAL);
        }
    };

    private class Listen extends AsyncTask<Void, Void, com.chrysler.t0826mr.mhacks6demo.CarDataPacket> {
        @Override
        protected com.chrysler.t0826mr.mhacks6demo.CarDataPacket doInBackground(Void...params) {
            return vehicleConnection.getAllData();
        }

        @Override
        protected void onPostExecute(com.chrysler.t0826mr.mhacks6demo.CarDataPacket cdp) {
            TextView screenX = (TextView)findViewById(R.id.screenX);
            screenX.setText("ScreenX: " + cdp.getScreenX());
            TextView screenY = (TextView)findViewById(R.id.screenY);
            screenY.setText("ScreenY: " + cdp.getScreenY());
        }
    }
}
