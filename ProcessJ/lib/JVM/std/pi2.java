package std;

import com.pi4j.io.gpio.*;

public class pi2{
	// public static final int PIN_MAX = 10;
	private static GpioPinDigitalOutput pin;
	private static GpioController gpio;

	// public pi2(){
	// 	// Initialize the GPIO controller
	// 	GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
	// 	gpio = GpioFactory.getInstance();
	// }
	public static void pi2_println(String s){
		System.out.println("UPDATED!!! Jiaqi is testing GPIO...");
    	System.out.println(s);
	}
	
	private static void initializePin(int pinNumber){
		GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
		gpio = GpioFactory.getInstance();
		Pin pin_num = RaspiPin.getPinByAddress(pinNumber);
		pin = gpio.provisionDigitalOutputPin(pin_num, "MyOutput", PinState.LOW);
		// Ensure the pin is shutdown when the program terminates
		pin.setShutdownOptions(true, PinState.LOW);
	}

	static{
		initializePin(21);
	}

	public static void set_high(){
		System.out.println("on");
		pin.high();
	}

	public static void set_low(){
		System.out.println("off");
		pin.low();
	}

	// public static void pi_led_test(){
	// 	try{	
	// 		// System.out.println("GPIO LED example ... started");
	// 		// GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
	// 		// final GpioController gpio = GpioFactory.getInstance();
	// 		// GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21);
	// 		int n = 5;
	// 		int i = 0;
	// 		while(i<5){
	// 			pin.high();
	// 			System.out.println("on");
	// 			Thread.sleep(1000);
	// 			pin.low();
	// 			System.out.println("off");
	// 			Thread.sleep(1000);
	// 			i = i + 1;
	// 		}
	//     }
	//     catch (InterruptedException e){
	//         System.out.println("The thread was interrupted");
	//     }
    // }


}

