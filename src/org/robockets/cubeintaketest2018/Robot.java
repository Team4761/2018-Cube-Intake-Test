package org.robockets.cubeintaketest2018;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the RobotDrive class. The
 * SampleRobot class is the base of a robot application that will automatically
 * call your Autonomous and OperatorControl methods at the right time as
 * controlled by the switches on the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're
 * inexperienced, don't. Unless you know what you are doing, complex code will
 * be much more difficult under this system. Use IterativeRobot or Command-Based
 * instead if you're new.
 */
public class Robot extends SampleRobot {
	Talon drivetrainL = new Talon(5);
	Talon drivetrainR = new Talon(4);
	DifferentialDrive myRobot = new DifferentialDrive(drivetrainL, drivetrainR);
	Talon cubeIntakeL = new Talon(0);
	Talon cubeIntakeR = new Talon(1);
	Joystick stick = new Joystick(0);

	public Robot() {
		myRobot.setExpiration(0.1);
		drivetrainL.setInverted(true);
		drivetrainR.setInverted(true);
		cubeIntakeL.setInverted(true);
	}

	@Override
	public void robotInit() {
		SmartDashboard.putNumber("Cube intake speed", 0);
	}


	@Override
	public void autonomous() {
	}


	/**
	 * Runs the motors with arcade steering.
	 */
	@Override
	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			myRobot.arcadeDrive(-stick.getRawAxis(1), -stick.getRawAxis(5));
			cubeIntakeL.set(stick.getRawAxis(2));
			cubeIntakeR.set(stick.getRawAxis(3));
			
			Timer.delay(0.005);
		}
	}

	/**
	 * Runs during test mode
	 */
	@Override
	public void test() {
	}
}
