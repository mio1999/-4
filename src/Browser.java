import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
public class Browser extends User {
	Browser(String name, String password, String role) {
		super(name, password, role);		
	}
	public void showMenu() {
		int order;
        do{
    	  System.out.println("****欢迎来到档案员浏览系统****");
          System.out.println("       1.下载文件");
  	      System.out.println("       2.文件列表 ");
  	      System.out.println("       3.修改密码 ");
  	      System.out.println("       4.退出");
  	      System.out.println("*****************************");
  	      System.out.println("请输入指令:");
  	      Scanner sc1=new Scanner(System.in);
  	      order=sc1.nextInt();
    	  switch(order){
    	    case 1:
				try{
		    	   System.out.println("下载文件");
		           System.out.println("请输入档案号:");
				   Scanner sc2=new Scanner(System.in);
				   String str1=sc2.nextLine();
				   downloadFile(str1);
				   System.out.println("下载成功!");
				}catch(IOException e){
				   System.out.println("IO流异常:"+e.getMessage());
				}
				break;
    	    case 2:
				try {
					showFileList();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("数据库异常:"+e.getMessage());
				}
		    	break;
    	    case 3:
    	    	try {
		    	  System.out.println("修改本人密码");
		    	  System.out.println("请输入新密码:");
		    	  Scanner sc3=new Scanner(System.in);
				  String str2=sc3.nextLine();
				  changeSelfInfo(str2);
    	    	} catch (SQLException e) {
    	    		// TODO Auto-generated catch block			
    	    		System.out.println("数据库异常:"+e.getMessage());		
    	    	}
		    	  break;	
    	    case 4:
    	    	return;
    	  }
        }while(order!=4);
	}
}
