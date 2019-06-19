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
    	  System.out.println("****��ӭ��������Ա���ϵͳ****");
          System.out.println("       1.�����ļ�");
  	      System.out.println("       2.�ļ��б� ");
  	      System.out.println("       3.�޸����� ");
  	      System.out.println("       4.�˳�");
  	      System.out.println("*****************************");
  	      System.out.println("������ָ��:");
  	      Scanner sc1=new Scanner(System.in);
  	      order=sc1.nextInt();
    	  switch(order){
    	    case 1:
				try{
		    	   System.out.println("�����ļ�");
		           System.out.println("�����뵵����:");
				   Scanner sc2=new Scanner(System.in);
				   String str1=sc2.nextLine();
				   downloadFile(str1);
				   System.out.println("���سɹ�!");
				}catch(IOException e){
				   System.out.println("IO���쳣:"+e.getMessage());
				}
				break;
    	    case 2:
				try {
					showFileList();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("���ݿ��쳣:"+e.getMessage());
				}
		    	break;
    	    case 3:
    	    	try {
		    	  System.out.println("�޸ı�������");
		    	  System.out.println("������������:");
		    	  Scanner sc3=new Scanner(System.in);
				  String str2=sc3.nextLine();
				  changeSelfInfo(str2);
    	    	} catch (SQLException e) {
    	    		// TODO Auto-generated catch block			
    	    		System.out.println("���ݿ��쳣:"+e.getMessage());		
    	    	}
		    	  break;	
    	    case 4:
    	    	return;
    	  }
        }while(order!=4);
	}
}
