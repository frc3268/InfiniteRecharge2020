/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.drive.TimedArcadeDriveCommand;
import frc.robot.commands.tilt.*;
import frc.robot.commands.shooter.*;
import frc.robot.commands.load.*;


/**
 * An example command.  You can replace me with your own command.
 */
public class TimedShoot extends CommandGroup {
    public TimedShoot() {
        addSequential(new TimedArcadeDriveCommand(0.5, 0, 5.0));
        addSequential(new TimedLoadCommand(0.3, 2));
        addSequential(new TimedTiltCommand(-0.35, 2));
        addSequential(new TimedTiltCommand(0.35, 2));
        addSequential(new TimedShooterCommand(0.75, 3));
    }
}
