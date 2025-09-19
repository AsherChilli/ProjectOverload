package org.firstinspires.ftc.teamcode.OpModes.Util;

import android.util.Size;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.Util.UniConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.Constants;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.ArrayList;
import java.util.HashMap;


@Config //Allows ALL PUBLIC STATIC VARIABLES to be monitored on FTC Dash.
@TeleOp(name = "Vision Teleop", group = "Example") //The name and group
//@Disabled //How you would disable/enable an opmode from appearing on the DS
public class VisionTesting extends OpMode {






    AprilTagProcessor myAprilTagProcessor = new AprilTagProcessor.Builder()
            .setDrawTagID(true)
            .setDrawAxes(true)
            .setDrawCubeProjection(true)
            .build();

    ArrayList<AprilTagDetection> detections;  // list of all detections
    int code;

    @Override
    public void init() {
        VisionPortal myVisionPortal;
        myVisionPortal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .addProcessor(myAprilTagProcessor)
                .setCameraResolution(new Size(640, 480))
                .enableLiveView(true)
                .build();
        //TODO: Create color processor for balls

    }




    @Override
    public void init_loop() {

    }

    @Override
    public void start(){

    }

    @Override
    public void loop() {

        // ID code of current detection, in for() loop

        // Get a list of AprilTag detections.
        detections = myAprilTagProcessor.getDetections();

        // Cycle through through the list and process each AprilTag.
        for (AprilTagDetection detected : detections) {

            if (detected.metadata != null) {  // This check for non-null Metadata is not needed for reading only ID code.
                code = detected.id;

                // Now take action based on this tag's ID code, or store info for later action.
                telemetry.addData("ID CODE: ", code);
                telemetry.addData("ID CODE INDEX: " + detections.indexOf(detected) + " LOOKUP: ", UniConstants.ID_TO_NAME.get(code));
            }
        }
        telemetry.update();

    }
}