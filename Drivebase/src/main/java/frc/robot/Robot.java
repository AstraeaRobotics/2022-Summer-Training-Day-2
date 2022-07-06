// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import com.revrobotics.CANSparkMax; //Motor Imports
import com.revrobotics.CANSparkMaxLowLevel; //Type and other Imports

import com.revrobotics.CANEncoder; //Encoder imports

import edu.wpi.first.wpilibj.PS4Controller;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;

  CANSparkMax rightMaster = new CANSparkMax(1,CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightFollower1 = new CANSparkMax(2,CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightFollower2 = new CANSparkMax(3,CANSparkMaxLowLevel.MotorType.kBrushless);

  CANSparkMax leftMaster = new CANSparkMax(4,CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax leftFollower1 = new CANSparkMax(5,CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax leftFollower2 = new CANSparkMax(6,CANSparkMaxLowLevel.MotorType.kBrushless);


  PS4Controller controller = new PS4Controller(0);

  double maxSpeed = 0.5; //We're not going to go max speed

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {  
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }
  

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    if (controller.getLeftY() != 0) {
      rightMaster.set(controller.getLeftY());
      rightFollower1.set(controller.getLeftY());
      rightFollower2.set(controller.getLeftY());
    }
    if (controller.getRightY() != 0) {
      leftMaster.set(controller.getRightY());
      leftFollower1.set(controller.getRightY());
      leftFollower2.set(controller.getRightY());
    }

    if (rightMaster.get() > maxSpeed) {
      rightMaster.set(maxSpeed);
      rightFollower1.set(maxSpeed);
      rightFollower2.set(maxSpeed);
    }
    if (leftMaster.get() < maxSpeed) {
      leftMaster.set(maxSpeed);
      leftFollower1.set(maxSpeed);
      leftFollower2.set(maxSpeed);
    }
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
