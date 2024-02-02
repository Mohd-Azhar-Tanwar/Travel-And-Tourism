package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgetPassword extends JFrame implements ActionListener  {
    
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;
    ForgetPassword(){
        setBounds(290, 190, 650, 280);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 40, 130, 130);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(20, 20, 380,200);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 15, 80, 20);
        lblusername.setFont(new Font("Tahoma",Font.BOLD, 13));
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(160, 15, 120, 20 );
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(290, 15, 80, 20);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(20, 45, 80, 20);
        lblname.setFont(new Font("Tahoma",Font.BOLD, 13));
        p1.add(lblname);
        
        tfname = new JTextField();
         tfname.setBounds(160, 45, 120, 20 );
         tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add( tfname);
        
        JLabel lblquestion  = new JLabel("Security Question");
        lblquestion.setBounds(20, 75, 140, 20);
        lblquestion.setFont(new Font("Tahoma",Font.BOLD, 13));
        p1.add(lblquestion);
        
        tfquestion = new JTextField();
         tfquestion .setBounds(160, 75, 120, 20 );
         tfquestion .setBorder(BorderFactory.createEmptyBorder());
        p1.add( tfquestion );
        
        JLabel lblanswer  = new JLabel("Answer");
        lblanswer.setBounds(20, 105, 100, 20);
        lblanswer.setFont(new Font("Tahoma",Font.BOLD, 13));
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
         tfanswer .setBounds(160, 105, 120, 20 );
         tfanswer .setBorder(BorderFactory.createEmptyBorder());
        p1.add( tfanswer );
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(285, 105, 90, 20);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lblpassword  = new JLabel("Password");
        lblpassword .setBounds(20, 135, 100, 20);
        lblpassword .setFont(new Font("Tahoma",Font.BOLD, 13));
        p1.add(lblpassword );
        
        tfpassword = new JTextField();
         tfpassword .setBounds(160, 135, 120, 20 );
         tfpassword .setBorder(BorderFactory.createEmptyBorder());
        p1.add( tfpassword );
        
         back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(140, 170, 90, 20);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                
                  ResultSet rs = c.s.executeQuery(query);
                  while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                  }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == retrieve){
            try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                
                  ResultSet rs = c.s.executeQuery(query);
                  while(rs.next()){
                    tfpassword.setText(rs.getString("password"));
                  }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Login();
        }
        
    
    }
    
    public static void main(String[] args){
        new ForgetPassword();
    }
}
