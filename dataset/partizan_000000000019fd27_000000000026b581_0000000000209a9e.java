import java.io.*;
import java.lang.Math;
import java.util.*;

public class Solution
{
	public BufferedReader in;
	public PrintStream out;
	
	public boolean log_enabled = true;
	
	int B;
	char[] Z;
	
	private class TestCase{
		
		public int caseNumber;
		TestCase(int number){
			caseNumber = number;
		}
		
		public int request(int P)
		{
			out.println(P+1);
			return readInt();
		}
		
		/*int rcount = 0;
		public int request(int P)
		{
			rcount ++;
			
			if (rcount % 10 == 1)
			{
				if (rcount % 2 == 1)
				{
					for (int i=0; i<B; i++)
					{
						Z[i] ^= 1;
					}
				}
				
				if (rcount % 3 == 1)
				{
					for (int i=0; i<B/2; i++)
					{
						char c = Z[i];
						Z[i] = Z[B-i-1];
						Z[B-i-1] = c;
					}
				}
			}
			
			return Z[P];
			
		}*/
		
		public void run()
		{
			int i,j;
			
			int[] same_master = new int[B / 10];
			int[] dif_master = new int[B / 10];
			
			int[] mdiff = new int[B];
			int[] R = new int[B];
			
			int a, b, k, sX=0, dX=0;
			for (i=0; i<B/10; i++)
			{
				same_master[i] = -1;
				dif_master[i] = -1;
				for (j=0; j<5; j++)
				{
					k = 5*i + j;
					a = request(k);
					b = request(B - k -1 );
					
					if (a == b)
					{
						R[k] = 0;
						
						if (same_master[i]==-1)
						{
							same_master[i] = k;
							mdiff[k] = 0;
							sX = a;
						}
						else
						{
							mdiff[k] = a == sX ? 0 : 1;
						}
					}
					else
					{
						R[k] = 1;
						if (dif_master[i]==-1)
						{
							dif_master[i] = k;
							mdiff[k] = 0;
							dX = a;
						}
						else
						{
							mdiff[k] = a == dX ? 0 : 1;
						}
					}
				}
			}
			
			int same_main = -1;
			int dif_main = -1;
			
			sX = 0;
			dX = 0;
			
			int r = 0;
			int[] msdiff = new int[B];
			for (i=0; i<B/10;i++)
			{
				if (same_master[i] > -1)
				{
					a = request( same_master[i] );
					if (same_main==-1)
					{
						same_main = same_master[i];
						sX = a;
						msdiff[same_master[i]] = 0;
					}
					else
					{
						msdiff[same_master[i]] = a == sX ? 0 : 1;
					}
					r ++;
				}
			}
			if (r > 0)
			{
				for (i=r; i<10; i++) request(0);
			}
			
			for (i=0; i<B/10;i++)
			{
				if (dif_master[i] > -1)
				{
					a = request( dif_master[i] );
					if (dif_main==-1)
					{
						dif_main = dif_master[i];
						dX = a;
						msdiff[dif_master[i]] = 0;
					}
					else
					{
						msdiff[dif_master[i]] = a == dX ? 0 : 1;
					}
					r ++;
				}
			}
			
			if (r > 8)
			{
				for (i=r; i<10; i++) request(0);
			}
			
			if (same_main > -1)
			{
				sX = request(same_main);
			}
			
			if (dif_main > -1)
			{
				dX = request(dif_main);
			}
			
			char[] X = new char[B];
			for (i=0; i<B/2; i++)
			{
				k = i / 5;
				if (R[i]==0)
				{
					X[i] = (char)('0' + (sX ^ mdiff[i] ^ msdiff[same_master[k]]));
					X[B-i-1] = X[i];
				}
				else
				{
					X[i] = (char)('0' + (dX ^ mdiff[i] ^ msdiff[dif_master[k]]));
					X[B-i-1] = X[i] == '0' ? '1' : '0';
				}
			}
			
			/*for (i=0; i<B; i++)
			{
				Z[i] += '0';
			}*/
			
			out.printf("%s\n", new String(X));
			readLn();
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
			int t = readInt(); 
			B = readInt();
			
			/*String S = readLn();			
			Z = new char[B];
			for (int i=0; i<B; i++)					
			{
				Z[i] = (char)(S.charAt(i) - '0');
			}
			*/
			
			for (int i=0; i<t; i++)					
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

