package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.ClimberConstants.*;
import com.revrobotics.CANSparkMax;

public class  LtClimber extends SubsystemBase {

  private CANSparkMax ltclimber_motor;
  /** Creates a new Grabber. */
  public LtClimber() {
    ltclimber_motor = new CANSparkMax(kltclimberID, MotorType.kBrushless);
    ltclimber_motor.restoreFactoryDefaults();
    ltclimber_motor.setIdleMode(IdleMode.kCoast);
    ltclimber_motor.setSmartCurrentLimit(25);


  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setltClimberWheel(double speed) {
    ltclimber_motor.set(speed);
  }

  public void setltClimberWheel() {
    ltclimber_motor.set(-1);
  }
}