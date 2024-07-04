import java.util.*;
import java.io.*;
public class Solution {
  
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
 
  public static void main(String[] args) {
    int t = in.nextInt();
    for (int tc = 1; tc <= t; ++tc) {
      int c = in.nextInt();
      int d = in.nextInt();
      Integer[][] ranks = new Integer[c-1][2];
      Integer[][] times = new Integer[c-1][2];
      int j = 0;
      int k = 0;
      for (int i = 0; i < c-1; i++) {
    	  int val = in.nextInt();
    	  if (val < 0) {
    		  ranks[j][1] = -val;
    		  ranks[j][0] = i+1;
    		  j++;
    	  } else {
    		  times[k][1] = val;
    		  times[k][0] = i+1;
    		  k++;
    	  }
      }
      for (; j < c-1; j++) {
    	  ranks[j][1] = 1000000;
      }
      for (; k < c-1; k++) {
    	  times[k][1] = 1000000;
      }
      Arrays.sort(ranks, new Comparator<Integer[]>() {
      public int compare(Integer[] i1, Integer[] i2) {
        return i1[1].compareTo(i2[1]);
      }
    });
      Arrays.sort(times, new Comparator<Integer[]>() {
      public int compare(Integer[] i1, Integer[] i2) {
        return i1[1].compareTo(i2[1]);
      }
    });
      @SuppressWarnings("unchecked")
      HashMap<Integer, Integer>[] edges = new HashMap[c];
      for (int i = 0; i < c; i++)
        edges[i] = new HashMap<Integer, Integer>();
      for (int i = 0; i < d; i++) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        int w = i;
        edges[x].put(y, w);
        edges[y].put(x, w);
      }
      int[] y = new int[d];
      for (int i = 0; i < d; i++) {
    	  y[i] = 1000000;
      }
      int[] lat = new int[c];
      int[] src = new int[c];
      for (int i = 1; i < c; i++) {
    	  src[i] = -1;
      }
      int[] di = new int[c];
//      int last = 0;
      int time = 0;
      for (Map.Entry<Integer, Integer> neighbour : edges[0].entrySet()) {
    	  src[neighbour.getKey()] = 0;
    	  di[neighbour.getKey()] = neighbour.getValue();
      }
      j = 0;
      k = 0;
      int next = 0;
      for (int i = 1; i < c; i++) {
    	  if (ranks[j][1] <= i) {
    		  next = ranks[j][0];
    		  if (ranks[j][1] == i) {
    			  if (times[k][1] == 1000000) {
    				  time++;
    			  } else {
    				  time = times[k][1];
    			  }
    		  }
    		  j++;
    	  } else {
    		  next = times[k][0];
    		  time = times[k][1];
    		  k++;
    	  }
    	  y[di[next]] = time - lat[src[next]];
    	  lat[next] = time;
          for (Map.Entry<Integer, Integer> neighbour : edges[next].entrySet()) {
        	  if (src[neighbour.getKey()] == -1) {
	        	  src[neighbour.getKey()] = next;
	        	  di[neighbour.getKey()] = neighbour.getValue();
        	  }
          }
      }
      out.printf("Case #%d:", tc);
      for (int i = 0; i < d; i++) {
    	  out.printf("% d", y[i]);
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