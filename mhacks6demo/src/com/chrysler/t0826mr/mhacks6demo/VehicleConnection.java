package com.chrysler.t0826mr.mhacks6demo;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.openxc.VehicleManager;
import com.openxc.measurements.Measurement;
import com.openxc.measurements.ScreenPressX;
import com.openxc.measurements.ScreenPressY;
import com.openxc.units.Coordinate;

public class VehicleConnection implements ServiceConnection {
    private VehicleManager vehicleManager;
    private Coordinate screenX, screenY;

    public VehicleConnection() { }

    public VehicleManager getVehicleManager() { return vehicleManager; }
    public void setVehicleManager(VehicleManager newManager) { vehicleManager = newManager; }

    public void addListeners() {
        vehicleManager.addListener(ScreenPressX.class, mScreenPressX);
        Log.d("MHacks6Demo", "Successfully listening to: ScreenPressX");
        vehicleManager.addListener(ScreenPressX.class, mScreenPressY);
        Log.d("MHacks6Demo", "Successfully listening to: ScreenPressY");
    }

    public void removeListeners() {
        vehicleManager.removeListener(ScreenPressX.class, mScreenPressX);
        Log.d("MHacks6Demo", "Stopped listening to: ScreenPressX");
        vehicleManager.removeListener(ScreenPressY.class, mScreenPressY);
        Log.d("MHacks6Demo", "Stopped listening to: ScreenPressY");
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d("MHacks6Demo", "VehicleManager connecting");
        vehicleManager = ((VehicleManager.VehicleBinder) service).getService();
        Log.d("MHacks6Demo", "Adding listeners");
        addListeners();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d("MHacks6Demo", "VehicleManager disconnecting");
        Log.d("MHacks6Demo", "Removing listeners");
        removeListeners();
        vehicleManager = null;
    }

    private ScreenPressX.Listener mScreenPressX = new ScreenPressX.Listener() {
        //enum states are OFF, ACCESSORY, START, RUN
        @Override
        public void receive(Measurement measurement) {
            ScreenPressX screenXStatus = (ScreenPressX) measurement;
            VehicleConnection.this.screenX = screenXStatus.getValue();
        }
    };

    private ScreenPressY.Listener mScreenPressY = new ScreenPressY.Listener() {
        //enum states are OFF, ACCESSORY, START, RUN
        @Override
        public void receive(Measurement measurement) {
            ScreenPressY screenYStatus = (ScreenPressY) measurement;
            VehicleConnection.this.screenY = screenYStatus.getValue();
        }
    };

    public CarDataPacket getAllData() {
        CarDataPacket cdp = new CarDataPacket();
        cdp.setScreenX(screenX);
        cdp.setScreenY(screenY);
        return cdp;
    }
}
