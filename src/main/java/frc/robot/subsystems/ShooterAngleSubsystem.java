/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterAngleSubsystem extends Subsystem {

  Talon Talon_angleShooter;
  SpeedControllerGroup ControllerGroup_angleShooter;

  public ShooterAngleSubsystem() {
    Talon_angleShooter= new Talon (RobotMap.PWM_shooterAngle);
    ControllerGroup_angleShooter= new SpeedControllerGroup(Talon_angleShooter);
  }

  public void setSpeed(double speed) {
    ControllerGroup_angleShooter.set(speed);
  }

  @Override
  public void initDefaultCommand() {
    // change if needed from null
    setDefaultCommand(null);
  }
}
