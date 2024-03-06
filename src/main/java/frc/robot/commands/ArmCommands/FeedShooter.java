package frc.robot.commands.ArmCommands;

//import edu.wpi.first.wpilibj2.command.*;
import frc.robot.RobotContainer;
import static frc.robot.Constants.ArmConstants.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FeedShooter extends SequentialCommandGroup {
  /** Creates a new FeedShooter */
  public FeedShooter() {
    addRequirements(RobotContainer.m_Arm);
    // Add your commands in the addCommands() call, e.g.
    addCommands(
       new SetArmPosition(FEED_SHOOTER));
       //new GrabNote().withTimeout(.5),
       //new EjectNote());
  }
}