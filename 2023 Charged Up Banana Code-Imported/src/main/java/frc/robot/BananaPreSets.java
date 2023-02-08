
package frc.robot;

/*
 *  Author : Alex Naehu
 *  Methods : 
 *  Functionality : Holds all presetables, i.e. game piece dimensions or specific arm positions, etc.
 *   
 *  Revision History : 
 *  First Created 1/13/23
 * 
 */

//idea: do 3 different levels of arm positions for 3 different scoring types (3 different heights to raise the arm)
//idea: do one angle to pick up rigth side up cones and cubes, do another angle to pickup at the single drop station



import edu.wpi.first.wpilibj.Timer;

public class BananaPreSets
{

   
    private static double NEUTRAL_PIVOT_ANGLE = 0.0;// 0.0 angle is at straight verticle down, have a button for manual to return the arm to verticle, have auton
                                                    // lower the arm to 0.0 before it drives to the charging station
    
    private static double PICKUP_PIVOT_ANGLE = 5.0;//slightly higher than the neutral angle, trial and error to find a comfortable angle to grab the cone
    

    //Values for picking up objects in the double station shelf
    private static double HATCH_PICKUP_PIVOT_ANGLE = 73.539; //Correct
   
    
    
    //Values for scoring cargo in different levels
     
    private static double LVL_3_BALL_PIVOT_ANGLE = 90.0; //Top step in the scoring grids
    

    private static double LVL_2_BALL_PIVOT_ANGLE = 80.0; //Middle step in the scoring grids
   

    private static double LVL_1_BALL_PIVOT_ANGLE = 10.0; //Doubles as the travel angle, rename to "travel angle"


    
    
    
    public static void setPosition(double pivotTargetAngle)
    {
        Robot.arm.setPivotTargetAngle(pivotTargetAngle);
        Robot.arm.setArmTargetHit(false);
    }

    public static void neutralPivotAngle()
    {
        Timer.delay(0.3);
        Robot.arm.setPivotTargetAngle(NEUTRAL_PIVOT_ANGLE);
        Robot.arm.setArmTargetHit(false);  
    }

    public static void cargoPickUp()
    {
        Timer.delay(0.3);
        Robot.arm.setPivotTargetAngle(PICKUP_PIVOT_ANGLE);
        Robot.arm.setArmTargetHit(false);  
    }

    public static void hatchPickUp() 
    {
        Timer.delay(0.3);
        Robot.arm.setPivotTargetAngle(HATCH_PICKUP_PIVOT_ANGLE); //incase we need a different angle for manually adding game pieces to the field via hatch
        Robot.arm.setArmTargetHit(false);
    }

    /*
     * 
     *  Positions for Cargo in different shelf levels
     * 
     */

    public static void lvl3RocketBall()
    {
        Robot.arm.setPivotTargetAngle(LVL_3_BALL_PIVOT_ANGLE);
        Robot.arm.setArmTargetHit(false);
    }

    public static void lvl2RocketBall()
    {
        Robot.arm.setPivotTargetAngle(LVL_2_BALL_PIVOT_ANGLE);
        Robot.arm.setArmTargetHit(false);
    }

    public static void lvl1RocketBall()
    {
        Robot.arm.setPivotTargetAngle(LVL_1_BALL_PIVOT_ANGLE);
        Timer.delay(0.2);
        Robot.arm.setArmTargetHit(false);
    }


   
}
