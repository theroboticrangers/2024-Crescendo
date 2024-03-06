package frc.robot.commands.ArmCommands;

//import edu.wpi.first.wpilibj2.command.*;
import frc.robot.RobotContainer;
import static frc.robot.Constants.ArmConstants.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
//import frc.robot.commands.Grab;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ScoreAmp extends SequentialCommandGroup {
  /** Creates a new FeedShooter */
  public ScoreAmp() {

    addRequirements(RobotContainer.m_Arm);
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    //addCommands(new getejectcommand().withTimeout(1),
   addCommands( new SetArmPosition(SCORE_AMP));
  }
}
