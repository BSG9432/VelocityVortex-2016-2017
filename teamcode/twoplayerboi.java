package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;



@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="HOLONOMIC2P",group = "something")
//@Disabled

public class twoplayerboi extends OpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor intake;
    public Servo leftServo;
    public Servo rightServo;

    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("motor_4");
        frontRight = hardwareMap.dcMotor.get("motor_1");
        backRight = hardwareMap.dcMotor.get("motor_2");
        backLeft = hardwareMap.dcMotor.get("motor_3");
        intake = hardwareMap.dcMotor.get("motor_5");
        leftServo = hardwareMap.servo.get("servo_1");
        rightServo = hardwareMap.servo.get("servo_2");


        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {                                //leftstick = direction
        //rightstick = rotation
        //double (gamepad1.left_stick_y)= (-gamepad1.left_stick_y);
        //double (gamepad1.left_stick_x) = (gamepad1.left_stick_x);
        //double (gamepad1.right_stick_x) =(gamepad1.right_stick_x);

        //holonomic formulas
        frontLeft.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x);
        frontRight.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x);
        backLeft.setPower(-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x);
        backRight.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x);

        //thresholds
          /*frontLeft = Range.clip(frontLeft, -1,1);
          frontRight = Range.clip (frontRight, -1,1);
          backLeft = Range.clip (backLeft, -1,1);
          backRight = Range.clip(backRight, -1,1); */

        //motor values

        if (gamepad2.right_bumper || gamepad2.left_bumper)
        {
            if(gamepad2.left_bumper)
            {
                rightServo.setPosition(.75);
            }
            if (gamepad2.right_bumper)
            {
                rightServo.setPosition(.25);
            }
        }
        else
        {
            rightServo.setPosition(.5);
        }



        if (gamepad2.left_trigger >= .25)
        {
            leftServo.setPosition(.25);
        }
        else if (gamepad2.right_trigger >= .25)
        {
            leftServo.setPosition(.75);
        }
        else
        {
            leftServo.setPosition(.5);
        }



        if (gamepad1.right_trigger > .1){
            intake.setPower(gamepad1.right_trigger);
        }
        else {
            intake.setPower(-gamepad1.left_trigger);
        }



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
    }
}