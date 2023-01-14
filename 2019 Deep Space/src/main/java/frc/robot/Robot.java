package frc.robot;

//Utilizes all mechanisms for the robot and runs their programs to perform each function

import frc.Autonomous.BananaDriveStraight;
import frc.Autonomous.BananaTurn;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.Mechanisms.BananaArm;
import frc.Mechanisms.BananaDriveTrain;
import frc.Mechanisms.BananaIntake;
import frc.Mechanisms.BananaLift;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot 
{
  public static BananaArm         arm;
  public static BananaDriveTrain  driveTrain;
  public static BananaIntake      intake;
  public static BananaLift        lift;

 

  @Override
  public void robotInit() 
  {

    /*--------------------------------------------------------------------------
    *  Initialize Drive Cameras
    *-------------------------------------------------------------------------*/
   
   
   
    /*--------------------------------------------------------------------------
    *  Initialize Mechanisms & Drive Controllers
    *-------------------------------------------------------------------------*/
    arm        = new BananaArm();
    driveTrain = new BananaDriveTrain();
    intake     = new BananaIntake();
    lift       = new BananaLift();
  
    xboxDrv    = new XboxController(XBOX_DRV_PORT);
    xboxAux    = new XboxController(XBOX_AUX_PORT);
    
    /*--------------------------------------------------------------------------
    *  Initialize Vision
    *-------------------------------------------------------------------------*/
    

    /*--------------------------------------------------------------------------
    *  Engage Mechanical Brakes, Set Target Angles to Current Angles & Start
    *  PID Threads
    *-------------------------------------------------------------------------*/
    
  }


  @Override
  public void robotPeriodic() 
  {

  }

  @Override
  public void autonomousInit() 
  {
    //initializeRobotPositions();
  }

  @Override
  public void autonomousPeriodic()
  {
    //robotControls();
  }

  @Override
  public void teleopInit() 
  {
    //initializeRobotPositions();
  
  }

  @Override
  public void teleopPeriodic() 
  {
    //robotControls();
    
  }


  private void initializeRobotPositions()
  {
   
  }

  private void robotControls()
  { 
    
    /*--------------------------------------------------------------------------
    *  DriveBase and lift controls
    *-------------------------------------------------------------------------*/
   
   
   
   
     /*--------------------------------------------------------------------------
    *  DriveBase shifter
    *-------------------------------------------------------------------------*/
     
     
     
     
     
     /*--------------------------------------------------------------------------
    *  Pivot Movement
    *-------------------------------------------------------------------------*/
   
   
   
   
      /*--------------------------------------------------------------------------
    *  Arm Movement - Manual Control
    *-------------------------------------------------------------------------*/
      
      
      
      
    
       /*-----------------------------------------------------------------------
       *  Out of Deadband - Manual Control
       *----------------------------------------------------------------------*/
       
       /*-----------------------------------------------------------------------
       *  In Deadband - Hold Position
       *----------------------------------------------------------------------*/
      
         // only stop arm if pid thread is not running 
         
         
     /*--------------------------------------------------------------------------
    *  Drive Controller - Presets
    *-------------------------------------------------------------------------*/
     
     
   

    /*--------------------------------------------------------------------------
    *  Aux Controller - Hatch Position Presets
    *-------------------------------------------------------------------------*/
     
     
  

     /*--------------------------------------------------------------------------
    *  Aux Controller - Cargo Position Presets
    * preset arm positions
    *-------------------------------------------------------------------------*/
     
     
    

    /*--------------------------------------------------------------------------
    *  Wrist Movement
    *-------------------------------------------------------------------------*/
     
     
    
    
      
    
  }
}

