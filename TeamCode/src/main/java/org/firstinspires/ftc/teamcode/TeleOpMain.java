package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;

@TeleOp(name = "TeleOpMain", group = "Main")
public class TeleOpMain extends OpMode {


    SwerveDrivetrain swerve;
    ArrayList<SwervePod> pods = new ArrayList<>();


    public void init() {

        pods.add(new SwervePod(hardwareMap.get(DcMotorEx.class, "motor0"), hardwareMap.get(Servo.class, "servo0"), 132-40, -(432/2 + 2.5 - 40), 0));
        pods.add(new SwervePod(hardwareMap.get(DcMotorEx.class, "motor1"), hardwareMap.get(Servo.class, "servo1"), -(132-40), -(432/2 + 2.5 - 40), 0));
        pods.add(new SwervePod(hardwareMap.get(DcMotorEx.class, "motor2"), hardwareMap.get(Servo.class, "servo2"), -(132-40), 432/2 + 2.5 - 40, 0));
        pods.add(new SwervePod(hardwareMap.get(DcMotorEx.class, "motor3"), hardwareMap.get(Servo.class, "servo3"), 132-40, 432/2 + 2.5 - 40, 0));
        swerve = new SwerveDrivetrain(pods);
        

    }

    @Override
    public void init_loop() {

    }

    @Override
    public void loop() {
        swerve.runTeleOp(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        swerve.debugMode(telemetry);
        telemetry.update();
    }



}
