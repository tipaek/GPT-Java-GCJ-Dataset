import java.io.*;
import java.lang.Math;
import java.util.*;

public class Solution
{
	public BufferedReader in;
	public PrintStream out;
	
	public boolean log_enabled = true;
	
	private class TestCase{
		
		public int caseNumber;
		TestCase(int number){
			caseNumber = number;
		}
		
		public void run()
		{
			String s = readLn();
			String r = "";
			
			int i, d = 0, x, j;
			for (i=0; i<s.length(); i++)
			{
				x = s.charAt(i) - '0';
				if (x > d)
				{
					for (j=0; j<x-d; j++)
					{
						r = r + "(";
					}
				}
				
				if (x < d)
				{
					for (j=0; j<d-x; j++)
					{
						r = r + ")";
					}
				}
				
				d = x;
				
				r = r + s.charAt(i);
			}
			
			if (d > 0)
			{
				for (j=0; j<d; j++)
				{
					r = r + ")";
				}
			}
			
			out.printf("Case #%d: %s\n", caseNumber, r);
		}
		
	}
		
    
	public void run()
	{
		try
		{
			in = new BufferedReader(new InputStreamReader(System.in));
			out = System.out;
			
			//in = new BufferedReader(new FileReader("in.txt"));
			//out = new PrintStream(new File("out.txt"));
			
			
		}
		catch (Exception e)
		{
			return;
		}
		
		//while (true)
		{
			int t = readInt(); for (int i=0; i<t; i++)					
			{
				TestCase T = new TestCase(i+1);
				T.run();
			}
		}
	}
	
	public static void main(String args[])
	{
		Locale.setDefault(Locale.US);
		new Solution().run();
	}
	
	private StringTokenizer tokenizer = null;
	
	public int readInt() 
	{
        return Integer.parseInt(readToken());
    }
   
    public long readLong() 
	{
        return Long.parseLong(readToken());
    }
   
    public double readDouble() 
	{
        return Double.parseDouble(readToken());
    }
   
	public String readLn()
	{	
		try
		{
			String s;
			while ((s = in.readLine()).length()==0);
			return s;
		}
		catch (Exception e)
		{
			return "";
		}
	}
	
    public String readToken() 
	{
		try
		{
			while (tokenizer == null || !tokenizer.hasMoreTokens()) 
			{
				tokenizer = new StringTokenizer(in.readLine());
			}
			return tokenizer.nextToken();
		}
		catch (Exception e)
		{
			return "";
		}
    }
	
	public int[] readIntArray(int n)
	{
		int[] x = new int[n];
		readIntArray(x, n);
		return x;
	}
	
	public void readIntArray(int[] x, int n)
	{
		for (int i=0; i<n; i++)
		{
			x[i] = readInt();
		}
	}
	
	public void logWrite(String format, Object... args)
	{
		if (!log_enabled)
		{
			return;
		}
		
		out.printf(format, args);
	}
}

