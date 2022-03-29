
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DoorConstants;
import frc.robot.subsystems.DoorSubsystem;

public class OpenDoorCommand extends CommandBase {
  private DoorSubsystem doorSubsystem;

  public OpenDoorCommand(DoorSubsystem doorSubsystem) {
    this.doorSubsystem = doorSubsystem;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    doorSubsystem.getEncoderPosition();

    if (doorSubsystem.getEncoderPosition() >= DoorConstants.forwardSoftLimit) {
      doorSubsystem.stopDoor();
    } else {
      doorSubsystem.moveDoor(.2);
    }
  }

  @Override
  public void end(boolean interrupted) {
    doorSubsystem.stopDoor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
