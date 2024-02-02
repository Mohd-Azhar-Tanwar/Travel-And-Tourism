package travel.management.system;

import java.awt.*;
import javax.swing.*;


public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;
    
    public void run(){
        try{
            for(int i = 1; i <= 101; i++){
                int max = bar.getMaximum();
                int value = bar.getValue();
                
                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    Loading(String username){
        this.username = username;
        t = new Thread(this);
        
        setBounds(350, 200, 550, 330);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); 
        
        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(70, 10, 550, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 25));
        add(text);
        
        
        bar = new JProgressBar();
        bar.setBounds(140, 65, 250, 25);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(210, 95, 120, 20);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 10));
        add(loading);
        
        JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setBounds(20, 260, 300, 20);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 14));
        add(lblusername );
        
        t.start();
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Loading("");
    }
}
