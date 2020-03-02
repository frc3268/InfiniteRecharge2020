/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.shooter.*;
import frc.robot.commands.tilt.*;
import frc.robot.commands.intake.*;
import frc.robot.commands.load.*;
import frc.robot.commands.climber.*;
// import edu.wpi.first.wpilibj.buttons.Button;
// import edu.wpi.first.wpilibj.buttons.JoystickButton;

// import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is. 
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	
	public static Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT);
	public static Joystick controller = new Joystick(RobotMap.BIG_CONTROLLER);

	public static Button tiltUpButton = new JoystickButton(controller, RobotMap.TILTUP);
	public static Button tiltDownButton = new JoystickButton(controller, RobotMap.TILTDOWN);

	public static Button panelButton = new JoystickButton(controller, RobotMap.PANEL);

	public static Button shootButton = new JoystickButton(controller, RobotMap.SHOOTER);

	public static Button shootLoadButton = new JoystickButton(controller, RobotMap.SHOOTLOAD);

	public static Button intakeButton = new JoystickButton(controller, RobotMap.INTAKE);
	public static Button reverseIntakeButton = new JoystickButton(controller, RobotMap.REVERSEINTAKE);
	public static Button loadButton = new JoystickButton(controller, RobotMap.LOAD);

	public static Button climbButton = new JoystickButton(controller, RobotMap.CLIMB);
	public static Button reverseClimbButton = new JoystickButton(controller, RobotMap.REVERSECLIMB);

	// public static double TiltShooterSlider = stick.getTwist();
	// public static double TiltShooterSlider = stick.getThrottle();

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());
	

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public OI() {
		panelButton.whenPressed(new ControlPanelCommand());
		panelButton.whenReleased(new ControlPanelStopCommand());

		shootButton.whenPressed(new ShooterCommand());
		shootButton.whenReleased(new ShooterStopCommand());

		intakeButton.whenPressed(new IntakeCommand());
		intakeButton.whenReleased(new IntakeStopCommand());

		loadButton.whenPressed(new LoadCommand());
		loadButton.whenReleased(new LoadStopCommand());

		shootLoadButton.whenPressed(new ShootLoadCommand());
		shootLoadButton.whenReleased(new ShootLoadStopCommand());

		tiltUpButton.whenPressed(new TiltUpCommand());
		tiltUpButton.whenReleased(new TiltStopCommand());

		tiltDownButton.whenPressed(new TiltDownCommand());
		tiltDownButton.whenReleased(new TiltStopCommand());

		climbButton.whenPressed(new ClimbCommand());
		climbButton.whenReleased(new ClimbStopCommand());

		reverseClimbButton.whenPressed(new ReverseClimbCommand());
		reverseClimbButton.whenReleased(new ReverseClimbStopCommand());

		reverseIntakeButton.whenPressed(new ReverseIntakeCommand());
		reverseIntakeButton.whenReleased(new ReverseIntakeStopCommand());
	}
}
