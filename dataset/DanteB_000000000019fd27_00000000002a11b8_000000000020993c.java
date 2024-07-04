import java.util.*;
import java.io.*;
public class Solution {
  
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
 
  public static void main(String[] args) {
    int t = in.nextInt();
    for (int tc = 1; tc <= t; ++tc) {
      int n = in.nextInt();
      int[][] mat = new int[n][n];
      int k = 0;
      int r = 0;
      int c = 0;
      for (int i = 0; i < n; i++) {
    	  boolean[] row = new boolean[n+1];
    	  boolean rep = false;
    	  for (int j = 0; j < n; j++) {
    		  int num = in.nextInt();
    		  if (i == j) {
    			  k += num;
    		  }
    		  if (!rep) {
    			  if (row[num]) {
    				  rep = true;
    				  r++;
    			  } else {
    				  row[num] = true;
    			  }
    		  }
    		  mat[i][j] = num;
    	  }
      }
      for (int j = 0; j < n; j++) {
    	  boolean[] col = new boolean[n+1];
    	  boolean rep = false;
    	  for (int i = 0; i < n; i++) {
    		  int num = mat[i][j];
    		  if (!rep) {
    			  if (col[num]) {
    				  rep = true;
    				  c++;
    			  } else {
    				  col[num] = true;
    			  }
    		  }
    	  }
      }
      out.printf("Case #%d: %d %d %d\n", tc, k, r, c);
    }
    finish();
  }
  
  public static void finish() {
    out.close();
    in.close();
    System.exit(0);
  }
  
  static class InputReader implements Iterator<String>, Closeable {
    // Fast input reader. Based on Kattio.java from open.kattis.com
    // but has method names to match Scanner

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    public InputReader(InputStream i) {
      r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasNext() {
      return peekToken() != null;
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public String next() {
      String ans = peekToken();
      token = null;
      return ans;
    }
    
    public String nextLine() {
      peekToken();
      String ans = line;
      token = null;
      st = null;
      return ans;
    }
    
    public void close() {
      try {
        r.close();
      } catch (IOException e) {
      }
    }

    private String peekToken() {
      if (token == null)
        try {
          while (st == null || !st.hasMoreTokens()) {
            line = r.readLine();
            if (line == null)
              return null;
            st = new StringTokenizer(line);
          }
          token = st.nextToken();
        } catch (IOException e) {
        }
      return token;
    }
    
  }
  
}