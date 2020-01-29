/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDriveCommand;

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
		driveLeftBack = new Spark(RobotMap.SPARK_driveLeftBack);
		driveRightFront = new Spark(RobotMap.SPARK_driveRightFront);
		driveRightBack = new Spark(RobotMap.SPARK_driveRightBack);
		driveLeft = new SpeedControllerGroup(driveLeftFront, driveLeftBack);
		driveRight = new SpeedControllerGroup(driveRightFront, driveRightBack);
		driveLeft.setInverted(true);
		driveRight.setInverted(true);
		drive = new DifferentialDrive(driveLeft, driveRight);
	}
	public void SwapControls()
	{
		driveLeft.setInverted(!(driveLeft.getInverted()));
		driveRight.setInverted(!(driveRight.getInverted()));
		
	}
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
	public void arcadeDriveInv(Joystick joy) {	
	}
	public void arcadeDrive(double xSpeed) {	
		drive.arcadeDrive(xSpeed, 0);
	}
	/**
	 * Tank drive using individual joystick axes.
	 *
	 * @param leftAxis  Left sides value
	 * @param rightAxis Right sides value
	 */

	public void stop() {
		drive.stopMotor();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ArcadeDriveCommand());
	}
}
