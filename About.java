package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class About extends JFrame implements ActionListener {
    
    About(){
        
        setBounds(500, 100, 500, 550);
        setLayout(null);
        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200, 5, 100, 30);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.PLAIN,16));
        add(l1);
        
        String s = "About Projects       \n" +
                "  \n"  +
                "The objetive of Travel and Tourism Management Systemproject is to develop a System that automates the processes and activities of travel and the purpose\n" +
                "\n" +
                "This Application will help in accesssing the information related to the travel to the particular destination with great ease through this application. The user can track the information related tp thier tours with great ease through this Application . The travel agency information can also be obtained through this Application\n" +
                "\n" +
                "Advantages of Project:\n" +
                "Gives accurate information\n" +
                "Simplifies the manual work\n" +
                "It minimizes the documentation related work\n" +
                "Provide up to date information\n" +
                "Friendly Enivironment by providing warning message.\n" +
                "travelers details can be provided\n" +
                "Booking confirmation notifications";
        
        TextArea area = new TextArea(s, 10, 30, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);
        
        JButton back = new JButton("Back");
        back.setBounds(200, 450, 100, 25);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args){
        new About();
    }
}
