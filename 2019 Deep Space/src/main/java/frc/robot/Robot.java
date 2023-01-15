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
         NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    NetworkTableEntry tv = table.getEntry("tv");

    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    double v = tv.getDouble(0.0);
    
    
    
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("<variablename>").getDouble(0);
              
    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
    SmartDashboard.putNumber("LimelightV", v);



    double targetOffsetAngle_Vertical = ty.getDouble(0.0);

    // how many degrees back is your limelight rotated from perfectly vertical?
    double limelightMountAngleDegrees = 25.0;
  
    // distance from the center of the Limelight lens to the floor
    double limelightLensHeightInches = 35.5;//WILL CHANGE THIS BECAUSE WE ARE USING A NEW ROBOT
  
    // distance from the target to the floor
    double goalHeightInches = 104.0;//WILL CHANGE BECAUSE THE GOALS ARE NOW DIFFERENT (MIGHT NOT EVEN NEED HEIGHT SINCE WE WORK IN INCHES)
  
    double angleToGoalDegrees = limelightMountAngleDegrees + targetOffsetAngle_Vertical;//AGAIN WE MAY NOT NEED THIS
    double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);//DOUBLE CHECK IF WE ARE GOING TO BE DOING IT THIS WAY)
  
    //calculate distance
    double distanceFromLimelightToGoalInches = (goalHeightInches - limelightLensHeightInches)/Math.tan(angleToGoalRadians); //(COULD POTENTIALLY USE THIS TO TELL
                                                                                                                            //THE ROBOT WHEN TO STOP IN FRONT OF
                                                                                                                            //THE GOAL TO BEGIN RAISING THE ARM,
                                                                                                                            //THEN TO MOVE CLOSER TO SCORE THE GOAL
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

