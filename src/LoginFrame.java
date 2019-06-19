
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener {
   JLabel lb1,lb2;
   JTextField tf1,tf2;
   JButton bt1;
   public int Login(){
	   JFrame fr1=new JFrame("档案管理系统");
	   fr1.setSize(280,150);
	   fr1.setLocationRelativeTo(null);
	   fr1.setVisible(true);
	   fr1.setLayout(new FlowLayout());
	   lb1=new JLabel("账号:");
	   lb2=new JLabel("密码:");
	   tf1=new JTextField("");
	   tf2=new JTextField("");
	   tf1.setColumns(18);
	   tf2.setColumns(18);
	   bt1=new JButton("登陆");
	   fr1.add(lb1);
	   fr1.add(tf1);
	   fr1.add(lb2);
	   fr1.add(tf2);
	   fr1.add(bt1);
	   bt1.addActionListener(this);
	   fr1.setVisible(true);
	   fr1.addWindowListener(new WindowAdapter()
       {
              public void windowClosing(WindowEvent e)
              {
                  System.exit(0);//关闭窗口处理关闭动作监听事件
              }
       });
	return 0;
   }

   public void actionPerformed(ActionEvent e){
	   
	   String s1=tf1.getText();
	   String s2=tf2.getText();
	   try {
		  User a = DataProcessing.searchUser(s1,s2);
		  if(a!=null){
		     setVisible(false);
			 OperateFrame b=new OperateFrame(s1,s2);
			 b.OpFrame(a.getRole(),s2);
			 dispose();
		  }
		  else
			 JOptionPane.showMessageDialog(null, "账号密码输入错误！");   
	   } catch (SQLException e1) {
		   JOptionPane.showMessageDialog(null, "数据库错误！");
			
	   }
    }
   public static void main(String[] args){
	   new LoginFrame().Login();
   }
}
