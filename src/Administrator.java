import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;
public class Administrator extends User {

	Administrator(String name, String password, String role) {
		super(name, password, role);
	}
	public void showMenu() {
		int order;
		do{
		  System.out.println("****欢迎来到档案员管理系统****");
		  System.out.println("       1.修改用户");	
          System.out.println("       2.删除用户");
	      System.out.println("       3.新增用户 ");
	      System.out.println("       4.列出用户");
	      System.out.println("       5.下载文件");
	      System.out.println("       6.文件列表");
	      System.out.println("       7.修改密码");
	      System.out.println("       8.退出");
	      System.out.println("*****************************");
	      System.out.println("请输入指令:");
	      Scanner sc1=new Scanner(System.in);
	      order=sc1.nextInt();
		  switch(order){
		     case 1:
		    	 try {
			    	 System.out.println("修改用户");
			    	 System.out.println("请输入用户名:");
			    	 Scanner sc2=new Scanner(System.in);
				     String name=sc2.nextLine();
			    	 System.out.println("请输入密码:");
			    	 Scanner sc3=new Scanner(System.in);
				     String password=sc3.nextLine();
				     System.out.println("请输入角色:");
			    	 Scanner sc4=new Scanner(System.in);
				     String role=sc4.nextLine();
					 DataProcessing.updateUser(name,password,role);
					 if(DataProcessing.updateUser(name,password,role)==true){
			    		 System.out.println("修改成功");
			    	 }
		    	 } catch (SQLException e) {
				// TODO Auto-generated catch block
		    		 System.out.println("数据库异常:"+e.getMessage());
		    	 }
		    	 break;
		     case 2:	
		    	 try{
			    	 Scanner sc5=new Scanner(System.in);
				     String name1=sc5.nextLine();
			    	 boolean a=DataProcessing.deleteUser(name1);
			    	 if(a==true)
			    		System.out.println("删除成功!");
			    	 else
			    		System.out.println("删除失败!");
		    	 }catch(SQLException e){
		    		 System.out.println("数据库异常"+e.getMessage());
		    	 }
		    	 break;
		    case 3:
		    	try{
		    		System.out.println("新增用户");
			    	System.out.println("请输入用户名:");
			    	Scanner sc6=new Scanner(System.in);
				    String name2=sc6.nextLine();
			    	System.out.println("请输入密码:");
			    	Scanner sc7=new Scanner(System.in);
				    String password2=sc7.nextLine();
				    System.out.println("请输入角色:");
				    Scanner sc8=new Scanner(System.in);
				    String role2=sc8.nextLine();
				    boolean b = DataProcessing.insertUser(name2,password2,role2);
				    if(b=true)
				        System.out.println("新增用户成功!");
				    else
				    	System.out.println("此用户名已被使用");
		    	}catch(SQLException e){
		    		System.out.println("数据库异常"+e.getMessage());
		    	} 
			    break;
		    case 4:
				 try {
					 Enumeration<User> e;
					 e = DataProcessing.getAllUser();
					 while (e.hasMoreElements()) {
			    		 User o = e.nextElement();
			    		 System.out.println("Name:"+o.getName()+"   "+"Password:"+o.getPassword()+"   "+"Role:"+o.getRole()+"   "); 
			    	}
				 } catch (SQLException e) {
				 	 // TODO Auto-generated catch block
					 System.out.println("数据库异常"+e.getMessage());
				 }
		    	 break;
		    case 5:
		    	try {		    	 
		    		System.out.println("下载文件");				
		    		System.out.println("请输入档案号:");			    
		    		Scanner sc9=new Scanner(System.in);				 
		    		String str1=sc9.nextLine();				
		    		downloadFile(str1);
		    	} catch (IOException e) {				
		    		// TODO Auto-generated catch block				
		    		System.out.println("IO流异常"+e.getMessage());
		    	}
				 break;
		    case 6:
				try {
					showFileList();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("数据库异常"+e.getMessage());
				}
		     	 break;
		    case 7:
		    	try {
			    	System.out.println("修改本人密码");
			    	System.out.println("请输入新密码:");
			    	Scanner sc10=new Scanner(System.in);
					String password3=sc10.nextLine();
					changeSelfInfo(password3);
		    	}catch (SQLException e) {
					// TODO Auto-generated catch block
		    		System.out.println("数据库异常"+e.getMessage());
			}
		    	 break;
		    case 8:
		    	 return;
		  }
		}while(order!=8);			
	}
    public void adMenu(){
    	
    }
}
