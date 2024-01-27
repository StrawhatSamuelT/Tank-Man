package frc.robot.commands;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Tank;
import frc.robot.subsystems.Blinkin.BlinkinLedMode;


public class DriveCommand extends Command {
    DoubleSupplier xSupplier;
    DoubleSupplier theta;
    Tank tank;
    public BlinkinLedMode ledMode;
    public DriveCommand(DoubleSupplier xSupplier, DoubleSupplier theta, Tank tank){
     this.xSupplier = xSupplier;
     this.theta = theta;
     this.tank = tank;
     addRequirements(tank);
    }
   
    @Override
    public void execute() {
        tank.Drive(xSupplier.getAsDouble()*2, theta.getAsDouble());
    }
}
