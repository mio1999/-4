import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class DocSystem {
     public static void main(String[] args){
    	int order;
    	do{ 
		    System.out.println("****��ӭ��������ϵͳ****");
		    System.out.println("       1.��½");
		    System.out.println("       2.�˳�");
		    System.out.println("***********************");
		    System.out.print("������ָ��:");
		    Scanner sc1=new Scanner(System.in);
			order=sc1.nextInt();
		    switch(order){
		      case 1:
		    	  System.out.print("�������û���:");
		    	  Scanner sc2=new Scanner(System.in);
		    	  String name=sc2.nextLine();
		    	  System.out.print("����������:");
		    	  Scanner sc3=new Scanner(System.in);
		    	  String password=sc3.nextLine();
		    	  User a;
				  try {
					 a = DataProcessing.searchUser(name,password);
					 if(a!=null){
			        	  a.showMenu();
			          }
					 else{
			    		  System.out.println("�˺������������");
			    	  }
				  }catch (SQLException e) {
					 // TODO Auto-generated catch block
					 System.out.println("���ݿ��쳣:"+e.getMessage());
				  }
				  break;
		      case 2:
		    	 System.out.println("ϵͳ�˳�, ллʹ�� ! ");
		  		 System.exit(0);
		      }
		}while(order!=2);   
    }
}


