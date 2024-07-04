import java.util.*;
import java.io.*;
public class Solution {
  
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
 
  public static void main(String[] args) {
    int t = in.nextInt();
    outer: for (int tc = 1; tc <= t; ++tc) {
    	out.printf("Case #%d: ", tc);
    	int n = in.nextInt();
    	Integer[][] tas = new Integer[n+1][2];
    	tas[0][0] = 0;
    	tas[0][1] = 0;
    	for (int i = 1; i <= n; i++) {
    		tas[i][0] = in.nextInt();
    		tas[i][1] = in.nextInt();
    	}
    	Arrays.sort(tas, new Comparator<Integer[]>() {
      public int compare(Integer[] i1, Integer[] i2) {
    	  if (i1[0] != i2[0])
    		  return i1[0].compareTo(i2[0]);
    	  else
    		  return i1[1].compareTo(i2[1]);
      }
    });
    	int c = 0;
    	int j = 0;
    	char[] sol = new char[n];
    	for (int i = 1; i <= n; i++) {
    		if (tas[c][1] <= tas[i][0]) {
    			sol[i-1] = 'C';
    			c = i;
    		} else if (tas[j][1] <= tas[i][0]) {
    			sol[i-1] = 'J';
    			j = i;
    		} else {
    			out.println("IMPOSSIBLE");
    			continue outer;
    		}
    	}
    	out.println(sol);
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