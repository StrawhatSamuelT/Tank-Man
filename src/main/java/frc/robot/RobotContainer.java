// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import org.littletonrobotics.junction.inputs.LoggableInputs;

import com.redstorm509.stormkit.controllers.LogitechDualAction;
import com.redstorm509.stormkit.controllers.LogitechDualAction.LogiButton;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Blinkin;
import frc.robot.subsystems.Tank;

import frc.robot.subsystems.Blinkin.BlinkinLedMode;


public class RobotContainer {
  private Tank tank;
  private LogitechDualAction controller = new LogitechDualAction(0);
  public BlinkinLedMode ledMode;
  public static Blinkin blinkin;
  
  public RobotContainer() {
    tank = new Tank();

    configureBindings();
  }
 
  private void configureBindings() {
   tank.setDefaultCommand(new DriveCommand(() -> -controller.getRightStickX(), () -> controller.getLeftStickY(), tank));
   controller.isPressedBind(LogiButton.A, new InstantCommand(() -> {ledMode = Blinkin.BlinkinLedMode.SOLID_DARK_RED;
    blinkin.setMode(ledMode);}));
  }

  
  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
