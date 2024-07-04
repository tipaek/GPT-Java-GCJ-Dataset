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
	
	int[][] s;        // contestant skill
	boolean[][] elim; // contestant eliminated 
	
	void solve()
	{
		int T = in.nextInt();  

		for (int tc = 1; tc <= T; tc++)
		{
			int r = in.nextInt();
			int c = in.nextInt();
			
			s = new int[r][c];
			for (int i = 0; i < r; i++) 
				for (int j = 0; j < c; j++) {
					s[i][j] = in.nextInt();
				}

			elim = new boolean[r][c];
			boolean eliminated1 = true;
			int interest = 0;
			int[] dx = new int[] { 0, 0, 1, -1 };
	        int[] dy = new int[] { 1, -1, 0, 0 };

			while (eliminated1) {
				ArrayList<Integer> elimi = new ArrayList<>();
				ArrayList<Integer> elimj = new ArrayList<>();
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (!elim[i][j]) {
							interest += s[i][j];
							int opponentSkills = 0;
							int numOpponents = 0;
							for (int k = 0; k < 4; k++) {
								int sk = getNeighbor(i,j, dx[k], dy[k]);
								if (sk > -1) {
									opponentSkills += sk; 
									numOpponents++;
								}
							}
							if (numOpponents > 0) {
								if (s[i][j] * numOpponents < opponentSkills) {
									elimi.add(i);
									elimj.add(j);
								}
							}
						}
					}				
				}				
				eliminated1 = elimi.size() > 0;
				for (int i = 0; i < elimi.size(); i++) {
					elim[elimi.get(i)][elimj.get(i)] = true;
				}
			}
			String ans = "" + interest;
			
			out.println("Case #" + tc + ": " + ans);
		}
	}
	
	public int getNeighbor(int r, int c, int dr, int dc) {
		int rows = s.length, cols = s[0].length;
		r += dr;
		c += dc;
		int skill = -1;
		while (r >= 0 && r < rows && c >= 0 && c < cols) {
			if (!elim[r][c]) {
				skill = s[r][c];
				break;
			}
			r += dr;
			c += dc;
		}		
		
		return skill;
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
