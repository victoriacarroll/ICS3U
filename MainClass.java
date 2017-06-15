package Robot;

/**
 * MainClass.Java
 * @author Victoria Carroll
 * 15/07/2017
 * This is the main class where the array of behaviors is held and where the program is initially run
 */
//importing all necessities
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;

public class MainClass {
  
	public static void main(String[] args) {
		TouchSensor touch = new TouchSensor(SensorPort.S3); //initialized touch sensor
		LightSensor light = new LightSensor(SensorPort.S2); //initialized light sensor
		UltrasonicSensor sonar = new UltrasonicSensor (SensorPort.S1); //initialized ultrasonic sensor
		Behavior b1 = new DriveForward(); //lowest priority
		Behavior b2 = new TurnRight(sonar); //second priority
		Behavior b3 = new NoLight(light); //third priority
		Behavior b4 = new WallTouch(touch); //fourth priority
		Behavior b5 = new ExitProgram(); //highest priority

		Behavior[] behaviors = {b1,b2,b3,b4,b5}; //array of behaviors
		
		Arbitrator arby = new Arbitrator (behaviors); //initial start of programs
		arby.start();
		
	}

}