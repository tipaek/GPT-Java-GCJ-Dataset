import java.util.*;
import java.io.*;
public class Solution {
  
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
 
  public static void main(String[] args) {
    int t = in.nextInt();
    for (int tc = 1; tc <= t; ++tc) {
      long l = in.nextLong();
      long r = in.nextLong();
      boolean swap = false;
      if (r > l) {
    	  swap = true;
    	  long temp = l;
    	  l = r;
    	  r = temp;
      }
      long diff = l-r;
      long cust = (long) ((-1.0 + Math.sqrt(1.0+8*diff))/2.0);
      if (cust*(cust+1)/2 > diff) {
    	  cust--;
      } else if ((cust+1)*(cust+2)/2 <= diff) {
    	  cust++;
      }
      l -= cust*(cust+1)/2;
      if (l == r && swap) {
    	  swap = false;
      }
      if (l >= cust+1) {
    	  l -= ++cust;
      }
      long xl = (long) (((-cust-1)+Math.sqrt((cust+1)*(cust+1) + 4*l))/2);
      if (l - xl*cust - xl*(xl+1) < 0) {
    	  xl--;
      } else if (l - (xl+1)*cust - (xl+1)*(xl+2) >= 0) {
    	  xl++;
      }
      long xr = (long) ((-cust + Math.sqrt(cust*cust + 4*r))/2);
      if (r - xr*cust - xr*xr < 0) {
    	  xr--;
      } else if (r - (xr+1)*cust - (xr+1)*(xr+1) >= 0) {
    	  xr++;
      }
      l = l - xl*cust - xl*(xl+1);
      r = r - xr*cust - xr*xr;
      if (xr > xl) {
    	  cust += 2*xr - 1;
      } else {
    	  cust += 2*xl;
      }
      if (swap) {
    	  long temp = l;
    	  l = r;
    	  r = temp;
      }
//      for (; ; i++) {
//    	  if (l >= r && l >= i) {
//    		  l -= i;
//    	  } else if (r >= i) {
//    		  r -= i;
//    	  } else {
//    		  break;
//    	  }
//      }
      out.printf("Case #%d: %d %d %d\n", tc, cust, l, r);
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