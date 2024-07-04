void setup() {
  Serial.begin(9600);

  pinMode(8, OUTPUT);
  digitalWrite(8, LOW);

  pinMode(7, INPUT);
  digitalWrite(7, LOW);

  pinMode(6, OUTPUT);
  digitalWrite(6, LOW);
}

// the loop function runs over and over again forever
void loop() {

  //digitalWrite(6, LOW);
  delay(2000); // thinking

  digitalWrite(8, HIGH); // request to eat
  //delay(100);
  //digitalWrite(8, LOW);
  //Serial.println("request to eat");
  //Serial.println(digitalRead(7));

  // approve to eat & eating
  if (digitalRead(7) == 1){
    digitalWrite(6, LOW);
    Serial.println("receive eat command");
    // turn on LED
    digitalWrite(LED_BUILTIN, HIGH);
    Serial.println("turn on LED"); 
    // start to eat
    delay(3000);
    // Eat Done - turn off LED
    digitalWrite(LED_BUILTIN, LOW);
    Serial.println("turn off LED"); 
    digitalWrite(8, LOW);
    // send info to Raspberry Pi to let it know - done eating
    digitalWrite(6, HIGH);
  }

    // send info to Raspberry Pi to let it know - done eating
  //digitalWrite(6, HIGH);
  
}



