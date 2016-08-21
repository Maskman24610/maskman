package tw.org.iii;

public class Bike {

		// TODO Auto-generated method stub
       private double speed;
       void upSpeed(){
    	   speed=speed<1?1:speed*1.2;   
       }
       void downSpeed(){
    	   speed=speed>2?speed*0.7:(speed+1);
       }
       public double getSpeed(){
    	return speed;   
       }
}
