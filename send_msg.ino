int requestPin = 7;  // Pin used to receive the request signal
int signalPin = 8;   // Pin used to send the signal

void setup() {
  pinMode(requestPin, INPUT);
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(signalPin, OUTPUT);
}

void loop() {
  if (digitalRead(requestPin) == HIGH) { // Check if request signal is received
    digitalWrite(LED_BUILTIN, HIGH);
    sendSignal();
    delay(1000);  // Delay to prevent continuous sending
  }
  if (digitalRead(requestPin) == LOW) { // Check if request signal is received
    digitalWrite(LED_BUILTIN, LOW);
  }
}

void sendSignal() {
  digitalWrite(signalPin, HIGH);
  delay(500);
//   digitalWrite(signalPin, LOW);
//   delay(500);
//   digitalWrite(signalPin, HIGH);
//   delay(500);
//   digitalWrite(signalPin, LOW);
//   delay(500);  // Ensure signal ends in LOW state
}
