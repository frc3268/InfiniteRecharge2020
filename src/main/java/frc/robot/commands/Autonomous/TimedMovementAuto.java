/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

import frc.robot.commands.TimedArcadeDriveCommand;
 * An example command.  You can replace me with your own command.
 */
public class TimedMovementAuto extends CommandGroup {
	
	public TimedMovementAuto() {
		addSequential(new TimedArcadeDriveCommand(0.5,0,6.0));
	}
	
}