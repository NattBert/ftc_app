package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.hardware.DcMotorController;

public class PushBotManualLegacy extends PushBotTelemetry

{
    DcMotorController.DeviceMode devMode;

    public PushBotManualLegacy()
    {

    }

    @Override public void loop ()

    {
        devMode = DcMotorController.DeviceMode.READ_WRITE;

        float l_left_drive_power = scale_motor_power (-gamepad1.left_stick_y);
        float l_right_drive_power = scale_motor_power (-gamepad1.right_stick_y);

        set_drive_power (l_left_drive_power, l_right_drive_power);

        float l_left_arm_power = scale_motor_power (-gamepad2.left_stick_y);
        m_left_arm_power (l_left_arm_power);

        if (gamepad2.x)
        {
            m_hand_position (a_hand_position () + 0.05);
        }
        else if (gamepad2.b)
        {
            m_hand_position (a_hand_position () - 0.05);
        }

        update_telemetry ();
        update_gamepad_telemetry ();

    }

}
