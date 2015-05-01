import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Academic extends JFrame implements ActionListener
{
	String s1;
	Connection con;
	ResultSet rs1;
	Statement stmt1,sm2;
	int s=1,flag=0,temp,a,b;
	JFrame f1;
	PreparedStatement pstmt1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,ls;
	JTextField tb1,tb2,tb3,tb4,tb5,tb6,tb7,tb8;
	JButton b1,b2,b3,b4,b5,ba,bh;
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

	public Academic(String s)
	{
		super(s);
		s1=s;
		JPanel jp=(JPanel)getContentPane();
		jp.setLayout(null);
		ls=new JLabel("Student Academic Details");
		ls.setBounds(450,30,800,50);
		ls.setFont(new Font("Times New Roman",Font.BOLD,40));
		ls.setForeground(Color.gray);
		jp.add(ls);
		l1=new JLabel("AdminNo");
		l1.setBounds(330,150,150,25);
		jp.add(l1);
		tb1=new JTextField(25);
		tb1.setBounds(500,150,150,25);
		jp.add(tb1);
		tb1.addActionListener(this);
		l2=new JLabel("University Rollno");
		l2.setBounds(330,200,150,25);
		jp.add(l2);
		tb2=new JTextField(25);
		tb2.setBounds(500,200,150,25);
		jp.add(tb2);
		tb2.addActionListener(this);
		l3=new JLabel("Enroll.no");
		l3.setBounds(330,250,150,25);
		jp.add(l3);
		tb3=new JTextField(10);
		tb3.setBounds(500,250,150,25);
		jp.add(tb3);
		tb3.addActionListener(this);
		l4=new JLabel("Name");
		l4.setBounds(330,300,150,25);
		jp.add(l4);
		tb4=new JTextField(25);
		tb4.setBounds(500,300,150,25);
		jp.add(tb4);
		tb4.addActionListener(this);
		l5=new JLabel("Course");
		l5.setBounds(330,350,150,25);
		jp.add(l5);
		tb5=new JTextField(25);
		tb5.setBounds(500,350,150,25);
		jp.add(tb5);
		tb5.addActionListener(this);
		l6=new JLabel("Branch");
		l6.setBounds(330,400,150,25);
		jp.add(l6);
		tb6=new JTextField();
		tb6.setBounds(500,400,150,25);
		jp.add(tb6);
		tb6.addActionListener(this);
		l7=new JLabel("Year");
		l7.setBounds(330,450,50,25);
		jp.add(l7);
		tb7=new JTextField();
		tb7.setBounds(500,450,50,25);
		jp.add(tb7);
		tb7.addActionListener(this);
		l8=new JLabel("Semester");
		l8.setBounds(330,500,150,25);
		jp.add(l8);
		tb8=new JTextField();
		tb8.setBounds(500,500,50,25);
		jp.add(tb8);
		tb8.addActionListener(this);
		b1 = new JButton("ADD", new ImageIcon(ClassLoader.getSystemResource("Images/save.png")));
		//b1=new JButton("ADD");
		b1.setBounds(830,250,110,35);
		jp.add(b1);
		b1.addActionListener(this);
		b2 = new JButton("DELETE", new ImageIcon(ClassLoader.getSystemResource("Images/cancel.png")));
		//b2=new JButton("DELETE");
		b2.setBounds(830,300,110,35);
		jp.add(b2);
		b2.addActionListener(this);
		b3 = new JButton("UPDATE", new ImageIcon(ClassLoader.getSystemResource("Images/update.png")));
		//b3=new JButton("UPDATE");
		b3.setBounds(830,350,110,35);
		jp.add(b3);
		b3.addActionListener(this);
		b4 = new JButton("CLEAR", new ImageIcon(ClassLoader.getSystemResource("Images/clear.png")));
		//b4=new JButton("CLEAR");
		b4.setBounds(830,400,110,35);
		jp.add(b4);
		b4.addActionListener(this);
		b5 = new JButton("VIEW", new ImageIcon(ClassLoader.getSystemResource("Images/view.png")));
		//b5=new JButton("VIEW");
		b5.setBounds(830,200,110,35);
		jp.add(b5);
		b5.addActionListener(this);
		ba = new JButton("BACK", new ImageIcon(ClassLoader.getSystemResource("Images/back.png")));
		//ba=new JButton("Back");
		ba.setBounds(830,600,100,35);
		jp.add(ba);
		ba.addActionListener(this);
		bh = new JButton("HOME", new ImageIcon(ClassLoader.getSystemResource("Images/home.png")));
		//bh=new JButton("HOME");
		bh.setBounds(830,640,100,35);
		bh.addActionListener(this);
		jp.add(bh);
		Color c= new Color(100,250,100);
		jp.setBackground(c);
		if(s1.equals("Student"))
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
		if(ae.getSource()==b1)
		{
			try
			{

				if(tb1.getText().equals("") || tb2.getText().equals("")|| tb3.getText().equals("") || tb4.getText().equals("") || tb5.getText().equals("") || tb6.getText().equals("") || tb7.getText().equals("") || tb8.getText().equals(""))
				{
						JOptionPane.showMessageDialog(f1,"FILL  THE ALL ENTRIES");
				}
				else
				{
				connect();
				temp=0;
				sm2=con.createStatement();
				rs1=sm2.executeQuery("Select *from Academicdetail");
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
					JOptionPane.showMessageDialog(f1,"Admission number is exist");
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
					String s8=tb8.getText();
				PreparedStatement stmt1=con.prepareStatement("insert into academicdetail values(?,?,?,?,?,?,?,?)");
				stmt1.setString(1,s1);
				stmt1.setString(2,s2);
				stmt1.setString(3,s3);
				stmt1.setString(4,s4);
				stmt1.setString(5,s5);
				stmt1.setString(6,s6);
				stmt1.setString(7,s7);
				stmt1.setString(8,s8);
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
				tb8.setText(null);
				con.close();
				}
				}
			}
			catch(Exception e)
			{
				System.out.println(e+" Plz fill the all fields");
			}
		}

		if(ae.getSource()==b5)
		{
			try
			{
				String s20=tb1.getText();
				connect();
				Statement stmt1=con.createStatement();
				ResultSet rs1=stmt1.executeQuery("select *from academicdetail");
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
						tb8.setText(rs1.getString(8));
						break;
						}
						flag=0;
					}
				if(flag==0)
				JOptionPane.showMessageDialog(this,"Plz enter the valid admission no");
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource()==b2)
		{
			String s1=tb1.getText();
			System.out.println(s1);
			try
			{
				connect();
				String sql="delete from Academicdetail where admissionno='"+s1+"'";
				PreparedStatement pstmt=con.prepareStatement(sql);
				int n=pstmt.executeUpdate();
				tb1.setText(null);
				tb2.setText(null);
				tb3.setText(null);
				tb4.setText(null);
				tb5.setText(null);
				tb6.setText(null);
				tb7.setText(null);
				tb8.setText(null);
				if(n!=0)
				{
					JOptionPane.showMessageDialog(f1,"record successfully deleted ");
				}
				con.commit();
				con.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource()==b3)
		{
			try
			{
				String s1=tb1.getText();
				String s2=tb2.getText();
				String s3=tb3.getText();
				String s4=tb4.getText();
				String s5=tb5.getText();
				String s6=tb6.getText();
				String s7=tb7.getText();
				String s8=tb8.getText();
				connect();
				String sql="update Academicdetail set admissionno=?,university_roll_no=?,enrollment_no=?,student_name=?,course=?,branch=?,year=?,semester=? where admissionno='"+s1+"'";
				PreparedStatement pstmt1=con.prepareStatement(sql);
				pstmt1.setString(1,s1);
				pstmt1.setString(2,s2);
				pstmt1.setString(3,s3);
				pstmt1.setString(4,s4);
				pstmt1.setString(5,s5);
				pstmt1.setString(6,s6);
				pstmt1.setString(7,s7);
				pstmt1.setString(8,s8);
				int n=pstmt1.executeUpdate();
				JOptionPane.showMessageDialog(f1,"Update record successfully");
				tb1.setText(null);
				tb2.setText(null);
				tb3.setText(null);
				tb4.setText(null);
				tb5.setText(null);
				tb6.setText(null);
				tb7.setText(null);
				tb8.setText(null);
				con.close();
				pstmt1.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	 	if(ae.getSource()==b4)
		{
			tb1.setText(null);
			tb2.setText(null);
			tb3.setText(null);
			tb4.setText(null);
			tb5.setText(null);
			tb6.setText(null);
			tb7.setText(null);
			tb8.setText(null);
		}
		if(ae.getSource()==ba)
		{
			JInfo jk=new JInfo(s1);
			jk.setSize(a,b);
			jk.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()==bh)
		{
			JEnter e=new JEnter("STUDENT INFORMATION MANAGEMENT SYSTEM");
			e.setSize(a,b);
			e.setVisible(true);
			this.setVisible(false);
		}
	}

	public static void main(String argu[])
	{
		Academic ai=new Academic("SIMS");
		ai.setSize(1100,1100);
		ai.setVisible(true);
	}
}
