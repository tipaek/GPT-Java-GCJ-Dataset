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
			int N = readInt();
			int[][] M = new int[N][N];
			
			int i, j, t = 0;
			for (i=0; i<N; i++)
			{
				readIntArray(M[i], N);
				t += M[i][i];
			}
			
			int c = 0;
			int r = 0;
			
			boolean[] used = new boolean[N+1];
			
			for (i=0; i<N; i++)
			{
				Arrays.fill(used, false);
				for (j=0; j<N; j++)
				{
					if (used[M[i][j]])
					{
						r ++;
						break;
					}
					used[M[i][j]] = true;
				}
			}
			
			for (i=0; i<N; i++)
			{
				Arrays.fill(used, false);
				for (j=0; j<N; j++)
				{
					if (used[M[j][i]])
					{
						c ++;
						break;
					}
					used[M[j][i]] = true;
				}
			}
			
			out.printf("Case #%d: %d %d %d\n", caseNumber, t, r, c);
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

