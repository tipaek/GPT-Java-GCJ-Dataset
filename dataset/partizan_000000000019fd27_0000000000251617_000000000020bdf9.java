import java.io.*;
import java.lang.Math;
import java.util.*;

public class Solution
{
	public BufferedReader in;
	public PrintStream out;
	
	public boolean log_enabled = true;
	
	private class Act implements Comparable<Act>
	{
		int S, E, idx;
				
		Act(int i)
		{
			idx = i;
			S = readInt();
			E = readInt();
		}
		
		public int compareTo(Act x)
		{
			return S - x.S;
		}
	}
	
	private class TestCase{
		
		public int caseNumber;
		TestCase(int number){
			caseNumber = number;
		}
		
		public void run()
		{
			int i, N = readInt();
			Act[] A = new Act[N];
			for (i=0; i<N; i++)
			{
				A[i] = new Act(i);
			}
			
			Arrays.sort(A);
			
			int J_free = 0;
			int C_free = 0;
			
			char[] B = new char[N];
			
			for (i=0; i<N; i++)
			{
				if (J_free <= A[i].S)
				{
					B[A[i].idx] = 'J';
					J_free = A[i].E;
				}
				else if (C_free <= A[i].S)
				{
					B[A[i].idx] = 'C';
					C_free = A[i].E;
				}
				else{
					out.printf("Case #%d: IMPOSSIBLE\n", caseNumber);
					return;
				}
			}
			
			out.printf("Case #%d: %s\n", caseNumber, new String(B));
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

