package frc.robot.subsystems;



import org.littletonrobotics.junction.AutoLog;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

@AutoLog
public class Tank extends SubsystemBase {
    
    private CANSparkMax leftFront = new CANSparkMax(3, MotorType.kBrushless);
    private CANSparkMax rightFront = new CANSparkMax(25, MotorType.kBrushless);
    private CANSparkMax leftBack = new CANSparkMax(9, MotorType.kBrushless);
    private CANSparkMax rightBack = new CANSparkMax(5, MotorType.kBrushless);
    private double maxSpeed = 5;
    private double maxRotSpeed = 5;
    public static double leftFrontSpeed;
    public static double rightFrontSpeed;
    public static double leftBackSpeed;
    public static double rightBackSpeed;
    
    // private DifferentialDriveKinematics kinematics;
    
    public Tank() {
        leftFront.setInverted(true);
        rightBack.setInverted(true);
    }

    @Override 
    public void periodic(){
    }
    // leftSpeed = speed + rotSpeed/2
    // rightSpeed = speed - rotSpeed/2
    public void Drive(double speed, double rotSpeed){
      // left
      leftBack.set((speed / maxSpeed) - (rotSpeed / (2 * maxRotSpeed)));
      leftBackSpeed = ((speed / maxSpeed) - (rotSpeed / (2 * maxRotSpeed)));
      leftFront.set((speed / maxSpeed) - (rotSpeed / (2 * maxRotSpeed)));
      leftFrontSpeed = ((speed / maxSpeed) - (rotSpeed / (2 * maxRotSpeed)));
      // right
      rightBack.set((speed / maxSpeed) + (rotSpeed / (2 * maxRotSpeed)));
      rightBackSpeed = ((speed / maxSpeed) + (rotSpeed / (2 * maxRotSpeed)));
      rightFront.set((speed / maxSpeed) + (rotSpeed / (2 * maxRotSpeed)));
      rightFrontSpeed = ((speed / maxSpeed) + (rotSpeed / (2 * maxRotSpeed)));
    }
  
}
