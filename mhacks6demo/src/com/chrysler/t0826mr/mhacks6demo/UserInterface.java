package com.chrysler.t0826mr.mhacks6demo;

import android.app.Activity;
import android.widget.TextView;

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
        TextView screenX = (TextView)activity.findViewById(R.id.screenX);
        screenX.setText("ScreenX: " + cdp.getScreenX());
        TextView screenY = (TextView)activity.findViewById(R.id.screenY);
        screenY.setText("ScreenY: " + cdp.getScreenY());
    }
}
