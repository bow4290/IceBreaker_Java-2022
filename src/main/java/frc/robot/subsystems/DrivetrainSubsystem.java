
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DrivetrainSubsystem extends SubsystemBase {
  
  private final MotorControllerGroup leftDriveMotors =
    new MotorControllerGroup(
      new WPI_VictorSPX(DriveConstants.leftMotor1Channel),
      new WPI_VictorSPX(DriveConstants.leftMotor2Channel));

  private final MotorControllerGroup rightDriveMotors =
    new MotorControllerGroup(
      new WPI_VictorSPX(DriveConstants.rightMotor1Channel),
      new WPI_VictorSPX(DriveConstants.rightMotor2Channel));

  private final DifferentialDrive drivetrain = new DifferentialDrive(leftDriveMotors, rightDriveMotors);

  public DrivetrainSubsystem() {
    leftDriveMotors.setInverted(false);
    rightDriveMotors.setInverted(true);
  }

  public void drive(double forward, double rotation){
    drivetrain.arcadeDrive((forward*.7), (rotation*.7), true);
  }

  public void stopDrive(){
    drive(0,0);
  }
  
  @Override
  public void periodic() {
  }
}
