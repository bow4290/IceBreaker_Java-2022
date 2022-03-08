package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DoorConstants;

public class DoorSubsystem extends SubsystemBase {
  public static WPI_TalonFX doorMotor = new WPI_TalonFX(DoorConstants.doorMotorChannel);

  public DoorSubsystem() {
    doorMotor.configFactoryDefault();
    doorMotor.setInverted(TalonFXInvertType.Clockwise);
    doorMotor.setNeutralMode(NeutralMode.Brake);
    doorMotor.configVoltageCompSaturation(DoorConstants.doorMotorVoltage);
    doorMotor.enableVoltageCompensation(true);
    doorMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
    doorMotor.configForwardSoftLimitThreshold(1000, 0); //TODO test raw sensor units for correct soft limit
    doorMotor.configReverseSoftLimitThreshold(-10, 0); //TODO test raw sensor units for correct soft limit
  }

  public void moveDoor(double speed) {
    doorMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
  }
}
