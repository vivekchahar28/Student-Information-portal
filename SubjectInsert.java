import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class SubjectInsert extends JFrame implements ActionListener
{
JLabel ll1,ll2,ll3,l1,l2,l3,l4,l5,l6,l7,ls,lc;
JButton b1,b2;
JTextField tt1,tt2,t1,t2,t3,t4,t5,t6,t7;

SubjectInsert()
{
setLayout(null);
ll1 = new JLabel("STUDENT INFORMATION MANAGEMENT SYSTEM");
ll1.setFont(new Font("Times New Roman",Font.BOLD,20));

ll2 = new JLabel("class");tt1 = new JTextField();
ll3 =new JLabel("Sem");tt2 = new JTextField();

lc=new JLabel("Subject Code");
ls=new JLabel("Subjects");

l1 = new JLabel("sub1");
l2 = new JLabel("sub2");
l3 = new JLabel("sub3");
l4 = new JLabel("sub4");
l5 = new JLabel("sub5");
l6 = new JLabel("Practical1");
l7 = new JLabel("Practical2");

t1 = new JTextField();
t2 = new JTextField();
t3 = new JTextField();
t4 = new JTextField();
t5 = new JTextField();
t6 = new JTextField();
t7 = new JTextField();
                              

b1 = new JButton("Insert");
b1.addActionListener(this);
b1.setForeground(Color.red);
b1.setBounds(650,450,100,30);

b2 = new JButton("Back");
b2.addActionListener(this);
b2.setForeground(Color.red);
b2.setBounds(650,500,100,30);

ll1.setBounds(250,30,800,30);
ll2.setBounds(120,100,75,30);tt1.setBounds(200,100,150,30);
ll3.setBounds(400,100,75,30);tt2.setBounds(480,100,75,30);

ls.setBounds(190,150,100,30);lc.setBounds(270,150,100,30);
l1.setBounds(200,200,100,30);t1.setBounds(270,200,100,30);
l2.setBounds(200,250,100,30);t2.setBounds(270,250,100,30);
l3.setBounds(200,300,100,30);t3.setBounds(270,300,100,30);
l4.setBounds(200,350,100,30);t4.setBounds(270,350,100,30);
l5.setBounds(200,400,100,30);t5.setBounds(270,400,100,30);
l6.setBounds(200,450,100,30);t6.setBounds(270,450,100,30);
l7.setBounds(200,500,100,30);t7.setBounds(270,500,100,30);
add(ll1);
add(ll2);
add(ll3);
add(ls);
add(lc);
add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);

add(tt1);
add(tt2);
add(t1);
add(t2);
add(t3);
add(t4);
add(t5);
add(t6);
add(t7);
add(b1);
add(b2);
}
public void actionPerformed(ActionEvent ae)
{
try
{
String r=ae.getActionCommand();
if(r.equals("Insert"))
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:SIMS"); 
  String cl,sm,sb1,sb2,sb3,sb4,sb5,sb6,sb7;
  cl=tt1.getText();
  sm=tt2.getText();
  sb1=t1.getText();
  sb2=t2.getText();
  sb3=t3.getText();
  sb4=t4.getText();
  sb5=t5.getText();
  sb6=t6.getText();
  sb7=t7.getText();

if(cl.equals("MBA"))
{
PreparedStatement ps = con.prepareStatement("insert into MBA values(?,?,?,?,?,?,?,?)");
ps.setString(1,sm);
ps.setString(2,sb1);
ps.setString(3,sb2);
ps.setString(4,sb3);
ps.setString(5,sb4);
ps.setString(6,sb5);
ps.setString(7,sb6);
ps.setString(8,sb7);
int a=ps.executeUpdate();
if(a!=0)
JOptionPane.showMessageDialog(this,"Insert new record successfully");
}
else if(cl.equals("MCA"))
{
PreparedStatement ps1 = con.prepareStatement("insert into MCA values(?,?,?,?,?,?,?,?)");
ps1.setString(1,sm);
ps1.setString(2,sb1);
ps1.setString(3,sb2);
ps1.setString(4,sb3);
ps1.setString(5,sb4);
ps1.setString(6,sb5);
ps1.setString(7,sb6);
ps1.setString(8,sb7);
int b=ps1.executeUpdate();
if(b!=0)
JOptionPane.showMessageDialog(this,"Insert new record successfully");
}


tt1.setText(null);
tt2.setText(null);
t1.setText(null);
t2.setText(null);
t3.setText(null);
t4.setText(null);
t5.setText(null);
t6.setText(null);
t7.setText(null);
}
}
catch(Exception e)
{
System.out.println(e);
}

if(ae.getSource()==b2)
{
JInfo ji=new JInfo("SIMS");
ji.setSize(1100,1100);
ji.setVisible(true);
this.setVisible(false);

}

}
public static void main(String arg[])
{
SubjectInsert si = new SubjectInsert();
si.setVisible(true);
si.setSize(1000,1000);
}

}