import java.io.*;
import java.util.*;
public class Solution{
	public static void main(String[]args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		for(int t=0;t<tc;t++)
		{
    		String test=sc.next();
    		
    		String result="";
    		
    		int starting=0;
    		
    		for(int i=0;i<test.length();i++)
    		{
    		    int num=test.charAt(i)-'0';
    		    
    		    if(starting>num)
    		    {
    		        int diff=starting-num;
    		        starting=num;
    		        
    		        for(int j=0;j<diff;j++)
    		        {
    		            result=result+")";
    		        }
    		        
    		    }
    		    else
    		    {
    		        int diff=num-starting;
    		        starting=num;
    		        
    		        for(int j=0;j<diff;j++)
    		        {
    		            result=result+"(";
    		        }
    		        
    		        
    		    }
    		    
    		    result=result+test.charAt(i);
    		}
    		
    		for(int j=0;j<starting;j++)
    		{
    		    result=result+")";
    		}
    		System.out.println("Case #"+(t+1)+": "+result);
    	}
    }
}