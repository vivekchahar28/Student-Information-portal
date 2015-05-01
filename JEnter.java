import java.awt.*;        
import java.awt.event.*;
import javax.swing.*;
import java.sql.*; 
public class JEnter extends JFrame implements ActionListener,KeyListener
{
	String str;
	int a,a1,b;
	JButton b1,b2;
	JLabel l,l1,l2;
	JComboBox jb ;
	JTextField t1;
	JPasswordField pf;
	JEnter(String s)
	{
		super(s);
		JPanel jp=(JPanel)getContentPane();
		jp.setLayout(null);
		Color c= new Color(100,250,100);
		jp.setBackground(c);
		JLabel wel2=new JLabel("Student Information Management System");
		wel2.setFont(new Font("Times New Roman",Font.BOLD,40));
		wel2.setBounds(300,100,900,50);
		wel2.setForeground(Color.gray);
		jp.add(wel2);
		l=new JLabel("Select the User ");
		l.setBounds(480,250,200,30);
		l.setFont(new Font("Times New Roman",Font.BOLD,20));
		jp.add(l); 
		jb = new JComboBox();
		jb.addItem("Administrator");
		jb.addItem("Student");
		jb.setBounds(680, 250, 150, 30);
		jp.add(jb);
		l1=new JLabel("Enter User Name ");
		l1.setBounds(480,300,250,30);
		l1.setFont(new Font("Times New Roman",Font.BOLD,20));
		jp.add(l1);
		t1=new JTextField(20);
		t1.setBounds(680,300,150,30);
		t1.setFont(new Font("Times New Roman",Font.BOLD,14));
		jp.add(t1);
		l2=new JLabel("Enter Password");
		l2.setBounds(480,350,150,30);
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		jp.add(l2);
		pf=new JPasswordField(10);
		pf.setBounds(680,350,150,30);
		pf.setFont(new Font("Times New Roman",Font.BOLD,20));
		jp.add(pf);
		b1 = new JButton("LOGIN", new ImageIcon(ClassLoader.getSystemResource("Images/login.png")));
		//b1=new JButton("ENTER");
		b1.setBounds(570,450,150,40);
		jp.add(b1);
		b1.addActionListener(this);
		b1.addKeyListener(this);
		//b2=new JButton("EXIT");
		b2 = new JButton("EXIT", new ImageIcon(ClassLoader.getSystemResource("Images/cancel.png")));
		b2.setBounds(730,450,150,40);
		jp.add(b2);
		b2.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
public void screen()
{
Toolkit t=Toolkit.getDefaultToolkit();
Dimension d=t.getScreenSize();
a1=d.width;
b=d.height;
}
	public void actionPerformed(ActionEvent ae)
	{
		String login;
		String password;
		login=t1.getText();
		password=pf.getText();
		if (ae.getSource()==b1)
		{
			if(login.equals("admin") && password.equals("admin") && jb.getSelectedItem().equals("Administrator"))
			{
				JOptionPane.showMessageDialog(this,"You are authorised user","Authenticated Login",JOptionPane.INFORMATION_MESSAGE);
				a=0;
				JInfo j=new JInfo("Admin");
				j.show();
				screen();
				j.setSize(a1,b);
				j.setVisible(true);
				this.setVisible(false);
			}
			else if(login.equals("student") && jb.getSelectedItem().equals("Student"))
			{
			  	try
				{
 
				             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	      				Connection c=DriverManager.getConnection("Jdbc:Odbc:SIMS");
	      				Statement s=c.createStatement();
	      				ResultSet rs=s.executeQuery("Select * from Academicdetail");
	      				String pass=pf.getText();
       	      				int flag=0;
	      				while(rs.next())
	     	      			{ 
	         					if(pass.equals(rs.getString(1)))
                					{ 
 							flag=1;
    							JOptionPane.showMessageDialog(this,"You are authorised user");
							JInfo j=new JInfo("Student");
							j.show();
							screen();
							j.setSize(a1,b);
							j.setVisible(true);
							this.setVisible(false);
                					} 
              				}
              				if(flag==0)
					{
						JOptionPane.showMessageDialog(this,"Incorrect Username and Passward");
						t1.setText(""); 
                 					pf.setText("");
					}
                   				s.close();
	      				c.close();
	   			}  
	    			catch(Exception ed)
            				{  
             					System.out.println("An Exception Occured"+ed); 
            				} 
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Illegal UserId or Password","Illegal User",JOptionPane.ERROR_MESSAGE);
				t1.setText("");
				pf.setText("");
			}
		}
		if(ae.getSource()==b2)
		{
			System.exit(0);
		}
		
	}
	public void keyPressed(KeyEvent ke)
	{
		int a=ke.getKeyCode();
		int b=KeyEvent.VK_ENTER;
		if(a==b)
		{
			String login;
			String password;
			login=t1.getText();
			password=pf.getText();
			if(login.equals("admin") && password.equals("admin") && jb.getSelectedItem().equals("Administrator"))
			{
				JOptionPane.showMessageDialog(this,"You are authorised user","Authenticated Login",JOptionPane.INFORMATION_MESSAGE);
				a=0;
				JInfo j=new JInfo("Admin");
				j.show();
				screen();
				j.setSize(a1,b);
				j.setVisible(true);
				this.setVisible(false);
			}
			else if(login.equals("student") && jb.getSelectedItem().equals("Student"))
			{
  				try
				{
 
             					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		      			Connection c=DriverManager.getConnection("Jdbc:Odbc:SIMS");
		      			Statement s=c.createStatement();
		      			ResultSet rs=s.executeQuery("Select * from Academicdetail");
		      			String pass=pf.getText();
       		      			int flag=0;
	      				while(rs.next())
	     	      			{ 
	         					if(pass.equals(rs.getString(1)))
                					{ 
 							flag=1;
	    						JOptionPane.showMessageDialog(this,"You are authorised user");
							JInfo j=new JInfo("Student");
							j.show();
							screen();
							j.setSize(a1,b);
							j.setVisible(true);
							this.setVisible(false);
                					} 
              				}
	              			if(flag==0)
					{
						JOptionPane.showMessageDialog(this,"Incorrect Username and Passward");
	                 				t1.setText(""); 
                 					pf.setText("");
					}
	              			s.close();
		      			c.close();
		   		}  
		    		catch(Exception ed)
	            			{  
	             				System.out.println("An Exception Occured"+ed); 
	            			} 
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Illegal UserId or Password","Illegal User",JOptionPane.ERROR_MESSAGE);
				t1.setText("");
				pf.setText("");
			}
		}
	}

	public void keyReleased(KeyEvent e)
 	{
 	}
	public void keyTyped(KeyEvent e)
 	{
	}
}