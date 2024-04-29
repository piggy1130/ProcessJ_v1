import com.pi4j.io.gpio.*;

public class test{
    public static void main(String[] args) throws InterruptedException{
        System.out.println("GPIO LED example ... started");
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));
        final GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21);
        while (true){
            pin.high();
            Thread.sleep(1000);
            pin.low();
            Thread.sleep(1000);
        }
        // gpio.shutdown();
        // System.out.println("Exiting");

    }
}