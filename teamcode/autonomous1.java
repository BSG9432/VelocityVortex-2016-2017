package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 299970 on 11/16/2016.
 */

@Autonomous(name = "JET", group = "something")

public class autonomous1 extends LinearOpMode
{

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor intake;
    public LightSensor litmas;
    public LightSensor lame;
    public Servo leftServo;
    public Servo rightServo;

    @Override
    public void runOpMode() throws InterruptedException
    {

        frontLeft = hardwareMap.dcMotor.get("motor_4");
        frontRight = hardwareMap.dcMotor.get("motor_1");
        backRight = hardwareMap.dcMotor.get("motor_2");
        backLeft = hardwareMap.dcMotor.get("motor_3");
        intake = hardwareMap.dcMotor.get("motor_5");
        litmas = hardwareMap.lightSensor.get("light");
        leftServo = hardwareMap.servo.get("servo_1");
        rightServo= hardwareMap.servo.get("servo_2");
        lame = hardwareMap.lightSensor.get("tape");

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        leftServo.setPosition(.9);
        rightServo.setPosition(.2);
        waitForStart();

        //forward for 3 secs
        frontLeft.setPower(.51);
        frontRight.setPower(-.5);
        backLeft.setPower(.5);
        backRight.setPower(-.5);
        sleep(3000);

        //blue button
        if(litmas.getLightDetected() >= .34 )
        {
          leftServo.setPosition(.2);

        }
        else
        {
            rightServo.setPosition(.9);
        }

        //side
        frontLeft.setPower(.5);
        frontRight.setPower(.5);
        backLeft.setPower(.5);
        backRight.setPower(.5);
        sleep(3000);

        if(litmas.getLightDetected() >= .34 )
        {
            leftServo.setPosition(.2);
        }
        else
        {
            rightServo.setPosition(.9);
        }


        //stops
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        sleep(1000);

        telemetry.addData("beacon",litmas);
        telemetry.addData("tape",lame);
        telemetry.update();

    }
}
