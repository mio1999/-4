import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.*;


public class UserOperate {
	JFrame fr=new JFrame("�û�����");
	JTable jt1=makeList();
	
	public void insertUser(){
		JLabel j1=new JLabel("�˺�");
		JLabel j2=new JLabel("����");
		JLabel j3=new JLabel("���");
		
		JTextField jt1=new JTextField();
		JTextField jt2=new JTextField();
		JTextField jt3=new JTextField();
		
		jt1.setColumns(18);
		jt2.setColumns(18);
		jt3.setColumns(18);
		
		JButton jb1=new JButton("�����޸�");
		
		fr.setSize(280,150);
		fr.setLayout(new FlowLayout());
		fr.add(j1);
		fr.add(jt1);
		fr.add(j2);
		fr.add(jt2);
		fr.add(j3);
		fr.add(jt3);
		fr.add(jb1);
		fr.setVisible(true);
		
		jb1.addActionListener(new Buttonactionlistener(jt1,jt2,jt3));
	}
	
	public void deleteUser(){

		JScrollPane jsp = new JScrollPane(jt1);
		jsp.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setSize(280,200);
		
		JButton jb1=new JButton("ɾ���û�");
		
		fr.setSize(500,500);
		fr.setLayout(new FlowLayout());
		fr.add(jsp);
		fr.add(jb1);
		fr.setVisible(true);
		
		jb1.addActionListener(new Buttonactionlistener(jt1));
	}
	
	public void showUserlist(){
		JScrollPane jsp = new JScrollPane(jt1);
		jsp.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setSize(280,200);
		
		fr.setSize(500,500);
		fr.setLayout(new FlowLayout());
		fr.add(jsp);
		fr.setVisible(true);
	}
	
	public JTable makeList(){
        Object[] columnNames={"�˺�","����","���"};
        Enumeration<User> e = null;
        Enumeration<User> b = null;
        //b1.setSize(10, 20);
		try {
			e = DataProcessing.getAllUser();
			b = DataProcessing.getAllUser();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		User o;
		int i=0,j=0;
		while (e.hasMoreElements()) {
	  		i++;
	  		e.nextElement();
		}
		Object[][] obj= new Object[i][3];
		while (b.hasMoreElements()){
			o = b.nextElement();
	        obj[j][0]=o.getName();
	        obj[j][1]=o.getPassword();
	        obj[j][2]=o.getRole();
	        j++;
		}
		JTable jt1 = new JTable(obj,columnNames);
		jt1.setSize(280,200);
		return jt1;
	}
	
 	class Buttonactionlistener implements ActionListener{
 		JTable j1=new JTable();
 		
 		JTextField jt1=new JTextField();
		JTextField jt2=new JTextField();
		JTextField jt3=new JTextField();
		
 		Buttonactionlistener(JTable jt1){
 			this.j1=jt1;
 		}
 		Buttonactionlistener(JTextField jt1,JTextField jt2,JTextField jt3){
 			this.jt1=jt1;
 			this.jt2=jt2;
 			this.jt3=jt3;
 		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()=="�����޸�"){
				String s1=jt1.getText();
				String s2=jt2.getText();
				String s3=jt3.getText();
				try{
					if(DataProcessing.updateUser(s1,s2,s3)==true){
						JOptionPane.showMessageDialog(null, "�޸ĳɹ���");   
				    }
					else{
						boolean b = DataProcessing.insertUser(s1,s2,s3);
					    if(b=true)
					    	JOptionPane.showMessageDialog(null, "�����ɹ���");   
					    else
					    	JOptionPane.showMessageDialog(null, "�û����ѱ�ʹ�ã�");   
					}
				}
				catch(SQLException e1){
			    		System.out.println("���ݿ��쳣"+e1.getMessage());
			    } 
		    }
			else if(e.getActionCommand()=="ɾ���û�"){
				int count=j1.getSelectedRow();//��ȡ��ѡ�е��кţ���¼��
				String getname= j1.getValueAt(count, 0).toString();
				try {
					if(DataProcessing.deleteUser(getname)==true){
						JOptionPane.showMessageDialog(null, "ɾ���ɹ���");   
					}
					else{
						JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");   
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
 	    }
 	}
	public static void main(String[] args){
		UserOperate n=new UserOperate();
		n.deleteUser();
	}
}
