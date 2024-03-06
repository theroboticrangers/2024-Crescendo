package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.subsystems.SwerveDriveTrain;

/**
 * Stops drivetrain.
 */
public class DrivetrainStop extends InstantCommand {

	private SwerveDriveTrain drivetrain;

	public DrivetrainStop(SwerveDriveTrain drivetrain) {
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
		System.out.println("DrivetrainStop: initialize");
		drivetrain.stop();
	}

}