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

	// If you are using multiple modules, make sure to define both the port
	// number and the module.

    //////////////////////////////////////////////////////////////////////////////////////////
	// --------------------------------------- OI ----------------------------------------- //
	//////////////////////////////////////////////////////////////////////////////////////////
	public static final int JOYSTICK_PORT = 0;
	public static final int BIG_CONTROLLER = 1;

	// public static final int Y_LINE_AXIS_ID = 0       /*fill in*/;
	// public static final int X_LINE_AXIS_ID = 0       /*fill in*/;
	// public static final int Z_ROTATIONAL_AXIS_ID = 0 /*fill in*/;

	public static final int PANEL = 2;
	public static final int SHOOTER = 7;
	public static final int INTAKE = 5;
	public static final int LOAD = 10;
	public static final int TILTUP = 3;
	public static final int TILTDOWN = 1;
	public static final int CLIMB = 11;	
	public static final int REVERSECLIMB = 12;
	public static final int REVERSEINTAKE = 6;

	public static final int SHOOTLOAD = 9;

	//////////////////////////////////////////////////////////////////////////////////////////
	// ------------------------------------- DRIVE ---------------------------------------- //
	//////////////////////////////////////////////////////////////////////////////////////////
	public static final int SPARK_driveLeftFront = 1;
	public static final int SPARK_driveLeftBack = 1;
	public static final int SPARK_driveRightFront = 2;
	public static final int SPARK_driveRightBack = 2;

	public static final int PWM_shooterAngle = 4;
	public static final int PWM_climb = 5;

	public static final int VICTORSPX_shooterRight = 0;
	public static final int VICTORSPX_shooterLeft = 1;
	// VICTORSPX_shooterRight refers to the shooter with the '3' Sticker on it
	public static final int VICTORSPX_ballIntake = 2;
	public static final int VICTORSPX_ballLoad = 3;
	// If you are using multiple modules, make sure to define both the port
	// public static int rangefinderModule = 1;

	/**Positive double - (0,1] - that defines a hardcoded offset because we don't have the PID yet... */
	public static final double L__PERCENT_OFFSET = 1;
	/**Positive double - (0,1] - that defines a hardcoded offset because we don't have the PID yet... */
	public static final double R__PERCENT_OFFSET = 1;

	// BUTTONS THAT ARE TAKEN
	// 1 2 4 6 5 3
}
