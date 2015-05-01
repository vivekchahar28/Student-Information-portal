import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class BasicInfo extends JFrame implements ActionListener
{
	Connection con;
	ResultSet rs1,rs2;
	Statement stmt1,sm2;
	int s=1,flag=0,temp,a,b;
	JFrame f1;
	String s2;
	PreparedStatement pstmt1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11, l12,ls;
	JTextField tb1,tb2,tb3,tb4,tb5,tb6,tb7,tb9,tb10,tb11,ts,tb12,tb13,tb14,tb15;
	JComboBox jcb1,jcb2,jcb3,jcb4,jcb5;
	JCheckBox jchb1,jchb2,jchb3,jchb4;
	JButton b1,b2,b3,b4,b5,ba,bh;
	JTextArea ta1,ta2;
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
	public BasicInfo(String s1)
	{
		super(s1);
		s2=s1;
		JPanel jp=(JPanel)getContentPane();
		jp.setLayout(null);
		ls=new JLabel("Student Personal Details");
		ls.setBounds(420,20,800,50);
		ls.setFont(new Font("Times New Roman",Font.BOLD,40));
		ls.setForeground(Color.gray);
		jp.add(ls);
		Color c= new Color(100,250,100);
		jp.setBackground(c);
		l1=new JLabel("Rollno");
		l1.setBounds(110,110,150,25);
		jp.add(l1);
		tb1=new JTextField(25);
		tb1.setBounds(250,110,150,25);
		jp.add(tb1);
		l2=new JLabel("Student Name");
		l2.setBounds(110,140,150,25);
		jp.add(l2);
		tb2=new JTextField(25);
		tb2.setBounds(250,140,150,25);
		jp.add(tb2);
		tb2.addActionListener(this);
		l3=new JLabel("Date Of Birth");
		l3.setBounds(110,170,150,25);
		jp.add(l3);
		tb3=new JTextField(10);
		tb3.setBounds(250,170,150,25);
		jp.add(tb3);
		tb3.addActionListener(this);
		l4=new JLabel("Father Name");
		l4.setBounds(110,200,150,25);
		jp.add(l4);
		tb4=new JTextField(25);
		tb4.setBounds(250,200,150,25);
		jp.add(tb4);
		tb4.addActionListener(this);

		l5=new JLabel("Mother Name");
		l5.setBounds(110,230,150,25);
		jp.add(l5);
		tb5=new JTextField(25);
		tb5.setBounds(250,230,150,25);
		jp.add(tb5);
		tb5.addActionListener(this);
	
		JLabel occus=new JLabel("Father Occupation");
		occus.setBounds(110,260,150,25);
		jcb1=new JComboBox();
		jcb1.setBounds(250,260,150,25);
		jcb1.addItem("Govt.Employee");
		jcb1.addItem("Bussiness");
		jcb1.addItem("Pvt.Service");
		jcb1.addItem("Agriculture");
		jcb1.addItem("Accountant");
		jcb1.addItem("Other");
		jp.add(occus);
		jp.add(jcb1);
		l6=new JLabel("Other");
		l6.setBounds(400,260,150,25);
		jp.add(l6);
		tb6=new JTextField("None");
		tb6.setBounds(450,260,150,25);
		jp.add(tb6);
		tb6.addActionListener(this);

		JLabel occusm=new JLabel("Mother Occupation");
		occusm.setBounds(110,290,150,25);
		jcb2=new JComboBox();
		jcb2.setBounds(250,290,150,25);
		jcb2.addItem("Govt.Employee");
		jcb2.addItem("Bussiness");
		jcb2.addItem("Pvt.Service");
		jcb2.addItem("Agriculture");
		jcb2.addItem("Accoutant");
		jcb2.addItem("Housewife");
		jcb2.addItem("Other");
		jp.add(occusm);
		jp.add(jcb2);
		l7=new JLabel("Other");
		l7.setBounds(400,290,150,25);
		jp.add(l7);
		tb7=new JTextField("None");
		tb7.setBounds(450,290,150,25);
		jp.add(tb7);
		tb7.addActionListener(this);

		l8=new JLabel("Present Address");
		l8.setBounds(110,320,150,25);
		jp.add(l8);
		ta1=new JTextArea(" ",25,25);
		ta1.setBounds(250,320,350,50);
		jp.add(ta1);		
		l9=new JLabel("Parmanent Address");
		l9.setBounds(110,380,150,25);
		jp.add(l9);	
		ta2=new JTextArea(" ",25,25);
		ta2.setBounds(250,380,350,50);
		jp.add(ta2);
		l10=new JLabel("Telephone No.");
		l10.setBounds(110,440,150,25);
		jp.add(l10);
		tb10=new JTextField(25);
		tb10.setBounds(250,440,150,25);
		jp.add(tb10);
		tb10.addActionListener(this);
		l11=new JLabel("Mobile No.");
		l11.setBounds(110,470,150,25);
		jp.add(l11);
		tb11=new JTextField(25);
		tb11.setBounds(250,470,150,25);
		jp.add(tb11);
		tb11.addActionListener(this);
		JLabel gends=new JLabel("Gender");
		gends.setBounds(100,500,150,25);
		jp.add(gends);
		jcb5=new JComboBox();
		jcb5.setBounds(250,500,150,25);
		jcb5.addItem("Male");
		jcb5.addItem("Female");
		jp.add(jcb5);
		JLabel cous=new JLabel("Class");
		cous.setBounds(110,530,150,25);
		jp.add(cous);
		jcb3=new JComboBox();
		jcb3.setBounds(250,530,150,25);
		jcb3.addItem("BBA");
		jcb3.addItem("BCA");
		jcb3.addItem("MBA");
		jcb3.addItem("MCA");
		jcb3.addItem("B.Tech");
		jp.add(jcb3);
		l12=new JLabel("Email-ID");
		l12.setBounds(110,560,150,25);
		jp.add(l12);
		tb12=new JTextField(50);
		tb12.setBounds(250,560,350,25);
		jp.add(tb12);
		tb12.addActionListener(this);
		JLabel lm=new JLabel("Marksheet Given");
		lm.setBounds(110,590,150,25);
		jp.add(lm);
		tb13=new JTextField(10);
		tb13.setBounds(250,590,50,25);
		tb13.setText("Yes/No");
		tb13.setEditable(true);
		jp.add(tb13);
		JLabel lm1=new JLabel("Sport Certi. Given");
		lm1.setBounds(110,620,150,25);
		jp.add(lm1);
		tb14=new JTextField(10);
		tb14.setBounds(250,620,50,25);
		tb14.setText("Yes/No");
		tb14.setEditable(true);
		jp.add(tb14);
		JLabel lm2=new JLabel("Character Certi. Given");
		lm2.setBounds(110,650,150,25);
		jp.add(lm2);
		tb15=new JTextField(10);
		tb15.setBounds(250,650,50,25);
		tb15.setText("Yes/No");
		tb15.setEditable(true);
		jp.add(tb15);
		b1 = new JButton("ADD", new ImageIcon(ClassLoader.getSystemResource("Images/editusr.png")));
		//b1=new JButton("ADD");
		b1.setBounds(850,200,110,35);
		jp.add(b1);
		b1.addActionListener(this);
		b2 = new JButton("DELETE", new ImageIcon(ClassLoader.getSystemResource("Images/delusr.png")));
		//b2=new JButton("DELETE");
		b2.setBounds(850,270,110,35);
		jp.add(b2);
		b2.addActionListener(this);
		b3 = new JButton("UPDATE", new ImageIcon(ClassLoader.getSystemResource("Images/update.png")));
		//b3=new JButton("UPDATE");
		b3.setBounds(850,340,110,35);
		jp.add(b3);
		b3.addActionListener(this);
		b4 = new JButton("CLEAR", new ImageIcon(ClassLoader.getSystemResource("Images/clear.png")));
		//b4=new JButton("CLEAR");
		b4.setBounds(850,410,110,35);
		jp.add(b4);
		b4.addActionListener(this);
		b5 = new JButton("VIEW", new ImageIcon(ClassLoader.getSystemResource("Images/view.png")));
		//b5=new JButton("VIEW");
		b5.setBounds(850,140,110,35);
		jp.add(b5);
		b5.addActionListener(this);
		ba = new JButton("BACK", new ImageIcon(ClassLoader.getSystemResource("Images/back.png")));
		//ba=new JButton("BACK");
		ba.setBounds(850,620,100,35);
		jp.add(ba);
		ba.addActionListener(this);
		bh = new JButton("HOME", new ImageIcon(ClassLoader.getSystemResource("Images/home.png")));
		//bh=new JButton("HOME");
		bh.setBounds(850,670,100,35);
		bh.addActionListener(this);
		jp.add(bh);
		
		if(s2.equals("Student"))
		{	
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			b4.setEnabled(false);
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		screen();
		String w3=ae.getActionCommand();
		if(ae.getSource()==b1)
		{ 
			try
			{
				
				if(tb1.getText().equals("") || tb2.getText().equals("")|| tb3.getText().equals("") || tb4.getText().equals("") || tb5.getText().equals("") || tb6.getText().equals("") || tb7.getText().equals("") || tb10.getText().equals("") ||tb11.getText().equals("")  || tb12.getText().equals("")  || tb13.getText().equals("") || tb14.getText().equals("") || tb15.getText().equals("") || ta1.getText().equals("") || ta2.getText().equals(""))
					{
						JOptionPane.showMessageDialog(f1,"FILL  THE ALL ENTRIES");
					} 
				else
				{
				connect();
				temp=0;
				sm2=con.createStatement();
				rs1=sm2.executeQuery("Select *from studentpersonal");
				while(rs1.next())
				{
					if(tb1.getText().equals(rs1.getString(1)))
					{
						temp=1;
						break;
					}
				}
				if(temp==1)
				{
					JOptionPane.showMessageDialog(f1,"Rollno is exist");
					tb1.setText(null);
				}
				if(temp==0)
				{
					
					String s1=tb1.getText();
					String s2=tb2.getText();
					String s3=tb3.getText();
					String s4=tb4.getText();
					String s5=tb5.getText();
					String s6=tb6.getText();
					String s7=tb7.getText();
					String s8=ta1.getText();
					String s9=ta2.getText();
					String s10=tb10.getText();
					String s11=tb11.getText();
					String s12=tb12.getText();
					String s13=(String)jcb1.getSelectedItem();
					String s14=(String)jcb5.getSelectedItem();
					String s15=(String)jcb2.getSelectedItem();
					String s16=(String)jcb3.getSelectedItem();
					String s17=tb13.getText();
					String s18=tb14.getText();
					String s19=tb15.getText();
					//connect();
					PreparedStatement stmt1=con.prepareStatement("insert into studentpersonal values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					stmt1.setString(1,s1);
					stmt1.setString(2,s2);
					stmt1.setString(3,s3);
					stmt1.setString(4,s4);
					stmt1.setString(5,s5);
					stmt1.setString(6,s6);		
					stmt1.setString(7,s7);
					stmt1.setString(8,s8);
					stmt1.setString(9,s9);
					stmt1.setString(10,s10);
					stmt1.setString(11,s11);
					stmt1.setString(12,s12);
					stmt1.setString(13,s13);
					stmt1.setString(14,s14);
					stmt1.setString(15,s15);
					stmt1.setString(16,s16);
					stmt1.setString(17,s17);
					stmt1.setString(18,s18);
					stmt1.setString(19,s19);
					int a=stmt1.executeUpdate();
					if(a!=0)
					JOptionPane.showMessageDialog(f1,"Insert new record successfully");
					tb1.setText(null);
				tb2.setText(null);
				tb3.setText(null);
				tb4.setText(null);
				tb5.setText(null);
				tb6.setText(null);
				tb7.setText(null);
				ta1.setText(null);
				ta2.setText(null);
				tb10.setText(null);
				tb11.setText(null);
				tb12.setText(null);
				tb13.setText(null);
				tb14.setText(null);
				tb15.setText(null);
					con.close();
					}
				}
			}
			catch(Exception e)
			{
			System.out.println(e);
			}
		}
		else if(ae.getSource()==b2)
		{
			String s1=tb1.getText();
			System.out.println(s1);
			try
			{
				connect();
				String sql="delete from studentpersonal where rollno='"+s1+"'";
				PreparedStatement pstmt=con.prepareStatement(sql);
				int n=pstmt.executeUpdate();
				tb1.setText(null);
				tb2.setText(null);
				tb3.setText(null);
				tb4.setText(null);
				tb5.setText(null);
				tb6.setText(null);
				tb7.setText(null);
				ta1.setText(null);
				ta2.setText(null);
				tb10.setText(null);
				tb11.setText(null);
				tb12.setText(null);
				tb13.setText(null);
				tb14.setText(null);
				tb15.setText(null);
				if(n==1)
				{
					JOptionPane.showMessageDialog(f1,"One Record Successfully Deleted ");}
					con.commit();
					con.close();
					pstmt.close();
				}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==b3)
		{
			String s1=tb1.getText();
			String s2=tb2.getText();
			String s3=tb3.getText();
			String s4=tb4.getText();
			String s5=tb5.getText();
			String s6=tb6.getText();
			String s7=tb7.getText();
			String s8=ta1.getText();
			String s9=ta2.getText();
			String s10=tb10.getText();
			String s11=tb11.getText();
			String s12=tb12.getText();
			String s13=(String)jcb1.getSelectedItem();
			String s14=(String)jcb5.getSelectedItem();
			String s15=(String)jcb2.getSelectedItem();
			String s16=(String)jcb3.getSelectedItem();
			String s17=tb13.getText();
			String s18=tb14.getText();
			String s19=tb15.getText();
			try
			{
				connect();
				String sql="update studentpersonal set Rollno=?,Stuname=?,Birthdate=?,Fathername=?,Mothername=?,Otherf=?,Otherm=?,Preaddress=?,Paraddress=?,Teleno=?,Mobino=?,Emailid=?,Foccu=?,Gender=?,Moccu=?,Class=?,Marksheet=?,Scc=?,Cc=? where Rollno='"+s1+"'";
				PreparedStatement pstmt1=con.prepareStatement(sql);
				pstmt1.setString(1,s1);
				pstmt1.setString(2,s2);
				pstmt1.setString(3,s3);
				pstmt1.setString(4,s4);
				pstmt1.setString(5,s5);
				pstmt1.setString(6,s6);
				pstmt1.setString(7,s7);
				pstmt1.setString(8,s8);
				pstmt1.setString(9,s9);
				pstmt1.setString(10,s10);
				pstmt1.setString(11,s11);
				pstmt1.setString(12,s12);
				pstmt1.setString(13,s13);
				pstmt1.setString(14,s14);
				pstmt1.setString(15,s15);
				pstmt1.setString(16,s16);
				pstmt1.setString(17,s17);
				pstmt1.setString(18,s18);
				pstmt1.setString(19,s19);
				int n=pstmt1.executeUpdate();
				JOptionPane.showMessageDialog(f1,"Update record successfully");
				tb1.setText(null);
				tb2.setText(null);
				tb3.setText(null);
				tb4.setText(null);
				tb5.setText(null);
				tb6.setText(null);
				tb7.setText(null);
				ta1.setText(null);
				ta2.setText(null);
				tb10.setText(null);
				tb11.setText(null);
				tb12.setText(null);
				tb13.setText(null);
				tb14.setText(null);
				tb15.setText(null);
				con.close();
				pstmt1.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(w3.equals("VIEW"))
		{
			try
			{
				String s20=tb1.getText();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("jdbc:odbc:SIMS");
				Statement stmt1=con.createStatement();
				ResultSet rs1=stmt1.executeQuery("select *from studentpersonal");
				while(rs1.next())
				{
					if(s20.equals(rs1.getString(1)))
					{
						flag=1;
						tb2.setText(rs1.getString(2));
						tb3.setText(rs1.getString(3));
						tb4.setText(rs1.getString(4));
						tb5.setText(rs1.getString(5));
						tb6.setText(rs1.getString(6));
						tb7.setText(rs1.getString(7));
						ta1.setText(rs1.getString(8));
						ta2.setText(rs1.getString(9));
						tb10.setText(rs1.getString(10));
						tb11.setText(rs1.getString(11));
						tb12.setText(rs1.getString(12));
						jcb5.setSelectedItem(rs1.getString(14));
						jcb2.setSelectedItem(rs1.getString(15));
						jcb3.setSelectedItem(rs1.getString(16));
						tb13.setText(rs1.getString(17));
						tb14.setText(rs1.getString(18));	
						tb15.setText(rs1.getString(19));
						break;
					}
					flag=0;
				}
				if(flag==0)
				JOptionPane.showMessageDialog(this,"Plz enter the valid rollno");
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==b4)
		{
			tb1.setText(null);
			tb2.setText(null);
			tb3.setText(null);
			tb4.setText(null);
			tb5.setText(null);
			tb6.setText(null);
			tb7.setText(null);
			ta1.setText(null);
			ta2.setText(null);
			tb10.setText(null);
			tb11.setText(null);
			//jcb1.setSelectedItem(" ");
			//jcb5.setSelectedItem(" ");
			//jcb2.setSelectedItem(" ");
			//jcb3.setSelectedItem(" ");
			tb12.setText(null);
			tb13.setText(null);
			tb14.setText(null);
			tb15.setText(null);
			//ts.setText(null);
		}
		else if(ae.getSource()==bh)
		{
			JEnter e=new JEnter("STUDENT INFORMATION MANAGEMENT SYSTEM");
			e.setSize(a,b);
			e.setVisible(true);
			this.setVisible(false);
		}
		else
		{
			JInfo jk=new JInfo(s2);
			jk.setSize(a,b);
			jk.setVisible(true);
			this.setVisible(false);
		}
	}
}