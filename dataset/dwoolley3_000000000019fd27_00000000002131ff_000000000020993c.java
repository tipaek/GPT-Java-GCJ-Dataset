import java.io.*;    //PrintWriter
import java.math.*;  //BigInteger, BigDecimal
import java.util.*;  //StringTokenizer, ArrayList

public class GCJ_2020_QR_A
{	
	FastReader in;
	PrintWriter out;
	
	public static void main(String[] args) throws IOException  {
		new GCJ_2020_QR_A().run();
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
			
			int duprow = 0, dupcol = 0;
			int[][] a = new int[n][n];
			for (int i = 0; i < n; i++) {
				HashSet<Integer> row = new HashSet<>();
				for (int j = 0; j < n; j++) { 
					a[i][j] = in.nextInt();
					row.add(a[i][j]);
				}
				duprow += ((row.size() < n) ? 1 : 0);
			}
			
			int k = 0; // trace
			for (int i = 0; i < n; i++) {
				k += a[i][i];
			}
			
			for (int i = 0; i < n; i++) {
				HashSet<Integer> col = new HashSet<>();
				for (int j = 0; j < n; j++) {
					col.add(a[j][i]);
				}
				dupcol += ((col.size() < n) ? 1 : 0);
			}
			String ans = k + " " + duprow + " " + dupcol;
			
			//System.out.println("Case #" + tc + ": " + ans);
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
