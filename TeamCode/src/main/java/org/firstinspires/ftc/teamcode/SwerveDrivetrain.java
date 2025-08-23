package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.ArrayList;


@TeleOp(name = "SwerveDrive", group = "Driving")
public class SwerveDrivetrain extends OpMode {
  
    

  public static boolean robotCentric = false;

    public void init() {
    }

    @Override
    public void init_loop() {
      //INIT LOOP
      //We never put anything here for motors/servos
      //as its against the rules for the bots to move AT ALL
      //in the initialization phase of the Driver Controlled Period.
      //For testing purposes, obviously yes you can put stuff here.

    }

    @Override
    public void loop() {

    }
}
