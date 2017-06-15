package Robot;

/**
 * DriveForward.Java
 * @author Victoria Carroll
 * 15/07/2017
 * This is the lowest priority and will alow the robot to drive forward
 */
//importing all necessities
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

public class DriveForward implements Behavior{
	private boolean suppressed = false;
	/**
	 * checks if boolean is true
	 * returns true
	 */
	public boolean takeControl() {
		return true;
	}
	/**
	 * sets speed, drives froward and if suppressed stops
	 */
	public void action(){
		suppressed = false;
		Motor.B.setSpeed(50);
		Motor.C.setSpeed(50);
		Motor.B.forward();
		Motor.C.forward();
		/**
		 * checks if suppressed boolean is true and if not checks all other priorities
		 */
		while(suppressed){
			Thread.yield();
		Motor.B.stop();
		Motor.C.stop();
		}
	}
	/**
	 * checks if suppressed boolean is true
	 */
		public void suppress(){
			suppressed = true;
		}

	}
