package frc.robot.auton.common;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
//import frc.robot.RobotContainer;
//import frc.robot.auton.AutonConstants;
import frc.robot.commands.LaunchNote;
import frc.robot.commands.PrepareLaunch;
import frc.robot.commands.ArmCommands.EjectNote;
import frc.robot.subsystems.*;
import frc.robot.Constants.LauncherConstants;

public class ShootNote extends SequentialCommandGroup {

    public ShootNote(CANLauncher m_launcher, Grabber grabber) {

        addCommands(

        new PrepareLaunch(m_launcher).withTimeout(LauncherConstants.kLauncherDelay),

			new EjectNote().withTimeout(.5),

			new LaunchNote(m_launcher).handleInterrupt(() -> m_launcher.stop()),

			new WaitCommand(.25) //.5 //1 // we wait so when we pick up the next note, it doesn't shoot up :)
                        
        ); 
  
    }
   
}