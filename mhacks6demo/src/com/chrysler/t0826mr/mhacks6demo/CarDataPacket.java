package com.chrysler.t0826mr.mhacks6demo;

import com.openxc.units.Coordinate;

public class CarDataPacket {
    private Coordinate screenX, screenY;

    public CarDataPacket() { }

    public Coordinate getScreenX() { return screenX; }
    public void setScreenX(Coordinate screenX) { this.screenX = screenX; }

    public Coordinate getScreenY() { return screenY; }
    public void setScreenY(Coordinate screenY) { this.screenY = screenY; }

}
