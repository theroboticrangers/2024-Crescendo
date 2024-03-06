package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.SwerveDriveTrain;

/**
 * Switches heading to opposite.
 */
public class DrivetrainOppositeHeading extends InstantCommand {

	private SwerveDriveTrain drivetrain;

	public DrivetrainOppositeHeading(SwerveDriveTrain drivetrain) {
		this.drivetrain = drivetrain;
		addRequirements(drivetrain);
	}

	// This instant command can run disabled
	@Override
	public boolean runsWhenDisabled() {
		return true;
	}

	// Called once when this command runs
	@Override
	public void initialize() {
		System.out.println("DrivetrainOppositeHeading: initialize");
		drivetrain.oppositeHeading();
	}

}