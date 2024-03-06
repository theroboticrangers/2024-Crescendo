package frc.robot.commands.drivetrain;

import edu.wpi.first.math.trajectory.Trajectory;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.SwerveDriveTrain;
import frc.robot.RobotContainer;

/**
 * Swerve-drives along trajectory. Trajectory is assumed to contain absolute coordinates.
 */
public class DrivetrainSwerveAbsolute extends SequentialCommandGroup {

	public DrivetrainSwerveAbsolute(SwerveDriveTrain drivetrain, RobotContainer container, Trajectory trajectory) {

		addCommands(
			new FieldSetTrajectory(container, trajectory, false),
			new DrivetrainFollowTrajectoryAndStop(drivetrain, trajectory));
	}

}