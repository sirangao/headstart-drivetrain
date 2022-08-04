// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalon;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {

  BaseTalon leftFront, leftBack, rightFront, rightBack;

  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    leftFront = new TalonFX(0);
    leftBack = new TalonFX(0);
    rightFront = new TalonFX(0);
    rightBack = new TalonFX(0);

    leftFront.configFactoryDefault();
    leftBack.configFactoryDefault();
    rightFront.configFactoryDefault();
    rightBack.configFactoryDefault();

    leftBack.follow(leftFront);
    rightBack.follow(rightFront);
  }

  public void drive(double speed, double turn){
    double left = speed + turn;
    double right = speed - turn;

    leftFront.set(ControlMode.PercentOutput, left); 
    rightFront.set(ControlMode.PercentOutput, -right);
  }

  public void stop(){
    drive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
