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
  }
  if (digitalRead(requestPin) == LOW) { // Check if request signal is received
    digitalWrite(LED_BUILTIN, LOW);
  }
}

// assume the signal is 5-digit
void sendSignal() {
  digitalWrite(signalPin, HIGH);
  delay(500);
  digitalWrite(signalPin, LOW);
  delay(500);
  digitalWrite(signalPin, LOW);
  delay(500);
  digitalWrite(signalPin, LOW);
  delay(500);  
  digitalWrite(signalPin, HIGH);
  delay(500);
  digitalWrite(signalPin, LOW); // Ensure signal ends in LOW state
  delay(500);  
}
