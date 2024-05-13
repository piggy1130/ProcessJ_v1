const int start_device_pin = 9;
//const int end_device_pin = 4;

int device_state = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600); // serial communication at 9600 bits per second
  pinMode(start_device_pin, INPUT); 
  pinMode(LED_BUILTIN, OUTPUT);
  //pinMode(end_device_pin, INPUT);
}

void loop() {
  
  if (digitalRead(start_device_pin) == HIGH){
    Serial.println("Device ON");
    digitalWrite(LED_BUILTIN, HIGH);
    delay(1000); // delay 1s
  }
  if (digitalRead(start_device_pin) == LOW){
    Serial.println("Device OFF");
    digitalWrite(LED_BUILTIN, LOW);
    delay(1000); // delay 1s
  }

}
