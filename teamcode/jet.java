package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by CAPTAIN JATNAEL
 */

@Autonomous(name = "jet",group = "nothing")
public class jet extends LinearOpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor intake;
    public LightSensor beacon;
    public LightSensor tape;
    public Servo leftServo;
    public Servo rightServo;

    @Override
    public void runOpMode() throws InterruptedException {

        frontLeft = hardwareMap.dcMotor.get("motor_4");
        frontRight = hardwareMap.dcMotor.get("motor_1");
        backRight = hardwareMap.dcMotor.get("motor_2");
        backLeft = hardwareMap.dcMotor.get("motor_3");
        intake = hardwareMap.dcMotor.get("motor_5");
        leftServo = hardwareMap.servo.get("servo_1");
        rightServo = hardwareMap.servo.get("servo_2");
        beacon = hardwareMap.lightSensor.get("light");
        tape = hardwareMap.lightSensor.get("tape");

        boolean bPrevState = false;
        boolean bCurrState = false;
        boolean bLedOn = true;

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        leftServo.setPosition(.9);
        rightServo.setPosition(.2);

        beacon.enableLed(bLedOn);
        tape.enableLed(bLedOn);

        /*
          move forward (diagonal)
          press beacon
          strafe to the left
          press beacon

         */



        waitForStart();

        //forward for 1.5 secs

        frontLeft.setPower(1);
        frontRight.setPower(-1);
        backLeft.setPower(1);
        backRight.setPower(-1);
        sleep(1500);


        if (tape.getLightDetected() > 0.2)
        {
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
            sleep(3000);                    //rest
        }


        //blue button
        if(beacon.getLightDetected() >= .34 )
        {
            leftServo.setPosition(.2);

        }
        else
        {
            rightServo.setPosition(.9);
        }

        //strafe to 1.5 seconds
        frontLeft.setPower(1);
        frontRight.setPower(1);
        backLeft.setPower(1);
        backRight.setPower(1);
        sleep(1500);

        //beacon
        if(beacon.getLightDetected() >= .34 )
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

        telemetry.addData("beacon",beacon);
        telemetry.addData("tape",tape);
        telemetry.update();

    }


}
