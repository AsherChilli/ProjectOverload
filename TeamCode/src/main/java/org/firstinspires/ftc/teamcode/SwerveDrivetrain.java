package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;
import com.pedropathing.follower.Follower;
import java.util.ArrayList;


@TeleOp(name = "SwerveDrive", group = "Driving")
@Disabled
public class SwerveDrivetrain extends OpMode {
  private ArrayList<PDFLController> PDFLController;
  
  public SwerveDrivetrain(ArrayList<PDFLController> PDFLController, ArrayList<DcMotorEx> motors, ArrayList<Servo> servos, double[] position) {
    this.PDFLController = PDFLController;
    
  }

  public static boolean robotCentric = false;

    public void init() {
      telemetry = new MultipleTelemetry(FtcDashboard.getInstance().getTelemetry(), telemetry);
      follower = new Follower(hardwareMap, FConstants.class, LConstants.class);
    }

    @Override
    public void init_loop() {
      //INIT LOOP
      //We never put anything here for motors/servos
      //as its against the rules for the bots to move AT ALL
      //in the initialization phase of the Driver Controlled Period.
      //For testing purposes, obviously yes you can put stuff here.


      telemetry.addLine("Initialized!");
      telemetry.update();
    }

    @Override
    public void loop() {

    }
}
