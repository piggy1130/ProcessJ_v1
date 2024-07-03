# compile java file:  
javac -classpath :/opt/pi4j/lib/'*' filename.java  

# sync files:  
git add .  
git commit -m "update message"  
git pull origin main  
git push origin main  

# DIY functions:  
## jl_sleep(int t); 
the unit of t is millisecond.    
example: jl_sleep(1000); sleep 1 second  

note: if we want to set high/low, need to declare the pin as "output" or "input" first!  
in file: lib/JVM/std/pi7.java
javac -classpath :/opt/pi4j/lib/'*' pi7.java  
## set_high_pi7(int pinNo);  
For Raspberry Pi GPIO "output" pin. Send HIGH to Arduino;  
## set_low_pi7(int pinNo);  
For Raspberry Pi GPIO "output" pin. Send LOW to Arduino;  
## get_pin_info(int pinNo);
For Raspberry Pi GPIO "input" pin. Read Arduino information.  
## double jl_random_1();  
get a random number between 0 and 1.  
## int jl_random_100();  
get a random integer number between 0 and 100.  

# Arduion:  
If I set the PIN as of HIHG, the PIN will keep as HIGH until I reset it.  
# ProcessJ:  
If I set the PIN as of HIGH, the PIN will keep as HIGH until program terminates.  
Once the program terminates, all of the PINs will go back to LOW as default.  

