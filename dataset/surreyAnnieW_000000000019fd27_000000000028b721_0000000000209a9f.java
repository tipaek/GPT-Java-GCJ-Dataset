import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static boolean isTest = false;
	
	public static void main(String[] args) throws Exception
	{
		
        	Scanner scan = getScanner();
        	String x = scan.nextLine();
        	int T = Integer.parseInt(x);
		for (int i = 0; i < T; i++)
		{
        		x = scan.nextLine();
        		int p = 0;
        		StringBuffer out = new StringBuffer();
        		for (int j=0; j < x.length(); j++)
        		{
        			int a = Integer.parseInt("" + x.charAt(j));
        			if ( a > p)
        			{
        				for (int k = 0; k < a-p; k ++)
        					out.append("(");
        			}else if (a < p)
        			{
        				for (int k = 0; k < p-a; k ++)
        					out.append(")");
        			}        			
        			out.append(a);
        			if ( j == x.length() - 1)
        			{
        				for (int k = 0; k < a; k ++)
        					out.append(")");
        			}
        			p = a;
        		}
        		System.out.println("Case #" + (i+1) + ": " + out.toString());
        	}
	}
	
	static Scanner getScanner() throws Exception
	{
		if (isTest)
			return new Scanner(new File("input.txt"));
		else
			return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
        
        static void debug(String s)
        {
        	if(isTest)
        		System.out.println(s);
        }
}

  