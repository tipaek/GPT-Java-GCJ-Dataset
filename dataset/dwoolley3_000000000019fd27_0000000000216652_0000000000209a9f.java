import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class Solution
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args) throws IOException  {
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
			String s = in.next();			
			int n = s.length();
			String ans = "";
			int lparen = 0, rparen = 0;
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				String cs = c + "";
				while (i+1 < n && c == s.charAt(i+1)) {
					i++;
					cs += c;
				}
				int dig = c - '0';
				int x = lparen - rparen;
				for (int j = 0; j < dig - x; j++) {
					lparen++;
					ans += "(";
				}
				x = lparen - rparen;
				for (int j = 0; j < x - dig; j++) {
					ans += ")";
					rparen++;
				}
				ans += cs;
			}
			for (int j = 0; j < (lparen - rparen); j++) {
				ans += ")";
			}

			out.println("Case #" + tc + ": " + ans);
		}
	}

	//-----------------------------------------------------

	
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
