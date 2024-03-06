package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.GrabberConstants.*;
import com.revrobotics.CANSparkMax;

public class  Grabber extends SubsystemBase {

  private CANSparkMax grabber_motor;
  /** Creates a new Grabber. */
  public Grabber() {
    grabber_motor = new CANSparkMax(grabberID, MotorType.kBrushless);
    grabber_motor.restoreFactoryDefaults();
    grabber_motor.setIdleMode(IdleMode.kCoast);
    grabber_motor.setSmartCurrentLimit(25);


  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setGrabberSpeed(double speed) {
    grabber_motor.set(speed);
  }

  public void setOutakeSpeed() {
    grabber_motor.set(-1);
  }
}