import java.awt.*;        
import java.awt.event.*;
import javax.swing.*; 
public class JInfo extends JFrame implements ActionListener
{
	String str,s;
	JButton b1,b2,b3,b5,ba;
	JLabel l,l1,l2;
	int a,b;
  	JInfo(String s1)
  	{
		super(s1);
		s=s1;
		JPanel jp=(JPanel)getContentPane();
		jp.setLayout(null);
		Color c= new Color(100,250,100);
		jp.setBackground(c);
		JLabel l=new JLabel("Student Information Management System");
		l.setFont(new Font("Times New Roman",Font.BOLD,40));
		l.setBounds(310,100,900,50);
		l.setForeground(Color.gray);
		jp.add(l);
		b1=new JButton("Basic Info");
		b1.setBounds(450,270,130,40);
		jp.add(b1);
		b1.addActionListener(this);
		b2=new JButton("Show Marks");
		b2.setBounds(710,270,130,40);
		jp.add(b2);
		b2.addActionListener(this);
		b3=new JButton("Insert Marks");
		b3.setBounds(710,340,130,40);
		jp.add(b3);
		b3.addActionListener(this);
		b5=new JButton("Acadmic Info");
		b5.setBounds(450,340,130,40);
		jp.add(b5);
		b5.addActionListener(this);
		ba = new JButton("BACK", new ImageIcon(ClassLoader.getSystemResource("Images/back.png")));
		//ba=new JButton("Back");
		ba.setBounds(580,410,130,40);
		jp.add(ba);
		ba.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(s.equals("Student"))
		b3.setEnabled(false);
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
			Basic bi=new Basic(s);
			screen();
			bi.setSize(a,b);
			bi.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()==b5)
		{
			Academic a1=new Academic(s);
			screen();
			a1.setSize(a,b);
			a1.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()==b3)
		{
			MarkInsert mi=new MarkInsert(s);
			screen();
			mi.setSize(a,b);
			mi.setVisible(true);
			this.setVisible(false);
		}
		String m=ae.getActionCommand();
		if(m.equals("Show Marks"))
		{
			Mark1 ms=new Mark1(s);
			screen();
			ms.setSize(a,b);
			ms.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()==ba)
		{
			JEnter e=new JEnter("STUDENT INFORMATION MANAGEMENT SYSTEM");
			screen();
			e.setSize(a,b);
			e.setVisible(true);
			this.setVisible(false);
		}
	}

	public static void main(String args[])
	{
		JInfo w=new JInfo("sims");
		w.setSize(1100,1100);
		w.setVisible(true);
	}
}
