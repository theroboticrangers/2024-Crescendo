package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkAbsoluteEncoder.Type;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.ArmConstants.*;

public class Arm extends SubsystemBase {

  public CANSparkMax Arm_motor;
  public AbsoluteEncoder arm_encoder;
  

  private SparkPIDController armPIDController;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;

  //private double maxSpeed = 0.25;
  //private double deadBand = 0.1;

  /** Creates a new Intake. */
  public Arm() {
    Arm_motor = new CANSparkMax(ArmID, MotorType.kBrushless);
    Arm_motor.restoreFactoryDefaults();

    armPIDController = Arm_motor.getPIDController();
    arm_encoder = Arm_motor.getAbsoluteEncoder(Type.kDutyCycle);
    armPIDController.setFeedbackDevice(arm_encoder);

    //arm_encoder.setPositionConversionFactor(360);
    //m_AbsoluteEncoder.setVelocityConversionFactor(1);

    Arm_motor.setInverted(false);
    Arm_motor.setIdleMode(IdleMode.kBrake);
    arm_encoder.setZeroOffset(.5);

    Arm_motor.setSmartCurrentLimit(60);
   

    kP = 1.4; //2.5 last working value from Ferradermis Code on their wrist
    kI = 0;
    kD = 0.01;
    kIz = 0;
    kFF = 0.001;
    kMaxOutput = 1;
    kMinOutput = -1;

    armPIDController.setP(kP);
    armPIDController.setI(kI);
    armPIDController.setD(kD);
    armPIDController.setIZone(kIz);
    armPIDController.setFF(kFF);
    armPIDController.setOutputRange(kMinOutput, kMaxOutput);

    armPIDController.setPositionPIDWrappingEnabled(false);
    armPIDController.setPositionPIDWrappingMinInput(0);
    armPIDController.setPositionPIDWrappingMaxInput(1);
  }

  @Override

  public void periodic() {
    SmartDashboard.putNumber("Arm Position", getAbsoluteEncoderPosition());
    //SmartDashboard.putNumber("Arm encoder", Arm_motor.getEncoder().getPosition());
    }

  public void setArmSpeed(double speed)
  {
    Arm_motor.set(speed);
  }

    public void stop()
  {
    Arm_motor.stopMotor();
  }

    public double getAbsoluteEncoderPosition() {
    return arm_encoder.getPosition();
  }

    public void setPosition(double position) {
    armPIDController.setReference(position, CANSparkMax.ControlType.kPosition);
  }


}
