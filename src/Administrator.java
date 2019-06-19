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
		  System.out.println("****��ӭ��������Ա����ϵͳ****");
		  System.out.println("       1.�޸��û�");	
          System.out.println("       2.ɾ���û�");
	      System.out.println("       3.�����û� ");
	      System.out.println("       4.�г��û�");
	      System.out.println("       5.�����ļ�");
	      System.out.println("       6.�ļ��б�");
	      System.out.println("       7.�޸�����");
	      System.out.println("       8.�˳�");
	      System.out.println("*****************************");
	      System.out.println("������ָ��:");
	      Scanner sc1=new Scanner(System.in);
	      order=sc1.nextInt();
		  switch(order){
		     case 1:
		    	 try {
			    	 System.out.println("�޸��û�");
			    	 System.out.println("�������û���:");
			    	 Scanner sc2=new Scanner(System.in);
				     String name=sc2.nextLine();
			    	 System.out.println("����������:");
			    	 Scanner sc3=new Scanner(System.in);
				     String password=sc3.nextLine();
				     System.out.println("�������ɫ:");
			    	 Scanner sc4=new Scanner(System.in);
				     String role=sc4.nextLine();
					 DataProcessing.updateUser(name,password,role);
					 if(DataProcessing.updateUser(name,password,role)==true){
			    		 System.out.println("�޸ĳɹ�");
			    	 }
		    	 } catch (SQLException e) {
				// TODO Auto-generated catch block
		    		 System.out.println("���ݿ��쳣:"+e.getMessage());
		    	 }
		    	 break;
		     case 2:	
		    	 try{
			    	 Scanner sc5=new Scanner(System.in);
				     String name1=sc5.nextLine();
			    	 boolean a=DataProcessing.deleteUser(name1);
			    	 if(a==true)
			    		System.out.println("ɾ���ɹ�!");
			    	 else
			    		System.out.println("ɾ��ʧ��!");
		    	 }catch(SQLException e){
		    		 System.out.println("���ݿ��쳣"+e.getMessage());
		    	 }
		    	 break;
		    case 3:
		    	try{
		    		System.out.println("�����û�");
			    	System.out.println("�������û���:");
			    	Scanner sc6=new Scanner(System.in);
				    String name2=sc6.nextLine();
			    	System.out.println("����������:");
			    	Scanner sc7=new Scanner(System.in);
				    String password2=sc7.nextLine();
				    System.out.println("�������ɫ:");
				    Scanner sc8=new Scanner(System.in);
				    String role2=sc8.nextLine();
				    boolean b = DataProcessing.insertUser(name2,password2,role2);
				    if(b=true)
				        System.out.println("�����û��ɹ�!");
				    else
				    	System.out.println("���û����ѱ�ʹ��");
		    	}catch(SQLException e){
		    		System.out.println("���ݿ��쳣"+e.getMessage());
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
					 System.out.println("���ݿ��쳣"+e.getMessage());
				 }
		    	 break;
		    case 5:
		    	try {		    	 
		    		System.out.println("�����ļ�");				
		    		System.out.println("�����뵵����:");			    
		    		Scanner sc9=new Scanner(System.in);				 
		    		String str1=sc9.nextLine();				
		    		downloadFile(str1);
		    	} catch (IOException e) {				
		    		// TODO Auto-generated catch block				
		    		System.out.println("IO���쳣"+e.getMessage());
		    	}
				 break;
		    case 6:
				try {
					showFileList();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("���ݿ��쳣"+e.getMessage());
				}
		     	 break;
		    case 7:
		    	try {
			    	System.out.println("�޸ı�������");
			    	System.out.println("������������:");
			    	Scanner sc10=new Scanner(System.in);
					String password3=sc10.nextLine();
					changeSelfInfo(password3);
		    	}catch (SQLException e) {
					// TODO Auto-generated catch block
		    		System.out.println("���ݿ��쳣"+e.getMessage());
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
