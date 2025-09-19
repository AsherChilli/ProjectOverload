package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Vector2D;

import java.util.ArrayList;

public class SwervePod {
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
        this.driveVector = translation.add(rotation.rotate(Math.atan2(position.get(0), position.get(1)) + Math.PI / 2));
    }

    public void drive() {
        double[] realVector = getRealVector(driveVector);

        //motor.setPower(realVector[1]);
        servo.setPosition(realVector[0]);
    }


    public void debugMode(Telemetry t) {

        t.addData("Drive Vector", driveVector.toString());
        t.addData("Drive Magnitude", driveVector.magnitude());
        t.addData("Drive Angle", driveVector.angle());
        t.addData("Motor Power", getRealVector(driveVector)[1]);
        t.addData("Servo Position", getRealVector(driveVector)[0]);
        t.addData("X value", position.get(0));
        t.addData("Y value", position.get(1));
    }

    private double[] getRealVector( Vector2D driveVector) {
        double[] realVector = new double[2];

        driveVector = driveVector.rotate(position.get(2));
        realVector[0] = Math.abs(driveVector.angle() / Math.PI)*180/255;
        realVector[1] = driveVector.magnitude() * (driveVector.angle() != 0 ? driveVector.angle()/ Math.abs(driveVector.angle()) : 1) ;


        return realVector;
    }



}
