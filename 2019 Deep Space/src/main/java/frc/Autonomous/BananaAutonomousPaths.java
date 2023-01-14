package frc.Autonomous;

public class BananaAutonomousPaths 
{
          final double turn_R_90 = 90.0;
          final double turn_L_90 = -90.0;
          /*
          final double middle_to_cargoship = 150.0;
          final double to_R_L_hatch =11.75; 
          final double approach_hatch = 51.13;
          final double backup_from_hatch = -40.0;
          double hatch_to_reload = 121.815;
          final double approach_reload = 180.25;
          final double backup_from_reload = -170.0;
          double to_other_hatch = 145.315;
          final double approach_to_other_hatch = 50.25;
          */

       public void middleFrontCargoPath(String hatchLocation) //right or left, add reload location if needed
           {
            CatzDriveStraight.PIDDriveNoTrig(0.0, 150, 0.0);
               
            if (hatchLocation.equalsIgnoreCase("left"))
            {
                CatzTurn.PIDturn(turn_L_90, 0.0);
                CatzDriveStraight.PIDDriveNoTrig(0.0, 11.75, 0.0);
                CatzTurn.PIDturn(turn_R_90, 0.0);
                CatzDriveStraight.PIDDriveNoTrig(0.0, 51.13, 0.0);
                //placeHatch();
            }
            else if(hatchLocation.equalsIgnoreCase("right"))
            {
                CatzTurn.PIDturn(turn_R_90, 0.0);
                CatzDriveStraight.PIDDriveNoTrig(0.0, 11.75, 0.0);
                CatzTurn.PIDturn(turn_L_90, 0.0);
                CatzDriveStraight.PIDDriveNoTrig(0.0, 51.13, 0.0); 
                //placeHatch();
            }
              // toReloadFromMiddle(hatchLocation,reloadLocation);
             //  placeSecondHatchFromReload(hatchLocation,reloadLocation);
           }

        public void sideToSideCargoPath(String startingSide)
        {
            CatzDriveStraight.PIDDriveNoTrig(0.0, 150, 0.0);
            if(startingSide.equalsIgnoreCase("right"))
            {
                CatzTurn.PIDturn(turn_L_90, 0.0);
                //placeHatch();
            }
            else if(startingSide.equalsIgnoreCase("left"))
            {
                CatzTurn.PIDturn(turn_R_90, 0.0);
                //placeHatch();
            }
        }
        public void placeHatch(){
            CatzDriveStraight.PIDDriveNoTrig(0.0, 1, 0.0);
            //CatzIntake.releaseCargo(1);
        }

        /*
       public void toReloadFromMiddle(String hatchLocationR_L,String reloadLocation)
       {
        if (hatchLocationR_L.equalsIgnoreCase("left")){
            if(reloadLocation.equalsIgnoreCase("right")){
                hatch_to_reload += 11.75;
            }
        }
        else if(hatchLocationR_L.equalsIgnoreCase("right")){
            if(reloadLocation.equalsIgnoreCase("left")){
                hatch_to_reload += 11.75;
            }
        }
          // after placeing the hatch, the robot moves to the hatch reload station
          CatzDriveStraight.PIDDriveNoTrig(0.0, backup_from_hatch, 0.0);
          
          if(reloadLocation.equalsIgnoreCase("left"))
          {
               CatzTurn.PIDturn(turn_L_90, 0.0);
               CatzDriveStraight.PIDDriveNoTrig(0.0, hatch_to_reload, 0.0);
               CatzTurn.PIDturn(turn_L_90,0.0);
               CatzDriveStraight.PIDDriveNoTrig(0.0, approach_reload, 0.0);
               //getHatch()
          }
          else if(reloadLocation.equalsIgnoreCase("right")) //right
          {
               CatzTurn.PIDturn(turn_R_90, 0.0);
               CatzDriveStraight.PIDDriveNoTrig(0.0, hatch_to_reload, 0.0);
               CatzTurn.PIDturn(turn_R_90, 0.0);
               CatzDriveStraight.PIDDriveNoTrig(0.0, approach_reload, 0.0);
               //getHatch()
          }
       }

       public void placeSecondHatchFromReload(String hatchLocationR_L, String reloadLocation)
       {
            if (reloadLocation.equalsIgnoreCase("left")){
                if(hatchLocationR_L.equalsIgnoreCase("right")){
                    to_other_hatch += 11.75;
                }
            }
            else if(reloadLocation.equalsIgnoreCase("right")){
                if(hatchLocationR_L.equalsIgnoreCase("left")){
                    to_other_hatch += 11.75;
                }
            }
            CatzDriveStraight.PIDDriveNoTrig(0.0, backup_from_reload, 0.0);
            if (reloadLocation.equalsIgnoreCase("left"))
            {
                 CatzTurn.PIDturn(turn_L_90, 0.0);
                 CatzDriveStraight.PIDDriveNoTrig(0.0, to_other_hatch, 0.0);
                 CatzTurn.PIDturn(turn_L_90, 0.0);
                 CatzDriveStraight.PIDDriveNoTrig(0.0, approach_to_other_hatch, 0.0);
                 //placeHatch();
            }
            else if(reloadLocation.equalsIgnoreCase("right"))
            {
                 CatzTurn.PIDturn(turn_R_90, 0.0);
                 CatzDriveStraight.PIDDriveNoTrig(0.0, to_other_hatch, 0.0);
                 CatzTurn.PIDturn(turn_R_90, 0.0);
                 CatzDriveStraight.PIDDriveNoTrig(0.0, approach_to_other_hatch, 0.0);
                 //placeHatch();
            }
       }
       */
}
