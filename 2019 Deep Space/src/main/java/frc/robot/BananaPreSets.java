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



import edu.wpi.first.wpilibj.Timer;

public class CatzPreSets
{
    //Values for ball and hatch pickup
    private static double NEUTRAL_PIVOT_ANGLE = 0.0;
    
 

    private static double HATCH_PICKUP_PIVOT_ANGLE = 0.0;
    


    /**
     * 
     *  Values for stowing arm
     * 
     */
    private static double PRESTOWED_PIVOT_ANGLE = 50.0;
   

    private static double PRESTOWED2_PIVOT_ANGLE = 55.0;
    private static double PRESTOWED2_WRIST_ANGLE = 40;// ??
    
    private static double STOWED_PIVOT_ANGLE = 29;
    private static double STOWED_WRIST_ANGLE = 78;

    /**
     * 
     *  Traveled Preset
     * 
     */
    private static double TRAVEL_PIVOT_ANGLE = 80.0;
    private static double TRAVEL_ARM_EXT     = 1.0;
    private static double TRAVEL_WRIST_ANGLE = 47.0;

    //Values for scoring in the cargo bay
    private static double CARGO_BAY_BALL_PIVOT_ANGLE = 110.0;
    private static double CARGO_BAY_BALL_ARM_EXT     = 9.5;
    private static double CARGO_BAY_BALL_WRIST_ANGLE = 55.6;
    private static double CARGO_BAY_BALL_LIFT_HEIGHT = 0.0;

    private static double CARGO_BAY_HATCH_PIVOT_ANGLE = 21.0;
    private static double CARGO_BAY_HATCH_ARM_EXT     = 3.0;
    private static double CARGO_BAY_HATCH_WRIST_ANGLE = -100.0;
    private static double CARGO_BAY_HATCH_LIFT_HEIGHT = 0.0;

    
    /**
     * 
     *  Values for scoring cargo in rocket
     * 
     */
    private static double LVL_3_BALL_PIVOT_ANGLE = 90;
    private static double LVL_3_BALL_ARM_EXT = 15;
    private static double LVL_3_BALL_WRIST_ANGLE = 15; 
    private static double LVL_3_BALL_LIFT_HEIGHT = 0.0; //TBD

    private static double LVL_2_BALL_PIVOT_ANGLE = 101.4;
    private static double LVL_2_BALL_ARM_EXT = 16.4;
    private static double LVL_2_BALL_WRIST_ANGLE = 29.5;
    private static double LVL_2_BALL_LIFT_HEIGHT = 0.0;

    private static double LVL_1_BALL_PIVOT_ANGLE = 53.0;
    private static double LVL_1_BALL_ARM_EXT     = 0.0;
    private static double LVL_1_BALL_WRIST_ANGLE = -5.0;
    private static double LVL_1_BALL_LIFT_HEIGHT = 0.0;


    /**
     * 
     *  Values for scoring hatches in rocket
     * 
     */
    private static double LVL_3_HATCH_PIVOT_ANGLE = 104.0;
    private static double LVL_3_HATCH_ARM_EXT     = 15;
    private static double LVL_3_HATCH_WRIST_ANGLE = -38.6; 
    private static double LVL_3_HATCH_LIFT_HEIGHT = 0.0; //TBD

    private static double LVL_2_HATCH_PIVOT_ANGLE = 100.0;
    private static double LVL_2_HATCH_ARM_EXT = 13.1;
    private static double LVL_2_HATCH_WRIST_ANGLE = -42.4;
    private static double LVL_2_HATCH_LIFT_HEIGHT = 0.0;

    private static double LVL_1_HATCH_PIVOT_ANGLE = 21.0;
    private static double LVL_1_HATCH_ARM_EXT = 3.0;
    private static double LVL_1_HATCH_WRIST_ANGLE = -100.0;
    private static double LVL_1_HATCH_LIFT_HEIGHT = 0.0;


    /** 
     *  Values for scoring in the cargo bay on the back side of the robot
    */
    private static double CARGO_BAY_REV_BALL_PIVOT_ANGLE = 155.0;
    private static double CARGO_BAY_REV_BALL_WRIST_ANGLE = -48.6;
    private static double CARGO_BAY_REV_BALL_ARM_EXT     = 9.844;

    public static void setPosition(double pivotTargetAngle, double armTargetExtension, 
                                   double wristTargetAngle, double liftTargetHeight)
    {
        Robot.arm.setPivotTargetAngle(pivotTargetAngle);

        Robot.arm.setArmTargetHit(false);
        Robot.arm.setArmTargetExt(armTargetExtension);
        
        Robot.intake.setWristTargetAngle(wristTargetAngle);
        Robot.lift.setLiftTargetHeight(liftTargetHeight);
    }

    public static void cargoPickUp()
    {
        /*Robot.intake.setWristTargetAngle(NEUTRAL_WRIST_ANGLE);
        Timer.delay(0.2); //Wait for wrist to be positioned not to hit the ground */

        Robot.intake.setWristTargetAngle(NEUTRAL_WRIST_ANGLE); //testing
        Timer.delay(0.2);

        Robot.arm.setArmTargetHit(false);
        Robot.arm.setArmTargetExt(NEUTRAL_ARM_EXT);
        Timer.delay(0.3);

        Robot.arm.setPivotTargetAngle(NEUTRAL_PIVOT_ANGLE);
        
        //Timer.delay(0.2);

        //Timer.delay(0.3);
        

        //Wait for wrist to be positioned not to hit the ground
        
    }

    public static void hatchPickUp()
    {
        Robot.arm.setPivotTargetAngle(HATCH_PICKUP_PIVOT_ANGLE);
        Robot.arm.setArmTargetHit(false);
        Robot.arm.setArmTargetExt(HATCH_PICKUP_ARM_EXT);
     
        Robot.intake.setWristTargetAngle(HATCH_PICKUP_WRIST_ANGLE);
        Robot.lift.setLiftTargetHeight(HATCH_PICKUP_LIFT_HEIGHT);
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

        Robot.intake.setWristTargetAngle(CARGO_BAY_BALL_WRIST_ANGLE);
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
        Robot.arm.setArmTargetExt(LVL_3_BALL_ARM_EXT);

        Robot.intake.setWristTargetAngle(LVL_3_BALL_WRIST_ANGLE);
        Robot.lift.setLiftTargetHeight(LVL_3_BALL_LIFT_HEIGHT);
    }

    public static void lvl2RocketBall()
    {
        Robot.arm.setPivotTargetAngle(LVL_2_BALL_PIVOT_ANGLE);

        Robot.arm.setArmTargetHit(false);
        Robot.arm.setArmTargetExt(LVL_2_BALL_ARM_EXT);

        Robot.intake.setWristTargetAngle(LVL_2_BALL_WRIST_ANGLE);
        Robot.lift.setLiftTargetHeight(LVL_2_BALL_LIFT_HEIGHT);
    }

    public static void lvl1RocketBall()
    {
        Robot.arm.setPivotTargetAngle(LVL_1_BALL_PIVOT_ANGLE);
        Timer.delay(0.2);

        Robot.arm.setArmTargetHit(false);
        Robot.arm.setArmTargetExt(LVL_1_BALL_ARM_EXT);

        Robot.intake.setWristTargetAngle(LVL_1_BALL_WRIST_ANGLE);
        Robot.lift.setLiftTargetHeight(LVL_1_BALL_LIFT_HEIGHT);
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
        Robot.arm.setArmTargetExt(LVL_3_HATCH_ARM_EXT);

        Robot.intake.setWristTargetAngle(LVL_3_HATCH_WRIST_ANGLE);
        Robot.lift.setLiftTargetHeight(LVL_3_HATCH_LIFT_HEIGHT);
    }

    public static void lvl2RocketHatch()
    {
        Robot.arm.setPivotTargetAngle(LVL_2_HATCH_PIVOT_ANGLE);

        Robot.arm.setArmTargetHit(false);
        Robot.arm.setArmTargetExt(LVL_2_HATCH_ARM_EXT);

        Robot.intake.setWristTargetAngle(LVL_2_HATCH_WRIST_ANGLE);
        Robot.lift.setLiftTargetHeight(LVL_2_HATCH_LIFT_HEIGHT);
    }

    public static void lvl1RocketHatch()
    {
        //Hatch spot is close to hatch pickup so use the same values
        hatchPickUp();
    }

    //TODO
    public static void stowed()
    {
        Robot.intake.setWristTargetAngle(STOWED_WRIST_ANGLE);

        Timer.delay(0.100);

        Robot.arm.setPivotTargetAngle(STOWED_PIVOT_ANGLE);
    }

    public static void prestowed()
    {
        Robot.arm.setPivotTargetAngle(PRESTOWED_PIVOT_ANGLE);

        Timer.delay(0.1);

        Robot.arm.setArmTargetHit(false);
        Robot.arm.setArmTargetExt(PRESTOWED_ARM_EXT);
        Timer.delay(0.1);

        Robot.intake.setWristTargetAngle(PRESTOWED_WRIST_ANGLE);
        Robot.lift.setLiftTargetHeight(PRESTOWED_LIFT_HEIGHT);
    }

    public static void prestowed2()
    {
        Robot.arm.setPivotTargetAngle(PRESTOWED2_PIVOT_ANGLE);
        Timer.delay(0.1);
        Robot.intake.setWristTargetAngle(PRESTOWED2_WRIST_ANGLE);
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
