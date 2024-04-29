import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.*;

public class gpio {

    public static void main(String[] args) throws InterruptedException {
        // Create a gpio controller instance
        final GpioController gpio = GpioFactory.getInstance();

        // Provision GPIO pin #21 as an output pin and turn it on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "MyLED", PinState.HIGH);
        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(5000); // wait for 1 seconds

        // Turn off GPIO pin #01
        pin.low();
        System.out.println("--> GPIO state should be: OFF");

        Thread.sleep(5000); // wait for 5 seconds

        // Toggle the current state of GPIO pin #01 (should turn on)
        pin.toggle();
        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(5000); // wait for 5 seconds

        // Toggle again (should turn off)
        pin.toggle();
        System.out.println("--> GPIO state should be: OFF");

        // Release all GPIO resources
        gpio.shutdown();
    }
}
