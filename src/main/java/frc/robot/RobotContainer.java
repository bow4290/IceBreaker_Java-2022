
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.ControllerConstants;
import frc.robot.commands.CloseDoorCommand;
import frc.robot.commands.OpenDoorCommand;
import frc.robot.commands.SpinSpinnerCommand;
import frc.robot.subsystems.DoorSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.SpinnerSubsystem;

public class RobotContainer {
  
  public static Joystick xboxController;

  private SpinnerSubsystem spinnerSubsystem;
  private DrivetrainSubsystem drivetrainSubsystem;
  private DoorSubsystem doorSubsystem;

  public RobotContainer() {
    xboxController = new Joystick(ControllerConstants.ControllerPort);

    spinnerSubsystem = new SpinnerSubsystem();
    drivetrainSubsystem = new DrivetrainSubsystem();
    doorSubsystem = new DoorSubsystem();
    
    configureButtonBindings(); 

    drivetrainSubsystem.setDefaultCommand(new RunCommand(() -> drivetrainSubsystem.drive(-getLeftY(), getLeftX()),drivetrainSubsystem));
  }

  private void configureButtonBindings() {
    toggleJoystickButton(xboxController, 1, new SpinSpinnerCommand(spinnerSubsystem));
    setJoystickButtonWhenPressed(xboxController, 5, new CloseDoorCommand(doorSubsystem));
    setJoystickButtonWhenPressed(xboxController, 6, new OpenDoorCommand(doorSubsystem));
  }

  public Command getAutonomousCommand() {
    return null;
  }

  private void toggleJoystickButton(Joystick joystick, int button, CommandBase command) {
    new JoystickButton(joystick, button).toggleWhenPressed(command);
  }

  private void setJoystickButtonWhenPressed(Joystick joystick, int button, CommandBase command) {
    new JoystickButton(joystick, button).whenPressed(command);
  }

  private double getLeftX(){
    return xboxController.getX();
  }

  private double getLeftY(){
    return xboxController.getY();
  }
}
