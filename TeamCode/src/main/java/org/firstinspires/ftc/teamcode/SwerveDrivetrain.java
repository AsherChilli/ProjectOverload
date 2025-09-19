package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;



public class SwerveDrivetrain {

  private ArrayList<DcMotorEx> motors;
  private ArrayList<Servo> servos;

  private ArrayList<SwervePod> pods;

  private boolean isBusy, robotCentric;

  public SwerveDrivetrain(ArrayList<SwervePod> pods) {
    this.pods = pods;


  }


  public void runTeleOp(double LeftStickX, double LeftStickY, double RightStickX) {
    Vector2D translation = new Vector2D(LeftStickX, LeftStickY);
    Vector2D rotation = new Vector2D(RightStickX, 0);

    for (SwervePod pod : pods) {
      pod.setDriveVector(translation, rotation);
      pod.drive();
    }
  }

  public void debugMode(Telemetry t) {
    for (SwervePod pod : pods) {
      t.addData("Pod", pods.indexOf(pod));
      pod.debugMode(t);
    }
  }


}
