package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by daddy on 11/9/2016.
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="holonomic",group = "something")
//@Disabled

public class teleOp extends OpMode {
    
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor intake;
    public Servo leftServo;
    public Servo rightServo;
    public LightSensor beacon;
    public LightSensor tape;
    public UltrasonicSensor heyDude;

    @Override
    public void init() {

        frontLeft = hardwareMap.dcMotor.get("motor_4");
        frontRight = hardwareMap.dcMotor.get("motor_1");
        backRight = hardwareMap.dcMotor.get("motor_2");
        backLeft = hardwareMap.dcMotor.get("motor_3");
        intake = hardwareMap.dcMotor.get("motor_5");
        leftServo = hardwareMap.servo.get("servo_1");
        rightServo = hardwareMap.servo.get("servo_2");
        beacon = hardwareMap.lightSensor.get("light");
        tape = hardwareMap.lightSensor.get("tape");
        heyDude = hardwareMap.ultrasonicSensor.get("wall");

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        boolean bPrevState = false;
        boolean bCurrState = false;

        boolean bLedOn = true;

        beacon = hardwareMap.lightSensor.get("light");
        tape = hardwareMap.lightSensor.get("tape");

        tape.enableLed(bLedOn);
        beacon.enableLed(bLedOn);
    }
    @Override
    public void loop() {

        frontLeft.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);
        frontRight.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);
        backLeft.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x);
        backRight.setPower(-gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x);

        if (gamepad1.left_bumper)
            rightServo.setPosition(.9);
        else
            rightServo.setPosition(.2);

        if (gamepad1.x)
            leftServo.setPosition(.2);
        else
            leftServo.setPosition(.9);

        if (gamepad1.right_trigger > .1)
            intake.setPower(gamepad1.right_trigger);
        else
            intake.setPower(-gamepad1.left_trigger);

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
//raw
//field = 0.03 - 0.04
//tape = 0.06 - 0.07

//led
//field = 0.15 - 0.16
//tape = 0.25 - 0.26
//red = .24 - .25
//blue = .22 - .23

//wall 16.0