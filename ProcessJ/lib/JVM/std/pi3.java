package std;

import com.pi4j.io.gpio.*;

public class pi3{

//    private static final int[] PI_GPIO = new int{14,15,18,23,24,25,8,7,12,16,20,21,2,3,4,17,27,22,10,9,11,5,6,13,19,26};
    //private static final int[] PI_GPIO = {14,15,18,23,24,25,8,7,12,16,20,21,2,3,4,17,27,22,10,9,11,5,6,13,19,26};
	// private static final int[] PI_GPIO = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,
	// 	15,16,17,18,19,20,21,22,23,24,25};
	private static final int[] PI_GPIO = {13,16,19,20,21};

	public static final int PIN_MAX = 25;
    // private static GpioPinDigitalOutput pins[];
	private static GpioPinDigitalOutput[] pins = new GpioPinDigitalOutput[PIN_MAX];
    // private static GpioController gpio[];
	private static GpioController gpio;

    public static void pi3_println(String s){
        System.out.println("UPDATED!!! Jiaqi is testing GPIO...");
        System.out.println(s);
    }

    private static void initializePins(){

        // pins = new GpioPinDigitalOutput[PIN_MAX];       
        // for (int i=0;i<40;i++)
        //     pins[i]=null;
		
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
        gpio = GpioFactory.getInstance();

        for (int pin : PI_GPIO) {
			System.out.println(pin);
            Pin pin_num = RaspiPin.getPinByAddress(pin);
            pins[pin] = gpio.provisionDigitalOutputPin(pin_num, "MyOutput", PinState.LOW);
            // Ensure the pin is shutdown when the program terminates
            pins[pin].setShutdownOptions(true, PinState.LOW);
        }

	}

	static{
		initializePins();
	}

	public static void set_high_pi3(int pinNo){
		System.out.println("on");
		if (pinNo <0 || pinNo > 39 || pins[pinNo] == null)
			System.out.println("Illegal Pin number (" + pinNo + ")");
		else
			pins[pinNo].high();
	}

	public static void set_low_pi3(int pinNo){
		System.out.println("off");
		if (pinNo <0 || pinNo > 39 || pins[pinNo] == null)
			System.out.println("Illegal Pin number (" + pinNo + ")");
		else
			pins[pinNo].low();
	}


}

