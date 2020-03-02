/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.shooter.ControlPanelCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * Subsystem for the motors that actually shoot the ball.
 */
public class ControlPanelSubsystem extends Subsystem {
  WPI_VictorSPX victorShooter_l;
  WPI_VictorSPX victorShooter_r;

  /**Positive double - (0,1] - that defines a hardcoded offset because we don't have the PID yet... */
  private final double L__PERCENT_OFFSET = 1;
  /**Positive double - (0,1] - that defines a hardcoded offset because we don't have the PID yet... */
  private final double R__PERCENT_OFFSET = 1;

  public ControlPanelSubsystem() {
    victorShooter_r = new WPI_VictorSPX(RobotMap.VICTORSPX_shooterRight);
    victorShooter_l = new WPI_VictorSPX(RobotMap.VICTORSPX_shooterLeft);
  }

  public void panel(double speed) {
    victorShooter_l.setInverted(false);
    System.out.println("Shooting... [" + speed + "," + L__PERCENT_OFFSET + "," + R__PERCENT_OFFSET + "]");
    victorShooter_l.set(speed * L__PERCENT_OFFSET);
    victorShooter_r.set(speed * R__PERCENT_OFFSET);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(null);
  }
}
