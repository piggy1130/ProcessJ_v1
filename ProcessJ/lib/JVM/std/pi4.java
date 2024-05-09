package std;

import com.pi4j.io.gpio.*;

public class pi4 {
    public static final int PIN_MAX = 40;
    // only 21 pins could be used as GPIO
    private static final int[] PI_GPIO = {2,3,4,17,27,22,5,6,13,19,26,
                                        14,15,18,23,24,25,12,16,20,21};
    private static GpioPinDigitalOutput[] pins = new GpioPinDigitalOutput[PIN_MAX];
    private static GpioController pi;

    public static void pi4_println(String s){
        System.out.println("UPDATED - version 4!!! Jiaqi is testing GPIO...");
        System.out.println(s);
    }

    private static void initializePins(){
        pi = GpioFactory.getInstance();
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));

        for (int pin : PI_GPIO){
            System.out.println(pin);
            Pin pin_num = RaspiPin.getPinByAddress(pin);
            pins[pin] = pi.provisionDigitalOutputPin(pin_num, "MyOutput", PinState.LOW);
            // Ensure the pin is shutdown when the program terminates                                                                                             
            pins[pin].setShutdownOptions(true, PinState.LOW);
        }
    }

    static{
        initializePins();
    }

    public static void set_high_pi4(int pinNo){
        System.out.println("on");
        pins[pinNo].high();
    }

    public static void set_low_pi4(int pinNo){
        System.out.println("off");
        pins[pinNo].low();
    }

}