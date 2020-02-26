/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // TODO change #s to specific motors
	public static final int SPARK_driveLeftFront = 0;
	public static final int SPARK_driveLeftBack = 0;
	public static final int SPARK_driveRightFront = 9;
	public static final int SPARK_driveRightBack = 9;

	public static final int PWM_shooterAngle = 3;

	public static final int VICTORSPX_shooterRight = 0;
	// VICTORSPX_shooterRight refers to the shooter with the '3' Sticker on it
	public static final int VICTORSPX_shooterLeft = 1;

	public static final int VICTORSPX_ballIntake = 2;
	public static final int VICTORSPX_ballLoad = 3;

	// declare buttons
	public static final int ballShootingButton = 1;

	public static final int tiltShooterButton = 3;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
