package Robot;

/**
 * TurnRight.Java
 * @author Victoria Carroll
 * 15/07/2017
 * This has the second lowest priority and will turn right when there is nothing to its right therefore not running into wall in front
 */
//importing all necessities
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.Behavior;

public class TurnRight implements Behavior{
	private UltrasonicSensor sonar;
	private boolean suppressed = false;
	
	public TurnRight(UltrasonicSensor us){
		this.sonar = us;
	}
	/**
	 * checks if boolean is true
	 */
	public boolean takeControl() {
		
		if(sonar.getDistance() < 5){
			return true;
		}
		return false;
	}
	/**
	 * if action is accepted then robot will turn right
	 */
	public void action(){
		suppressed = false;
		
		sonar.continuous();

		Motor.B.setSpeed(50);
		Motor.C.setSpeed(50);
		Motor.B.stop();
		Motor.C.forward();
		/**
		 * checks if suppressed boolean is true and if not checks all other priorities
		 */
		while(!suppressed){
			Thread.yield();
		}
	}

	/**
	 * checks if suppressed boolean is true
	 */
	public void suppress(){
		suppressed = true;


	}

}

//UltrasonicSensor sonic1 = new UltrasonicSensor (SensorPort.S1);
//UltrasonicSensor sonic2 = new UltrasonicSensor (SensorPort.S2);
//LightSensor light = new LightSensor (SensorPort.S3);
//TouchSensor touch = new TouchSensor (SensorPort.S4);

//import lejos.nxt.Button;
//import lejos.nxt.Motor;
//import lejos.nxt.SensorPort;
//import lejos.nxt.UltrasonicSensor;
//import lejos.nxt.LightSensor;
//import lejos.nxt.TouchSensor;
//import lejos.robotics.subsumption.Behavior;