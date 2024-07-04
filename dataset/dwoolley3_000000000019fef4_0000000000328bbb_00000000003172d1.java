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
			int d = in.nextInt();
			
			HashMap<Long,Integer> map = new HashMap<>();
			long[] a = new long[n];
			long maxa = 0;
			int MAX = 1000;
			int cuts = MAX;
			boolean oneLess = false;
			for (int i = 0; i < n; i++) {
				a[i] = in.nextLong();
				int cnt = 0;
				if (map.containsKey(a[i])) {
					cnt = map.get(a[i]);
				}
				map.put(a[i], ++cnt);
				if (cnt == d) cuts = 0;
				if (cnt == d-1) {
					oneLess = true;
				}
				if (a[i] > maxa) {
					maxa = a[i];
				}
			}
			
			if (cuts == MAX) {
				if (d == 2) {
					cuts = 1;
				} else if (d == 3) {
					cuts = 2;
					for (Map.Entry<Long,Integer> ent : map.entrySet())  {
						if (ent.getValue() == d - 1 && maxa > ent.getKey()) {
							cuts = 1;
							break;
						}
					}
					if (cuts == 2) {
						for (int i = 0; i < n; i++) {
							if (a[i] % 2 == 0) {
								if (map.containsKey(a[i]/2) && map.get(a[i]/2) == 1) {
									cuts = 1;
								}
							}
						}
					}
				}
			}
			
			String ans = "" + cuts;

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
