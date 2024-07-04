import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Solution {
	
	static final boolean DEBUG = false;
	
	static InputReader in;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		
    	in = new InputReader(System.in);
    	out = new PrintWriter(System.out, true);
		int t = in.nextInt();
	    for (int i = 0; i < t; i++) {
	    	int n = in.nextInt();
	    	if (DEBUG) {
				System.out.println("n: " + n);
			}
	    	
	    	int[][] m = new int[n][n];
	    	boolean [][] rm = new boolean[n][n];
	    	boolean [][] cm = new boolean[n][n];
	    	boolean []ra = new boolean[n];
	    	boolean []ca = new boolean[n];
	    	int trace = 0;
	    	for (int j = 0; j < n; j++) {
	    		for (int k = 0; k < n; k++) {
	    			int v = in.nextInt();
	    			m[j][k] = v;
	    			if (DEBUG) {
		    			System.out.print(m[j][k] + " ");
		    		}
	    			
	    			if (!ra[j]) {
		    			if (rm[j][v - 1]) {
		    				ra[j] = true;
		    			} else {
		    				rm[j][v - 1] = true;
		    			}
	    			}
	    			
	    			if (!ca[k]) {
		    			if (cm[k][v - 1]) {
		    				ca[k] = true;
		    			} else {
		    				cm[k][v - 1] = true;
		    			}
	    			}
	    			
	    			if (j == k) {
	    				trace += v;
	    			}
	    		}
	    		if (DEBUG) {
	    			System.out.println();
	    		}
	    	}
	    	
	    	int r = 0, c = 0;
	    	for (int j = 0; j < n; j++) {
	    		if (ra[j]) {
	    			r++;
	    		}
	    		if (ca[j]) {
	    			c++;
	    		}
	    	}
	    	
	    	out.println(String.format("Case #%d: %d %d %d", i + 1, trace, r, c));
	    }
	    
	    out.close();
	    System.exit(0);
	}
	
	static class InputReader {
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;

	    public InputReader(InputStream stream) {
	      reader = new BufferedReader(new InputStreamReader(stream), 32768);
	      tokenizer = null;
	    }

	    public String next() {
	      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	        try {
	          tokenizer = new StringTokenizer(reader.readLine());
	        } catch (IOException e) {
	          throw new RuntimeException(e);
	        }
	      }
	      return tokenizer.nextToken();
	    }

	    public int nextInt() {
	      return Integer.parseInt(next());
	    }
  	}
}
