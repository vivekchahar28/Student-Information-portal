import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class MarkInsert extends JFrame implements ActionListener
{
	JLabel ll1,ll2,ll3,ll4,l1,l2,l3,l4,l5,l6,l7,l8,ls,le,li;
	JButton b1,b2,bh;
	JTextField tt1,tt2,t1,t2,t3,t4,t5,t6,t7;
	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;
	JComboBox jcb1;
	String s1;
	Connection con;
	ResultSet rs1,rs2;
	Statement sm2,sm1;
	int temp,temp1;
	JFrame f1;
	int a,b;
	MarkInsert(String s)
	{
		super(s);
		s1=s;
		JPanel jp=(JPanel)getContentPane();
		jp.setLayout(null);
		ll1 = new JLabel("STUDENT INFORMATION MANAGEMENT SYSTEM");
		ll1.setFont(new Font("Times New Roman",Font.BOLD,30));
		ll1.setForeground(Color.gray);
		Color c= new Color(100,250,100);
		jp.setBackground(c);
		ll2 = new JLabel("Rollno");
		ll3 =new JLabel("Sem");
		ll4=new JLabel("Class");
		ls=new JLabel("Subjects");
		le=new JLabel("Exernal Marks");
		li=new JLabel("Internal Marks");
		l1 = new JLabel("Sub1");
		l2 = new JLabel("Sub2");
		l3 = new JLabel("Sub3");
		l4 = new JLabel("Sub4");
		l5 = new JLabel("Sub5");
		l6 = new JLabel("Practical1");
		l7 = new JLabel("Practical2");
		l8 = new JLabel("GP");
		tt1 = new JTextField();
		tt2 = new JTextField();
		t1 = new JTextField(); tf1=new JTextField();
		t2 = new JTextField();tf2=new JTextField();
		t3 = new JTextField();tf3=new JTextField();
		t4 = new JTextField();tf4=new JTextField();
		t5 = new JTextField();tf5=new JTextField();
		t6 = new JTextField();tf6=new JTextField();
		t7 = new JTextField();tf7=new JTextField();
		tf8= new JTextField();
		jcb1=new JComboBox();
		jcb1.setBounds(670,100,75,30);
		jcb1.addItem("MBA");
		jcb1.addItem("MCA");
		//jcb1.addItemListener(this);
		b1 = new JButton("SAVE", new ImageIcon(ClassLoader.getSystemResource("Images/save.png")));
		b1.addActionListener(this);
		b1.setBounds(800,500,100,30);
		b2 = new JButton("BACK", new ImageIcon(ClassLoader.getSystemResource("Images/back.png")));
		//b2 = new JButton("BACK");
		b2.addActionListener(this);
		b2.setBounds(800,550,100,30);
		bh = new JButton("HOME", new ImageIcon(ClassLoader.getSystemResource("Images/home.png")));
		//bh=new JButton("HOME");
		bh.setBounds(800,600,100,30);
		bh.addActionListener(this);
		jp.add(bh);
		ll1.setBounds(280,30,800,40);
		ll2.setBounds(400,100,50,30);
		tt1.setBounds(450,100,100,30);
		ll4.setBounds(600,100,75,30);
		ll3.setBounds(780,100,75,30);
		tt2.setBounds(850,100,75,30);
		ls.setBounds(400,150,100,30);
		le.setBounds(480,150,100,30);	
		li.setBounds(620,150,100,30);
		l1.setBounds(400,200,100,30);
		t1.setBounds(480,200,100,30);tf1.setBounds(620,200,100,30);
		l2.setBounds(400,250,100,30);t2.setBounds(480,250,100,30);tf2.setBounds(620,250,100,30);
		l3.setBounds(400,300,100,30);t3.setBounds(480,300,100,30);tf3.setBounds(620,300,100,30);
		l4.setBounds(400,350,100,30);t4.setBounds(480,350,100,30);tf4.setBounds(620,350,100,30);
		l5.setBounds(400,400,100,30);t5.setBounds(480,400,100,30);tf5.setBounds(620,400,100,30);
		l6.setBounds(400,450,100,30);t6.setBounds(480,450,100,30);tf6.setBounds(620,450,100,30);
		l7.setBounds(400,500,100,30);t7.setBounds(480,500,100,30);tf7.setBounds(620,500,100,30);
		l8.setBounds(560,550,100,30);tf8.setBounds(620,550,100,30);
		jp.add(ll1);jp.add(ll2);jp.add(ll3);jp.add(ll4);
		jp.add(ls);jp.add(le);jp.add(li);
		jp.add(l1);
		jp.add(l2);
		jp.add(l3);
		jp.add(l4);
		jp.add(l5);
		jp.add(l6);
		jp.add(l7);
		jp.add(l8);
		jp.add(tt1);jp.add(tt2);
		jp.add(t1);jp.add(tf1);
		jp.add(t2);jp.add(tf2);
		jp.add(t3);jp.add(tf3);
		jp.add(t4);jp.add(tf4);
		jp.add(t5);jp.add(tf5);
		jp.add(t6);jp.add(tf6);
		jp.add(t7);jp.add(tf7);
		jp.add(b1);jp.add(tf8);
		jp.add(b2);
		jp.add(jcb1);
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

	public void actionPerformed(ActionEvent ae)
	{
			screen();
			String r=ae.getActionCommand();
			if(r.equals("SAVE"))
			{
			 	
				try
				{

					if(tt1.getText().equals("") || tt2.getText().equals("")|| t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("") || t5.getText().equals("") || t6.getText().equals("") ||t7.getText().equals("") || tf1.getText().equals("") || tf2.getText().equals("")|| tf3.getText().equals("") || tf4.getText().equals("") || tf5.getText().equals("") || tf6.getText().equals("") ||tf7.getText().equals("") || tf8.getText().equals(""))		
					{		
						JOptionPane.showMessageDialog(f1,"FILL  THE ALL ENTRIES");
					} 
					else if((Integer.parseInt(tf1.getText())>50) || (Integer.parseInt(tf2.getText())>50) || (Integer.parseInt(tf3.getText())>50) || (Integer.parseInt(tf4.getText())>50) || (Integer.parseInt(tf5.getText())>50) || (Integer.parseInt(tf6.getText())>50) || (Integer.parseInt(tf7.getText())>50) || (Integer.parseInt(tf8.getText())>50))		
					{
						JOptionPane.showMessageDialog(f1,"Enter the Internal Marks blow 50");
					}
					else if(Integer.parseInt(t1.getText())>100 || Integer.parseInt(t2.getText())>100|| Integer.parseInt(t3.getText())>100 || Integer.parseInt(t4.getText())>100|| Integer.parseInt(t5.getText())>100 || Integer.parseInt(t6.getText())>100 ||Integer.parseInt(t7.getText())>100)		
					{
						JOptionPane.showMessageDialog(f1,"Enter the External Marks blow 100");
					}
					else
					{
				connect();
				temp=0;
				temp1=0;
				sm2=con.createStatement();
				sm1=con.createStatement();
				rs1=sm2.executeQuery("Select *from Academicdetail");
				rs2=sm1.executeQuery("Select *from marks");
				while(rs1.next())
				{
					if(tt1.getText().equals(rs1.getString(2)))
					{
						temp=1;
						break;
					}
				}
				while(rs2.next())
				{
					if(tt1.getText().equals(rs2.getString(1)))
					{
						temp1=1;
						break;
					}
				}
				if(temp==1 && temp1==0)
				{
				String rn,sm,sb1,sb2,sb3,sb4,sb5,sb6,sb7;
  				rn = tt1.getText();
  				sm=tt2.getText();
  				sb1= t1.getText();
  				sb2 = t2.getText();
 				sb3 = t3.getText();
 				sb4 = t4.getText();
 				sb5 = t5.getText();
 				sb6=t6.getText();
			 	sb7=t7.getText();
				PreparedStatement ps = con.prepareStatement("insert into marks values(?,?,?,?,?,?,?,?,?)");
				ps.setString(1,rn);
				ps.setString(2,sm);
				ps.setString(3,sb1);
				ps.setString(4,sb2);
				ps.setString(5,sb3);
				ps.setString(6,sb4);
				ps.setString(7,sb5);
				ps.setString(8,sb6);
				ps.setString(9,sb7);
				int a=ps.executeUpdate();
				String ss1,ss2,ss3,ss4,ss5,ss6,ss7,ss8;
  				ss1=tf1.getText();
  				ss2=tf2.getText(); 
				ss3=tf3.getText();
  				ss4=tf4.getText();
  				ss5=tf5.getText();
  				ss6=tf6.getText();
  				ss7=tf7.getText();
  				ss8=tf8.getText();
				PreparedStatement ps1 = con.prepareStatement("insert into internalmarks values(?,?,?,?,?,?,?,?,?,?)");
				ps1.setString(1,rn);
				ps1.setString(2,sm);
				ps1.setString(3,ss1);
				ps1.setString(4,ss2);
				ps1.setString(5,ss3);
				ps1.setString(6,ss4);
				ps1.setString(7,ss5);
				ps1.setString(8,ss6);
				ps1.setString(9,ss7);
				ps1.setString(10,ss8);
				int b=ps1.executeUpdate();
				if(a!=0 && b!=0)
				JOptionPane.showMessageDialog(this,"Insert new record successfully");
				tt1.setText(null);tf1.setText(null);
				tt2.setText(null);tf2.setText(null);
				t1.setText(null);tf3.setText(null);
				t2.setText(null);tf4.setText(null);
				t3.setText(null);tf5.setText(null);
				t4.setText(null);tf6.setText(null);
				t5.setText(null);tf7.setText(null);
				t6.setText(null);tf8.setText(null);
				t7.setText(null);
				}
				
				if(temp==0)
				{
				JOptionPane.showMessageDialog(f1,"Roll number is not exist in Academic DataBase");
					tt1.setText(null);
				}
				if(temp==1 && temp1==1)
				{
					JOptionPane.showMessageDialog(f1,"This rollno record allready exist in DataBase");
					tt1.setText(null);
				}
				}

		}
		catch(Exception e)
		{
		System.out.println(e);
		}}

		if(ae.getSource()==b2)
		{
			JInfo ji=new JInfo(s1);
			ji.setSize(a,b);
			ji.setVisible(true);
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
	/*public static void main(String arg[])
	{
		MarkInsert mi = new MarkInsert("SIMS");
		mi.setVisible(true);
		mi.setSize(1000,1000);
	}*/

}