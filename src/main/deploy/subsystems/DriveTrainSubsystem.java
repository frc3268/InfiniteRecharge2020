/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.commands.drive.ArcadeDriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The motors which drive the robot, and their methods of control.
 */
public class DriveTrainSubsystem extends Subsystem {

	Spark driveLeftFront;
	Spark driveLeftBack;
	Spark driveRightFront;
	Spark driveRightBack;
	SpeedControllerGroup driveLeft;
	SpeedControllerGroup driveRight;
	DifferentialDrive drive;
	public boolean invert = false;	//	Tracker to track the current state of whether or not the robot is inverted or not.

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public DriveTrainSubsystem() {
		driveLeftFront = new Spark(RobotMap.SPARK_driveLeftFront);
		//driveLeftBack = new Spark(RobotMap.SPARK_driveLeftBack); //this was commented out, because driveLeftFront already has port 0. this otherwise throws an error
		driveRightFront = new Spark(RobotMap.SPARK_driveRightFront);
		//driveRightBack = new Spark(RobotMap.SPARK_driveRightBack); //same as above
		driveLeft = new SpeedControllerGroup(driveLeftFront); //, driveLeftBack); //same as above
		driveRight = new SpeedControllerGroup(driveRightFront); //, driveRightBack); //same as above
		driveLeft.setInverted(true);
		driveRight.setInverted(true);
		drive = new DifferentialDrive(driveLeft, driveRight);
	}

	public void SwapControls()
	{
		driveLeft.setInverted(!(driveLeft.getInverted()));
		driveRight.setInverted(!(driveRight.getInverted()));	
	}

	/*
	public void arcadeDrive(Joystick joy) {	
		if( invert == true )
		{
			driveLeft.setInverted(false);
			driveRight.setInverted(false);
		}
		else
		{
			driveLeft.setInverted(true);
			driveRight.setInverted(true);	
		}
		

		drive.arcadeDrive(-joy.getRawAxis(1) * 0.75, 	
						-joy.getRawAxis(0) * 0.75);
	}
	*/

	public void arcadeDriveInv(Joystick joy/*ful*/) {	
	}

	public void arcadeDrive(double xSpeed, double zRotation) {	
		drive.arcadeDrive(xSpeed, zRotation);
	}

	// Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
	public void stop() {
		drive.stopMotor();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ArcadeDriveCommand());
	}
}
