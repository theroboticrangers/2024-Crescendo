package frc.robot.auton.sp3;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.auton.AutonConstants;
//import frc.robot.auton.common.*;
import frc.robot.commands.ArmCommands.GrabNote;
import frc.robot.commands.ArmCommands.SetArmPosition;
import static frc.robot.Constants.ArmConstants.*;
import frc.robot.commands.drivetrain.*;
import frc.robot.subsystems.*;



// GP = game piece
// Can be used to place one cube or one cone and either starting position one or two
public class StartingPositionThreePickupSecondNote extends SequentialCommandGroup {

    public StartingPositionThreePickupSecondNote(RobotContainer container, SwerveDriveTrain drivetrain, Arm m_Arm, Grabber grabber){

        addCommands(

			new SetArmPosition(FLOOR_POSITION),

            new GrabNote().withTimeout(1),

			new DrivetrainSwerveRelative(drivetrain, container, createPickupSecondNoteTrajectory(container))
            
        );  
  
    }
   
    public Trajectory createPickupSecondNoteTrajectory(RobotContainer container) {
		// An example trajectory to follow. All units in meters.
		Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
			// Start at the origin facing the -X direction
			new Pose2d(AutonConstants.STARTING_POSITION_3_X_VALUE-AutonConstants.STARTING_POSITION_3_X_VALUE, AutonConstants.STARTING_POSITION_3_Y_VALUE-AutonConstants.STARTING_POSITION_3_Y_VALUE, Rotation2d.fromDegrees(180.0)),
			// Pass through these waypoints
			List.of(),
			// End straight ahead of where we started, facing forward
			new Pose2d(AutonConstants.STARTING_POSITION_3_X_VALUE-AutonConstants.DISTANCE_FROM_STARTING_POSITION_3_TO_SECOND_NOTE_PICKUP_X, AutonConstants.STARTING_POSITION_3_Y_VALUE-AutonConstants.DISTANCE_FROM_STARTING_POSITION_3_TO_SECOND_NOTE_PICKUP_Y, Rotation2d.fromDegrees(60)),
            container.createTrajectoryConfig());

		return trajectory;
	}


}
