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
			int u = in.nextInt();
			int n = 10_000;
			
			char[] let = new char[10];
			HashSet<Character> hs = new HashSet<>();
			HashSet<Character> used = new HashSet<>();
			long[] r = new long[n];
			String[] s = new String[n];
			for (int i = 0; i < n; i++) {
				r[i] = in.nextLong();
				s[i] = in.next();	
				for (int j = 0; j < s[i].length(); j++) {
					hs.add(s[i].charAt(j));
				}
			}
			
			for (int num = 1; num < 10; num++) {				
				for (int i = 0; i < n; i++) {
					long pow10 = 1;
					for (int j = 1; j <= u; j++) {
						if (r[i] >= num*pow10 && r[i] <= (num+1)*pow10 - 1 && s[i].length() == j) {
							char c = s[i].charAt(0);
							if (!used.contains(c)) {
								let[num] = c;
							}
						}
						pow10 *= 10L;
					}
//				    if (r[i] >= num*1L && r[i] <= (num+1)*1L - 1 && s[i].length() == 1) {
//						char c = s[i].charAt(0);
//						if (!used.contains(c)) {
//							let[num] = c;
//						}
//					} else if (r[i] >= num*10L && r[i] <= (num+1)*10L - 1 && s[i].length() == 2) {
//						char c = s[i].charAt(0);
//						if (!used.contains(c)) {
//							let[num] = c;
//						}
//					} else if (r[i] >= num*100L && r[i] <= (num+1)*100L - 1 && s[i].length() == 3) {
//						char c = s[i].charAt(0);
//						if (!used.contains(c)) {
//							let[num] = c;
//						}
//					}
				}
				used.add(let[num]);
			}
			
			for (char c: hs) {
				if (!used.contains(c)) {
					let[0] = c;
					break;
				}
			}			
			
			String ans = new String(let);

			out.println("Case #" + tc + ": " + ans);
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
