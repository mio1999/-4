import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class OperateFrame implements ActionListener{
	String ID;
	String password;
	public OperateFrame(String ID,String password){
		this.ID=ID;
    	this.password=password;
	}
    public void OpFrame(String role, String password){
    	JFrame fr=new JFrame("��������ϵͳ");
    	fr.setSize(500,400);
    	JMenuBar mb = new JMenuBar();
    	JMenu m1=new JMenu("�ļ�����");
    	JMenu m2=new JMenu("������Ϣ����");
    	JMenu m3=new JMenu("�û�����");
    	mb.add(m1);
    	mb.add(m2);
    	mb.add(m3);
    	JMenuItem mi1 =new JMenuItem("�ϴ��ļ�");
    	JMenuItem mi2 =new JMenuItem("�����ļ�");
    	JMenuItem mi3 =new JMenuItem("�ļ��б�");
    	JMenuItem mi4 =new JMenuItem("�޸�����");
    	JMenuItem mi5 =new JMenuItem("�޸��û�");
    	JMenuItem mi6 =new JMenuItem("ɾ���û�");
    	JMenuItem mi7 =new JMenuItem("�����û�");
    	JMenuItem mi8 =new JMenuItem("�û��б�");
    	m1.add(mi1);
    	m1.add(mi2);
    	m1.add(mi3);
    	m2.add(mi4);
    	m3.add(mi5);
    	m3.add(mi6);
    	m3.add(mi7);
    	m3.add(mi8);
    	fr.add(mb);
    	fr.setVisible(true);
    	switch(role){
    	case "admistrator":
    		m1.setEnabled(true);
			m2.setEnabled(true);
			m3.setEnabled(true);
			mi1.setEnabled(false);
			mi2.setEnabled(true);
			mi3.setEnabled(true);
			mi4.setEnabled(true);
			mi5.setEnabled(false);
			mi6.setEnabled(true);
			mi7.setEnabled(true);
			mi8.setEnabled(true);
    		break;
    	case "operator":
    		m1.setEnabled(true);
    		m2.setEnabled(true);
    		m3.setEnabled(false);
    		mi1.setEnabled(true);
    		mi2.setEnabled(true);
    		mi3.setEnabled(true);
    		mi4.setEnabled(true);
    		mi5.setEnabled(false);
			mi6.setEnabled(false);
			mi7.setEnabled(false);
			mi8.setEnabled(false);
    		break;
    	case "browser":
    		m1.setEnabled(true);
    		m2.setEnabled(true);
    		m3.setEnabled(false);
    		mi1.setEnabled(false);
    		mi2.setEnabled(true);
    		mi3.setEnabled(true);
    		mi4.setEnabled(true);
    		mi5.setEnabled(false);
			mi6.setEnabled(false);
			mi7.setEnabled(false);
			mi8.setEnabled(false);
    		break;
    	}
    	mi1.addActionListener(new OperateFrame(ID, password));
    	mi2.addActionListener(new OperateFrame(ID, password));
    	mi3.addActionListener(new OperateFrame(ID, password));
    	mi4.addActionListener(new OperateFrame(ID, password));
    	mi5.addActionListener(new OperateFrame(ID, password));
    	mi6.addActionListener(new OperateFrame(ID, password));
    	mi8.addActionListener(new OperateFrame(ID, password));
    }
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="�ϴ��ļ�") {
			DocOperate DocOperate=new DocOperate(ID,password);
			DocOperate.uploadFile();
		}
		else if(e.getActionCommand()=="�����ļ�") {
			DocOperate DocOperate=new DocOperate(ID,password);
			DocOperate.downloadFile();
		}
		else if(e.getActionCommand()=="�ļ��б�") {
			DocOperate DocOperate=new DocOperate(ID,password);
			DocOperate.showFilelist();
		}
		else if(e.getActionCommand()=="�޸�����") {
			ChangeSelfinfo ChangeSelfinfo=new ChangeSelfinfo(ID,password);
			ChangeSelfinfo.changePassword(ID,password);
		}
		else if(e.getActionCommand()=="�޸��û�") {
			UserOperate useroperate=new UserOperate();
			useroperate.insertUser();
		}
		else if(e.getActionCommand()=="ɾ���û�") {
			UserOperate useroperate=new UserOperate();
			useroperate.deleteUser();
		}	
		else if(e.getActionCommand()=="�����û�") {
			UserOperate useroperate=new UserOperate();
			useroperate.insertUser();
		}
		else if(e.getActionCommand()=="�û��б�") {
			UserOperate useroperate=new UserOperate();
			useroperate.showUserlist();
		}
	}   	   	
}
    


