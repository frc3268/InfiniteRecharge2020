/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class BallLoadSubsystem extends Subsystem {
  WPI_VictorSPX victorBallLoad; 

  // TODO: test to find if offsets are needed
  // private final double PERCENT_OFFSET = 1;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public BallLoadSubsystem() {
    victorBallLoad = new WPI_VictorSPX(RobotMap.VICTORSPX_ballLoad);

    // TODO: invert motor?
    // victorBallLoad.setInverted(true);
  }

  public void load(double speed) {
    victorBallLoad.set(speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
