package org.robockets.cubeintaketest2018;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


@SuppressWarnings("deprecation")
public class Robot extends SampleRobot {
	Talon drivetrainL = new Talon(5);
	Talon drivetrainR = new Talon(4);
	DifferentialDrive myRobot = new DifferentialDrive(drivetrainL, drivetrainR);
	Talon cubeIntakeL = new Talon(0);
	Talon cubeIntakeR = new Talon(1);
	Joystick stick = new Joystick(0);

	public Robot() {
	}

	@Override
	public void robotInit() {
		myRobot.setExpiration(0.1);
		drivetrainL.setInverted(true);
		drivetrainR.setInverted(true);
		cubeIntakeL.setInverted(true);
	}


	@Override
	public void autonomous() {
	}

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


	@Override
	public void test() {
	}
}
