import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int t= scn.nextInt();
        Random ra = new Random();
        Writer writer = new PrintWriter(System.out);
        long a = scn.nextLong(),b =scn.nextLong();
        while(t!=0)
        {
        	int tc=1;
        	while(tc<=300)
        	{
        		long x =ra.nextInt((999999995 - (-999999995)) + 1) -999999995;
        		long y=ra.nextInt((999999995 - (-999999995)) + 1) -999999995;
        		System.out.println(x +" "+ y);
        		try {
        		writer.flush();
        		}  catch (Exception e) { 
                    System.out.println(e); 
                }
        		String r = scn.next();
        		if(r.equals("CENTER"))
        		{
        			break;
        		}
        		else if(r.equals("HIT") || r.equals("MISS"))
        		{
        			
        		tc++;	
        		}
        	}
        	t--;
        }
        
       
	}

}