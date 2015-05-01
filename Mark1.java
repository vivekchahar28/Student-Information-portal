import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Mark1 extends JFrame implements ActionListener
{
	String ss;
	JLabel l1,l2,l3,l4;
	JButton b1,b2,bh;
	JTextField t1;
	JComboBox jcb1,jcb2;
	Connection con;
	ResultSet rs1;
	Statement stmt1;
	int temp=0,temp1=0,a,b;
	JPanel c;
	String s1,s2,s3,s4,s5,s6;
	Mark k1;
	Mark1(String s)
	{
		super(s);
		ss=s;
		JPanel c=(JPanel)getContentPane();
		c.setLayout(null);
                           Color cl= new Color(100,250,100);
		c.setBackground(cl);
		l4=new JLabel("STUDENT INFORMATION MANAGEMENT SYSTEM");
		l4.setFont(new Font("Arial",Font.BOLD,20));
		l4.setBounds(430,300,550,20);
		l4.setForeground(Color.gray);
		l1=new JLabel("Enter RollNumber");
		l1.setFont(new Font("Arial",Font.BOLD,12));
		l1.setBounds(350,350,100,12);
		t1=new JTextField();
		t1.setBounds(460,350,100,20);
		l2=new JLabel("Select Course");
		l2.setFont(new Font("Arial",Font.BOLD,12));
		l2.setBounds(580,350,100,12);
		jcb1=new JComboBox();
		jcb1.setBounds(680,350,70,20);
		jcb1.addItem("MBA");
		jcb1.addItem("MCA");
		//jcb1.addItemListener(this);
		l3=new JLabel("Select Semester");
		l3.setFont(new Font("Arial",Font.BOLD,12));
		l3.setBounds(760,350,100,12);
		jcb2=new JComboBox();
		jcb2.setBounds(870,350,80,20);
		jcb2.addItem("1");
		jcb2.addItem("2");
		jcb2.addItem("3");
		jcb2.addItem("4");
		jcb2.addItem("5");
		jcb2.addItem("6");
		//jcb2.addItemListener(this);
		b1=new JButton("Submit");
		b1.setFont(new Font("Arial",Font.BOLD,12));
		b1.setBounds(540,390,100,20);
		b1.addActionListener(this);
		b2=new JButton("Back");
		b2.setFont(new Font("Arial",Font.BOLD,12));
		b2.setBounds(650,390,100,20);
		b2.addActionListener(this);
		bh=new JButton("HOME");
		bh.setBounds(760,390,100,20);
		bh.setFont(new Font("Arial",Font.BOLD,12));
		bh.addActionListener(this);
		c.add(bh);
		c.add(l4);
		c.add(l1);
		c.add(t1);
		c.add(l2);
		c.add(jcb1);
		c.add(l3);
		c.add(jcb2);
		c.add(b1);
		c.add(b2);
	}
	public void connect()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:SIMS");
		}
		catch(Exception e){}
	}
public void screen()
{
Toolkit t=Toolkit.getDefaultToolkit();
Dimension d=t.getScreenSize();
a=d.width;
b=d.height;
}

	public void actionPerformed(ActionEvent e)
	{
		screen();
		String s5=e.getActionCommand();
		if(s5.equals("Submit"))
		{
			
			try
			{
				temp=0;
				Mark k1= new Mark(ss);
				s1=t1.getText();
				s2=(String)jcb1.getSelectedItem();
				s3=(String)jcb2.getSelectedItem();
				connect();
				Statement stmt1=con.createStatement();
				ResultSet rs1=stmt1.executeQuery("select *from Academicdetail");
				while(rs1.next())
				{
					
					
					temp=0;
					if(s1.equals(rs1.getString(2))&&s2.equals(rs1.getString(5))&&s3.equals(rs1.getString(8)))
				             {
						
						k1.l2.setText(s2+" "+s3+" Semester Result");
						k1.l8.setText(s1);
						k1.l4.setText(rs1.getString(4));
						temp=1;
						Statement stmt5=con.createStatement();
						ResultSet rs6=stmt5.executeQuery("select *from studentpersonal");
						while(rs6.next())
						{
							if(s1.equals(rs6.getString(1)))
							{
								k1.l6.setText(rs6.getString(4));
								break;
							}
						}	
						Statement stmt2=con.createStatement();
						ResultSet rs3=stmt2.executeQuery("select *from "+s2);
						while(rs3.next())
						{
							if(s3.equals(rs3.getString(1)))
							{
								k1.l12.setText(rs3.getString(2));
								k1.l15.setText(rs3.getString(3));
								k1.l18.setText(rs3.getString(4));
								k1.l21.setText(rs3.getString(5));
								k1.l24.setText(rs3.getString(6));
								k1.l27.setText(rs3.getString(7));
								k1.l30.setText(rs3.getString(8));
								break;
											
							}
							
						}
						Statement stmt3=con.createStatement();
						ResultSet rs4=stmt3.executeQuery("select *from marks");
				
						while(rs4.next())
						{
							if(s1.equals(rs4.getString(1)))					
							{
								k1.l13.setText(rs4.getString(3));
								k1.l16.setText(rs4.getString(4));
								k1.l19.setText(rs4.getString(5));
								k1.l22.setText(rs4.getString(6));
								k1.l25.setText(rs4.getString(7));
								k1.l28.setText(rs4.getString(8));
								k1.l31.setText(rs4.getString(9));
								break;
											
							}
							
						}
						Statement stmt4=con.createStatement();
						ResultSet rs5=stmt4.executeQuery("select *from internalmarks");
				
						while(rs5.next())
						{
										
							if(s1.equals(rs5.getString(1)))
							{
								k1.l14.setText(rs5.getString(3));
								k1.l17.setText(rs5.getString(4));
								k1.l20.setText(rs5.getString(5));
								k1.l23.setText(rs5.getString(6));
								k1.l26.setText(rs5.getString(7));
								k1.l29.setText(rs5.getString(8));
								k1.l32.setText(rs5.getString(9));								
								k1.l34.setText(rs5.getString(10));
								break;
											
							}

						}
                                             			int cp=0;
						if(Integer.parseInt(k1.l13.getText())<30 || Integer.parseInt(k1.l14.getText())<30) 
						{
						cp++;
						}
						if(Integer.parseInt(k1.l16.getText())<30|| Integer.parseInt(k1.l17.getText())<30) 
						{
						cp++;
						}
						if(Integer.parseInt(k1.l19.getText())<30|| Integer.parseInt(k1.l20.getText())<30) 
						{
						cp++;
						}
						if(Integer.parseInt(k1.l22.getText())<30|| Integer.parseInt(k1.l23.getText())<30)
						{
						cp++;
						}
						if(Integer.parseInt(k1.l25.getText())<30|| Integer.parseInt(k1.l26.getText())<30) 
						{
						cp++;
						}
						if(Integer.parseInt(k1.l28.getText())<30|| Integer.parseInt(k1.l29.getText())<30) 
						{
						cp++;
						}
						if(Integer.parseInt(k1.l31.getText())<30|| Integer.parseInt(k1.l32.getText())<30) 
						{
						cp++;
						}
						k1.l40.setText(String.valueOf(cp));
						int a=Integer.parseInt(k1.l13.getText())+Integer.parseInt(k1.l16.getText())+Integer.parseInt(k1.l19.getText())+Integer.parseInt(k1.l22.getText())+Integer.parseInt(k1.l25.getText())+Integer.parseInt(k1.l28.getText())+Integer.parseInt(k1.l31.getText())+Integer.parseInt(k1.l14.getText())+Integer.parseInt(k1.l17.getText())+Integer.parseInt(k1.l20.getText())+Integer.parseInt(k1.l23.getText())+Integer.parseInt(k1.l26.getText())+Integer.parseInt(k1.l29.getText())+Integer.parseInt(k1.l32.getText())+Integer.parseInt(k1.l34.getText());
						k1.l35.setText(String.valueOf(a));
						int b=a/10;
						if(cp>=5|| b<50)
						k1.l38.setText("Fail");
						else
						k1.l38.setText("Pass");
						break;
						
					}
					
				}
				if(temp==1)
				{
					t1.setText(null);
					k1.setVisible(true);
					k1.setSize(a,b);
					this.setVisible(false);
				}	
				if(temp==0)
				{
					JOptionPane.showMessageDialog(this,"This Rollno is not a Valid OR is Not a "+jcb2.getSelectedItem()+"Semester");
					t1.setText(null);
				}
				con.close();
			
			
			}
			catch(Exception e1){}
			
		}
		if(e.getSource()==b2)
		{
             			JInfo jk=new JInfo(ss);
			jk.setSize(a,b);
			jk.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==bh)
		{
			JEnter e1=new JEnter("STUDENT INFORMATION MANAGEMENT SYSTEM");
			e1.setSize(a,b);
			e1.setVisible(true);
			this.setVisible(false);
		}
	}
	

}