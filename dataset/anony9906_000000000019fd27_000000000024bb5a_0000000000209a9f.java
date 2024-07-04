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
            	   
            	  char[] s = sc.next().toCharArray();
            	  int n = s.length;
            	  int j = 0,op = 0;
            	  StringBuilder ans = new StringBuilder();
            	  for(int i=0;i<n;++i) {
            		  while(j < n && s[i] == s[j]) ++j;
            		  int len = j-i;
            		  int req = s[i]-'0';
            		  if(req > op) {
            			     int diff = req-op;
            			     while(diff-->0) ans.append('(');
            			     while(len-->0) ans.append(s[i]);
            			     op = req;
            		  }else {
            			  int diff = op - req;
            			  op-=diff;
            			  while(diff-->0) ans.append(')');
            			  while(len-->0) ans.append(s[i]);
            		  }
            		//  out.println(op+" "+j);
            		  i = j-1;
            	  }
            	  while(op-->0) ans.append(')');
            	  out.println("Case #"+t+": "+ans);
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

