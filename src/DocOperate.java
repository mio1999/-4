import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.swing.*;


public class DocOperate {
	JFrame fr=new JFrame("文件管理");
    JTextField jt2 = new JTextField();
    JTextField jt3 = new JTextField();
    JTextField jt4 = new JTextField();
	String ID;
	String password;
	DocOperate(String ID,String password){
		
	}
	static String uploadpath="F:\\upload\\";
	static String downloadpath="F:\\download\\";
	
	public static boolean downloadFile(String filename) throws IOException{
		//double ranValue=Math.random();
		//if (ranValue>0.5)
			//throw new IOException( "Error in accessing file" );
		try {
			Doc e = DataProcessing.searchDoc(filename);
			if(e==null)
				return false;
			File a = new File(uploadpath+e.getFilename());
			BufferedInputStream sourcefile = new BufferedInputStream(new FileInputStream(a));
			BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(downloadpath+e.getFilename()));
			byte[] b = new byte[1024];
			int len=0;
			while((len=sourcefile.read(b))!=-1){
			  targetfile.write(b,0,len);
			}
			sourcefile.close();
			targetfile.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库异常:"+e.getMessage());
		}
		return true;
	}
	
	public static boolean uploadFile(String creator,String docid,String docinfo,String docname,String docpath) throws IOException{
		try{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
		DataProcessing.insertDoc(docid, creator , timestamp, docinfo, docname );
		File a = new File(docpath);
		byte[] b = new byte[1024];
		BufferedInputStream sourcefile = new BufferedInputStream(new FileInputStream(a));
		BufferedOutputStream targetfile = new BufferedOutputStream(new FileOutputStream(uploadpath+docname));
		int len=0;
		while((len=sourcefile.read(b))!=-1)
			targetfile.write(b,0,len);
		sourcefile.close();
		targetfile.close();
		System.out.println("上传中... ...");
		System.out.println("上传成功");
		} catch (SQLException e) {
			System.out.println("数据库异常:"+e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("未找到对应文件:"+e.getMessage());
		} catch (IOException e) {
			System.out.println("IO流异常:"+e.getMessage());
        }
		return true;
	}
	
	
	public void downloadFile(){
//    	JFrame fr = new JFrame("下载文件");
    	fr.setSize(300,200);
//        JLabel jl=new JLabel("下载文件");
//        jl.setSize(10, 10);
        fr.setLayout(new BorderLayout());
        Object[] columnNames={"档案号","上传者","上传时间","文件描述","文件名"};
        Enumeration<Doc> e = null;
        Enumeration<Doc> b = null;
        JButton b1=new JButton("下载文件");
        //b1.setSize(10, 20);
		try {
			e = DataProcessing.getAllDocs();
			b = DataProcessing.getAllDocs();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Doc o;
		int i=0,j=0;
		while (e.hasMoreElements()) {
	  		i++;
	  		e.nextElement();
		}
		Object[][] obj= new Object[i][5];
		while (b.hasMoreElements()){
			o = b.nextElement();
	        obj[j][0]=o.getID();
	        obj[j][1]=o.getCreator();
	        obj[j][2]=o.getTimestamp();
	        obj[j][3]=o.getDescription();
	        obj[j][4]=o.getFilename();
	        j++;
		}
		JTable jt1 = new JTable(obj,columnNames);
		jt1.setSize(500,300);
//		JPanel jp = new JPanel();
//		jp.setSize(500,300);
//		jp.add(jt1);
		JScrollPane jsp = new JScrollPane(jt1);
		jsp.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		jsp.add(jp);
//	    jp.setVisible(true);
		//fr.add(jl,BorderLayout.NORTH);
		fr.add(jsp,BorderLayout.CENTER);
		fr.add(b1,BorderLayout.SOUTH);
		fr.setVisible(true);
//		int count=jt1.getSelectedRow();//获取你选中的行号（记录）
//		String getname= jt1.getValueAt(1, 4).toString();
//		System.out.println(getname);
		b1.addActionListener(new buttonlistener(jt1));
    }
	public void uploadFile(){
//		JFrame fr = new JFrame("上传文件");
    	fr.setSize(500,600);

        fr.setLayout(new FlowLayout());
        Object[] columnNames={"档案号","上传者","上传时间","文件描述","文件名"};
        Enumeration<Doc> e = null;
        Enumeration<Doc> b = null;
        JButton b1=new JButton("上传文件");
        JButton b2=new JButton("打开");
        JLabel jl1=new JLabel("目录");
        JLabel jl2=new JLabel("档案描述");
        JLabel jl3=new JLabel("档案编号");
        jt2.setColumns(30);
        jt3.setColumns(35);
        jt4.setColumns(35);
        
		try {
			e = DataProcessing.getAllDocs();
			b = DataProcessing.getAllDocs();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Doc o;
		int i=0,j=0;
		while (e.hasMoreElements()) {
	  		i++;
	  		e.nextElement();
		}
		Object[][] obj= new Object[i][5];
		while (b.hasMoreElements()){
			o = b.nextElement();
	        obj[j][0]=o.getID();
	        obj[j][1]=o.getCreator();
	        obj[j][2]=o.getTimestamp();
	        obj[j][3]=o.getDescription();
	        obj[j][4]=o.getFilename();
	        j++;
		}
		JTable jt1 = new JTable(obj,columnNames);
		jt1.setSize(300,200);

		JScrollPane jsp = new JScrollPane(jt1);
		jsp.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setSize(300,200);

		fr.add(jsp);
		fr.add(jl1);
		fr.add(jt2);
		fr.add(b2);
		fr.add(jl2);
		fr.add(jt3);
		fr.add(jl3);
		fr.add(jt4);
		fr.add(b1);
		fr.setVisible(true);
		b2.addActionListener(new buttonlistener(jt1));
		b1.addActionListener(new buttonlistener(jt1));
    }
	public void showFilelist(){
		JFrame fr = new JFrame("文件列表");
    	fr.setSize(300,200);
//        JLabel jl=new JLabel("下载文件");
//        jl.setSize(10, 10);
        fr.setLayout(new BorderLayout());
        Object[] columnNames={"档案号","上传者","上传时间","文件描述","文件名"};
        Enumeration<Doc> e = null;
        Enumeration<Doc> b = null;
        //b1.setSize(10, 20);
		try {
			e = DataProcessing.getAllDocs();
			b = DataProcessing.getAllDocs();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Doc o;
		int i=0,j=0;
		while (e.hasMoreElements()) {
	  		i++;
	  		e.nextElement();
		}
		Object[][] obj= new Object[i][5];
		while (b.hasMoreElements()){
			o = b.nextElement();
	        obj[j][1]=o.getID();
	        obj[j][2]=o.getCreator();
	        obj[j][3]=o.getTimestamp();
	        obj[j][4]=o.getDescription();
	        obj[j][5]=o.getFilename();
	        j++;
		}
		JTable jt1 = new JTable(obj,columnNames);
		jt1.setSize(500,300);
//		JPanel jp = new JPanel();
//		jp.setSize(500,300);
//		jp.add(jt1);
		JScrollPane jsp = new JScrollPane(jt1);
		jsp.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		jsp.add(jp);
//	    jp.setVisible(true);
		//fr.add(jl,BorderLayout.NORTH);
		fr.add(jsp,BorderLayout.CENTER);
		fr.setVisible(true);
//		
    
	}
	class buttonlistener implements ActionListener{
		JTable jt1; 
		buttonlistener(JTable jt1){
			this.jt1=jt1;
		}
//		buttonlistener(){
//			this.obj=obj;
//		}
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand()=="下载文件") {
				int count=jt1.getSelectedRow();//获取你选中的行号（记录）
				String getname= jt1.getValueAt(count, 0).toString();
				System.out.println(getname);
				try {
					if((downloadFile(getname))==true){
						JOptionPane.showMessageDialog(null, "下载成功！");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getActionCommand()=="打开"){
				FileDialog fd =new FileDialog(fr,"打开文件",FileDialog.LOAD);
				fd.setVisible(true);
				jt2.setText(fd.getDirectory()+fd.getFile());
			}
			else if(e.getActionCommand()=="上传文件"){
				if(jt2.getText()==null){
					JOptionPane.showMessageDialog(null, "路径输入错误！");
				}
				else{
					String s1=jt2.getText();
					String s2=jt3.getText();
					String s3=jt4.getText();
					int begin=s1.lastIndexOf("\\");
					String s4=s1.substring(begin+1);
					try {
						if(uploadFile(ID,s2,s3,s4,s1)==true){
							JOptionPane.showMessageDialog(null, "上传成功！");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		}
	}
//	public static void main(String[] args){
//		DocOperate n =new DocOperate("jack","123");
//		n.uploadFile();
//	}
}
