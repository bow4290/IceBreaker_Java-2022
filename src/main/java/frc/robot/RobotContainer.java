
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.ControllerConstants;
import frc.robot.commands.SpinSpinnerCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.SpinnerSubsystem;

public class RobotContainer {
  
  public static Joystick xboxController;

  private SpinnerSubsystem spinnerSubsystem;
  private DrivetrainSubsystem drivetrainSubsystem;

  public RobotContainer() {
    xboxController = new Joystick(ControllerConstants.ControllerPort);

    spinnerSubsystem = new SpinnerSubsystem();
    drivetrainSubsystem = new DrivetrainSubsystem();
    
    configureButtonBindings(); 

    drivetrainSubsystem.setDefaultCommand(new RunCommand(() -> drivetrainSubsystem.drive(-getLeftY(), getLeftX()),drivetrainSubsystem));
  }

  private void configureButtonBindings() {
    toggleJoystickButton(xboxController, 1, new SpinSpinnerCommand(spinnerSubsystem));
  }

  public Command getAutonomousCommand() {
    return null;
  }

  private void toggleJoystickButton(Joystick joystick, int button, CommandBase command) {
    new JoystickButton(joystick, button).toggleWhenPressed(command);
  }

  private double getLeftX(){
    return xboxController.getX();
  }

  private double getLeftY(){
    return xboxController.getY();
  }
}
