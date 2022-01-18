import java.util.*;
import java.io.*;

 
class Employee implements Serializable{
   String AcNo;
   String CosName;
   String PhoneNo;
   String Dob;
   int Ammount;
   Employee(String AcNo, String CosName,String PhoneNo,String Dob,int Ammount)
   {
     this.AcNo=AcNo;
	 this.CosName=CosName;
	 this.PhoneNo=PhoneNo;
	 this.Dob=Dob;
	 this.Ammount=Ammount;
   }
   public String toString()
   {
	   return AcNo+" "+CosName+" "+PhoneNo+" "+Dob+" "+Ammount;
   }
}
//26:33
class Project{
  public static void main(String arg[]) throws IOException,ClassNotFoundException
  {
      int choice=-1;
	  ArrayList<Employee> al=new ArrayList<Employee>();
	  File file=new File("employee.txt");
	  ObjectOutputStream oos=null;
	  ObjectInputStream ois=null;
	  ListIterator li=null;
	  if(file.isFile())
	  {
		  ois=new ObjectInputStream(new FileInputStream(file));
		  al=(ArrayList<Employee>)ois.readObject();
	      ois.close();
	  }
	  
	  
	  Scanner scan=new Scanner(System.in);
	  do{
	   System.out.println("1.CREATE NEW ACCOUNTS");
	   System.out.println("2.DISPLAY ALL ACCOUNT");
	   System.out.println("3.SEARCH ACCOUNT");
	   System.out.println("4.CLOSE ACCOUNT");
	   System.out.println("5.UPDATE ACCOUNT");
	   System.out.println("6.DEPOSITE AMMOUNT");
	   System.out.println("7.DEBITED AMMOUNT");
	   System.out.println("8.EXIT THE PAGE");
	   System.out.println("9.ENTER YOUR CHOICE : ");
	   choice=scan.nextInt();
	   switch(choice)
	   {
	   
	    case 1:{
		    System.out.println("How Many Costumer Do You Want");
			int n=scan.nextInt();
			for(int i=0;i<n;i++)
			{
			scan.nextLine();
		    System.out.println("Enter Costumer Name");
			String name=scan.nextLine();
			
			
			System.out.println("Enter Account No");
			String acNo=scan.next();
			
			
			System.out.println("Enter Costumer Dob");
			String doB=scan.next();
			
			
			System.out.println("Enter Costumer Phone No");
			String phon=scan.next();
			
			System.out.println("Enter Ammount");
			int ammount=scan.nextInt();
			
		    ois=new ObjectInputStream(new FileInputStream(file));
		    al=(ArrayList<Employee>)ois.readObject();
	        ois.close();
			   
			li=al.listIterator();
			boolean found=false;
			while(li.hasNext())
			{
			    Employee e=(Employee)li.next();
				//System.out.println(acn.getClass().getSimpleName());
				
				String str=e.AcNo;
			
				if(str.equals(acNo))
				{
			    System.out.println("???   The Account No Is Already Exist");
				found=true;
				break;
				}
			}
			if(found==false)
			{
				 al.add(new Employee(acNo, name,phon,doB,ammount));
				 System.out.println("!!!! SuccessFully Created Account");
			
		    }
			
			}
			oos=new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(al);
			oos.close();
			break;
		}
        case 2:
		{
			if(file.exists())
			{
		
		    ois=new ObjectInputStream(new FileInputStream(file));
		    al=(ArrayList<Employee>)ois.readObject();
	        ois.close();
				
		    li=al.listIterator();
			int count=0;
			while(li.hasNext())
			{
				count++;
				System.out.println("--------Data Record : "+count+"----------");
				System.out.println(li.next());
				System.out.println("--------The Next Data----------");
				System.out.println();
				System.out.println();
				System.out.println();
				
			}
			}
			else{
				System.out.println();
				System.out.println();
				
			       System.out.println("!!!!!   The File Does Not Exist");	
			    System.out.println();
				System.out.println();
				
			}
            //System.out.println(al);
            break;
		}
        case 3:
		{ 
		   if(file.exists()){
			   
		    ois=new ObjectInputStream(new FileInputStream(file));
		    al=(ArrayList<Employee>)ois.readObject();
	        ois.close();
			   
			System.out.println("Enter Account Number Of The Coustumer");
			String acn=scan.next();
			li=al.listIterator();
			boolean found=false;
			while(li.hasNext())
			{
			    Employee e=(Employee)li.next();
				//System.out.println(acn.getClass().getSimpleName());
				
				String str=e.AcNo;
			
				if(str.equals(acn))
				{
			    System.out.println();
				System.out.println();
				System.out.println();
				
				System.out.println("--------Data Record : ----------");
		
      			System.out.println("Account NO:   - "+e.AcNo);
			    System.out.println("Costumer Name:- "+e.CosName);
				System.out.println("Phone No:     - "+e.PhoneNo);
				System.out.println("DOB:          - "+e.Dob);
				System.out.println("Ammount       - "+e.Ammount);
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				found=true;
				break;
				}
			}
			if(found==false)
			{
				System.out.println();
				System.out.println();
				
			       System.out.println("!!!!!!  The Record Not Found...");	
			    System.out.println();
				System.out.println();
			
		   }
		  }
		  else{
			 System.out.println();
				System.out.println();
				
			    System.out.println("!!!!!   The File Does Not Exist");	
			    System.out.println();
				System.out.println();
				
		  }
		break;
		}
        case 4:
		{
		if(file.exists()){
			   
		    ois=new ObjectInputStream(new FileInputStream(file));
		    al=(ArrayList<Employee>)ois.readObject();
	        ois.close();
			   
			System.out.println("Enter Account Number Of The Coustumer");
			String acn=scan.next();
			li=al.listIterator();
			boolean found=false;
			while(li.hasNext())
			{
			    Employee e=(Employee)li.next();
				//System.out.println(acn.getClass().getSimpleName());
				
				String str=e.AcNo;
			
				if(str.equals(acn))
				{
			
				System.out.println("--------Data Record Remover SuccessFully : ----------");
		          
      		      li.remove();
				found=true;
				break;
				}
			}
			if(found==false)
			{
				System.out.println();
				System.out.println();
				
			    System.out.println("!!!!!!  The Record Not Found...");	
			    System.out.println();
				System.out.println();
		   }else{
			   System.out.println();
				System.out.println();
			oos=new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(al);
			oos.close();
			    System.out.println("!!!!!!  SuccessFully Deleted...");	
			    System.out.println();
				System.out.println();
		   }
		  }
		  else{
			 System.out.println();
				System.out.println();
				
			       System.out.println("!!!!!   The File Does Not Exist");	
			    System.out.println();
				System.out.println();
				
		  }
		break;
		}
        case 5:
		{
			if(file.exists()){
			   
		    ois=new ObjectInputStream(new FileInputStream(file));
		    al=(ArrayList<Employee>)ois.readObject();
	        ois.close();
			   
			System.out.println("Enter Account Number To Update The Data");
			String acn=scan.next();
			li=al.listIterator();
			boolean found=false;
			while(li.hasNext())
			{
			    Employee e=(Employee)li.next();
				String strAcNo=e.AcNo;
			
				if(strAcNo.equals(acn))
				{
			scan.nextLine();
			System.out.println("Enter Costumer Name");
			String name=scan.nextLine();
			
			
			System.out.println("Enter Costumer Dob");
			String doB=scan.next();
			
			
			System.out.println("Enter Costumer Phone No");
			String phon=scan.next();
			
			System.out.println("Enter Ammount");
			int ammount=scan.nextInt();
			
		          
      		      li.set(new Employee(strAcNo, name,phon,doB,ammount));
				found=true;
				break;
				}
			}
			if(found==false)
			{
				System.out.println();
				System.out.println();
				
			    System.out.println("!!!!!!  The Record Not Found...");	
			    System.out.println();
				System.out.println();
		   }else{
			   System.out.println();
				System.out.println();
			oos=new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(al);
			oos.close();
			    System.out.println("!!!!!!  Record SuccessFully Updated...");	
			    System.out.println();
				System.out.println();
		   }
		  }
		  else{
			 System.out.println();
				System.out.println();
				
			       System.out.println("!!!!!   The File Does Not Exist");	
			    System.out.println();
				System.out.println();
				
		  }
        break;	
		}	
        case 6:{
            if(file.exists()){
			
			  String AcNo;
   String CosName;
   String PhoneNo;
   String Dob;
   int Ammount;
			
		    ois=new ObjectInputStream(new FileInputStream(file));
		    al=(ArrayList<Employee>)ois.readObject();
	        ois.close();
			   
			System.out.println("Enter Account Number To Deposite The Ammount");
			String acn=scan.next();
			li=al.listIterator();
			boolean found=false;
			while(li.hasNext())
			{
			    Employee e=(Employee)li.next();
				String strAcNo=e.AcNo;
			
				if(strAcNo.equals(acn))
				{
			scan.nextLine();
	
			
			System.out.println("How Much Ammount Do You Want To Deposite");
			int ammount=scan.nextInt();
			
		          ammount=e.Ammount+ammount;
      		      li.set(new Employee(strAcNo, e.CosName,e.PhoneNo,e.Dob,ammount));
				found=true;
				break;
				}
			}
			if(found==false)
			{
				System.out.println();
				System.out.println();
				
			    System.out.println("!!!!!!  The Record Not Found...");	
			    System.out.println();
				System.out.println();
		   }else{
			   System.out.println();
				System.out.println();
			oos=new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(al);
			oos.close();
			    System.out.println("!!!!!!  Ammount SuccessFully Deposited...");	
			    System.out.println();
				System.out.println();
		   }
		  }
		  else{
			 System.out.println();
				System.out.println();
				
			       System.out.println("!!!!!   The File Does Not Exist");	
			    System.out.println();
				System.out.println();
				
		  }
            break;			
		}
		case 7:
		{ if(file.exists()){
			
			  String AcNo;
   String CosName;
   String PhoneNo;
   String Dob;
   int Ammount;
			
		    ois=new ObjectInputStream(new FileInputStream(file));
		    al=(ArrayList<Employee>)ois.readObject();
	        ois.close();
			   
			System.out.println("Enter Account Number To Deposite The Ammount");
			String acn=scan.next();
			li=al.listIterator();
			boolean found=false;
			while(li.hasNext())
			{
			    Employee e=(Employee)li.next();
				String strAcNo=e.AcNo;
			
				if(strAcNo.equals(acn))
				{
			scan.nextLine();
	
			
			System.out.println("How Much Ammount Do You Want To Credit");
			int ammount=scan.nextInt();
			
		          ammount=e.Ammount-ammount;
      		      li.set(new Employee(strAcNo, e.CosName,e.PhoneNo,e.Dob,ammount));
				found=true;
				break;
				}
			}
			if(found==false)
			{
				System.out.println();
				System.out.println();
				
			    System.out.println("!!!!!!  The Record Not Found...");	
			    System.out.println();
				System.out.println();
		   }else{
			   System.out.println();
				System.out.println();
			oos=new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(al);
			oos.close();
			    System.out.println("!!!!!! The Ammount SuccessFully Debited...");	
			    System.out.println();
				System.out.println();
		   }
		  }
		  else{
			 System.out.println();
				System.out.println();
				
			       System.out.println("!!!!!   The File Does Not Exist");	
			    System.out.println();
				System.out.println();
				
		  }
            break;	
		}
		case 8:
		{
			System.exit(0);
			break;
		}
			
			
	   }
	  }
	  while(choice!=-1);
  }
}