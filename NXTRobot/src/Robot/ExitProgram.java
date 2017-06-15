package Robot;

/**
 * ExitProgram.Java
 * @author Victoria Carroll
 * 15/07/2017
 * This is the exit program or behavior 5 in the array this will take priority over all
 */
//importing all necessities

import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.Button;
import lejos.nxt.Motor;

public class ExitProgram implements Behavior{
	/**
	 * checks if button is pressed
	 * returns true if button pushed
	 * else returns false
	 */
	public boolean takeControl() {
		if(Button.ESCAPE.isDown()){
			return true;
		}
		return false;
	}
	/**
	 * exits program
	 */
	public void action(){
		System.exit(0);
	}

	/**
	 * program done
	 */
	public void suppress(){

	}

}