package com.chrysler.mhacks6demo;

import com.openxc.units.Celsius;
import com.openxc.units.Coordinate;
import com.openxc.units.Degree;
import com.openxc.units.Kilometer;
import com.openxc.units.KilometersPerHour;
import com.openxc.units.KilopascalGauge;
import com.openxc.units.Liter;
import com.openxc.units.MetersPerSecondSquared;
import com.openxc.units.NewtonMeter;
import com.openxc.units.PSI;
import com.openxc.units.Percentage;
import com.openxc.units.RotationsPerMinute;
import com.openxc.units.Volt;
import com.openxc.wrappers.BrakePedalPosition;
import com.openxc.wrappers.GearPosition;
import com.openxc.wrappers.IgnitionPosition;
import com.openxc.wrappers.PaddleShifterPosition;
import com.openxc.wrappers.SwitchState;
import com.openxc.wrappers.TireStatus;
import com.openxc.wrappers.TurnSignalPosition;

/**
 * Car data packet containing all vehicle information from the CAN bus
 * @author Ray, Michael (FCA)
 * @version 1
 * @since 06/11/2015
 */
public class CarDataPacket {
    private Engine engine;
    private Tire tire;
    private Infotainment infotainment;
    private Transmission transmission;
    private Cluster cluster;
    private Diagnostic diagnostic;
    private Lighting lighting;
    private UserControl userControl;

    public CarDataPacket() {
        tire = new Tire();
        engine = new Engine();
        infotainment = new Infotainment();
        transmission = new Transmission();
        cluster = new Cluster();
        diagnostic = new Diagnostic();
        lighting = new Lighting();
        userControl = new UserControl();
    }

    /**
     * Get infotainment information
     * @return infotainment object
     */
    public Infotainment getInfotainment() { return this.infotainment; }

    /**
     * Set infotainment information
     * @param infotainment infotainment object
     */
    public void setInfotainment(Infotainment infotainment) { this.infotainment = infotainment; }

    /**
     * Get engine information
     * @return engine object
     */
    public Engine getEngine() { return this.engine; }

    /**
     * Set engine information
     * @param engine engine object
     */
    public void setEngine(Engine engine) { this.engine = engine; }

     /**
     * Get transmission information
     * @return transmission object
     */
    public Transmission getTransmission() { return this.transmission; }

    /**
     * Set transmission information
     * @param transmission transmission object
     */
    public void setTransmission(Transmission transmission) { this.transmission = transmission; }

    /**
     * Get tire information
     * @return tire object
     */
    public Tire getTire() { return this.tire; }

    /**
     * Set tire information
     * @param tire tire object
     */
    public void setTire(Tire tire) { this.tire = tire; }

    /**
     * Get cluster information
     * @return cluster object
     */
    public Cluster getCluster() { return this.cluster; }

    /**
     * Set cluster information
     * @param cluster cluster object
     */
    public void setCluster(Cluster cluster) { this.cluster = cluster; }

    /**
     * Get diagnostic information
     * @return diagnostic object
     */
    public Diagnostic getDiagnostic() { return this.diagnostic; }

    /**
     * Set diagnostic information
     * @param diagnostic diagnostic object
     */
    public void setDiagnostic(Diagnostic diagnostic) { this.diagnostic = diagnostic; }

    /**
     * Get lighting information
     * @return lighting object
     */
    public Lighting getLighting() { return this.lighting; }

    /**
     * Set lighting information
     * @param lighting lighting object
     */
    public void setLighting(Lighting lighting) { this.lighting = lighting; }

    /**
     * Get user control information
     * @return user control object
     */
    public UserControl getUserControl() { return this.userControl; }

    /**
     * Set user control information
     * @param userControl user control object
     */
    public void setUserControl(UserControl userControl) { this.userControl = userControl; }

    /**
     * <b>Engine class</b><br>
     * Contains engine coolant temperature, engine oil temperature, and engine speed
     *
     * @see Celsius
     * @see RotationsPerMinute
     */
    public class Engine {
        private Celsius engineCoolTemp, engineOilTemp;
        private RotationsPerMinute engineSpeed;

        /**
         * Initialize sensor data to defaults
         */
        public Engine() {
            engineCoolTemp = new Celsius(0);
            engineOilTemp = new Celsius(0);
            engineSpeed = new RotationsPerMinute(0);
        }

        /**
         * Get engine coolant temperature
         * @return engine coolant temp in degrees celsius
         */
        public Celsius getEngineCoolTemp() { return engineCoolTemp; }

        /**
         * Set engine coolant temperature
         * @param engineCoolTemp engine coolant temp in degrees celsius
         */
        public void setEngineCoolTemp(Celsius engineCoolTemp) { this.engineCoolTemp = engineCoolTemp; }

        /**
         * Get engine oil temperature
         * @return engine oil temp in degrees celsius
         */
        public Celsius getEngineOilTemp() { return engineOilTemp; }

        /**
         * Set engine oil temperature
         * @param engineOilTemp engine oil temp in degrees celsius
         */
        public void setEngineOilTemp(Celsius engineOilTemp) { this.engineOilTemp = engineOilTemp; }

        /**
         * Get engine speed
         * @return engine speed in rotations per min
         */
        public RotationsPerMinute getEngineSpeed() { return engineSpeed; }

        /**
         * Set engine speed
         * @param engineSpeed engine speed in rotations per min
         */
        public void setEngineSpeed(RotationsPerMinute engineSpeed) { this.engineSpeed = engineSpeed; }

        /**
         * Converts the engine object to a string<br>
         * <pre>    Engine coolant temperature: 0 C<br>    Engine oil temperature: 0 C<br>    Engine speed: 0 RPM</pre>
         * @return Engine string
         */
        @Override
        public String toString() {
            return "Engine coolant temperature: " + engineCoolTemp.toString() + "\nEngine oil temperature: " + engineCoolTemp.toString()
                    + "\nEngine speed: " + engineSpeed.toString();
        }
    }

    /**
     * <b>Tire class</b><br>
     * Contains tire pressures and tire sensor statuses
     *
     * @see PSI
     * @see TireStatus
     */
    public class Tire {
        private PSI[] tirePressure;
        private TireStatus[] tireStatus;
        public static final int FRONTLEFT = 0, FRONTRIGHT = 1, REARLEFT = 2, REARRIGHT = 3;

        /**
         * Initialize sensor data to defaults
         */
        public Tire() {
            tirePressure = new PSI[4];
            for (int i=0; i<4; i++) tirePressure[i] = new PSI(0);
            tireStatus = new TireStatus[4];
            for (int i=0; i<4; i++) tireStatus[i] = TireStatus.SNA;
        }

        /**
         * Get array of tire pressures
         * @return array of PSIs
         */
        public PSI[] getTirePressure() { return tirePressure; }

        /**
         * Set array of tire pressures
         * @param tirePressure array of tire pressures in psi
         */
        public void setTirePressure(PSI[] tirePressure) { this.tirePressure = tirePressure; }

        /**
         * Set a tire pressure
         * @param tirePressure tire pressure in psi
         * @param index desired tire
         */
        public void setTirePressure(PSI tirePressure, int index) { this.tirePressure[index] = tirePressure; }

        /**
         * Get array of tire pressure sensor statuses
         * @return array of tire sensor statuses
         */
        public TireStatus[] getTireStatus() { return tireStatus; }

        /**
         * Set array of tire pressure sensor statuses
         * @param tireStatus array of tire sensor statuses
         */
        public void setTireStatus(TireStatus[] tireStatus) { this.tireStatus = tireStatus; }

        /**
         * Set a tire pressure sensor status
         * @param tireStatus tire sensor status
         * @param index desired tire
         */
        public void setTireStatus(TireStatus tireStatus, int index) { this.tireStatus[index] = tireStatus; }

        /**
         * Converts the tire object to a string<br>
         * <pre>    Tire pressures: FrontLeft, FrontRight, RearLeft, RearRight<br>    Tire sensors: FrontLeft, FrontRight, RearLeft, RearRight</pre>
         * @return Tire string
         */
        @Override
        public String toString() {
            return "Tire pressures: " + tirePressure[0].toString() + ", " + tirePressure[1].toString() + ", " +
                    tirePressure[2].toString() + ", " + tirePressure[3].toString()
                    + "\nTire sensors: " + tireStatus[0].toString() + ", " + tireStatus[1].toString() + ", " +
                    tireStatus[2].toString() + ", " + tireStatus[3].toString();
        }
    }

    /**
     * <b>Infotainment class</b><br>
     * Contains screen coordinates
     *
     * @see Coordinate
     * @see SwitchState
     */
    public class Infotainment {
        private Coordinate screenX, screenY;
        private SwitchState vol, seek;

        /**
         * Initialize sensor data to defaults
         */
        public Infotainment() {
            screenX = new Coordinate(0);
            screenY = new Coordinate(0);
            vol = SwitchState.SNA;
            seek = SwitchState.SNA;
        }

        /**
         * Get screen X touch coordinate
         * @return x coordinate in pixels
         */
        public Coordinate getScreenX() { return screenX; }

        /**
         * Set screen X touch coordinate
         * @param screenX x coordinate in pixels
         */
        public void setScreenX(Coordinate screenX) { this.screenX = screenX; }

        /**
         * Get screen Y touch coordinate
         * @return y coordinate in pixels
         */
        public Coordinate getScreenY() { return screenY; }

        /**
         * Set screen Y touch coordinate
         * @param screenY y coordinate in pixels
         */
        public void setScreenY(Coordinate screenY) { this.screenY = screenY; }

        /**
         * Get volume switch state
         * @return volume switch state
         */
        public SwitchState getVol() { return vol; }

        /**
         * Set volume switch state
         * @param vol volume switch state
         */
        public void setVol(SwitchState vol) { this.vol = vol; }

        /**
         * Get seek (radio tuner) switch state
         * @return seek (radio tuner) switch state
         */
        public SwitchState getSeek() { return seek; }

        /**
         * Set seek (radio tuner) switch state
         * @param seek seek (radio tuner) switch state
         */
        public void setSeek(SwitchState seek) { this.seek = seek; }

        /**
         * Converts the infotainment object to a string<br>
         * <pre>    X touch coordinate: 0 pixels<br>    Y touch coordinate: 0 pixels
         *    Volume switch state: SNA<br>    Seek switch state: SNA</pre>
         * @return Infotainment string
         */
        @Override
        public String toString() {
            return "X touch coordinate: " + screenX.toString() + "\nY touch coordinate: " + screenY.toString() +
                    "\nVolume switch state: " + vol.toString() + "\nSeek switch state: " + seek.toString();
        }
    }

    /**
     * <b>Transmission class</b><br>
     * Contains transmission torque and transmission gear position
     *
     * @see NewtonMeter
     * @see GearPosition
     */
    public class Transmission {
        private NewtonMeter torqueAtTransmission;
        private GearPosition transmissionGearPosition;

        /**
         * Initialize sensor data to defaults
         */
        public Transmission() {
            torqueAtTransmission = new NewtonMeter(0);
            transmissionGearPosition = GearPosition.NEUTRAL;
        }

        /**
         * Get torque at the transmission
         * @return transmission torque in newton meters
         */
        public NewtonMeter getTorqueAtTransmission() { return torqueAtTransmission; }

        /**
         * Set torque at the transmission shaft
         * @param torqueAtTransmission transmission torque in newton meters
         */
        public void setTorqueAtTransmission(NewtonMeter torqueAtTransmission) { this.torqueAtTransmission = torqueAtTransmission; }

        /**
         * Get gear position of the transmission
         * @return transmission gear
         */
        public GearPosition getTransmissionGearPosition() { return transmissionGearPosition; }

        /**
         * Set gear position of the transmission
         * @param transmissionGearPosition transmission gear
         */
        public void setTransmissionGearPosition(GearPosition transmissionGearPosition) {
            this.transmissionGearPosition = transmissionGearPosition;
        }

        /**
         * Converts the transmission object to a string<br>
         * <pre>    Torque at transmission: 0 Nm<br>    Transmission gear position: NEUTRAL</pre>
         * @return Transmission string
         */
        @Override
        public String toString() {
            return "Torque at transmission: " + torqueAtTransmission.toString() + "\nTransmission gear position: " + transmissionGearPosition.toString();
        }
    }

    /**
     * <b>Cluster class</b><br>
     * Contains ambient temperature, fuel consumed, fuel level, odometer, oil pressure, vehicle speed and turn signal status
     *
     * @see Celsius
     * @see Liter
     * @see Kilometer
     * @see KilopascalGauge
     * @see KilometersPerHour
     * @see TurnSignalPosition
     */
    public class Cluster {
        private Celsius ambientTemp, outsideAirTemp;
        private Liter fuelConsumed, fuelLevel;
        private Kilometer odometer;
        private KilopascalGauge oilPressure;
        private KilometersPerHour vehicleSpeed;
        private TurnSignalPosition turnSignalPosition;
        private boolean brakeFluidLow;

        /**
         * Initialize sensor data to defaults
         */
        public Cluster() {
            ambientTemp = new Celsius(0);
            outsideAirTemp = new Celsius(0);
            fuelConsumed = new Liter(0);
            fuelLevel = new Liter(0);
            odometer = new Kilometer(0);
            oilPressure = new KilopascalGauge(0);
            vehicleSpeed = new KilometersPerHour(0);
            turnSignalPosition = TurnSignalPosition.OFF;
            brakeFluidLow = false;
        }

        /**
         * Get ambient temperature
         * @return ambient temperature in degrees celsius
         */
        public Celsius getAmbientTemp() { return ambientTemp; }

        /**
         * Set ambient temperature
         * @param ambientTemp ambient temperature in degrees celsius
         */
        public void setAmbientTemp(Celsius ambientTemp) { this.ambientTemp = ambientTemp; }

        /**
         * Get fuel consumed during last cycle
         * @return fuel consumed during last cycle in liters
         */
        public Liter getFuelConsumed() { return fuelConsumed; }

        /**
         * Set fuel consumed during last cycle
         * @param fuelConsumed fuel consumed during last cycle in liters
         */
        public void setFuelConsumed(Liter fuelConsumed) { this.fuelConsumed = fuelConsumed; }

        /**
         * Get fuel level
         * @return fuel level in liters
         */
        public Liter getFuelLevel() { return fuelLevel; }

        /**
         * Set fuel level
         * @param fuelLevel fuel level in liters
         */
        public void setFuelLevel(Liter fuelLevel) { this.fuelLevel = fuelLevel; }

        /**
         * Get odometer
         * @return odometer in kilometers
         */
        public Kilometer getOdometer() { return odometer; }

        /**
         * Set odometer
         * @param odometer odometer in kilometers
         */
        public void setOdometer(Kilometer odometer) { this.odometer = odometer; }

        /**
         * Get oil pressure
         * @return oil pressure in kilopascal gauge
         */
        public KilopascalGauge getOilPressure() { return oilPressure; }

        /**
         * Set oil pressure
         * @param oilPressure oil pressure in kilopascal gauge
         */
        public void setOilPressure(KilopascalGauge oilPressure) { this.oilPressure = oilPressure; }

        /**
         * Get vehicle speed
         * @return vehicle speed in kilometers per hour
         */
        public KilometersPerHour getVehicleSpeed() { return vehicleSpeed; }

        /**
         * Set vehicle speed
         * @param vehicleSpeed vehicle speed in kilometers per hour
         */
        public void setVehicleSpeed(KilometersPerHour vehicleSpeed) { this.vehicleSpeed = vehicleSpeed; }

        /**
         * Get turn signal position
         * @return turn signal position
         */
        public TurnSignalPosition getTurnSignalPosition() { return turnSignalPosition; }

        /**
         * Set turn signal position
         * @param turnSignalPosition turn signal position
         */
        public void setTurnSignalPosition(TurnSignalPosition turnSignalPosition) { this.turnSignalPosition = turnSignalPosition; }

        /**
         * Get outside air temperature
         * @return outside air temperature in degree celsius
         */
        public Celsius getOutsideAirTemp() { return outsideAirTemp; }

        /**
         * Set outside air temperature
         * @param outsideAirTemp outside air temperature in degree celsius
         */
        public void setOutsideAirTemp(Celsius outsideAirTemp) { this.outsideAirTemp = outsideAirTemp; }

        /**
         * Get brake fluid low status
         * @return brake fluid low status as a boolean
         */
        public boolean getBrakeFluidLow() { return brakeFluidLow; }

        /**
         * Set brake fluid low status
         * @param brakeFluidLow brake fluid low status as a boolean
         */
        public void setBrakeFluidLow(com.openxc.units.Boolean brakeFluidLow) { this.brakeFluidLow = brakeFluidLow.booleanValue(); }

        /**
         * Converts the cluster object to a string<br>
         * <pre>    Ambient temperature: 0 C<br>    Fuel consumed since last ignition: 0 L
         *    Fuel level: 0 L<br>    Odometer: 0 km<br>    Oil pressure: 0 kPaG
         *    Vehicle speed: 0 km/h<br>    Turn signal position: OFF<br>    Outside Air Temperature: 0 C</pre>
         * @return Cluster string
         */
        @Override
        public String toString() {
            return "Ambient temperature: " + ambientTemp.toString() + "\nFuel consumed since last ignition:" + fuelConsumed.toString() +
                    "\nFuel level: " + fuelLevel.toString() + "\nOdometer: " + odometer.toString() + "\nOil pressure: " + oilPressure.toString() +
                    "\nVehicle speed: " + vehicleSpeed.toString() + "\nTurn signal position: " + turnSignalPosition.toString() +
                    "\nOutside air temperature: " + outsideAirTemp.toString() + "\nBrake Fluid Low: " + brakeFluidLow;
        }
    }

    /**
     * <b>Diagnostic class</b><br>
     * Contains battery voltage and intake air temperature
     *
     * @see Volt
     * @see Celsius
     */
    public class Diagnostic {
        private Volt batteryVoltage;
        private Celsius intakeAirTemp;
        private MetersPerSecondSquared vehicleAccelX, vehicleAccelY;

        /**
         * Initialize sensor data to defaults
         */
        public Diagnostic() {
            batteryVoltage = new Volt(0);
            intakeAirTemp = new Celsius(0);
            vehicleAccelX = new MetersPerSecondSquared(0);
            vehicleAccelY = new MetersPerSecondSquared(0);
        }

        /**
         * Get battery voltage
         * @return battery voltage in volts
         */
        public Volt getBatteryVoltage() { return batteryVoltage; }

        /**
         * Set battery voltage
         * @param batteryVoltage battery voltage in volts
         */
        public void setBatteryVoltage(Volt batteryVoltage) { this.batteryVoltage = batteryVoltage; }

        /**
         * Get intake air temperature
         * @return intake air temperature in celsius
         */
        public Celsius getIntakeAirTemp() { return intakeAirTemp; }

        /**
         * Set intake air temperature
         * @param intakeAirTemp intake air temperature in celsius
         */
        public void setIntakeAirTemp(Celsius intakeAirTemp) { this.intakeAirTemp = intakeAirTemp; }

        /**
         * Get forward vehicle acceleration (x)
         * @return forward vehicle acceleration (x-direction) in meters per second squared
         */
        public MetersPerSecondSquared getForwardAcceleration() { return vehicleAccelX; }

        /**
         * Set forward vehicle acceleration (x)
         * @param vehicleAccelX forward vehicle acceleration (x-direction) in meters per second squared
         */
        public void setForwardAcceleration(MetersPerSecondSquared vehicleAccelX) { this.vehicleAccelX = vehicleAccelX; }

        /**
         * Get climb vehicle acceleration (y)
         * @return climb vehicle acceleration (y-direction) in meters per second squared
         */
        public MetersPerSecondSquared getClimbAcceleration() { return vehicleAccelY; }

        /**
         * Set climb vehicle acceleration (y)
         * @param vehicleAccelY climb vehicle acceleration (y-direction) in meters per second squared
         */
        public void setClimbAcceleration(MetersPerSecondSquared vehicleAccelY) { this.vehicleAccelY = vehicleAccelY; }

        /**
         * Converts the diagnostic object to a string<br>
         * <pre>    Battery voltage: 0 V<br>    Intake air temperature: 0 C</pre>
         * @return Transmission string
         */
        @Override
        public String toString() {
            return "Battery voltage: " + batteryVoltage.toString() + "\nIntake air temperature: " + intakeAirTemp.toString() +
                    "\nForward acceleration (x): " + vehicleAccelX.toString() + "\nClimb acceleration (y): " + vehicleAccelY.toString();
        }
    }

    /**
     * <b>Lighting class</b><br>
     * Contains headlamp and high-beam statuses
     */
    public class Lighting {
        private boolean headlamp, highBeam;

        /**
         * Initialize sensor data to defaults
         */
        public Lighting() { }

        /**
         * Get headlamp status
         * @return headlamp status as a boolean
         */
        public boolean getHeadlamp() { return headlamp; }

        /**
         * Set headlamp status
         * @param headlamp headlamp status as a boolean
         */
        public void setHeadlamp(com.openxc.units.Boolean headlamp) { this.headlamp = headlamp.booleanValue(); }

        /**
         * Get high beam status
         * @return high beam status as a boolean
         */
        public boolean getHighBeam() { return highBeam; }

        /**
         * Set high beam status
         * @param highBeam high beam status as a boolean
         */
        public void setHighBeam(com.openxc.units.Boolean highBeam) { this.highBeam = highBeam.booleanValue(); }

        /**
         * Converts the lighting object to a string<br>
         * <pre>    High beams on: false<br>    Headlamps on: false</pre>
         * @return Transmission string
         */
        @Override
        public String toString() {
            return "High beams on: " + highBeam + "\nHeadlamps on: " + headlamp;
        }
    }

    /**
     * <b>User Control class</b><br>
     * Contains accelerator pedal position, steering wheel angle, brake pedal, ignition, paddle shifter and parking brake statuses
     *
     * @see Degree
     * @see Percentage
     * @see BrakePedalPosition
     * @see IgnitionPosition
     * @see PaddleShifterPosition
     */
    public class UserControl {
        private Percentage acceleratorPedalPosition;
        private Degree steeringWheelAngle;
        private BrakePedalPosition brakePedalPosition;
        private IgnitionPosition ignitionPosition;
        private boolean parkingBrakePosition;
        private PaddleShifterPosition paddleShifterPosition;

        /**
         * Initialize sensor data to defaults
         */
        public UserControl() {
            acceleratorPedalPosition = new Percentage(0);
            steeringWheelAngle = new Degree(0);
            brakePedalPosition = BrakePedalPosition.SNA;
            ignitionPosition = IgnitionPosition.SNA;
            parkingBrakePosition = false;
            paddleShifterPosition = PaddleShifterPosition.SNA;
        }

        /**
         * Get accelerator pedal position
         * @return accelerator pedal position as a percentage (100% = pedal to the metal)
         */
        public Percentage getAcceleratorPedalPosition() { return acceleratorPedalPosition; }

        /**
         * Set accelerator pedal position
         * @param acceleratorPedalPosition accelerator pedal position as a percentage (100% = pedal to the metal)
         */
        public void setAcceleratorPedalPosition(Percentage acceleratorPedalPosition) {
            this.acceleratorPedalPosition = acceleratorPedalPosition;
        }

        /**
         * Set steering wheel angle
         * @return steering wheel angle in degrees (0 degrees=wheels straight, degree<0 = turning left, degree>0 = turning right)
         */
        public Degree getSteeringWheelAngle() { return steeringWheelAngle; }

        /**
         * Set steering wheel angle
         * @param steeringWheelAngle steering wheel angle in degrees (0 degrees : wheels straight, degree=- : turning left, degree=+ : turning right)
         */
        public void setSteeringWheelAngle(Degree steeringWheelAngle) { this.steeringWheelAngle = steeringWheelAngle; }

        /**
         * Get brake pedal position
         * @return brake pedal position
         */
        public BrakePedalPosition getBrakePedalPosition() { return brakePedalPosition; }

        /**
         * Set brake pedal position
         * @param brakePedalPosition brake pedal position
         */
        public void setBrakePedalPosition(BrakePedalPosition brakePedalPosition) {
            this.brakePedalPosition = brakePedalPosition;
        }

        /**
         * Get ignition position
         * @return ignition position
         */
        public IgnitionPosition getIgnitionPosition() { return ignitionPosition; }

        /**
         * Set ignition position
         * @param ignitionPosition ignition position
         */
        public void setIgnitionPosition(IgnitionPosition ignitionPosition) { this.ignitionPosition = ignitionPosition; }

        /**
         * Get parking brake status
         * @return parking brake status
         */
        public boolean isParkingBrakePosition() { return parkingBrakePosition; }

        /**
         * Set parking brake status
         * @param parkingBrakePosition parking brake status
         */
        public void setParkingBrakePosition(com.openxc.units.Boolean parkingBrakePosition) {
            this.parkingBrakePosition = parkingBrakePosition.booleanValue();
        }

        /**
         * Get paddle shifter positions
         * @return paddle shifter position
         */
        public PaddleShifterPosition getPaddleShifterPosition() { return paddleShifterPosition; }

        /**
         * Set paddle shifter positions
         * @param paddleShifterPosition paddle shifter position
         */
        public void setPaddleShifterPosition(PaddleShifterPosition paddleShifterPosition) {
            this.paddleShifterPosition = paddleShifterPosition;
        }

        /**
         * Converts the user control object to a string<br>
         * <pre>    Accelerator Pedal: 0 %<br>    Brake Pedal: SNA
         *    Ignition Status: SNA<br>    Paddle Shifter Status: SNA<br>    Parking brake status: false
         *    Steering wheel angle: 0 degrees</pre>
         * @return Cluster string
         */
        @Override
        public String toString() {
            return "Accelerator Pedal: " + acceleratorPedalPosition.toString() + "\nBrake Pedal: " + brakePedalPosition.toString() +
                    "\nIgnition Status: " + ignitionPosition.toString() + "\nPaddle Shifter Status: " + paddleShifterPosition.toString() +
                    "\nParking brake status: " + parkingBrakePosition + "\nSteering Wheel Angle: " + steeringWheelAngle.toString();
        }
    }



}
