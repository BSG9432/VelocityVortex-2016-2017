package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;
import com.qualcomm.robotcore.hardware.LightSensor;

/**
 * Created by 299970 on 2/3/2017.
 */

@Autonomous(name = "raspberries", group = "something")

public class redAutonD extends LinearOpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor intake;
    public Servo leftServo;
    public Servo rightServo;
    public LightSensor tape;
    public LightSensor beacon;
    public UltrasonicSensor heyDude;

    @Override
    public void runOpMode() throws InterruptedException {

        frontLeft = hardwareMap.dcMotor.get("motor_4");
        frontRight = hardwareMap.dcMotor.get("motor_1");
        backRight = hardwareMap.dcMotor.get("motor_2");
        backLeft = hardwareMap.dcMotor.get("motor_3");
        intake = hardwareMap.dcMotor.get("motor_5");
        leftServo = hardwareMap.servo.get("servo_1");
        rightServo= hardwareMap.servo.get("servo_2");
        tape = hardwareMap.lightSensor.get("tape");
        beacon = hardwareMap.lightSensor.get("light");
        heyDude = hardwareMap.ultrasonicSensor.get("wall");

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        leftServo.setPosition(.9);
        rightServo.setPosition(.2);

        boolean bPrevState = false;
        boolean bCurrState = false;

        boolean bLedOn = true;

        beacon = hardwareMap.lightSensor.get("light");
        tape = hardwareMap.lightSensor.get("tape");

        tape.enableLed(bLedOn);
        beacon.enableLed(bLedOn);

        waitForStart();

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        sleep(1000);                                                //rest

        frontLeft.setPower(1);
        frontRight.setPower(1);
        backLeft.setPower(-1);
        backRight.setPower(-1);
        sleep(3000);                                                //right

        frontLeft.setPower(.5);
        frontRight.setPower(-.5);
        backLeft.setPower(.5);
        backRight.setPower(-.5);
        sleep(2000);                                                //forward between beacons

        if (tape.getLightDetected() > .35) {
            frontLeft.setPower(.5);
            frontRight.setPower(.5);
            backLeft.setPower(-.5);
            backRight.setPower(-.5);                                //left towards beacon
        }
        else {
            if (heyDude.getUltrasonicLevel() >= 16) {
                frontLeft.setPower(1);
                frontRight.setPower(-1);
                backLeft.setPower(1);
                backRight.setPower(-1);                             //forward towards beacon
            }
            else {
                if (beacon.getLightDetected() >= .28) {                                             //CHANGE THIS VALUE
                    leftServo.setPosition(.2);
                }
                else {
                    rightServo.setPosition(.9);
                }
            }
        }//initate servos accordingly

        beacon.getLightDetected();
        tape.getLightDetected();

        telemetry.addData("left X", gamepad1.left_stick_x);
        telemetry.addData("left Y", gamepad1.left_stick_y);
        telemetry.addData("right x", gamepad1.right_stick_x);
        telemetry.addData("front left", frontLeft);
        telemetry.addData("front right", frontRight);
        telemetry.addData("back left", backLeft);
        telemetry.addData("back right", backRight);
        telemetry.addData("intake", intake);
        telemetry.addData("left Servo", leftServo);
        telemetry.addData("right Servo", rightServo);
        telemetry.addData("beacon",beacon);
        telemetry.addData("tape", tape);
        telemetry.addData("wall", heyDude);
        telemetry.update();
    }
}
