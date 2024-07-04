import java.util.*;
import java.io.*;
public class Solution {
  
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
 
  public static void main(String[] args) {
//	long[] nums = new long[392];
//	for (int i = 1; i <= 392; i++) {
//		long ilong = i;
//		nums[i] = (ilong+3)*(ilong+2)*(ilong+1)*ilong/24 + (ilong+2)*(ilong+1)*ilong/6 + (ilong+1)*ilong/2 + 2*ilong;
//	}
//	long[] nums2 = new long[392];
//	for (int i = 1; i <= 392; i++) {
//		long ilong = i;
//		nums2[i] = (ilong+3)*(ilong+2)*(ilong+1)*ilong/24 + (ilong+2)*(ilong+1)*ilong/3 + 2;
//	}
	  
    int t = in.nextInt();
    
    for (int tc = 1; tc <= t; ++tc) {
      long n = in.nextInt();
      out.printf("Case #%d:\n", tc);
      if (n <= 500) {
    	  for (int i = 1; i <= n; i++) {
    		  out.printf("%d %d\n", i, i);
    	  }
    	  continue;
      }
      if (n <= 998) {
    	  for (int i = 1; i <= n-499; i++) {
    		  out.printf("%d %d\n", i, i);
    	  }
    	  out.printf("%d %d\n", n-498, n-499);
    	  for (int i = (int) (n-498); i <= 499; i++) {
    		  out.printf("%d %d\n", i, i);
    	  }
    	  continue;
      }
      if (n <= 1000) {
    	  for (int i = 1; i <= n-995; i++) {
    		  out.printf("%d %d\n", i, i);
    	  }
    	  out.printf("%d %d\n", n-994, n-995);
    	  for (int i = (int) (n-994); i <= 498; i++) {
    		  out.printf("%d %d\n", i, i);
    	  }
    	  out.println("498 497");
    	  continue;
      }
//      int mini = 1;
//      int maxi = 392;
//      while (maxi > mini) {
//    	  int testi = (mini+maxi)/2;
//    	  if (nums[testi] > n) {
//    		  maxi = testi-1;
//    	  } else {
//    		  mini = testi;
//    	  }
//      }
      
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