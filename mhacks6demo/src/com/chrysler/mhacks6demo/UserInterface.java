package com.chrysler.mhacks6demo;

import android.app.Activity;
import android.widget.TextView;

import com.chrysler.t0826mr.mhacks6demo.R;

public class UserInterface {
    private Activity activity;
    private CarDataPacket cdp;

    public UserInterface(Activity activity) {
        this.activity = activity;
    }

    public void updateCarDataPacket(CarDataPacket cdp) {
        this.cdp = cdp;
    }

    public void refreshScreen() {
        TextView engine = (TextView)activity.findViewById(R.id.engine);
        engine.setText(cdp.getEngine().toString());
        TextView infotainment = (TextView)activity.findViewById(R.id.infotainment);
        infotainment.setText(cdp.getInfotainment().toString());
        TextView tire = (TextView)activity.findViewById(R.id.tire);
        tire.setText(cdp.getTire().toString());
        TextView transmission = (TextView)activity.findViewById(R.id.transmission);
        transmission.setText(cdp.getTransmission().toString());
        TextView vehicle = (TextView)activity.findViewById(R.id.vehicle);
        vehicle.setText(cdp.getVehicle().toString());
    }
}
