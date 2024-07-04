import java.io.*;
import java.lang.Math;
import java.util.*;

public class Solution
{
	public BufferedReader in;
	public PrintStream out;
	
	public boolean log_enabled = true;
	
	int N;
	
	public int[][] gen_simple()
	{
		int[][] R = new int[N][N];
		for (int i=0; i<N; i++)
		{
			for (int j=0; j<N; j++)
			{
				R[i][j] = (N+j-i) % N;
			}
		}
		
		return R;
	}
	
	public int[][] permc(int[][] M, int ... P)
	{
		int[][] R = new int[N][N];
		for (int i=0; i<N; i++)
		{
			for (int j=0; j<N; j++)
			{
				R[i][j] = P[M[i][j]];
			}
		}
		return R;
	}
	
	public int[][] perm(int[][] M, int[] P)
	{
		int[][] R = new int[N][N];
		for (int i=0; i<N; i++)
		{
			for (int j=0; j<N; j++)
			{
				R[i][j] = P[M[i][j]];
			}
		}
		return R;
	}
	
	public int[] gen_perm(int ... S)
	{
		
		int []P = new int[N];
		Arrays.fill(P, 0);
		
		boolean[] used = new boolean[N+1];
		Arrays.fill(used, false);
		
		int i;		
		for (i=0; i<S.length/2; i++)
		{
			//logWrite("P[%d] = %d\n", S[2*i], S[2*i+1]);
			
			P[S[2*i]] = S[2*i+1];
			used[S[2*i+1]] = true;
		
			
			
		}
		
		int f = 0;
		for (i=0; i<N; i++)
		{
			if (P[i]==0)
			{
				do{
					f ++;
				}
				while (used[f]);
				P[i] = f;
			}
		}
		
		return P;
	}
	
	public int[][] shift(int[][] M, int k)
	{
		int[][] R = new int[N][N];
		for (int i=0; i<N; i++)
		{
			for (int j=0; j<N; j++)
			{
				if (i<k)
				{
					R[i][j] = M[i][j];
				}
				else if (i==k)
				{
					R[i][j] = M[N-1][j];
				}
				else 
				{
					R[i][j] = M[i-1][j];
				}
			}
		}
		return R;
	}
	
	
	
	public void output(int[][] M){
		for (int i=0; i<N; i++)
		{
			out.printf("%d", M[i][0]);
			for (int j=1; j<N; j++)
			{
				out.printf(" %d", M[i][j]);
			}
			out.printf("\n");
		}
	}
	
	private class TestCase{
		
		public int caseNumber;
		TestCase(int number){
			caseNumber = number;
		}
		
		public void run()
		{
			N = readInt();
			int K = readInt();
			
			int[][] M = get(K);
			if (M==null)
			{
				out.printf("Case #%d: IMPOSSIBLE\n", caseNumber);
			}
			else{
				out.printf("Case #%d: POSSIBLE\n", caseNumber);
				output(M);
			}
		}
		
		public int[][] get(int K)
		{
			switch (N)
			{
				case 2:
					switch (K)					
					{
						case 2:
							return permc(gen_simple(), 1, 2);
						case 4:
							return permc(gen_simple(), 2, 1);
						default:
							return null;
					}
					
				case 3:
					switch (K) {
						case 3:
							return permc(gen_simple(), 1, 2, 3);
						case 6:
							return permc(gen_simple(), 2, 1, 3);
						case 9:
							return permc(gen_simple(), 3, 1, 2);
						default:
							return null;
					}
					
				default:
				
					if (K==N)
					{
						return perm(gen_simple(), gen_perm());
					}
					
					if (K % N == 0)
					{
						return perm(gen_simple(), gen_perm(0, K/N));
					}
				
					if (( K == N+2)&&(N==4))
					{
						return perm(new int[][]{
								{0,1,2,3},
								{1,0,3,2},
								{2,3,1,0},
								{3,2,0,1}
							}, gen_perm());
					}
					
					if (( K == N*N-2)&&(N==4))
					{
						return perm(new int[][]{
								{0,1,2,3},
								{1,0,3,2},
								{2,3,1,0},
								{3,2,0,1}
							}, gen_perm(0,4,1,3));
					}
					
					if (( K == N+2)&&(N==5))
					{
						return perm(new int[][]{
								{0,1,4,2,3},
								{2,0,1,3,4},
								{1,3,0,4,2},
								{3,4,2,1,0},
								{4,2,3,0,1}
							}, gen_perm());
					}
					
					
					if (( K == N*N-2)&&(N==5))
					{
						return perm(new int[][]{
								{0,1,4,2,3},
								{2,0,1,3,4},
								{1,3,0,4,2},
								{3,4,2,1,0},
								{4,2,3,0,1}
							}, gen_perm(0,5,1,4));
					}
					
					if  (K <= N+2 )
					{
						return null;
					}
					
					if (K >= N*N-2)
					{
						return null;
					}
					
					int g = 1;
					int z = (K-1) / (N-1);
					
					if (z==1)
					{
						g = 3;
					}
					
					while (z==N)
					{
						g++;
						z = (K-g) / (N-1);
						
						/*if (z==g)
						{
							out.printf("error 1");
						}
						
						if (g>N)
						{
							out.printf("error 2");
						}*/
					}
					
					//out.printf("Z = %d\n", z);
					
					int b = (K-g) % (N-1);
					
					int z2 = z+1;
					
					if (b == 0)
					{
						if (g>1)
						{
							g --;
							b = 1;
						}
						else if (z>3)
						{
							z2 = z-1;
							g = 2;
							b = 1;
						}
						else if (z==2){
							g = 3;
							z2 = 1;
							b = 2;
						}
						// z==3
						else if (N==4)
						{
							return perm(new int[][]{
								{0,3,1,2},
								{2,1,3,0},
								{3,0,2,1},
								{1,2,0,3}
							}, gen_perm());
						}
						else
						{ 
							g = 4;
							z2 = 2;
							b = 3;
						}
					}
					
					int a = N-1 - b;
					
					int[][] M = shift(gen_simple(), a);
					
					return perm(M, gen_perm(0, z, 1, z2, M[a][a], g));
					
 			}
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

