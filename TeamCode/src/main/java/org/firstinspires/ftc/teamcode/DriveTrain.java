import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.ArrayList;

public class DriveTrain(){
  private PDFLController Centripetal;
  private PDFLController Drive;
  private PDFLController Heading;
  private PDFLController Translational;
  
  public DriveTrain(){
    super(ArrayList<HardwareDevice> devices, DcMotorEx motors, servos, double[] position)
  }
}
