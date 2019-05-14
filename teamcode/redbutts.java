package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AccelerationSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

/**
 * Created by 299970 on 12/13/2016.
 */

@Autonomous(name = "redbutts",group = "Jet's Buttons")

public class redbutts extends LinearOpMode{

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor intake;
    public Servo leftServo;
    public Servo rightServo;
    //public LightSensor tape;
    //public LightSensor beacon;
    public UltrasonicSensor  heyDude;

    @Override
    public void runOpMode() throws InterruptedException {

        frontLeft = hardwareMap.dcMotor.get("motor_4");
        frontRight = hardwareMap.dcMotor.get("motor_1");
        backRight = hardwareMap.dcMotor.get("motor_2");
        backLeft = hardwareMap.dcMotor.get("motor_3");
        intake = hardwareMap.dcMotor.get("motor_5");
        leftServo = hardwareMap.servo.get("servo_1");
        rightServo= hardwareMap.servo.get("servo_2");
        //tape = hardwareMap.lightSensor.get("tape");
       // beacon = hardwareMap.lightSensor.get("beacon");
        heyDude = hardwareMap.ultrasonicSensor.get("wall");

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
        leftServo.setPosition(.9);
        rightServo.setPosition(.2);

        waitForStart();

        //strafe right for 4 seconds
        frontLeft.setPower(1);
        frontRight.setPower(1);
        backLeft.setPower(-1);
        backRight.setPower(-1);
        sleep(4000);

        //forward for 3 seconds
        frontLeft.setPower(1);
        frontRight.setPower(-1);
        backLeft.setPower(1);
        backRight.setPower(-1);
        sleep(3000);

        /*while (OPTICAL SENSOR GREATER THAN WALL){
            frontLeft.setPower(.5);
            frontRight.setPower(-.5);
            backLeft.setPower(.5);
            backRight.setPower(-.5);
        }
        else {
            frontLeft.setPower(-.5);
            frontRight.setPower(-.5);
            backLeft.setPower(.5);
            backRight.setPower(.5);

            if (TAPE SENSOR ON WHITE){
                frontLeft.setPower(0);
                frontRight.setPower(0);
                backLeft.setPower(0);
                backRight.setPower(0);
                sleep(1000);

                //DETECT LIGHTS LEVELS AND HAVE SERVOS REACT
                frontLeft.setPower(.5);
                frontRight.setPower(-.5);
                backLeft.setPower(.5);
                backRight.setPower(-.5);
            }
          */   }
        }


    /*
            Ideal Sensor Values
    - beacon: 29(on)
      * .37 (red/close)
      * .32 (blue/close)
    - tape: 52(on) 33 (off)

     */


