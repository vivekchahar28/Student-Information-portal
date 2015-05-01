import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class MarkShow extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
JButton b1;
JTextField t1;
MarkShow()
{
setLayout(null);
setSize(1000,700);
setResizable(false);

l1 = new JLabel("STUDENT INFORMATION MANAGEMENT SYSTEM");
l2 = new JLabel("Enter the  rollno");

l3 = new JLabel("sub1");
l4 = new JLabel("sub2");
l5 = new JLabel("sub3");
l6 = new JLabel("sub4");
l7 = new JLabel("sub5");

l8 = new JLabel();
l9 = new JLabel();
l10 = new JLabel();
l11 = new JLabel();
l12 = new JLabel();

t1 = new JTextField(5);
b1 = new JButton("Show");
b1.addActionListener(this);
l1.setForeground(Color.red);


l1.setBounds(100,30,400,30);
l2.setBounds(100,100,150,30);

l3.setBounds(10,200,100,30);
l4.setBounds(110,200,100,30);
l5.setBounds(210,200,100,30);
l6.setBounds(310,200,100,30);
l7.setBounds(410,200,100,30);

l8.setBounds(10,250,100,30);
l9.setBounds(110,250,100,30);
l10.setBounds(210,250,100,30);
l11.setBounds(310,250,100,30);
l12.setBounds(410,250,100,30);

t1.setBounds(300,100,150,30);
b1.setBounds(200,300,100,30);

add(l1);
add(l2);
add(l3);l3.setVisible(false);
add(l4);l4.setVisible(false);
add(l5);l5.setVisible(false);
add(l6);l6.setVisible(false);
add(l7);l7.setVisible(false);
add(l8);
add(l9);
add(l10);
add(l11);
add(l12);
add(b1);
add(t1);
}
public void actionPerformed(ActionEvent ae)
{
try
{
String r=ae.getActionCommand();
if(r.equals("Show"))
{
l3.setVisible(true);
l4.setVisible(true);
l5.setVisible(true);
l6.setVisible(true);
l7.setVisible(true);
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:SIMS");
//System.out.println("conneted");
  PreparedStatement ps = con.prepareStatement("select * from marksdetail" );

    ResultSet rs= ps.executeQuery();
//System.out.println("bhupi database");
     while(rs.next()){
String s1=t1.getText();

String rn,sb1,sb2,sb3,sb4,sb5;
  rn = rs.getString("rollno");
  sb1= rs.getString("sub1");
  sb2 = rs.getString("sub2");
 sb3 = rs.getString("sub3");
 sb4 = rs.getString("sub4");
 sb5 = rs.getString("sub5");
if(s1.equals(rn))
{

l8.setText(sb1);
l9.setText(sb2);
l10.setText(sb3);
l11.setText(sb4);
l12.setText(sb5);
}
//else{JOptionPane.showMessageDialog(this,"Plz enter a valid rollno");}
}
}}
catch(Exception e){  }
}
public static void main(String arg[])
{
MarkShow ms = new MarkShow();
ms.setVisible(true);
ms.setSize(500,500);
}
}

