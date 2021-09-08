package Signup;

import java.io.*;

public class read
{
	private static RandomAccessFile raf;

	public static void main(String[] args)throws Exception
	{
        File f =new File("D:\\Pranav\\Java workspace\\Login_System\\creds.txt");
        String text = "";
        String search="pranav12";
		int countbuffer=0, countline=0;
		int b=0,a;
		String line="";
		try{
        raf = new RandomAccessFile(f,"rw");
		while((line=raf.readLine()) != null )
		{
			countline++;
			String[]words = line.split(" ");
			for(String word: words)
			{
				if (word.equals(search)) 
				{
                    countbuffer++;
				}
				if(countbuffer>0)
				{
					countbuffer=0;
					b+=countline;
				}
			}
		}
        raf = new RandomAccessFile(f,"rw");
		for(a=1;a<12;a++)
		{
			if(a == b)
			{
				text =raf.readLine(); 
			}
			else{
				raf.readLine();
			}
		}
		int c= search.length();
		String check= text.substring(c+1);
		System.out.println("Word is--"+check);
		System.out.println("Word found at--"+b);
		System.out.println(c);
		}catch(IOException e) {
			e.printStackTrace();
			}
	}    
}    
