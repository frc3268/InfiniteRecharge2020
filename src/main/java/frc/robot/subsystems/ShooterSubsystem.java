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

  public ShooterSubsystem() {
    victorShooter_r = new WPI_VictorSPX(RobotMap.VICTORSPX_shooterRight);
    victorShooter_l = new WPI_VictorSPX(RobotMap.VICTORSPX_shooterLeft);
  }

/**
 * Shoots with a speed value between 0 and 1 (inlcudes 0). Has a percent offset for each motor, defined in RobotMap.java. This doesn't use PID and will hopefully become a legacy function.
 */
  public void shoot(double speed) {
    System.out.println("Shooting... [ " + RobotMap.L__PERCENT_OFFSET + ", " + RobotMap.R__PERCENT_OFFSET + " ]:::[ " + speed + " ]");
    victorShooter_l.setInverted(true);
    victorShooter_l.set(speed * RobotMap.L__PERCENT_OFFSET);
    victorShooter_r.set(speed * RobotMap.R__PERCENT_OFFSET);
  }

  public void accraShoot(double speed) {
    // PID shoot function will go here
  }

  @Override
  public void initDefaultCommand() {
    // TODO Figure out what should go here
    setDefaultCommand(null);
  }
}
