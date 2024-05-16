package std;

import com.pi4j.io.gpio.*;

public class pi5 {
    public static final int PIN_MAX = 40;
    // only 21 pins could be used as GPIO
    private static final int[] PI_GPIO = {2,3,4,17,27,22,5,6,13,19,26,
                                        14,15,18,23,24,25,12,16,21};
    
    private static GpioController pi;
    private static GpioPinDigitalOutput[] pins = new GpioPinDigitalOutput[PIN_MAX];
    private static GpioPinDigitalInput input_pin;

    public static void pi5_println(String s){
        System.out.println("UPDATED - version 5!!! Jiaqi is testing GPIO...");
        System.out.println(s);
    }

    private static void initializePins(){
        pi = GpioFactory.getInstance();
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));

        for (int pin : PI_GPIO){
            // System.out.println(pin);
            Pin pin_num = RaspiPin.getPinByAddress(pin);
            pins[pin] = pi.provisionDigitalOutputPin(pin_num, "MyOutput", PinState.LOW);
            // Ensure the pin is shutdown when the program terminates                                                                                             
            pins[pin].setShutdownOptions(true, PinState.LOW);
        }

        input_pin = pi.provisionDigitalInputPin(RaspiPin.GPIO_20, PinPullResistance.PULL_DOWN);

    }

    static{
        initializePins();
    }

    public static void set_high_pi5(int pinNo){
        System.out.println("on");
        pins[pinNo].high();
    }

    public static void set_low_pi5(int pinNo){
        System.out.println("off");
        pins[pinNo].low();
    }

    public static int get_pin_info(){
        PinState state;
        System.out.println("GPIO Pin State is: " + input_pin.getState()); 
        if (input_pin.getState() == PinState.HIGH){
            return 1;
        }
        else if (input_pin.getState() == PinState.LOW){
            return 0;
        }
        else{
            throw new IllegalArgumentException("Unknow PinSate: " + input_pin.getState());
        }
    }

}