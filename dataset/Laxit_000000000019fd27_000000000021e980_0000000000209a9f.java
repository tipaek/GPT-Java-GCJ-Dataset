
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc= new Scanner(System.in);
		int test = sc.nextInt();
		int temp=1;
		while(temp<=test)
		{
		    String str = sc.next();
		    int n = str.length();
		    StringBuffer ans = new StringBuffer();
		    
		    int rem = Integer.parseInt(""+str.charAt(0));
		    for(int i=0;i<n;i++)
		    {
		        int val = Integer.parseInt(""+str.charAt(i));
		        
		        if(val>rem) {
		            for(int j=1;j<=rem;j++)
		            ans.append(')');
		            rem=0;       
		        }
		        else {
		            for(int j=1;j<=rem-val;j++)
		               ans.append(')');
		            rem = val;
		        }
		        
		      
		        if(rem == 0 || i == 0) {
		            for(int j=1;j<=val;j++)
		               ans.append('(');
		            rem = val;     
		        }
		           
		        ans.append(""+val);     
		    }
		    for(int j=1;j<=rem;j++)
		       ans.append(')');
		    
		    System.out.println("Case #"+temp+": "+ans);
		    temp++;
		}
	}
}





















