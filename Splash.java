package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread thread;
    
    Splash()
    {
      //setSize(1000, 500); 
      //setLocation(130, 100);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
       Image i2 =i1.getImage().getScaledInstance(700, 260, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       add(image);
       
       
       setVisible(true);
       thread = new Thread(this);
       thread.start();
   
    }
    
    public void run() {
        try{
            Thread.sleep(7000);
            //new Login();
            setVisible(false);
        }catch (Exception e){}
        
        
    }
    
    public static void main(String[] arsg){
       Splash frame = new Splash();
       int x = 1;
       for(int i = 1; i <= 300; x+=6, i+=5){
           frame.setLocation(675-(x+i)/2,350-(i/2));
           frame.setSize(x+i,i);
           try {
               Thread.sleep(10 );
           } catch(Exception e){}
       }
    } 
    
}
