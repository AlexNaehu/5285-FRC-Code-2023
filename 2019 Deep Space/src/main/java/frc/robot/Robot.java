package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import frc.Mechanisms.CatzArm;
import frc.Mechanisms.CatzClimber;
import frc.Mechanisms.CatzDriveTrain;
import frc.Mechanisms.CatzIntake;
import frc.Mechanisms.CatzLift;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot 
{
  private CatzArm        arm;
  private CatzClimber    climber;
  private CatzDriveTrain driveTrain;
  private CatzIntake     intake;
  private CatzLift       lift;

  public static AHRS navx;

  private static XboxController xboxDrv;
  private static XboxController xboxAux;

  private static final int XBOX_DRV_PORT = 0;
  private static final int XBOX_AUX_PORT = 1;

  private static final double MAX_POWER  = 1;
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() 
  {
    navx = new AHRS(SPI.Port.kMXP,(byte)200);  

    arm        = new CatzArm();
    climber    = new CatzClimber();
    driveTrain = new CatzDriveTrain();
    intake     = new CatzIntake();
    lift       = new CatzLift();
    
    xboxDrv = new XboxController(XBOX_DRV_PORT);
    xboxAux = new XboxController(XBOX_AUX_PORT);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() 
  {

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() 
  {
   
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() 
  {
    
    
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic()
  {
    driveTrain.arcadeDrive(xboxDrv.getY(Hand.kLeft), xboxDrv.getX(Hand.kRight));

    lift.set(xboxDrv.getTriggerAxis(Hand.kRight) - xboxDrv.getTriggerAxis(Hand.kLeft));

    arm.movePivot(xboxAux.getX(Hand.kRight));
    arm.moveArm(xboxAux.getTriggerAxis(Hand.kRight));

    if(xboxAux.getAButton())
    {
      intake.intake(MAX_POWER);
    }
    else if(xboxAux.getYButton())
    {
      intake.outtake(MAX_POWER);
    }
    else
    {
      intake.intake(0);
    }

    if(xboxAux.getBumper(Hand.kRight))
    {
      intake.rotateWrist(MAX_POWER);
    }
    else if(xboxAux.getBumper(Hand.kLeft))
    {
      intake.rotateWrist(-MAX_POWER);
    }
    else
    {
      intake.rotateWrist(0);
    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() 
  {
    
  }
}
