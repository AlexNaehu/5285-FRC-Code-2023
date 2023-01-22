/*
 *  Author : Alex Naehu

 *  Methods : 
 
 *  Functionality : 
 *   
 *  Revision History : First Created 1/13/23
 * 
 */
package frc.Mechanisms;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.BananaConstants;

public class BananaDriveTrain 
{     
    private CANSparkMax Rdrive1 = new CANSparkMax(27, MotorType.kBrushless);
    private CANSparkMax Rdrive2 = new CANSparkMax(28, MotorType.kBrushless);
    private CANSparkMax Ldrive1 = new CANSparkMax(26, MotorType.kBrushless); 
    private CANSparkMax Ldrive2 = new CANSparkMax(25, MotorType.kBrushless);
    
    private MotorControllerGroup RIGHT = new MotorControllerGroup(Rdrive1, Rdrive2);
    private MotorControllerGroup LEFT = new MotorControllerGroup(Ldrive1, Ldrive2);

    private DifferentialDrive drivebase = new DifferentialDrive(RIGHT, LEFT);

    private double left_command = 0;
    private double right_command = 0;

    public BananaDriveTrain()
    {

    }
}