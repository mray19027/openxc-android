package com.chrysler.mhacks6demo;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.openxc.VehicleManager;
import com.openxc.measurements.Measurement;
import com.openxc.measurements.cluster.AmbientTemp;
import com.openxc.measurements.cluster.FuelConsumed;
import com.openxc.measurements.cluster.FuelLevel;
import com.openxc.measurements.cluster.Odometer;
import com.openxc.measurements.cluster.OilPressure;
import com.openxc.measurements.cluster.TurnSignalStatus;
import com.openxc.measurements.cluster.VehicleSpeed;
import com.openxc.measurements.diagnostic.BatteryVoltage;
import com.openxc.measurements.diagnostic.IntakeAirTemp;
import com.openxc.measurements.engine.EngineCoolTemp;
import com.openxc.measurements.engine.EngineOilTemp;
import com.openxc.measurements.engine.EngineSpeed;
import com.openxc.measurements.infotainment.ScreenPressX;
import com.openxc.measurements.infotainment.ScreenPressY;
import com.openxc.measurements.tires.TireFLPressure;
import com.openxc.measurements.tires.TireFLStatus;
import com.openxc.measurements.tires.TireFRPressure;
import com.openxc.measurements.tires.TireFRStatus;
import com.openxc.measurements.tires.TireRLPressure;
import com.openxc.measurements.tires.TireRLStatus;
import com.openxc.measurements.tires.TireRRPressure;
import com.openxc.measurements.tires.TireRRStatus;
import com.openxc.measurements.transmission.TorqueAtTransmission;
import com.openxc.measurements.transmission.TransmissionGearPosition;

public class VehicleConnection implements ServiceConnection {
    private VehicleManager vehicleManager;
    private CarDataPacket carDataPacket;

    public VehicleConnection() {
        carDataPacket = new CarDataPacket();
    }

    public CarDataPacket getCarDataPacket() { return carDataPacket; }
    public void setCarDataPacket(CarDataPacket carDataPacket) { this.carDataPacket = carDataPacket; }

    public VehicleManager getVehicleManager() { return vehicleManager; }
    public void setVehicleManager(VehicleManager newManager) { vehicleManager = newManager; }

    public void addListeners() {
        Log.d("MHacks6Demo", "Adding listeners");
        vehicleManager.addListener(ScreenPressX.class, mScreenPressX);
        vehicleManager.addListener(ScreenPressX.class, mScreenPressY);
        vehicleManager.addListener(EngineCoolTemp.class, mEngineCoolTemp);
        vehicleManager.addListener(EngineOilTemp.class, mEngineOilTemp);
        vehicleManager.addListener(EngineSpeed.class, mEngineSpeed);
        vehicleManager.addListener(TireFLPressure.class, mTireFLPressure);
        vehicleManager.addListener(TireFRPressure.class, mTireFRPressure);
        vehicleManager.addListener(TireRLPressure.class, mTireRLPressure);
        vehicleManager.addListener(TireRRPressure.class, mTireRRPressure);
        vehicleManager.addListener(TireFLStatus.class, mTireFLStatus);
        vehicleManager.addListener(TireFRStatus.class, mTireFRStatus);
        vehicleManager.addListener(TireRLStatus.class, mTireRLStatus);
        vehicleManager.addListener(TireRRStatus.class, mTireRRStatus);
        vehicleManager.addListener(TorqueAtTransmission.class, mTorqueAtTransmission);
        vehicleManager.addListener(TransmissionGearPosition.class, mTransmissionGearPosition);
        vehicleManager.addListener(BatteryVoltage.class, mBatteryVoltage);
        vehicleManager.addListener(IntakeAirTemp.class, mIntakeAirTemp);
        vehicleManager.addListener(AmbientTemp.class, mAmbientTemp);
        vehicleManager.addListener(FuelConsumed.class, mFuelConsumed);
        vehicleManager.addListener(FuelLevel.class, mFuelLevel);
        vehicleManager.addListener(Odometer.class, mOdometer);
        vehicleManager.addListener(OilPressure.class, mOilPressure);
        vehicleManager.addListener(TurnSignalStatus.class, mTurnSignalStatus);
        vehicleManager.addListener(VehicleSpeed.class, mVehicleSpeed);
    }

    public void removeListeners() {
        Log.d("MHacks6Demo", "Removing listeners");
        vehicleManager.removeListener(ScreenPressX.class, mScreenPressX);
        vehicleManager.removeListener(ScreenPressY.class, mScreenPressY);
        vehicleManager.removeListener(EngineCoolTemp.class, mEngineCoolTemp);
        vehicleManager.removeListener(EngineOilTemp.class, mEngineOilTemp);
        vehicleManager.removeListener(EngineSpeed.class, mEngineSpeed);
        vehicleManager.removeListener(TireFLPressure.class, mTireFLPressure);
        vehicleManager.removeListener(TireFRPressure.class, mTireFRPressure);
        vehicleManager.removeListener(TireRLPressure.class, mTireRLPressure);
        vehicleManager.removeListener(TireRRPressure.class, mTireRRPressure);
        vehicleManager.removeListener(TireFLStatus.class, mTireFLStatus);
        vehicleManager.removeListener(TireFRStatus.class, mTireFRStatus);
        vehicleManager.removeListener(TireRLStatus.class, mTireRLStatus);
        vehicleManager.removeListener(TireRRStatus.class, mTireRRStatus);
        vehicleManager.removeListener(TorqueAtTransmission.class, mTorqueAtTransmission);
        vehicleManager.removeListener(TransmissionGearPosition.class, mTransmissionGearPosition);
        vehicleManager.removeListener(BatteryVoltage.class, mBatteryVoltage);
        vehicleManager.removeListener(IntakeAirTemp.class, mIntakeAirTemp);
        vehicleManager.removeListener(AmbientTemp.class, mAmbientTemp);
        vehicleManager.removeListener(FuelConsumed.class, mFuelConsumed);
        vehicleManager.removeListener(FuelLevel.class, mFuelLevel);
        vehicleManager.removeListener(Odometer.class, mOdometer);
        vehicleManager.removeListener(OilPressure.class, mOilPressure);
        vehicleManager.removeListener(TurnSignalStatus.class, mTurnSignalStatus);
        vehicleManager.removeListener(VehicleSpeed.class, mVehicleSpeed);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d("MHacks6Demo", "VehicleManager connecting");
        vehicleManager = ((VehicleManager.VehicleBinder) service).getService();
        addListeners();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d("MHacks6Demo", "VehicleManager disconnecting");
        removeListeners();
        vehicleManager = null;
    }

    private ScreenPressX.Listener mScreenPressX = new ScreenPressX.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getInfotainment().setScreenX(((ScreenPressX) measurement).getValue());
        }
    };

    private ScreenPressY.Listener mScreenPressY = new ScreenPressY.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getInfotainment().setScreenY(((ScreenPressY) measurement).getValue());
        }
    };

    private EngineCoolTemp.Listener mEngineCoolTemp = new EngineCoolTemp.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getEngine().setEngineCoolTemp(((EngineCoolTemp) measurement).getValue());
        }
    };

    private EngineOilTemp.Listener mEngineOilTemp = new EngineOilTemp.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getEngine().setEngineOilTemp(((EngineOilTemp) measurement).getValue());
        }
    };

    private EngineSpeed.Listener mEngineSpeed = new EngineSpeed.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getEngine().setEngineSpeed(((EngineSpeed) measurement).getValue());
        }
    };

    private TireFLPressure.Listener mTireFLPressure = new TireFLPressure.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getTire().setTirePressure(((TireFLPressure) measurement).getValue(), CarDataPacket.Tire.FRONTLEFT);
        }
    };

    private TireFRPressure.Listener mTireFRPressure = new TireFRPressure.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getTire().setTirePressure(((TireFRPressure) measurement).getValue(), CarDataPacket.Tire.FRONTRIGHT);
        }
    };

    private TireRLPressure.Listener mTireRLPressure = new TireRLPressure.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getTire().setTirePressure(((TireRLPressure) measurement).getValue(), CarDataPacket.Tire.REARLEFT);
        }
    };

    private TireRRPressure.Listener mTireRRPressure = new TireRRPressure.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getTire().setTirePressure(((TireRRPressure) measurement).getValue(), CarDataPacket.Tire.REARRIGHT);
        }
    };

    private TireFLStatus.Listener mTireFLStatus = new TireFLStatus.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getTire().setTireStatus(((TireFLStatus) measurement).getValue().enumValue(), CarDataPacket.Tire.FRONTLEFT);
        }
    };

    private TireFRStatus.Listener mTireFRStatus = new TireFRStatus.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getTire().setTireStatus(((TireFRStatus) measurement).getValue().enumValue(), CarDataPacket.Tire.FRONTRIGHT);
        }
    };

    private TireRLStatus.Listener mTireRLStatus = new TireRLStatus.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getTire().setTireStatus(((TireRLStatus) measurement).getValue().enumValue(), CarDataPacket.Tire.REARLEFT);
        }
    };

    private TireRRStatus.Listener mTireRRStatus = new TireRRStatus.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getTire().setTireStatus(((TireRRStatus) measurement).getValue().enumValue(), CarDataPacket.Tire.REARRIGHT);
        }
    };

    private TorqueAtTransmission.Listener mTorqueAtTransmission = new TorqueAtTransmission.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getTransmission().setTorqueAtTransmission(((TorqueAtTransmission) measurement).getValue());
        }
    };

    private TransmissionGearPosition.Listener mTransmissionGearPosition = new TransmissionGearPosition.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getTransmission().setTransmissionGearPosition(((TransmissionGearPosition) measurement).getValue().enumValue());
        }
    };

    private BatteryVoltage.Listener mBatteryVoltage = new BatteryVoltage.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getDiagnostic().setBatteryVoltage(((BatteryVoltage) measurement).getValue());
        }
    };

    private IntakeAirTemp.Listener mIntakeAirTemp = new IntakeAirTemp.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getDiagnostic().setIntakeAirTemp(((IntakeAirTemp) measurement).getValue());
        }
    };

    private AmbientTemp.Listener mAmbientTemp = new AmbientTemp.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getCluster().setAmbientTemp(((AmbientTemp) measurement).getValue());
        }
    };

    private FuelConsumed.Listener mFuelConsumed = new FuelConsumed.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getCluster().setFuelConsumed(((FuelConsumed) measurement).getValue());
        }
    };

    private FuelLevel.Listener mFuelLevel = new FuelLevel.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getCluster().setFuelLevel(((FuelLevel) measurement).getValue());
        }
    };

    private Odometer.Listener mOdometer = new Odometer.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getCluster().setOdometer(((Odometer) measurement).getValue());
        }
    };

    private OilPressure.Listener mOilPressure = new OilPressure.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getCluster().setOilPressure(((OilPressure) measurement).getValue());
        }
    };

    private TurnSignalStatus.Listener mTurnSignalStatus = new TurnSignalStatus.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getCluster().setTurnSignalPosition(((TurnSignalStatus) measurement).getValue().enumValue());
        }
    };

    private VehicleSpeed.Listener mVehicleSpeed = new VehicleSpeed.Listener() {
        @Override
        public void receive(Measurement measurement) {
            carDataPacket.getCluster().setVehicleSpeed(((VehicleSpeed) measurement).getValue());
        }
    };
}
