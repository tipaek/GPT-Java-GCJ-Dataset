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
            	Pair[] p = new Pair[n];
            	for(int i=0;i<n;++i) p[i] = new Pair(sc.nextInt(),sc.nextInt(),i);
            	Arrays.sort(p,new Comparator<Pair>() {

					@Override
					public int compare(Pair o1, Pair o2) {
						if(o1.x!=o2.x) return o1.y-o2.y;
						return o1.x-o2.x;
					}
            	});
            	
            	boolean yes = true;
            	char[] s = new char[n];
            	int lastc=0,lastj=0;
            	for(int i=0;i<n;++i) {
            		if(lastc <= p[i].x) {
            			lastc = p[i].y;
                        s[p[i].idx] = 'C';
            		}else if(lastj <= p[i].x) {
            			lastj = p[i].y;
            			s[p[i].idx] = 'J';
            		}else yes = false;
            	}
            	if(yes) out.println("Case #"+t+": "+new String(s));
            	else out.println("Case #"+t+": IMPOSSIBLE");
              }
        }
        
        static class Pair{
        	int x;
        	int y;
        	int idx;
        	Pair(int x,int y,int idx){
        		this.x = x;
        		this.y = y;
        		this.idx = idx;
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

