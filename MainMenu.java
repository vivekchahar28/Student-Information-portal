import java.awt.*;
import java.awt.event.*;

class NavMenu extends Frame implements ActionListener{
MenuBar mb;
Menu sInfo,mInfo;
Label l3;
MenuItem miAdd,miDelete,miView,miEdit,miExit,miShow,miUpdate;
NavMenu(String s){
super(s);
l3=new Label("STUDENT INFORMATION MANAGEMENT SYSTEM");
l3.setBounds(100,10,500,150);
l3.setFont(new Font("Times New Roman",Font.BOLD,20));
add(l3);
mb=new MenuBar();
sInfo=new Menu("Student Info");
mInfo=new Menu("Marks Info");
miAdd=new MenuItem("Add Student");
miDelete=new MenuItem("Delete Student");
miView=new MenuItem("View Student Info");
miEdit=new MenuItem("Edit Student Info");
miExit=new MenuItem("Exit");
miShow=new MenuItem("Show");
miUpdate=new MenuItem("Update");
//miNew.addActionListener(this);
miExit.addActionListener(this);
sInfo.add(miAdd);
sInfo.add(miDelete);
sInfo.add(miView);
sInfo.add(miEdit);
sInfo.add(miExit);
mInfo.add(miShow);
mInfo.add(miUpdate);
mb.add(sInfo);
mb.add(mInfo);
setMenuBar(mb);
}	


public void actionPerformed(ActionEvent ae){
	if(ae.getSource()==miExit){
	System.exit(0);
	}

}


}
class MainMenu{
public static void main(String s[]){
NavMenu nm=new NavMenu("SIMS");
nm.setSize(1000,1000);
nm.setVisible(true);
}
}
