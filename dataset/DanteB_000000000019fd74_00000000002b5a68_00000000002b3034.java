import java.util.*;

import java.io.*;
public class Solution {
  
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
 
  public static void main(String[] args) {
    int t = in.nextInt();
    outer: for (int tc = 1; tc <= t; ++tc) {
      int n = in.nextInt();
      char[] pre = new char[10000]; 
      char[] suf = new char[10000]; 
      char[] mid = new char[10000];
      int prel = 0;
      int sufl = 0;
      int midl = 0;
      for (int i = 0; i < n; i++) {
    	  char[] word = in.next().toCharArray();
    	  int wl = word.length;
    	  
    	  int wpl = 0;
    	  for (; wpl < wl; wpl++) {
    		  if (word[wpl] == '*')
    			  break;
    	  }
    	  int minp = Math.min(wpl, prel);
    	  for (int j = 0; j < minp; j++) {
    		  if (word[j] != pre[j]) {
    			  out.printf("Case #%d: *\n", tc);
    			  continue outer;
    		  }
    	  }
    	  if (wpl > prel) {
    		  for (int j = prel; j < wpl; j++) {
    			  pre[j] = word[j];
    		  }
    		  prel = wpl;
    	  }
    	  
    	  int wsl = 0;
    	  for (; wsl < wl; wsl++) {
    		  if (word[wl-wsl-1] == '*')
    			  break;
    	  }
    	  int mins = Math.min(wsl, sufl);
    	  for (int j = 0; j < mins; j++) {
    		  if (word[wl-j-1] != suf[j]) {
    			  out.printf("Case #%d: *\n", tc);
    			  continue outer;
    		  }
    	  }
    	  if (wsl > sufl) {
    		  for (int j = sufl; j < wsl; j++) {
    			  suf[j] = word[wl-j-1];
    		  }
    		  sufl = wsl;
    	  }
    	  
    	  for (int j = wpl; j < wl-wsl; j++) {
    		  if (word[j] != '*')
    			  mid[midl++] = word[j];
    	  }
    	  
      }
      out.printf("Case #%d: ", tc);
      for (int i = 0; i < prel; i++) {
    	  out.print(pre[i]);
      }
      for (int i = 0; i < midl; i++) {
    	  out.print(mid[i]);
      }
      for (int i = 0; i < sufl; i++) {
    	  out.print(suf[sufl-i-1]);
      }
      out.println();
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