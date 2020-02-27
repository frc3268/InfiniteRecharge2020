/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.OI;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class TiltShooterCommand extends Command {

  public TiltShooterCommand() {
   	// Use requires() here to declare subsystem dependencies
		requires(Robot.tilt);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // tiltUpButton rasies the hopper, tiltDownButton lowers the hopper
    // Create presets here for the speed and timing so we can automate the process of going from one mode to the other
    // TODO testing for that ^
    boolean up = OI.tiltUpButton;
    boolean down = OI.tiltDownButton;
    double speed = 1;

    if (up) {
      Robot.tilt.setSpeed(speed);
    } else if (down) {
      Robot.tilt.setSpeed(speed);
    } else {
      Robot.tilt.setSpeed(0);
    }

    // TODO preset for raising the cannon to reach the control wheel/panel
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.tilt.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
