package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.ClimberConstants.*;
import com.revrobotics.CANSparkMax;

public class  RtClimber extends SubsystemBase {

  private CANSparkMax rtclimber_motor;
  /** Creates a new Grabber. */
  public RtClimber() {
    rtclimber_motor = new CANSparkMax(krtclimberID, MotorType.kBrushless);
    rtclimber_motor.restoreFactoryDefaults();
    rtclimber_motor.setIdleMode(IdleMode.kCoast);
    rtclimber_motor.setSmartCurrentLimit(25);


  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setrtclimberwheel(double speed) {
    rtclimber_motor.set(speed);
  }

  public void setrtclimberwheel() {
    rtclimber_motor.set(-1);
  }
}