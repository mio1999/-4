import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.sql.*;
import java.io.*;

public abstract class User {
	private String name;
	private String password;
	private String role;
	
	User(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;				
	}
	
    String uploadpath="F:\\upload\\";
    String downloadpath="F:\\download\\";
	
    
	
	public boolean changeSelfInfo(String password) throws SQLException{
		//写用户信息到存储
		if (DataProcessing.updateUser(name, password, role)){
			this.password=password;
			System.out.println("修改成功");
			return true;
		}else
			return false;
	}
	
	public boolean downloadFile(String filename) throws IOException{
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
			System.out.println("下载成功!");
			sourcefile.close();
			targetfile.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库异常:"+e.getMessage());
		}
		return true;
	}
	
	public void showFileList() throws SQLException{
		//double ranValue=Math.random();
		//if (ranValue>0.5)
			//throw new SQLException( "Error in accessing file DB" );
		 Enumeration<Doc> e= DataProcessing.getAllDocs();
		 //e = DataProcessing.getAllDocs();
		 System.out.println("列表:");
		 Doc o;
		 while (e.hasMoreElements()) {
   		 o = e.nextElement();
   		 System.out.println("ID:"+o.getID()+"   "+"Filename:"+o.getFilename()+"   "+"Timestamp:"+o.getTimestamp()+"   "+"Creator:"+o.getCreator()+"   "+"Description:"+o.getDescription()+"   "); 
   	     }
	}
	
	public abstract void showMenu();
	
	public void exitSystem(){
		System.out.println("系统退出, 谢谢使用 ! ");
		System.exit(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
