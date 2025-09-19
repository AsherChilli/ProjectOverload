//package org.firstinspires.ftc.teamcode;
//
//import android.graphics.Color;
//
//import com.bylazar.configurables.annotations.Configurable;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
//
//import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
//import org.firstinspires.ftc.vision.VisionPortal;
//import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
//import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
//import org.firstinspires.ftc.vision.opencv.Circle;
//import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;
//import org.firstinspires.ftc.vision.opencv.ColorRange;
//import org.firstinspires.ftc.vision.opencv.ImageRegion;
//
//import java.util.List;
//
//@Configurable
//@TeleOp
//public class VisionTestingImplemented extends OpMode {
//
//
//
//    AprilTagProcessor aprilTagProcessor = new AprilTagProcessor.Builder()
//            .setDrawTagID(true)
//            .setDrawAxes(true)
//            .setDrawCubeProjection(true)
//            .build();
//    ColorBlobLocatorProcessor colorLocator = new ColorBlobLocatorProcessor.Builder()
//            .setTargetColorRange(ColorRange.ARTIFACT_PURPLE)   // Use a predefined color match
//            .setContourMode(ColorBlobLocatorProcessor.ContourMode.EXTERNAL_ONLY)
//            .setRoi(ImageRegion.asUnityCenterCoordinates(-0.75, 0.75, 0.75, -0.75))
//            .setDrawContours(true)   // Show contours on the Stream Preview
//            .setBoxFitColor(0)       // Disable the drawing of rectangles
//            .setCircleFitColor(Color.rgb(255, 255, 0)) // Draw a circle
//            .setBlurSize(5)          // Smooth the transitions between different colors in image
//
//            // the following options have been added to fill in perimeter holes.
//            .setDilateSize(15)       // Expand blobs to fill any divots on the edges
//            .setErodeSize(15)        // Shrink blobs back to original size
//            .setMorphOperationType(ColorBlobLocatorProcessor.MorphOperationType.CLOSING)
//
//            .build();
//
//
//
//
//    @Override
//    public void init() {
//
//        VisionPortal visionPortal = new VisionPortal.Builder()
//                .addProcessor(aprilTagProcessor)
//                .addProcessor(colorLocator)
//                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
//                .build();
//
//    }
//
//    @Override
//    public void loop() {
//
//        List<ColorBlobLocatorProcessor.Blob> blobs = colorLocator.getBlobs();
//
//        ColorBlobLocatorProcessor.Util.filterByCriteria(
//                ColorBlobLocatorProcessor.BlobCriteria.BY_CONTOUR_AREA,
//                50, 20000, blobs);  // filter out very small blobs.
//
//        ColorBlobLocatorProcessor.Util.filterByCriteria(
//                ColorBlobLocatorProcessor.BlobCriteria.BY_CIRCULARITY,
//                0.6, 1, blobs);
//
//        for (ColorBlobLocatorProcessor.Blob b : blobs) {
//
//            Circle circleFit = b.getCircle();
//            telemetry.addLine(String.format("%5.3f      %3d     (%3d,%3d)",
//                    b.getCircularity(), (int) circleFit.getRadius(), (int) circleFit.getX(), (int) circleFit.getY()));
//        }
//
//        List<AprilTagDetection> currentDetections = aprilTagProcessor.getDetections();
//
//
//        // Step through the list of detections and display info for each one.
//        for (AprilTagDetection detection : currentDetections) {
//            if (detection.metadata != null) {
//                telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
//                telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
//                telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
//                telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
//            } else {
//                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
//                telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
//            }
//        }
//
//    }
//
//}
