package Robot;

/**
 * NoLight.Java
 * @author Victoria Carroll
 * 15/07/2017
 * When the light sensor points at the ground it should be sensing light yet prior to walls there is no light so that the sensor knows to allow the program to turn left because it will not be turning right and also not be going forward
 */
//importing all necessities
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;

public class NoLight implements Behavior{
	private LightSensor light = new LightSensor(SensorPort.S2);
	private boolean suppressed = false;

	public NoLight(LightSensor ls){
		this.light = ls;
	}
	/**
	 * checks if boolean is true
	 */
	public boolean takeControl() {	

		light.getLightValue();
		if((light.getLightValue() <= 30)){
			return true;
		}
		return false;
	}


	public void action() {
		suppressed = false;
		Motor.C.stop();
		
		Motor.B.forward();
		
		/**
		 * checks if suppressed boolean is true and if not checks all other priorities
		 */
			while(!suppressed){
				Thread.yield();

			}
		
		
		Motor.B.stop();
		Motor.C.stop();
		
	}

	/**
	 * checks if suppressed boolean is true
	 */
	public void suppress() {
		suppressed = true;	
	}
}
