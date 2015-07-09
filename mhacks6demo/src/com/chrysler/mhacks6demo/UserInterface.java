package com.chrysler.mhacks6demo;

import android.app.Activity;
import android.view.View;
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
        TextView cluster = (TextView)activity.findViewById(R.id.cluster);
        cluster.setText(cdp.getCluster().toString());
        TextView lighting = (TextView)activity.findViewById(R.id.lighting);
        lighting.setText(cdp.getLighting().toString());
        TextView userControl = (TextView)activity.findViewById(R.id.userControl);
        userControl.setText(cdp.getUserControl().toString());
    }

    public void simulateTouch(View masterView) {
        //TODO differentiate from the screen coordinates what is a false touch or not, and then filter results to only simulate on an actual touch
        /*
        long downTime = SystemClock.uptimeMillis();
        long eventTime = SystemClock.uptimeMillis() + 100;
        int metaState = 0;
        MotionEvent motionEvent = MotionEvent.obtain(
                downTime,
                eventTime,
                MotionEvent.ACTION_UP,
                cdp.getInfotainment().getScreenX().intValue(),
                cdp.getInfotainment().getScreenY().intValue(),
                metaState
        );
        masterView.dispatchTouchEvent(motionEvent);
        */
    }
}
