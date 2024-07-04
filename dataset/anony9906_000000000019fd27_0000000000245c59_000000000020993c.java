import java.util.*;
import java.io.*;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author prem_cse
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CodeJam solver = new CodeJam();
        solver.solve(1, in, out);
        out.close();
    }

    static class CodeJam {
        public void solve(int testNumber, FastReader sc, PrintWriter out) {
              int T = sc.nextInt();
              for(int t=1;t<=T;++t) {
            	   
            	  int n = sc.nextInt();
            	  int[][] tab = new int[n][n];
            	  int trace = 0;
            	  for(int i=0;i<n;++i) {
            		  for(int j=0;j<n;++j) {
            			  tab[i][j] = sc.nextInt();
            			  if(i == j) trace+=tab[i][j];
            		  }
            	  }
            	  int r = 0, c = 0;
            	  for(int col=0;col<n;++col) {
            		  Set<Integer> set = new HashSet<>();
            		  for(int i=0;i<n;++i) {
            			  if(set.contains(tab[i][col])) {
            				  ++c;
            				  break;
            			  }
            			  set.add(tab[i][col]);
            		  }
            	  }
            	  for(int row=0;row<n;++row) {
            		  Set<Integer> set = new HashSet<>();
            		  for(int j=0;j<n;++j) {
            			  if(set.contains(tab[row][j])) {
            				  ++r;
            				  break;
            			  }
            			  set.add(tab[row][j]);
            		  }
            	  }
            	  out.println("Case #"+t+": "+trace+" "+r+" "+c);
            	  
              }
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream), 32768);
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

