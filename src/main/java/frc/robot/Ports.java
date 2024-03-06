package frc.robot;

/**
 * Contains the definitions of all the ports
 */
public class Ports {

/**
		 * CAN Ids
		 */
		public static class CAN {		

					// SPARK MAX CAN IDs
                    public static final int FRONT_LEFT_DRIVING = 6;
                    public static final int REAR_LEFT_DRIVING = 4;
                    public static final int FRONT_RIGHT_DRIVING = 8;
                    public static final int REAR_RIGHT_DRIVING = 2;
        
                    public static final int FRONT_LEFT_TURNING = 5;
                    public static final int REAR_LEFT_TURNING = 3;
                    public static final int FRONT_RIGHT_TURNING = 7;
                    public static final int REAR_RIGHT_TURNING = 1;

			// TALON SRX CAN IDS
		}
		
		/**
		 * USB ports
		 */
		public static class USB {
			public static final int RIGHT_JOYSTICK = 0;
			public static final int LEFT_JOYSTICK = 1;
			//public static final int DRIVER_GAMEPAD = 3;
			public static final int COPILOT_GAMEPAD = 2;
			public static final int MAIN_JOYSTICK = 4;
		}

        public static class Analog {
			//public static final int SONAR = 3;
			//public static final int PRESSURE_SENSOR = 1;

			// 2023 Off-season
			// SPARK MAX Absolute encoders
			
            public static final int FRONT_RIGHT_TURNING_ABSOLUTE_ENCODER = 0;
			public static final int REAR_RIGHT_TURNING_ABSOLUTE_ENCODER = 1;
			public static final int REAR_LEFT_TURNING_ABSOLUTE_ENCODER = 3;
			public static final int FRONT_LEFT_TURNING_ABSOLUTE_ENCODER = 2;		
		}
		
		/**
		 * PWM ports
		 */
		//public static class PWM {
			//public static final int LED_STRIP = 9;
		//}

		/**
		 * USB cameras
		 */
		//public static class UsbCamera {
			//public static final int PRIMARY_CAMERA = 0;
			//public static final int BOTTOM_CAMERA = 1;
			//public static final int TOP_CAMERA = 2;
		}
