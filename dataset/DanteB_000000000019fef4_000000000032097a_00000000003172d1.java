import java.util.*;
import java.io.*;
public class Solution {
  
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
 
  public static void main(String[] args) {
    int t = in.nextInt();
    outer: for (int tc = 1; tc <= t; ++tc) {
      int n = in.nextInt();
      int d = in.nextInt();
      long[] a = new long[n];
      for (int i = 0; i < n; i++) {
    	  a[i] = in.nextLong();
      }
      Arrays.sort(a);
      if (d == 2) {
    	  long last = -1;
    	  for (int i = 0; i < n; i++) {
    		  if (a[i] == last) {
    			  out.printf("Case #%d: %d\n", tc, 0);
    			  continue outer;
    		  } else {
    			  last = a[i];
    		  }
    	  }
    	  out.printf("Case #%d: %d\n", tc, 1);
      } else {
    	  long last = -1;
    	  boolean cand = false;
    	  for (int i = 0; i < n-1; i++) {
    		  if (a[i] == last) {
    			  if (a[i+1] == last) {
    				  out.printf("Case #%d: %d\n", tc, 0);
    				  continue outer;
    			  }
    			  else
    				  cand = true;
    		  }
			  last = a[i];
    	  }
    	  if (cand) {
    		  out.printf("Case #%d: %d\n", tc, 1);
    		  continue outer;
    	  }
    	  for (int i = 0; i < n-1; i++) {
    		  long twice = 2*a[i];
    		  if (Arrays.binarySearch(a, twice) > 0) {
    			  out.printf("Case #%d: %d\n", tc, 1);
    			  continue outer;
    		  }
    	  }
    	  out.printf("Case #%d: %d\n", tc, 2);
      }
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