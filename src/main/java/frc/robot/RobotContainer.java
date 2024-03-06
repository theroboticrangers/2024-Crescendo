// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import java.util.List;

import edu.wpi.first.math.MathUtil;
//mport edu.wpi.first.math.controller.PIDController;
//import edu.wpi.first.math.controller.ProfiledPIDController;
//import edu.wpi.first.math.geometry.Pose2d;
//import edu.wpi.first.math.geometry.Rotation2d;
//import edu.wpi.first.math.geometry.Translation2d;
//import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
//import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
//import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.OIConstants;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants.LauncherConstants;
import frc.robot.subsystems.SwerveDriveTrain;
import frc.robot.subsystems.CANLauncher;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.LtClimber;
import frc.robot.subsystems.RtClimber;
import frc.robot.commands.ArmCommands.Floor;
import frc.robot.commands.ArmCommands.GrabNote;
import frc.robot.commands.ArmCommands.EjectNote;
import frc.robot.commands.ArmCommands.FeedShooter;
import frc.robot.commands.ltClimb;
import frc.robot.commands.rtClimb;
import frc.robot.commands.rtclimbdown;
import frc.robot.commands.ltclimbdown;
import frc.robot.commands.LaunchNote;
import frc.robot.commands.PrepareLaunch;
import frc.robot.commands.ArmCommands.ScoreAmp;
import frc.robot.auton.*;
import frc.robot.auton.common.*;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

	public static final double GAMEPAD_AXIS_THRESHOLD = 0.15;
	public static final double JOYSTICK_AXIS_THRESHOLD = 0.15;

	//choosers for auton
	public static final String AUTON_DO_NOTHING = "Do Nothing";
	public static final String AUTON_CUSTOM = "My Auto";
	public static final String AUTON_SAMPLE_SWERVE = "Sample Swerve";
	public static final String AUTON_SAMPLE_MOVE_FORWARD = "Sample Move Forward";
	public static final String AUTON_SAMPLE_MOVE_IN_REVERSE = "Sample Move In Reverse";
	public static final String AUTON_SAMPLE_MOVE_IN_GAMMA_SHAPE = "Sample Move In Gamma Shape";
	public static final String AUTON_SAMPLE_MOVE_IN_L_SHAPE_IN_REVERSE = "Sample Move In L Shape In Reverse";
	public static final String AUTON_TEST_HARDCODED_MOVE_1 = "Test Hardcoded Move 1";
	public static final String AUTON_TEST_HARDCODED_MOVE_2 = "Test Hardcoded Move 2";
	private String autonSelected;
	private SendableChooser<String> autonChooser = new SendableChooser<>();

	public static final String MAIN_TARGET_SPEAKER = "Speaker";
	public static final String MAIN_TARGET_NOWHERE = "Nowhere";
	private String mainTarget;
	private SendableChooser<String> mainTargetChooser = new SendableChooser<>();

	public static final String GAME_PIECE_NONE = "None";
	public static final String GAME_PIECE_1_NOTE = "1 Note";
	public static final String GAME_PIECE_2_NOTES = "2 Notes";
	public static final String GAME_PIECE_3_NOTES = "3 Notes";
	private String gamePieceSelected;
	private SendableChooser<String> gamePieceChooser = new SendableChooser<>();
	
	public static final String START_POSITION_1 = "Starting Position 1";
	public static final String START_POSITION_2 = "Starting Position 2";
	public static final String START_POSITION_3 = "Starting Position 3";
	public static final String START_POSITION_4 = "Starting Position 4";
	public static final String START_POSITION_5 = "Starting Position 5";
	public static final String START_POSITION_6 = "Starting Position 6";
	private String startPosition;
	private SendableChooser<String> startPositionChooser = new SendableChooser<>();

	public static final String AUTON_OPTION_JUST_SHOOT_NOTE = "Just Shoot Note";
	public static final String AUTON_OPTION_LEAVE_COMMUNITY = "Leave Community";
	public static final String AUTON_OPTION_PICKUP_NOTE_AT_MIDLINE = "Pickup Note at Midline";
	public static final String AUTON_OPTION_PICKUP_NOTE_AT_WING = "Pickup Note at Wing";
	private String autonOption;
	private SendableChooser<String> autonOptionChooser = new SendableChooser<>();

	// Subsystems
	private final SwerveDriveTrain drivetrain = new SwerveDriveTrain();
	private final CANLauncher m_launcher = new CANLauncher();
	public static Grabber grabber = new Grabber();
	private final RtClimber m_rtclimber = new RtClimber();
	private final LtClimber m_ltclimber = new LtClimber();
	public static Arm m_Arm= new Arm();

	// misc
	private final Field2d field = new Field2d(); //  a representation of the field

  // The driver's controller
	XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);

	private final CommandXboxController m_operatorController =
	new CommandXboxController(OIConstants.kOperatorControllerPort);
	
	/**
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {

        autonChooser.setDefaultOption("Do Nothing", AUTON_DO_NOTHING);
		autonChooser.addOption("My Auto", AUTON_CUSTOM);
		autonChooser.addOption("Sample Swerve", AUTON_SAMPLE_SWERVE);
		autonChooser.addOption("Sample Move Forward", AUTON_SAMPLE_MOVE_FORWARD);
		autonChooser.addOption("Sample Move In Reverse", AUTON_SAMPLE_MOVE_IN_REVERSE);
		autonChooser.addOption("Sample Move In Gamma Shape", AUTON_SAMPLE_MOVE_IN_GAMMA_SHAPE);
		autonChooser.addOption("Sample Move In L Shape In Reverse", AUTON_SAMPLE_MOVE_IN_L_SHAPE_IN_REVERSE);
		autonChooser.addOption("Test Hardcoded Move 1", AUTON_TEST_HARDCODED_MOVE_1);
		autonChooser.addOption("Test Hardcoded Move 2", AUTON_TEST_HARDCODED_MOVE_2);
		SmartDashboard.putData("Auto choices", autonChooser);

        gamePieceChooser.setDefaultOption("None", GAME_PIECE_NONE);
		gamePieceChooser.addOption("1 Note", GAME_PIECE_1_NOTE);
		gamePieceChooser.addOption("2 Notes", GAME_PIECE_2_NOTES);
		SmartDashboard.putData("Game piece choices", gamePieceChooser);

		mainTargetChooser.setDefaultOption("To Nowhere", MAIN_TARGET_NOWHERE);
		mainTargetChooser.addOption("Speaker", MAIN_TARGET_SPEAKER);
		SmartDashboard.putData("Main targets", mainTargetChooser);
		
		SmartDashboard.putData("Start positions", startPositionChooser);
		startPositionChooser.setDefaultOption("Starting Position 1", START_POSITION_1);
		startPositionChooser.addOption("Starting Position 2", START_POSITION_2);
		startPositionChooser.addOption("Starting Position 3", START_POSITION_3);
		startPositionChooser.addOption("Starting Position 4", START_POSITION_4);
		startPositionChooser.addOption("Starting Position 5", START_POSITION_5);
		startPositionChooser.addOption("Starting Position 6", START_POSITION_6);

        autonOptionChooser.setDefaultOption("Just Shoot Note", AUTON_OPTION_JUST_SHOOT_NOTE);
		autonOptionChooser.addOption("Leave Community", AUTON_OPTION_LEAVE_COMMUNITY);
		autonOptionChooser.addOption("Pickup Note At Midline", AUTON_OPTION_PICKUP_NOTE_AT_MIDLINE);
		autonOptionChooser.addOption("Pickup Note At Wing", AUTON_OPTION_PICKUP_NOTE_AT_WING);
	
		SmartDashboard.putData("Auton options", autonOptionChooser);



		// Configure the button bindings
		configureButtonBindings();

		// Configure default commands
		drivetrain.setDefaultCommand(
			// The left stick controls translation of the robot.
			// Turning is controlled by the X axis of the right stick.
			// We are inverting LeftY because Xbox controllers return negative values when we push forward.
			// We are inverting LeftX because we want a positive value when we pull to the left. Xbox controllers return positive values when you pull to the right by default.
			// We are also inverting RightX because we want a positive value when we pull to the left (CCW is positive in mathematics).
			new RunCommand(
				() -> drivetrain.drive(
					-MathUtil.applyDeadband(m_driverController.getLeftY(), JOYSTICK_AXIS_THRESHOLD),
					-MathUtil.applyDeadband(m_driverController.getLeftX(), JOYSTICK_AXIS_THRESHOLD),
					-MathUtil.applyDeadband(m_driverController.getRightX(), JOYSTICK_AXIS_THRESHOLD),
					true, true),
				drivetrain));
	}

	/**
	 * Use this method to define your button->command mappings. Buttons can be
	 * created by
	 * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
	 * subclasses ({@link
	 * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling
	 * passing it to a
	 * {@link JoystickButton}.
	 */
	private void configureButtonBindings() {

		// driver (joystick)

new JoystickButton(m_driverController, Button.kA.value)
			.onTrue(new InstantCommand(
				() -> drivetrain.zeroHeading(),
				drivetrain).ignoringDisable(true)); 

new JoystickButton(m_driverController, Button.kY.value)
			.onTrue(new InstantCommand(
				() -> drivetrain.resetEncoders(),
				drivetrain).ignoringDisable(true));
//testing stuff//
		//new JoystickButton(m_driverController, Button.kB.value)
			//.onTrue(getAutonomousCommand());
		
			//new JoystickButton(m_driverController, Button.kB.value).onTrue(new DriveTrainZeroHeading(drivetrain));
			//new JoystickButton(m_driverController, Button.kB.value).onTrue(new DrivetrainOppositeHeading(drivetrain));
			//new JoystickButton(m_driverController, Button.kB.value).onTrue(new MoveInLShapeInReverse(drivetrain, this, 3));
		    // new JoystickButton(m_driverController, Button.kB.value).onTrue(new MoveInGammaShape(drivetrain, this, 3));
            //new JoystickButton(m_driverController, Button.kB.value).onTrue(new MoveForward(drivetrain, this, 3));	
//actual driver commands//
			new JoystickButton (m_driverController, Button.kB.value).whileTrue(new rtClimb(m_rtclimber));
			new JoystickButton (m_driverController,Button.kRightBumper.value).whileTrue(new rtclimbdown(m_rtclimber));
			new JoystickButton (m_driverController, Button.kLeftBumper.value).whileTrue(new ltClimb(m_ltclimber));
			new JoystickButton (m_driverController,Button.kX.value).whileTrue(new ltclimbdown(m_ltclimber));

		//Operator//
		   m_operatorController.x().whileTrue(new GrabNote());
		   m_operatorController.rightBumper().whileTrue(new EjectNote());
		   m_operatorController.leftBumper().whileTrue(m_launcher.getIntakeCommand());
		   m_operatorController.b().onTrue(new FeedShooter());
		   m_operatorController.povDown().onTrue(new Floor());
		   m_operatorController.povUp().onTrue(new ScoreAmp());
		
			/*Create an inline sequence to run when the operator presses and holds the A (green) button. Run the PrepareLaunch
			 * command for 1 seconds and then run the LaunchNote command */
			m_operatorController
				.a()
				.whileTrue(new PrepareLaunch(m_launcher)
						.withTimeout(LauncherConstants.kLauncherDelay)
						.andThen(new LaunchNote(m_launcher)).handleInterrupt(() -> m_launcher.stop()));			
		}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		autonSelected = autonChooser.getSelected();
		System.out.println("Auton selected: " + autonSelected);	

		gamePieceSelected = gamePieceChooser.getSelected();
		System.out.println("Game piece selected: " + gamePieceSelected);	
		
		mainTarget = mainTargetChooser.getSelected();
		System.out.println("Main target: " + mainTarget);

		startPosition = startPositionChooser.getSelected();
		System.out.println("Start position: " + startPosition);


		autonOption = autonOptionChooser.getSelected();
		System.out.println("Auton option: " + autonOption);
		

		switch (autonSelected) {
			case AUTON_SAMPLE_SWERVE:
				//return createSwerveControllerCommand(createExampleTrajectory());
				//return new DrivetrainSwerveRelative(drivetrain, this, createExampleTrajectory());
				return new MoveInSShape(drivetrain, this, 3);
				//break;

			case AUTON_SAMPLE_MOVE_FORWARD:
				return new MoveForward(drivetrain, this, 3);
				//break;

			case AUTON_SAMPLE_MOVE_IN_REVERSE:
				return new MoveInReverse(drivetrain, this, 3);
				//break;

			case AUTON_SAMPLE_MOVE_IN_GAMMA_SHAPE:
				return new MoveinGammaShape(drivetrain, this, 3);
				//break;

			case AUTON_SAMPLE_MOVE_IN_L_SHAPE_IN_REVERSE:
				return new MoveInLShapeInReverse(drivetrain, this,3);
				//break;

			case AUTON_TEST_HARDCODED_MOVE_1:
				return new CompletelyLeaveCommunity(drivetrain, this);
				//break;

			case AUTON_TEST_HARDCODED_MOVE_2:
				return new MoveinGammaShape(drivetrain, this, 0);
				//break;*/

			case AUTON_CUSTOM:
				return new CustomAuton(gamePieceSelected, startPosition, autonOption, drivetrain, this, grabber, m_launcher);
				//break;

			case AUTON_DO_NOTHING:
				return null;
				//break;
				
			default:
				// nothing
				return null;
				//break;
		} // end switch
	}

			
	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	//public Command getAutonomousCommand() {

		public TrajectoryConfig createTrajectoryConfig() {
			// Create config for trajectory
			TrajectoryConfig config = new TrajectoryConfig(
				AutoConstants.MAX_SPEED_METERS_PER_SECOND,
				AutoConstants.MAX_ACCELERATION_METERS_PER_SECOND_SQUARED)
				// Add kinematics to ensure max speed is actually obeyed
				.setKinematics(DrivetrainConstants.DRIVE_KINEMATICS);
	
			return config;
		}
	
		public TrajectoryConfig createReverseTrajectoryConfig() {
	
			TrajectoryConfig config = createTrajectoryConfig();
	
			config.setReversed(true); // in reverse!
	
			return config;
		}

// Create config for trajectory
		/*TrajectoryConfig config = new TrajectoryConfig(
			AutoConstants.MAX_SPEED_METERS_PER_SECOND,
			AutoConstants.MAX_ACCELERATION_METERS_PER_SECOND_SQUARED)
			// Add kinematics to ensure max speed is actually obeyed
			.setKinematics(DrivetrainConstants.DRIVE_KINEMATICS);

		// An example trajectory to follow. All units in meters.
		Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(

			// Start at the origin facing the +X direction
			new Pose2d(0, 0, new Rotation2d(0)),
			// Pass through these two interior waypoints, making an 's' curve path
			List.of(new Translation2d(0, 1), new Translation2d(2, -1)),
			// End 3 meters straight ahead of where we started, facing forward
			new Pose2d(3, 0, new Rotation2d(0)),
			config);

		var thetaController = new ProfiledPIDController(
			AutoConstants.THETA_CONTROLLER_P, 0, 0, AutoConstants.THETA_CONTROLLER_CONSTRAINTS);
			
		thetaController.enableContinuousInput(-Math.PI, Math.PI);

		SwerveControllerCommand swerveControllerCommand = new SwerveControllerCommand(
			exampleTrajectory,
			drivetrain::getPose, // Functional interface to feed supplier
			DrivetrainConstants.DRIVE_KINEMATICS,

			// Position controllers
			new PIDController(AutoConstants.X_CONTROLLER_P, 0, 0),
			new PIDController(AutoConstants.Y_CONTROLLER_P, 0, 0),
			thetaController,
			drivetrain::setModuleStates,
			drivetrain);

		// Reset odometry to the starting pose of the trajectory.
		drivetrain.resetOdometry(exampleTrajectory.getInitialPose()); // WARNING: https://github.com/REVrobotics/MAXSwerve-Java-Template/issues/13

		field.getObject("exampleTrajectory").setTrajectory(exampleTrajectory);

		// Run path following command, then stop at the end.
		return swerveControllerCommand.andThen(() -> drivetrain.drive(0, 0, 0, false, false));
	}
*/
	public Field2d getField()
	{
		return field;
	}

	public SwerveDriveTrain getDrivetrain()
	{
		return drivetrain;
	}

	public SendableChooser<String> getAutonChooser()
	{
		return autonChooser;
	}
	
	public SendableChooser<String> getGamePieceChooser()
	{
		return gamePieceChooser;
	}

	public SendableChooser<String> getStartPositionChooser()
	{
		return startPositionChooser;
	}

	public SendableChooser<String> getAutonOptionChooser()
	{
		return autonOptionChooser;
	}


}