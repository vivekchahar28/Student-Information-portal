import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Mark extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l39,l40,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,l30,l31,l32,l33,l34,l35,l36,l37,l38;
	JButton b1,pnt;
	String s1;
	int a,b;
	Mark(String s)
	{
		super(s);
		s1=s;
		JPanel c=(JPanel)getContentPane();
		c.setLayout(null);
		Color cl= new Color(100,250,100);
		c.setBackground(cl);
		l1=new JLabel("STUDENT INFORMATION MANAGEMENT SYSTEM");
		l1.setFont(new Font("Arial",Font.BOLD,25));
		l1.setBounds(330,100,600,25);
		l1.setForeground(Color.gray);
		l2=new JLabel();
		l2.setFont(new Font("Arial",Font.BOLD,16));
		l2.setBounds(560,140,200,14);
		l3=new JLabel("Name :");
		l3.setFont(new Font("Arial",Font.BOLD,12));
		l3.setBounds(410,200,100,12);
		l4=new JLabel();
		l4.setFont(new Font("Arial",Font.BOLD,12));
		l4.setBounds(560,200,100,14);
		l5=new JLabel("Father Name :");
		l5.setFont(new Font("Arial",Font.BOLD,12));
		l5.setBounds(410,220,100,12);
		l6=new JLabel();
		l6.setFont(new Font("Arial",Font.BOLD,12));
		l6.setBounds(560,220,150,14);
		l7=new JLabel("Roll Number :");
		l7.setFont(new Font("Arial",Font.BOLD,12));
		l7.setBounds(410,240,150,14);
		l8=new JLabel();
		l8.setFont(new Font("Arial",Font.BOLD,12));
		l8.setBounds(560,240,150,14);
		l9=new JLabel("Subject Code");
		l9.setFont(new Font("Arial",Font.BOLD,12));
		l9.setBounds(410,300,150,14);
		l10=new JLabel("External Marks");
		l10.setFont(new Font("Arial",Font.BOLD,12));
		l10.setBounds(560,300,150,14);
		l11=new JLabel("Internal Marks");
		l11.setFont(new Font("Arial",Font.BOLD,12));
		l11.setBounds(730,300,150,14);
		l12=new JLabel();
		l12.setFont(new Font("Arial",Font.BOLD,12));
		l12.setBounds(410,320,150,14);
		l13=new JLabel();
		l13.setFont(new Font("Arial",Font.BOLD,12));
		l13.setBounds(560,320,150,14);
		l14=new JLabel();
		l14.setFont(new Font("Arial",Font.BOLD,12));
		l14.setBounds(730,320,150,14);
		l15=new JLabel();
		l15.setFont(new Font("Arial",Font.BOLD,12));
		l15.setBounds(410,340,150,14);
		l16=new JLabel();
		l16.setFont(new Font("Arial",Font.BOLD,12));
		l16.setBounds(560,340,150,14);
		l17=new JLabel();
		l17.setFont(new Font("Arial",Font.BOLD,12));
		l17.setBounds(730,340,150,14);
		l18=new JLabel();
		l18.setFont(new Font("Arial",Font.BOLD,12));
		l18.setBounds(410,360,150,14);
		l19=new JLabel();
		l19.setFont(new Font("Arial",Font.BOLD,12));
		l19.setBounds(560,360,150,14);
		l20=new JLabel();
		l20.setFont(new Font("Arial",Font.BOLD,12));
		l20.setBounds(730,360,150,14);
		l21=new JLabel();
		l21.setFont(new Font("Arial",Font.BOLD,12));
		l21.setBounds(410,380,150,14);
		l22=new JLabel();
		l22.setFont(new Font("Arial",Font.BOLD,12));
		l22.setBounds(560,380,150,14);
		l23=new JLabel();
		l23.setFont(new Font("Arial",Font.BOLD,12));
		l23.setBounds(730,380,150,14);
		l24=new JLabel();
		l24.setFont(new Font("Arial",Font.BOLD,12));
		l24.setBounds(410,400,150,14);
		l25=new JLabel();
		l25.setFont(new Font("Arial",Font.BOLD,12));
		l25.setBounds(560,400,150,14);
		l26=new JLabel();
		l26.setFont(new Font("Arial",Font.BOLD,12));
		l26.setBounds(730,400,150,14);
		l27=new JLabel();
		l27.setFont(new Font("Arial",Font.BOLD,12));
		l27.setBounds(410,420,150,14);
		l28=new JLabel();
		l28.setFont(new Font("Arial",Font.BOLD,12));
		l28.setBounds(560,420,150,14);
		l29=new JLabel();
		l29.setFont(new Font("Arial",Font.BOLD,12));
		l29.setBounds(730,420,150,14);
		l30=new JLabel();
		l30.setFont(new Font("Arial",Font.BOLD,12));
		l30.setBounds(410,440,150,14);
		l31=new JLabel();
		l31.setFont(new Font("Arial",Font.BOLD,12));
		l31.setBounds(560,440,150,14);
		l32=new JLabel();
		l32.setFont(new Font("Arial",Font.BOLD,12));
		l32.setBounds(730,440,150,14);
		l33=new JLabel("GP");
		l33.setFont(new Font("Arial",Font.BOLD,12));
		l33.setBounds(410,460,150,14);
		l34=new JLabel();
		l34.setFont(new Font("Arial",Font.BOLD,12));
		l34.setBounds(640,460,150,14);
		l35=new JLabel();
		l35.setFont(new Font("Arial",Font.BOLD,12));
		l35.setBounds(730,530,150,14);
		l36=new JLabel("Status");
		l36.setFont(new Font("Arial",Font.BOLD,12));
		l36.setBounds(580,510,150,14);
		l37=new JLabel("Marks");
		l37.setFont(new Font("Arial",Font.BOLD,12));
		l37.setBounds(730,510,150,14);
		l38=new JLabel("Pass");
		l38.setFont(new Font("Arial",Font.BOLD,12));
		l38.setBounds(580,530,150,14);
		l39=new JLabel("CP");
		l39.setBounds(550,510,150,14);
		l39.setFont(new Font("Arial",Font.BOLD,12));
		l40=new JLabel();
		l40.setBounds(550,530,150,14);
		l40.setFont(new Font("Arial",Font.BOLD,12));
		b1 = new JButton("BACK", new ImageIcon(ClassLoader.getSystemResource("Images/back.png")));
		//b1=new JButton("Back");
		b1.setFont(new Font("Arial",Font.BOLD,12));
		b1.setBounds(770,590,100,30);
		b1.addActionListener(this);
		pnt = new JButton("Print", new ImageIcon(ClassLoader.getSystemResource("Images/print.png")));
	        //pnt=new JButton("Print");
		pnt.setBounds(50,50,100,30);
		pnt.addActionListener(this);
		c.add(l39);
		c.add(l40);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l5);
		c.add(l6);
		c.add(l7);
		c.add(l8);
		c.add(l9);
		c.add(l10);
		c.add(l11);
		c.add(l12);
		c.add(l13);
		c.add(l14);
		c.add(l15);
		c.add(l16);
		c.add(l17);
		c.add(l18);
		c.add(l19);
		c.add(l20);
		c.add(l21);
		c.add(l22);
		c.add(l23);
		c.add(l24);
		c.add(l25);
		c.add(l26);
		c.add(l27);
		c.add(l28);
		c.add(l29);
		c.add(l30);
		c.add(l31);
		c.add(l32);
		c.add(l33);
		c.add(l34);
		c.add(l35);
		c.add(l36);
		c.add(l37);
		c.add(l38);
		c.add(b1);
		c.add(pnt);

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
		screen();
		 Mark1 m=new Mark1(s1);
		m.setSize(a,b);
		
		m.setVisible(true);
		this.setVisible(false);
               }
	if(ae.getSource()==pnt)
	{
	Toolkit t=getToolkit();
	PrintJob pj=t.getPrintJob(this,"My Printing",null);
	Graphics g=pj.getGraphics();
	printAll(g);
	g.dispose();
	//g.end();
	}
	}		
	
	/*public static void main(String ag[])
	{
		Mark k=new Mark("sims");
		k.setVisible(true);
		k.setSize(a,b);
	}*/
}

