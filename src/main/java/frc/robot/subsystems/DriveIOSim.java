package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;



public class DriveIOSim implements DriveIO{

    private CANSparkMax leftFront = new CANSparkMax(3, MotorType.kBrushless);
    private CANSparkMax rightFront = new CANSparkMax(25, MotorType.kBrushless);
    private CANSparkMax leftBack = new CANSparkMax(9, MotorType.kBrushless);
    private CANSparkMax rightBack = new CANSparkMax(5, MotorType.kBrushless);


    public DriveIOSim() {
        leftFront.setInverted(true);
        rightBack.setInverted(true);
    }
    
    public void updateInputs(DriveIOInputs inputs){
      inputs.leftFrontVelocity = Tank.leftFrontSpeed;
      inputs.leftBackVelocity = Tank.leftBackSpeed;
      inputs.rightFrontVelocity = Tank.rightFrontSpeed;
      inputs.rightBackVelocity = Tank.rightBackSpeed;
    }
    public void setVelocity(DriveIOInputs inputs){
        // left
      leftBack.set(inputs.leftBackVelocity);
      leftFront.set(inputs.leftFrontVelocity);
      // right
      rightBack.set(inputs.rightBackVelocity);
      rightFront.set(inputs.rightFrontVelocity);
    }
}