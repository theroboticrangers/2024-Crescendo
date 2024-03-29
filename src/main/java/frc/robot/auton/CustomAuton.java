/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.RobotContainer;
//import frc.robot.auton.sp1.*;
//import frc.robot.auton.common.*;
import frc.robot.subsystems.*;

public class CustomAuton extends SequentialCommandGroup {

	String gamePiece;
	String startPosition;
	String mainTarget;
	String autonOption;

	/**
     * Add your docs here.
     * 
     * @param gamePiece_in game piece
	 * @param startPosition_in starting position
     * @param mainTarget_in    main target
     * @param autonOption_in   auton option
    */
    public CustomAuton(String gamePiece_in, String startPosition_in, String mainTarget_in, String cameraOption_in,
            String sonarOption_in, String autonOption_in, SwerveDriveTrain drivetrain, RobotContainer container,CANLauncher mLauncher, Grabber grabber) {

		gamePiece = gamePiece_in;
		startPosition = startPosition_in;
		mainTarget = mainTarget_in;
		//autonOption = autonOption_in;

		switch (startPosition) {
			case RobotContainer.START_POSITION_1:
				switch (gamePiece) {
					case RobotContainer.GAME_PIECE_1_NOTE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_SHOOT_NOTE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_PICKUP_NOTE_AT_MIDLINE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.GAME_PIECE_2_NOTES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_SHOOT_NOTE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_PICKUP_NOTE_AT_MIDLINE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_PICKUP_NOTE_AT_WING:
							//TODO
							break;
							default:
								// nothing
								break;
						}	
						break;
			case RobotContainer.START_POSITION_2:
				switch (gamePiece) {
					case RobotContainer.GAME_PIECE_1_NOTE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_SHOOT_NOTE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_PICKUP_NOTE_AT_MIDLINE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					
			case RobotContainer.START_POSITION_3:
				switch (gamePiece) {
					case RobotContainer.GAME_PIECE_1_NOTE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_SHOOT_NOTE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_PICKUP_NOTE_AT_MIDLINE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					}
					
			case RobotContainer.START_POSITION_4:
				switch (gamePiece) {
					case RobotContainer.GAME_PIECE_1_NOTE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_SHOOT_NOTE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_PICKUP_NOTE_AT_MIDLINE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;
					case RobotContainer.GAME_PIECE_2_NOTES:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_SHOOT_NOTE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_PICKUP_NOTE_AT_MIDLINE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_PICKUP_NOTE_AT_WING:
								//TODO
								break;
					default:
						// nothing
						break;
						
				}
				break;
			}
			case RobotContainer.START_POSITION_6:
				switch (gamePiece) {
					case RobotContainer.GAME_PIECE_1_NOTE:
						switch (autonOption) {
							case RobotContainer.AUTON_OPTION_JUST_SHOOT_NOTE:
								//TODO
								break;
							case RobotContainer.AUTON_OPTION_LEAVE_COMMUNITY:
								//addCommands(new DropTopCubeAndShrink(container, elevator, drawer, roller));
								break;
							case RobotContainer.AUTON_OPTION_PICKUP_NOTE_AT_MIDLINE:
								//TODO
								break;
							default:
								// nothing
								break;
						}	
						break;			}
					}
				}
			}
		}

	 // end switch

	public CustomAuton(String gamePieceSelected, String startPosition2, String autonOption, SwerveDriveTrain drivetrain,
			RobotContainer robotContainer, Grabber grabber, CANLauncher m_launcher) {
	}
			}
		
					