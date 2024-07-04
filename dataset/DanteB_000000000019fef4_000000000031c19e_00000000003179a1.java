import java.util.*;
import java.io.*;
public class Solution {
  
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
 
  public static void main(String[] args) {
    int t = in.nextInt();
    for (int tc = 1; tc <= t; ++tc) {
      int u = in.nextInt();
      int[][] count = new int[26][u+1];
      for (int i = 0; i < 26; i++)
    	  count[i][0] = i;
      for (int i = 0; i < 10000; i++) {
    	  in.next();
    	  char[] ri = in.next().toCharArray();
    	  for (int j = 0; j < ri.length; j++) {
    		  count[ri[j]-'A'][j+1]++;
    	  }
      }
      Arrays.sort(count, new Comparator<int[]>() {
	      public int compare(int[] i1, int[] i2) {
	        for (int i = 1; i <= u; i++) {
	        	if (i1[i] < i2[i])
	        		return 1;
	        	else if (i1[i] > i2[i])
	        		return -1;
	        }
	        return Integer.compare(i1[0], i2[0]);
	      }
      	});
      char[] sol = new char[10];
      for (int i = 0; i < 9; i++) {
    	  sol[i+1] = (char) (count[i][0]+'A');
      }
      sol[0] = (char) (count[9][0] + 'A');
      out.printf("Case #%d: %s\n", tc, new String(sol));
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