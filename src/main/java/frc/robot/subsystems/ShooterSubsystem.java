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
 * Subsystem for the motors that actually shoot the ball.
 */
public class ShooterSubsystem extends Subsystem {
  WPI_VictorSPX victorShooter_l;
  WPI_VictorSPX victorShooter_r;

  /**Positive double - (0,1] - that defines a hardcoded offset because we don't have the PID yet... */
  private final double L__PERCENT_OFFSET = 1;
  /**Positive double - (0,1] - that defines a hardcoded offset because we don't have the PID yet... */
  private final double R__PERCENT_OFFSET = 1;

  public ShooterSubsystem() {
    victorShooter_r = new WPI_VictorSPX(RobotMap.VICTORSPX_shooterRight);
    victorShooter_l = new WPI_VictorSPX(RobotMap.VICTORSPX_shooterLeft);
  }

  public void shoot(double speed) {
    System.out.println("Shooting... [" + speed + "," + L__PERCENT_OFFSET + "," + R__PERCENT_OFFSET + "]");
    victorShooter_l.setInverted(true);
    victorShooter_l.set(speed * L__PERCENT_OFFSET);
    victorShooter_r.set(speed * R__PERCENT_OFFSET);
  }

  @Override
  public void initDefaultCommand() {
    // TODO Figure out what should go here
    setDefaultCommand(null);
  }
}
