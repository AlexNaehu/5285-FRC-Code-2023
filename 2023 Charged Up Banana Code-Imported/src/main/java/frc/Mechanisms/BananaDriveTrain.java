
/*
 *  Author : Alex Naehu

 *  Methods : 
 
 *  Functionality : 
 *   
 *  Revision History : First Created 1/13/23
 * 
 */
package frc.Mechanisms;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
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

    private static int Rdrive1ID = 27;
    private static int Rdrive2ID = 28;
    private static int Ldrive1ID = 26;
    private static int Ldrive2ID = 25;

    private MotorControllerGroup RIGHT = new MotorControllerGroup(Rdrive1, Rdrive2);
    private MotorControllerGroup LEFT = new MotorControllerGroup(Ldrive1, Ldrive2);

    private DifferentialDrive drivebase = new DifferentialDrive(RIGHT, LEFT);

    private double left_command = 0;
    private double right_command = 0;
    
    private final double SPARKMAX_INTEGRATED_ENC_CNTS_PER_REV      = 2048.0;
    private final double DRVTRAIN_WHEEL_RADIUS                    = 2;
    private final double DRVTRAIN_WHEEL_CIRCUMFERENCE             = (2.0 * Math.PI * DRVTRAIN_WHEEL_RADIUS);

   
    public  double         currentEncCountsToInches = 0.0;
 
    
 
 
    /*----------------------------------------------------------------------------------------------
    *  Autonomous Closed Loop Control - Velocity
    *---------------------------------------------------------------------------------------------*/
    private final int DRVTRAIN_VELOCITY_PID_IDX = 0;
    private final int PID_TIMEOUT_MS            = 10;

    public final double RT_PID_P = 0.04;  
    public final double RT_PID_I = 0.0; 
    public final double RT_PID_D = 0.0;    
    public final double RT_PID_F = 1080.0/20480.0; 

    public final double LT_PID_P = 0.04;  //TBD-MH: verify lt and rt values
    public final double LT_PID_I = 0.0; 
    public final double LT_PID_D = 0.0;    
    public final double LT_PID_F = 1080.0/20480.0;  //TBD-MH:  ADD COMMENTS & DEFINE CONSTANTS

    private      double drvStraightTargetVelocityOffsetFwd = 50.0;
    private      double drvStraightTargetVelocityOffsetBwd = 50.0;

 
 
    public BananaDriveTrain()
    {
     
       Rdrive1.restoreFactoryDefaults();
       Rdrive2.restoreFactoryDefaults();
       Ldrive1.restoreFactoryDefaults();
       Ldrive2.restoreFactoryDefaults();
      
       //BACK MOTORS FOLLOW FRONT MOTORS
       Rdrive2.follow(Rdrive1);
       Ldrive2.follow(Ldrive1);
     
       Rdrive1.setInverted(true);
       Rdrive2.setInverted(true);
     
     
     
       //setDriveTrainPIDConfiguration(LEFT, LT_PID_P, LT_PID_I, LT_PID_D, LT_PID_F); //TBD Only used for autonomous
       //setDriveTrainPIDConfiguration(RIGHT, RT_PID_P, RT_PID_I, RT_PID_D, RT_PID_F);
     
      /*----------------------------------------------------------------------------------------------
    *
    *  Closed Loop Control Methods
    *
    *---------------------------------------------------------------------------------------------*/
    }
     
      /*  public void setDriveTrainPIDConfiguration(MotorControllerGroup side, double kP, double kI, double kD, double kF) 
    {

        //Configure PID Gain Constants
        if (side == LEFT) 
        {
             //Configure feedback device for PID loop
             //Change Talon to SparkMax
            Ldrive1.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, DRVTRAIN_VELOCITY_PID_IDX,
                                                                                                PID_TIMEOUT_MS);
            Ldrive1.config_kP(DRVTRAIN_VELOCITY_PID_IDX, kP);
            Ldrive1.config_kI(DRVTRAIN_VELOCITY_PID_IDX, kI);
            Ldrive1.config_kD(DRVTRAIN_VELOCITY_PID_IDX, kD);
            Ldrive1.config_kF(DRVTRAIN_VELOCITY_PID_IDX, kF);

        } 
        else 
        {
            Rdrive1.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, DRVTRAIN_VELOCITY_PID_IDX, 
                                                                                                PID_TIMEOUT_MS);
            Rdrive1.config_kP(DRVTRAIN_VELOCITY_PID_IDX, kP);
            Rdrive1.config_kI(DRVTRAIN_VELOCITY_PID_IDX, kI);
            Rdrive1.config_kD(DRVTRAIN_VELOCITY_PID_IDX, kD);
            Rdrive1.config_kF(DRVTRAIN_VELOCITY_PID_IDX, kF);
        }
         
    }   //End of setDriveTrainPIDConfiguration()
     */
       
     /*----------------------------------------------------------------------------------------------
    *
    *  Motor Config & Status Methods
    *
    *---------------------------------------------------------------------------------------------*/
    public void setToBrakeMode()
    {
        Ldrive1.setIdleMode(IdleMode.kBrake); 
        Ldrive2.setIdleMode(IdleMode.kBrake);
        Rdrive1.setIdleMode(IdleMode.kBrake);
        Rdrive2.setIdleMode(IdleMode.kBrake);
    }

    public void setToCoastMode() 
    {
        Ldrive1.setIdleMode(IdleMode.kCoast); 
        Ldrive2.setIdleMode(IdleMode.kCoast);
        Rdrive1.setIdleMode(IdleMode.kCoast);
        Rdrive2.setIdleMode(IdleMode.kCoast);
    }
     public double getMotorTemperature(int id)
    {
        double temp = -999.0;
        switch (id)
        {
            case 27:
                temp = Rdrive1.getMotorTemperature();
            break;

            case 28:
                temp = Rdrive2.getMotorTemperature();
            break;

            case 26:
                temp = Ldrive1.getMotorTemperature();
            break;
                
            case 25:
                temp = Ldrive2.getMotorTemperature();
            break;

            default :
                temp = -999.0;          
        }
        return temp; 
    }

}