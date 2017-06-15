package Robot;

/**
 * WallTouch.Java
 * @author Victoria Carroll
 * 15/07/2017
 * When the touch sensor is on the wall and being pushed then the entire program ends as this proves that the bomb has been diffused.
 */
//importing all necessities
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;

public class WallTouch implements Behavior{
	private TouchSensor touch;
	private boolean suppressed = false;

	public WallTouch(TouchSensor ts){
		this.touch = ts;
	}
	/**
	 * checks if boolean is true
	 */
	public boolean takeControl() {	

		if (touch.isPressed()){
			return true;
		}
		return false;
	}


	public void action() {
		suppressed = false;
		Motor.C.stop();
		
		Motor.B.stop();
		
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
