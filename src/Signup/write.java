package Signup;

import java.io.FileWriter;
import java.io.PrintWriter;

public class write {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileWriter fw=new FileWriter("C:\\Users\\Nagaraj\\Desktop\\credentials.txt");  
			PrintWriter pw=new PrintWriter(fw);
	        pw.println("enter username");
	        
	        pw.println("enter password");
	        fw.close();
		}catch(Exception e)
		{System.out.println(e);}
		System.out.println("Success");
	}

}
