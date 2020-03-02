/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.load;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class TimedLoadCommand extends Command {
	double speed, heading;
	public TimedLoadCommand(double speed, double time) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.load);
		this.speed = speed;
		setTimeout(time);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.shoot.shoot(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.load.load(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		
	}
		
}
