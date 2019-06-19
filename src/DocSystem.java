import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class DocSystem {
     public static void main(String[] args){
    	int order;
    	do{ 
		    System.out.println("****欢迎来到档案系统****");
		    System.out.println("       1.登陆");
		    System.out.println("       2.退出");
		    System.out.println("***********************");
		    System.out.print("请输入指令:");
		    Scanner sc1=new Scanner(System.in);
			order=sc1.nextInt();
		    switch(order){
		      case 1:
		    	  System.out.print("请输入用户名:");
		    	  Scanner sc2=new Scanner(System.in);
		    	  String name=sc2.nextLine();
		    	  System.out.print("请输入密码:");
		    	  Scanner sc3=new Scanner(System.in);
		    	  String password=sc3.nextLine();
		    	  User a;
				  try {
					 a = DataProcessing.searchUser(name,password);
					 if(a!=null){
			        	  a.showMenu();
			          }
					 else{
			    		  System.out.println("账号密码输入错误！");
			    	  }
				  }catch (SQLException e) {
					 // TODO Auto-generated catch block
					 System.out.println("数据库异常:"+e.getMessage());
				  }
				  break;
		      case 2:
		    	 System.out.println("系统退出, 谢谢使用 ! ");
		  		 System.exit(0);
		      }
		}while(order!=2);   
    }
}


