/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.drive.TimedArcadeDriveCommand;

/**
 * An example command.  You can replace me with your own command.
 */
public class TimedMovement extends CommandGroup {
    public TimedMovement() {
      // speed, heading, time
        addSequential(new TimedArcadeDriveCommand(0.5, 0, 5.0));
    }
}
