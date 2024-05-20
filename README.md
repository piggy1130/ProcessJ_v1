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
## set_high_pi6(int pinNo);  
For Raspberry Pi GPIO "output" pin. Send HIGH to Arduino;  
## set_low_pi6(int pinNo);  
For Raspberry Pi GPIO "output" pin. Send LOW to Arduino;  
## get_pin_info(int pinNo);
For Raspberry Pi GPIO "input" pin. Read Arduino information.  
