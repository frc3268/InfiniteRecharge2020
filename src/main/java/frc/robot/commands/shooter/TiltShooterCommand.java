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
    double slider = OI.stick.getRawAxis(3);

    //this block was to use buttons to 
    // boolean tilt_up = OI.stick.getRawButton(8);
    // boolean tilt_down = OI.stick.getRawButton(7);
    // double speed = 0;

    // if (tilt_up) {
    //   angler.setSpeed(speed + 0.05);
    // } else if (tilt_down) {
    //   angler.setSpeed(speed - 0.05);
    // }
    

    //if slider in middle, transmit zero, if up transmit low, if down transmit high.
    // TODO Make this set to values and work with the buttons on the top of the stick (slider shouldn't define speed)
    if (slider < 40) {
      Robot.tilt.setSpeed(slider);
    } else if (slider > 60) {
      Robot.tilt.setSpeed(slider);
    }
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
