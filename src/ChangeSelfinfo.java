import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;


public class ChangeSelfinfo {//implements ActionListener
	String ID;
	String password;
	ChangeSelfinfo(String ID,String password){
		
	}
    public void changePassword(String ID, String password){
    	JTextField jt1;
    	JFrame fr=new JFrame("�޸�����");
    	fr.setSize(280,150);
 	    fr.setLocationRelativeTo(null);
 	    fr.setVisible(true);
 	    fr.setLayout(new FlowLayout());
    	JLabel lb1=new JLabel("������:");
    	JButton B1=new JButton("�޸�����");
    	jt1=new JTextField("");
    	jt1.setColumns(18);
    	fr.add(lb1);
    	fr.add(jt1);
    	fr.add(B1);
    	B1.addActionListener(new ButtonListener(jt1));
    }
	/*public void actionPerformed(ActionEvent e) {
		String s1="222";
		
		try {
			User a = DataProcessing.searchUser(ID);
		    a.changeSelfInfo(s1);
			if(a.changeSelfInfo(s1)!=false)
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
			else
				JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�"); 
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "���ݿ����");
		}
	}*/
    public class ButtonListener implements ActionListener{
        JTextField jt1=new JTextField();
        ButtonListener(JTextField jt1){
        	this.jt1=jt1;
        }
		public void actionPerformed(ActionEvent e) {
			String s1 = jt1.getText();
			try {
				User a = DataProcessing.searchUser(ID,password);
			    a.changeSelfInfo(s1);
				if(a.changeSelfInfo(s1)!=false)
					JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
				else
					JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�"); 
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "���ݿ����");
			}
			
		}
    }
}