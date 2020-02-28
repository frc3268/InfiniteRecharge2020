/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class TiltCommand extends Command {
  public TiltCommand() {
    requires(Robot.tilt);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // boolean up = OI.stick.getRawButton(5);
    // boolean down = OI.stick.getRawButton(3);
    double tilt = OI.stick.getRawAxis(3) * -0.2;

    /*
    if (up) {
      Robot.tilt.setSpeed(-0.1);
    } else if (down) {
      Robot.tilt.setSpeed(0.1);
    } else {
      Robot.tilt.setSpeed(0);
    }
    */

    if (tilt > 0) {
      Robot.tilt.setSpeed(0.2);
    }
    else if (tilt < 0) {
      Robot.tilt.setSpeed(-0.2);
    }
    else Robot.tilt.setSpeed(0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
