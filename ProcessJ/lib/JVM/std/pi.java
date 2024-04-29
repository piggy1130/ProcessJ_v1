package std;

import com.pi4j.io.gpio.*;

public class pi{
	// public static final int PIN_MAX = 10;

	public static void pi_println(String s){
		System.out.println("Jiaqi is testing GPIO...");
    		System.out.println(s);
	}

	public static void pi_led_test(){
		try{	
			System.out.println("GPIO LED example ... started");
			GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
			final GpioController gpio = GpioFactory.getInstance();
			GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21);
			int n = 5;
			int i = 0;
			while(i<5){
				pin.high();
				System.out.println("on");
				Thread.sleep(1000);
				pin.low();
				System.out.println("off");
				Thread.sleep(1000);
				i = i + 1;
			}
	    }
	    catch (InterruptedException e){
	        System.out.println("The thread was interrupted");
	    }
    }


/*
	public static GpioPinDigitalOutput provisionPin(String userInput){
	    GpioController gpio = GpioFactory.getInstance();
	    Pin pin = convertStringToPin(userInput);
	    if (pin != null){
	     
	    }
	}
*/

}

