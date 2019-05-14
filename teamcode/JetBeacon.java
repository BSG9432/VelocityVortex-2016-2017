package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;



@Autonomous(name = "jet blue", group = "nothing")
@Disabled

public class JetBeacon extends LinearOpMode {

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

        leftServo.setPosition(.9);
        rightServo.setPosition(.2);

        waitForStart();

        if (tape.getLightDetected() > 0.4)
        {
            frontLeft.setPower(.15);
            frontRight.setPower(-.15);
            backLeft.setPower(.15);
            backRight.setPower(-.15);


        }

      /*   if (beacon.getLightDetected() > .25) {
            leftServo.setPosition(.2);
        } else
        {
            rightServo.setPosition(.9);
            sleep(3000);
        }
        */

    }

}
//red = .26
//