/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.TiltShooterCommand;
import frc.robot.commands.autonomous.TimedMovement;
import frc.robot.commands.drive.ArcadeDriveCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ShooterAngleSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

//import frc.robot.subsystems.BallShootingSubSystem;

/*
 ____    ___      __     ___       __       _______.   .______    _______     _______.___________.   
|___ \  |__ \    / /    / _ \     |  |     /       |   |   _  \  |   ____|   /       |           |   
  __) |    ) |  / /_   | (_) |    |  |    |   (----`   |  |_)  | |  |__     |   (----`---|  |----`   
 |__ <    / /  | '_ \   > _ <     |  |     \   \       |   _  <  |   __|     \   \       |  |        
 ___) |  / /_  | (_) | | (_) |    |  | .----)   |      |  |_)  | |  |____.----)   |      |  |        
|____/  |____|  \___/   \___/     |__| |_______/       |______/  |_______|_______/       |__|   
                               
*/

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
	private ArcadeDriveCommand arcadeDrive_command;

	public static ShooterAngleSubsystem tilt = new ShooterAngleSubsystem();
	private TiltShooterCommand tilt_command;

	public static ShooterSubsystem shoot = new ShooterSubsystem();
	private ShooterCommand shoot_command;
	public static OI m_oi;

	Command m_autoCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI(); 

		/* Autonomous Initiation and Declaration */
		m_chooser.setDefaultOption("No Auto", null);
		m_chooser.addOption("TimedMovement", new TimedMovement());

		SmartDashboard.putData("Autonomous", m_chooser);

		// initiate cameras
		CameraServer.getInstance().startAutomaticCapture(0);
		CameraServer.getInstance().startAutomaticCapture(1);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */ 
	@Override
	public void disabledInit() { }

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autoCommand = m_chooser.getSelected();
		m_autoCommand = new TimedMovement();

		// schedule the autonomous command (example)
		if (m_autoCommand != null) {
			m_autoCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		arcadeDrive_command = new ArcadeDriveCommand();
		tilt_command = new TiltShooterCommand();
		shoot_command = new ShooterCommand();
		arcadeDrive_command.start();
		tilt_command.start();
		shoot_command.start();
		// ^ when in Teleop, have control over the tilting mechanism. right now this assumes one talon on port 3


		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autoCommand != null) {
			m_autoCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
