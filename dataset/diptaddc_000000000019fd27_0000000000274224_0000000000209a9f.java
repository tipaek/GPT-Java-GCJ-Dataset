import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    for(int testCase = 1; testCase <= t; testCase++)
	    {
	        String [] str = br.readLine().split("");
	        StringBuffer sb = new StringBuffer("");
	        int balance = 0;
	        for(int i =0; i<str.length; i++)
	        {
	            int x = Integer.parseInt(str[i]);
	            while(balance < x)
	            {
	                sb.append("(");
	                balance++;
	            }
	            while(balance > x)
	            {
	                sb.append(")");
	                balance--;
	            }
	            sb.append(x);
	        }
	        while(balance > 0)
	        {
	            sb.append(")");
	            balance--;
	        }
	        System.out.println("Case #" + testCase + ": " + sb.toString());
	    }
	}
}