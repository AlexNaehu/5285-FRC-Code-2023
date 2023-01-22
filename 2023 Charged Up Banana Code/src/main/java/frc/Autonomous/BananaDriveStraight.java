package frc.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.BananaConstants;
import frc.robot.Robot;
import frc.Mechanisms.BananaDriveTrain;

public class BananaDriveStraight 
{

	/****************************************************************************
	 * PID Drive Constants
	 ****************************************************************************/
	
    
	/****************************************************************************
	 * PID Drive Variables
	 ****************************************************************************/
	
	
	
	//Turbo Constants
	
	
	//TurboVariables
	
	
	/****************************************************************************
	 * pass 0 for drive power to use calculated value
	 * Tested w/battery > 12.7 V & defaultPower =
	 *   0.50 @ 10", 
	 *   0.55 @ 10", 
	 *   0.65 @ 17", 
	 *   0.70 @ 22", 
	 ***************************************************************************/

	//public static void PIDDriveNoTrig(double defaultPower, double distance, double timeoutSeconds) {
		
	
					/**************************************************************
					 * Calculate Heading Derivative Term
					 * The first time through the loop, deltaTimeSec will be zero
					 * so we will set derivative to zero.
					 **************************************************************/
					

					/**************************************************************
					 * Calculate Drive Power
					 **************************************************************/
					
						// calculates drivetrain power
						

						// Verify we have not exceeded max power when turning right or left
						
					/**************************************************************
					 * 
					 **************************************************************/
					
					
				
			
		
		
		

		/*************************************************************************
		 * Brake using motors 
		 *************************************************************************/
		// always invert power for braking
		
		

		

	
	
	private static void calculatePwrPidValues(double distance)
	{
		//Use different KD for different distances Hard coded, tried and tested
		
			//calculate KD ------- EXPERAMENTAL ------- Need to tune
			
		
	}

	public static void setDebugModeEnabled(boolean enabled) {
		
	}

	public static void printDebugInit() {
		
	}


	public static void printDebugHeader() 
	{
		
	}


	public static void printDebugData() {
	
	}


	public static void printPwrDebugHeader() {
		
	}

	public static void printPwrDebugData() {
		
	}
	
	
	public static void printDatainSmartDashboard() {
		//SmartDashboard.putNumber("timestamp", functionTimer.get());
		//SmartDashboard.putNumber("deltaTimeMillis", deltaTimeSec);
		//SmartDashboard.putNumber("currentAngleDegrees", currentHeading);
		//SmartDashboard.putNumber("currentErrorDegrees", deltaAngleError);
		//SmartDashboard.putNumber("derivative", derivative);

	}
}
