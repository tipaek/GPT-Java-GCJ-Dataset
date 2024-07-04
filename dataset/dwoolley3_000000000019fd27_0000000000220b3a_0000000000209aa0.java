import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList


public class Solution
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args)  {
		new Solution().run();
	}
	
	void run()
	{		
		in = new FastReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int n = in.nextInt();
			int k = in.nextInt();
			String IMPOSSIBLE = "IMPOSSIBLE";
			String POSSIBLE = "POSSIBLE";
			
			if (n == 2) {
				if (k == 2) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("1 2");
					out.println("2 1");
				} else if (k == 4) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("2 1");
					out.println("1 2");
				}
				else {
					out.println("Case #" + tc + ": " + IMPOSSIBLE);
				}
			}
			else if (n == 3) {
				if (k == 3) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("1 3 2");
					out.println("2 1 3");
					out.println("3 2 1");
				} 
				else if (k == 6) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("2 3 1");
					out.println("1 2 3");
					out.println("3 1 2");
				}
				else if (k == 9) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("3 2 1");
					out.println("1 3 2");
					out.println("2 1 3");
				}
				else {
					out.println("Case #" + tc + ": " + IMPOSSIBLE);
				}
			}
			else if (n == 4) {
				if (k == 4) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("1 2 3 4");
					out.println("4 1 2 3");
					out.println("3 4 1 2");
					out.println("2 3 4 1");
				} 
				else if (k == 8) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("2 3 4 1");
					out.println("1 2 3 4");
					out.println("4 1 2 3");
					out.println("3 4 1 2");
				} 		
				else if (k == 12) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("3 4 1 2");
					out.println("2 3 4 1");
					out.println("1 2 3 4");
					out.println("4 1 2 3");
				} 					
				else if (k == 16) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("4 1 2 3");
					out.println("3 4 1 2");
					out.println("2 3 4 1");
					out.println("1 2 3 4");
				}
				else {
					out.println("Case #" + tc + ": " + IMPOSSIBLE);
				}
			}
			else if (n == 5) {
				if (k == 5) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("1 2 3 4 5");
					out.println("5 1 2 3 4");
					out.println("4 5 1 2 3");
					out.println("3 4 5 1 2");
					out.println("2 3 4 5 1");
				} 
				else if (k == 10) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("2 3 4 5 1");				
					out.println("1 2 3 4 5");
					out.println("5 1 2 3 4");
					out.println("4 5 1 2 3");
					out.println("3 4 5 1 2");
				} 
				else if (k == 15) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("3 4 5 1 2");				
					out.println("2 3 4 5 1");				
					out.println("1 2 3 4 5");
					out.println("5 1 2 3 4");
					out.println("4 5 1 2 3");
				} 
				else if (k == 20) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("4 5 1 2 3");
					out.println("3 4 5 1 2");				
					out.println("2 3 4 5 1");				
					out.println("1 2 3 4 5");
					out.println("5 1 2 3 4");
				} 
				else if (k == 25) {
					out.println("Case #" + tc + ": " + POSSIBLE);
					out.println("5 1 2 3 4");
					out.println("4 5 1 2 3");
					out.println("3 4 5 1 2");				
					out.println("2 3 4 5 1");				
					out.println("1 2 3 4 5");
				} 
				else {
					out.println("Case #" + tc + ": " + IMPOSSIBLE);
				}
			}
			else {
				out.println("Case #" + tc + ": " + IMPOSSIBLE);
			}
						
		}
	}

	//-----------------------------------------------------
	void runWithFiles() {
		in = new FastReader(new File("input.txt"));
		try {
			out = new PrintWriter(new File("output.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		solve();
		out.close();
	}
	
	class FastReader
	{
	    BufferedReader br;
	    StringTokenizer tokenizer;
	    
	    public FastReader(InputStream stream)
	    {
	        br = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }
		public FastReader(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
				tokenizer = null;
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	    
	    private String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens())
	            try {
	            	tokenizer = new StringTokenizer(br.readLine());
	            }
	            catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        return tokenizer.nextToken();
	    }
		public String nextLine() {
			try	{
				return br.readLine();
			}
			catch(Exception e) {
				throw(new RuntimeException());
			}
		}

	    int nextInt() {
	        return Integer.parseInt(next());
	    }
	    long nextLong() {
	        return Long.parseLong(next());
	    }
	    double nextDouble() {
	        return Double.parseDouble(next());
	    }	    
	    BigInteger nextBigInteger() {
	        return new BigInteger(next());
	    }
	    BigDecimal nextBigDecimal() {
	        return new BigDecimal(next());
	    }
	}
}
