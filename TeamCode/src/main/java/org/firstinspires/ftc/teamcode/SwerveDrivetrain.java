package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
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



  public static class SwervePod {
    private DcMotorEx motor;
    private Servo servo;

    Vector2D driveVector = new Vector2D();

    private ArrayList<Double> position = new ArrayList<>();

    public SwervePod(DcMotorEx motor, Servo servo, double x, double y, double offset) {
      this.motor = motor;
      this.servo = servo;
      position.add(x);
      position.add(y);
      position.add(offset);
    }

    public void setDriveVector(Vector2D driveVector) {
      this.driveVector = driveVector;
    }

    public void setDriveVector(Vector2D translation, Vector2D rotation) {
      this.driveVector = translation.add(rotation.rotate(Math.atan2(translation.y, translation.x) + Math.PI / 2));
    }

    public void drive() {
      double[] realVector = getRealVector(driveVector);

      //motor.setPower(realVector[1]);
      servo.setPosition(realVector[0]);
    }

    private double[] getRealVector( Vector2D driveVector) {
      double[] realVector = new double[2];

      driveVector = driveVector.rotate(position.get(2));
      realVector[0] = driveVector.angle() / Math.PI % 1;
      realVector[1] = driveVector.magnitude() * (driveVector.angle() > Math.PI ? -1 : 1);


      return realVector;
    }



  }
}
