import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class JWelcomes extends JFrame implements ActionListener
{
	String str;
	JButton b1,b2;
	int a,b;
	JWelcomes(String s)
  	{
		super(s);
		JPanel jp=(JPanel)getContentPane();
		jp.setLayout(null);
		b1 = new JButton("CONTINUE", new ImageIcon(ClassLoader.getSystemResource("Images/user.png")));

		b1.setBounds(500,400,150,40);
		jp.add(b1);
		b1.addActionListener(this);
		b2 = new JButton("EXIT", new ImageIcon(ClassLoader.getSystemResource("Images/cancel.png")));
		//b2=new JButton("EXIT");
		b2.setBounds(660,400,150,40);
		jp.add(b2);

		b2.addActionListener(this);
		JLabel wel=new JLabel("WELCOME");
		wel.setFont(new Font("Times New Roman",Font.BOLD,35));
		wel.setBounds(550,80,300,35);
		wel.setForeground(Color.gray);
		jp.add(wel);
		JLabel wel1=new JLabel("TO");
		wel1.setFont(new Font("Times New Roman",Font.BOLD,35));
		wel1.setBounds(620,160,300,35);
		wel1.setForeground(Color.gray);
		jp.add(wel1);
		JLabel wel2=new JLabel(" STUDENT INFORMATION MANAGEMENT SYSTEM");
		wel2.setFont(new Font("Times New Roman",Font.BOLD,35));
		wel2.setBounds(200,230,1000,35);
		wel2.setForeground(Color.gray);
		jp.add(wel2);
		Color c= new Color(100,250,100);
		jp.setBackground(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		if(ae.getSource()==b1)
		{
			JEnter je=new JEnter("STUDENT INFORMATION MANAGEMENT SYSTEM");
			screen();
			je.setSize(a,b);
			je.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()==b2)
		{
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		JWelcomes w=new JWelcomes("STUDENT INFORMATION MANAGEMENT SYSTEM");
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		int a=d.width;
		int b=d.height;
		w.setSize(a,b);
		w.setVisible(true);
	}
}
