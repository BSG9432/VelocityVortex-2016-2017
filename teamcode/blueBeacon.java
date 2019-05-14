package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 299970 on 1/4/2017.
 */

@Autonomous(name = "dtran blue", group = "nothing")
@Disabled

public class blueBeacon extends LinearOpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
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
        leftServo = hardwareMap.servo.get("servo_1");
        rightServo = hardwareMap.servo.get("servo_2");
        beacon = hardwareMap.lightSensor.get("light");
        tape = hardwareMap.lightSensor.get("tape");

        waitForStart();

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        sleep(1000);                    //wait

        frontLeft.setPower(.3);
        frontRight.setPower(-.25);
        backLeft.setPower(.3);
        backRight.setPower(-.25);
        sleep(4000);                    //go forward

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        sleep(1000);                    //wait

        frontLeft.setPower(.5);
        frontRight.setPower(.5);
        backLeft.setPower(.5);
        backRight.setPower(.5);
        sleep(1000);                    //turn

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        sleep(1000);                    //wait

        while (tape.getLightDetected() < 0.35 && opModeIsActive()) {
            frontLeft.setPower(.15);
            frontRight.setPower(-.15);
            backLeft.setPower(.15);
            backRight.setPower(-.15);
            sleep(5000);
        }
        if (tape.getLightDetected() < 0.35) {
            if (tape.getLightDetected() < 0.35) {
                frontLeft.setPower(-.25);
                frontRight.setPower(-.25);
                backLeft.setPower(-.25);
                backRight.setPower(-.25);
                sleep(1000);

                //blue button
                if (beacon.getLightDetected() < .35) {
                    rightServo.setPosition(.9);
                }
                else {
                    leftServo.setPosition(.2);
                }

                frontLeft.setPower(0);
                frontRight.setPower(0);
                backLeft.setPower(0);
                backRight.setPower(0);
                sleep(1000);                    //rest

                frontLeft.setPower(.5);
                frontRight.setPower(-.5);
                backLeft.setPower(.5);
                backRight.setPower(-.5);
                sleep(1000);                    //go forward

                frontLeft.setPower(0);
                frontRight.setPower(0);
                backLeft.setPower(0);
                backRight.setPower(0);
                sleep(1000);                    //wait
            } else {
                frontLeft.setPower(-.25);
                frontRight.setPower(-.25);
                backLeft.setPower(-.25);
                backRight.setPower(-.25);
                sleep(1000);
            }

            telemetry.addData("left X", gamepad1.left_stick_x);
            telemetry.addData("left Y", gamepad1.left_stick_y);
            telemetry.addData("right x", gamepad1.right_stick_x);
            telemetry.addData("front left", frontLeft);
            telemetry.addData("front right", frontRight);
            telemetry.addData("back left", backLeft);
            telemetry.addData("back right", backRight);
            telemetry.addData("left Servo", leftServo);
            telemetry.addData("right Servo", rightServo);
            telemetry.addData("beacon", beacon);
            telemetry.addData("tape", tape);
            telemetry.update();

        }
    }
}