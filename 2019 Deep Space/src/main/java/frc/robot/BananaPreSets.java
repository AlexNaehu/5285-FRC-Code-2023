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

public class CatzPreSets
{
    //Values for ball and hatch pickup
    private static double NEUTRAL_PIVOT_ANGLE = 0.0;// 0.0 angle is at straight verticle down
    
 

    private static double HATCH_PICKUP_PIVOT_ANGLE = 0.0;
    


    

    /**
     * 
     *  Traveled Preset
     * 
     */
    private static double TRAVEL_PIVOT_ANGLE = 80.0;
    

    //Values for scoring in the cargo bay
    private static double CARGO_BAY_BALL_PIVOT_ANGLE = 110.0; 
   

    private static double CARGO_BAY_HATCH_PIVOT_ANGLE = 21.0; //the surface of the shelf is 95cm above the carpet
   

    
    /**
     * 
     *  Values for scoring cargo in rocket
     * 
     */
    private static double LVL_3_BALL_PIVOT_ANGLE = 90;
    

    private static double LVL_2_BALL_PIVOT_ANGLE = 101.4;
   

    private static double LVL_1_BALL_PIVOT_ANGLE = 2.0;



    /**
     * 
     *  Values for scoring hatches in rocket
     * 
     */
    private static double LVL_3_HATCH_PIVOT_ANGLE = 104.0;
   

    private static double LVL_2_HATCH_PIVOT_ANGLE = 100.0;
  

    private static double LVL_1_HATCH_PIVOT_ANGLE = 21.0;



    /** 
     *  Values for scoring in the cargo bay on the back side of the robot
    */
    private static double CARGO_BAY_REV_BALL_PIVOT_ANGLE = 155.0;//change ball to cube, and add a scoring angle 
                                                                //might be different if you have to lift the arm higher for the peg
    
    public static void setPosition(double pivotTargetAngle)
    {
        Robot.arm.setPivotTargetAngle(pivotTargetAngle);

        Robot.arm.setArmTargetHit(false);
       
    }

    public static void cargoPickUp()
    {
        /*Robot.intake.setWristTargetAngle(NEUTRAL_WRIST_ANGLE);
        Timer.delay(0.2); //Wait for wrist to be positioned not to hit the ground */

 

        
        Timer.delay(0.3);

        Robot.arm.setPivotTargetAngle(NEUTRAL_PIVOT_ANGLE);
        Robot.arm.setArmTargetHit(false);
        //Timer.delay(0.2);

        //Timer.delay(0.3);
        

        //Wait for wrist to be positioned not to hit the ground
        
    }

    public static void hatchPickUp() 
    {
        Robot.arm.setPivotTargetAngle(HATCH_PICKUP_PIVOT_ANGLE); //incase we need a different angle for manually adding game pieces to the field via hatch
        Robot.arm.setArmTargetHit(false);
     
    }


    /**
     * 
     *  Positions for Scoring in Cargo Bay
     * 
     */
    public static void cargoBayBall()
    {
        /*Robot.arm.setArmTargetHit(false);
        Robot.arm.setArmTargetExt(CARGO_BAY_BALL_ARM_EXT);
        Timer.delay(0.0200);*/

        Robot.arm.setPivotTargetAngle(CARGO_BAY_BALL_PIVOT_ANGLE);
        Timer.delay(0.0100);

        
    }

    public static void cargoBayHatch()
    {
        //Hatch spot is close to hatch pickup so use the same values
        hatchPickUp();

        /*Robot.arm.setPivotTargetAngle(CARGO_BAY_HATCH_PIVOT_ANGLE);
        Robot.arm.setArmTargetHit(false);
        Robot.arm.setArmTargetExt(CARGO_BAY_HATCH_ARM_EXT);
        
        Robot.intake.setWristTargetAngle(CARGO_BAY_HATCH_WRIST_ANGLE);
        Robot.lift.setLiftTargetHeight(CARGO_BAY_HATCH_LIFT_HEIGHT);*/
    }

    /*
     * 
     *  Positions for Cargo in Rocket
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


    /*
     * 
     *  Positions for Hatch in Rocket
     * 
     */

    public static void lvl3RocketHatch()
    {
        Robot.arm.setPivotTargetAngle(LVL_3_HATCH_PIVOT_ANGLE);

        Robot.arm.setArmTargetHit(false);
      
    }

    public static void lvl2RocketHatch()
    {
        Robot.arm.setPivotTargetAngle(LVL_2_HATCH_PIVOT_ANGLE);

        Robot.arm.setArmTargetHit(false);
       
    }

    public static void lvl1RocketHatch()
    {
        //Hatch spot is close to hatch pickup so use the same values
        hatchPickUp();
    }

    

    
        
    }

    
 
    //also for scoring in rocket lvl 1
    public static void transport()
    {
        Robot.arm.setArmTargetHit(false);
        Robot.arm.setArmTargetExt(Robot.arm.getArmTargetExt() - 1);
        
        Robot.arm.setPivotTargetAngle(TRAVEL_PIVOT_ANGLE);

        Robot.arm.setArmTargetHit(false);
        Robot.arm.setArmTargetExt(TRAVEL_ARM_EXT);

        Timer.delay(0.15);
        Robot.intake.setWristTargetAngle(TRAVEL_WRIST_ANGLE);
    }

    public static void cargoBayReversed() //scored behind
    {
        Robot.arm.setPivotTargetAngle(CARGO_BAY_REV_BALL_PIVOT_ANGLE);

        Robot.arm.setArmTargetHit(false);
        Robot.arm.setArmTargetExt(CARGO_BAY_REV_BALL_ARM_EXT);

        Robot.intake.setWristTargetAngle(CARGO_BAY_REV_BALL_WRIST_ANGLE);
    }

}
