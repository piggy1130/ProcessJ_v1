package std;

import com.pi4j.io.gpio.*;

public class pi7 {
    public static final int PIN_MAX = 40;
    // only 21 pins could be used as GPIO
    private static final int[] PI_output_pin = {2,3,4,17,27,22,5,6,13,19,26,
                                        14,15,18,23,24,25,12,20};
    private static final int[] PI_input_pin = {21,16};

    private static GpioController pi;
    private static GpioPinDigitalOutput[] output_pins = new GpioPinDigitalOutput[PIN_MAX];
    private static GpioPinDigitalInput[] input_pins = new GpioPinDigitalInput[PIN_MAX];
    //private static GpioPinDigitalInput input_pin;

    public static void pi7_println(String s){
        System.out.println("UPDATED - version 7!!! Jiaqi is testing GPIO...");
        System.out.println(s);
    }

    private static void initializePins(){
        pi = GpioFactory.getInstance();
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));

        // initialize OUTPUT pins
        for (int pin : PI_output_pin){
            System.out.println("output pin: "+ pin);
            Pin pin_num = RaspiPin.getPinByAddress(pin);
            output_pins[pin] = pi.provisionDigitalOutputPin(pin_num, "MyOutput", PinState.LOW);
            // Ensure the pin is shutdown when the program terminates                                                                                             
            output_pins[pin].setShutdownOptions(true, PinState.LOW);
        }

        // initialize INPUT pins
        for (int pin : PI_input_pin){
            System.out.println("Input pin: "+ pin);
            Pin input_pin_num = RaspiPin.getPinByAddress(pin);
            input_pins[pin] = pi.provisionDigitalInputPin(input_pin_num, PinPullResistance.PULL_DOWN);
        }

    }

    static{
        initializePins();
    }

    public static void set_high_pi7(int pinNo){
        System.out.println("on");
        output_pins[pinNo].high();
    }

    public static void set_low_pi7(int pinNo){
        System.out.println("off");
        output_pins[pinNo].low();
    }

    public static int get_pin_info_pi7(int pinNo){
        PinState state;
        System.out.println("GPIO Pin State is: " + input_pins[pinNo].getState()); 
        if (input_pins[pinNo].getState() == PinState.HIGH){
            return 1;
        }
        else if (input_pins[pinNo].getState() == PinState.LOW){
            return 0;
        }
        else{
            throw new IllegalArgumentException("Unknow PinSate: " + input_pins[pinNo].getState());
        }
    }

}