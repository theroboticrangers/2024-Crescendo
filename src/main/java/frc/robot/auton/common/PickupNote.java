package frc.robot.auton.common;

import java.util.List;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;

import frc.robot.auton.AutonConstants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.*;
import frc.robot.commands.drivetrain.*;
import frc.robot.commands.ArmCommands.GrabNote;
import frc.robot.commands.ArmCommands.SetArmPosition;
import static frc.robot.Constants.ArmConstants.*;


public class PickupNote extends ParallelCommandGroup{
    
    public PickupNote(SwerveDriveTrain drivetrain, RobotContainer container, Grabber grabber) {

        addCommands(

            new SetArmPosition(FLOOR_POSITION),
        
			new GrabNote(),withTimeout(1),

            new DrivetrainSwerveRelative(drivetrain, container, createAreaBeforeNotePickupTrajectory(container))        
        );
    }
    
    public Trajectory createAreaBeforeNotePickupTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(0, 0, Rotation2d.fromDegrees(0.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(AutonConstants.DISTANCE_TO_PICKUP_NOTE_METERS, 0, Rotation2d.fromDegrees(0)),
			container.createTrajectoryConfig());

		return trajectory;
	}
}

