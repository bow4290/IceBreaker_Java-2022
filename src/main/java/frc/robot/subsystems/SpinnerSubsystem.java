
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SpinnerConstants;

public class SpinnerSubsystem extends SubsystemBase {
  private final WPI_VictorSPX spinnerMotor;

  public SpinnerSubsystem() {
    spinnerMotor = new WPI_VictorSPX(SpinnerConstants.spinnerMotorChannel);

    spinnerMotor.setInverted(false);
  }

  public void spin(double speed){
    spinnerMotor.set(speed);
  }

  public void stopSpin(){
    spin(0.0);
  }

  @Override
  public void periodic() {
  }
}
