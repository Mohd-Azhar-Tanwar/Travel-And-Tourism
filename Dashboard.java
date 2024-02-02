package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkpackages, bookpackage, viewpackage, viewhotels;
    JButton destinations, bookhotel,viewBookedHotel,payments, calculator, notepad, about, deletePersonalDetails;
    Dashboard(String username){
        this.username = username;
       // setBounds(0, 0, 1600, 1000);
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       setLayout(null);
       
       JPanel p1 = new JPanel();
       p1.setLayout(null);
       p1.setBackground(new Color(0, 0, 102));
       p1.setBounds(0, 0, 1600, 45);
       add(p1);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
       Image i2 = i1.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel icon = new JLabel(i3);
       icon.setBounds(5, 0, 50, 50);
       p1.add(icon);
       
       
       JLabel heading = new JLabel("Dashboard");
       heading.setBounds(60, 9, 200, 25);
       heading.setForeground(Color.WHITE);
       heading.setFont(new Font("Tahoma",Font.BOLD,18));
       p1.add(heading);
       
       JPanel p2 = new JPanel();
       p2.setLayout(null);
       p2.setBackground(new Color(0, 0, 102));
       p2.setBounds(0, 45, 200, 800);
       add(p2);
       
        addPersonalDetails = new JButton("Add Personal Details");
       addPersonalDetails.setBounds(0, 0, 200, 30);
       addPersonalDetails.setBackground(new Color(0, 0, 102));
       addPersonalDetails.setForeground(Color.WHITE);
       addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
       addPersonalDetails.setMargin(new Insets(0, 0, 0, 40));
       addPersonalDetails.addActionListener(this);
       p2.add(addPersonalDetails);
       
       
        updatePersonalDetails = new JButton("Update Personal Details");
       updatePersonalDetails.setBounds(0, 40, 200, 30);
       updatePersonalDetails.setBackground(new Color(0, 0, 102));
       updatePersonalDetails.setForeground(Color.WHITE);
       updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
       updatePersonalDetails.setMargin(new Insets(0, 0, 0, 20));
       updatePersonalDetails.addActionListener(this);
       p2.add(updatePersonalDetails);
       
        viewPersonalDetails = new JButton("View Details");
       viewPersonalDetails.setBounds(0, 80, 200, 30);
       viewPersonalDetails.setBackground(new Color(0, 0, 102));
       viewPersonalDetails.setForeground(Color.WHITE);
       viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
       viewPersonalDetails.setMargin(new Insets(0, 0, 0, 90));
       viewPersonalDetails.addActionListener(this);
       p2.add(viewPersonalDetails);
       
        deletePersonalDetails = new JButton("Delete Personal Details");
       deletePersonalDetails.setBounds(0, 120, 200, 30);
       deletePersonalDetails.setBackground(new Color(0, 0, 102));
       deletePersonalDetails.setForeground(Color.WHITE);
       deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
       deletePersonalDetails.setMargin(new Insets(0, 0, 0, 25));
    
       p2.add(deletePersonalDetails);
       
        checkpackages = new JButton("Check Packages");
       checkpackages.setBounds(0, 160, 200, 30);
       checkpackages.setBackground(new Color(0, 0, 102));
       checkpackages.setForeground(Color.WHITE);
       checkpackages.setFont(new Font("Tahoma", Font.PLAIN, 14));
       checkpackages.setMargin(new Insets(0, 0, 0, 70));
       checkpackages.addActionListener(this);
       p2.add(checkpackages);
       
        bookpackage = new JButton("Book Packages");
       bookpackage.setBounds(0, 200, 200, 30);
       bookpackage.setBackground(new Color(0, 0, 102));
       bookpackage.setForeground(Color.WHITE);
       bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 14));
       bookpackage.setMargin(new Insets(0, 0, 0, 74));
       bookpackage.addActionListener(this);
       p2.add(bookpackage);
       
        viewpackage = new JButton("View Packages");
       viewpackage.setBounds(0, 240, 200, 30);
       viewpackage.setBackground(new Color(0, 0, 102));
       viewpackage.setForeground(Color.WHITE);
       viewpackage.setFont(new Font("Tahoma", Font.PLAIN, 14));
       viewpackage.setMargin(new Insets(0, 0, 0, 74));
       viewpackage.addActionListener(this);
       p2.add(viewpackage);
       
        viewhotels = new JButton("View Hotels");
       viewhotels.setBounds(0, 280, 200, 30);
       viewhotels.setBackground(new Color(0, 0, 102));
       viewhotels.setForeground(Color.WHITE);
       viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 14));
       viewhotels.setMargin(new Insets(0, 0, 0, 96));
       viewhotels.addActionListener(this);
       p2.add(viewhotels);
       
        bookhotel = new JButton("Book Hotel");
       bookhotel.setBounds(0, 320, 200, 30);
       bookhotel.setBackground(new Color(0, 0, 102));
       bookhotel.setForeground(Color.WHITE);
       bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 14));
       bookhotel.setMargin(new Insets(0, 0, 0, 100));
       bookhotel.addActionListener(this);
       p2.add(bookhotel);
       
        viewBookedHotel = new JButton("View Booked Hotel");
       viewBookedHotel.setBounds(0, 360, 200, 30);
       viewBookedHotel.setBackground(new Color(0, 0, 102));
       viewBookedHotel.setForeground(Color.WHITE);
       viewBookedHotel.setFont(new Font("Tahoma", Font.PLAIN, 14));
       viewBookedHotel.setMargin(new Insets(0, 0, 0, 50));
       viewBookedHotel.addActionListener(this);
       p2.add(viewBookedHotel);
       
        destinations = new JButton("Destinations");
       destinations.setBounds(0, 400, 200, 30);
       destinations.setBackground(new Color(0, 0, 102));
       destinations.setForeground(Color.WHITE);
       destinations.setFont(new Font("Tahoma", Font.PLAIN, 14));
       destinations.setMargin(new Insets(0, 0, 0, 93));
        destinations.addActionListener(this);
       p2.add(destinations);
       
        payments = new JButton("Payments");
       payments.setBounds(0, 440, 200, 30);
       payments.setBackground(new Color(0, 0, 102));
       payments.setForeground(Color.WHITE);
       payments.setFont(new Font("Tahoma", Font.PLAIN, 14));
       payments.setMargin(new Insets(0, 0, 0, 105));
       payments.addActionListener(this);
       p2.add(payments);
       
        calculator = new JButton("Calculator");
       calculator.setBounds(0, 480, 200, 30);
       calculator.setBackground(new Color(0, 0, 102));
       calculator.setForeground(Color.WHITE);
       calculator.setFont(new Font("Tahoma", Font.PLAIN, 14));
       calculator.setMargin(new Insets(0, 0, 0, 105));
       calculator.addActionListener(this);
       p2.add(calculator);
       
        notepad = new JButton("Notepad");
       notepad.setBounds(0, 520, 200, 30);
       notepad.setBackground(new Color(0, 0, 102));
       notepad.setForeground(Color.WHITE);
       notepad.setFont(new Font("Tahoma", Font.PLAIN, 14));
       notepad.setMargin(new Insets(0, 0, 0, 120));
       notepad.addActionListener(this);
       p2.add(notepad);
       
        about = new JButton("About");
       about.setBounds(0, 560, 200, 30);
       about.setBackground(new Color(0, 0, 102));
       about.setForeground(Color.WHITE);
       about.setFont(new Font("Tahoma", Font.PLAIN, 14));
       about.setMargin(new Insets(0, 0, 0, 130));
       about.addActionListener(this);
       p2.add(about);
       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
       Image i5 = i4.getImage().getScaledInstance(1200, 720, Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel image = new JLabel(i6);
       image.setBounds(0, 0, 1400, 800);
       add(image);
       
       JLabel text = new JLabel("Travel and Tourism Management System");
       text.setBounds(440, 60, 1000, 70);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("Raleway", Font.PLAIN, 30));
       image.add(text);
      
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        } else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        } else if (ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username);
        } else if( ae.getSource() == checkpackages) {
            new CheckPackage();
         
        
        } else if (ae.getSource() == bookpackage){
            new BookPackage(username);
        } else if (ae.getSource() == viewpackage){
            new ViewPackage(username);
        } else if (ae.getSource() == viewhotels ){
            new CheckHotels();
        } else if (ae.getSource() == destinations){
            new Destinations();
        } else if (ae.getSource() == bookhotel){
            new BookHotel(username);
        } else if (ae.getSource() == viewBookedHotel){
            new ViewBookedHotel(username);
        } else if (ae.getSource() ==  payments){
            new Payment();
        } else if(ae.getSource() == calculator){
            try{
                Runtime .getRuntime().exec("calc.exe");
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == about){
            new About();
        } else if(ae.getSource() == deletePersonalDetails){
            new DeleteDetails(username);
        }
    }
    
    public static void main(String[] args){
        new Dashboard("");
    }
}
