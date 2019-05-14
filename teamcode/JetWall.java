package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by Daddy.
 */

@Autonomous(name = "JetWall",group = "something")

public class JetWall extends LinearOpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor intake;
    public Servo leftServo;
    public Servo rightServo;
    public UltrasonicSensor heyDude;

    @Override
    public void runOpMode() throws InterruptedException {

        frontLeft = hardwareMap.dcMotor.get("motor_4");
        frontRight = hardwareMap.dcMotor.get("motor_1");
        backRight = hardwareMap.dcMotor.get("motor_2");
        backLeft = hardwareMap.dcMotor.get("motor_3");
        intake = hardwareMap.dcMotor.get("motor_5");
        leftServo = hardwareMap.servo.get("servo_1");
        rightServo = hardwareMap.servo.get("servo_2");
        heyDude = hardwareMap.ultrasonicSensor.get("wall");


        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        leftServo.setPosition(.9);
        rightServo.setPosition(.2);

        waitForStart();
        {

            while (heyDude.getUltrasonicLevel() > 10) {
                frontLeft.setPower(.1);
                frontRight.setPower(-.1);
                backLeft.setPower(.1);
                backRight.setPower(-.1);



            }

            frontLeft.setPower(.5);
            frontRight.setPower(.5);
            backLeft.setPower(.5);
            backRight.setPower(.5);
            leftServo.setPosition(.5);
            sleep(1000);

            frontLeft.setPower();
            frontRight.setPower();
            backLeft.setPower();
            backRight.setPower();

            telemetry.addData("wall", heyDude);
            telemetry.update();


        }

    }

}


