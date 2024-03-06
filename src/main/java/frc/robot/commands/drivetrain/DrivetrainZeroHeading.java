package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.SwerveDriveTrain;

/**
 * Resets the heading to zero.
 */
public class DrivetrainZeroHeading extends InstantCommand {

	private SwerveDriveTrain drivetrain;

	public DrivetrainZeroHeading(SwerveDriveTrain drivetrain) {
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
		System.out.println("DrivetrainZeroHeading: initialize");
		drivetrain.zeroHeading();
	}

}