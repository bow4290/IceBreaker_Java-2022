
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpinnerSubsystem;

public class SpinSpinnerCommand extends CommandBase {
  private final SpinnerSubsystem spinner;

  public SpinSpinnerCommand(SpinnerSubsystem subsystem) {
    spinner = subsystem;
    addRequirements(spinner);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    spinner.spin(0.45);
  }

  @Override
  public void end(boolean interrupted) {
    spinner.stopSpin();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
