import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
 
public class Solution {
	public static void main(String[] args) throws Exception {
		new Solution().run();
	}
	int qcnt;
	FastScanner f;
	PrintWriter out;
	public void run() throws Exception {
		f = new FastScanner();
		out = new PrintWriter(System.out);
		int times = f.nextInt(); int n = f.nextInt();
		for(int asdf = 1; asdf <= times; asdf++) {
			int sameind = -1, diffind = -1;
			int sameval = -1, diffval = -1;
			ArrayList<Integer> _00 = new ArrayList<>();
			ArrayList<Integer> _01 = new ArrayList<>();
			ArrayList<Integer> _10 = new ArrayList<>();
			ArrayList<Integer> _11 = new ArrayList<>();
			qcnt = 0;
			for(int i = 0; i < n/2; i++) {
				if(qcnt % 2 == 1) query(0);
				if(qcnt % 10 == 0) {
					boolean sc = false, dc = false;
					if(sameind != -1) {
						if(query(sameind) != sameval) {
							sameval ^= 1;
							sc = true;
						}
					}
					if(diffind != -1) {
						if(query(diffind) != diffval) {
							diffval ^= 1;
							dc = true;
						}
					}
					ArrayList<Integer> t;
					if(sc && dc) {
						t = _00;
						_00 = _11;
						_11 = t;
						t = _10;
						_10 = _01;
						_01 = t;
					} else if(sc && !dc) {
						t = _00;
						_00 = _11;
						_11 = t;
					} else if(!sc && dc) {
						t = _10;
						_10 = _01;
						_01 = t;
					}
				}
				int a = query(i);
				int b = query(n-i-1);
				if(a == 0 && b == 0) {
					_00.add(i);
					sameind = i;
					sameval = a;
				}
				if(a == 1 && b == 0) {
					_10.add(i);
					diffind = i;
					diffval = a;
				}
				if(a == 0 && b == 1) {
					_01.add(i);
					diffind = i;
					diffval = a;
				}
				if(a == 1 && b == 1) {
					_11.add(i);
					sameind = i;
					sameval = a;
				}
			}
			int[] ans = new int[n];
			for(int i : _00) {
				ans[i] = 0;
				ans[n-i-1] = 0;
			}
			for(int i : _01) {
				ans[i] = 0;
				ans[n-i-1] = 1;
			}
			for(int i : _10) {
				ans[i] = 1;
				ans[n-i-1] = 0;
			}
			for(int i : _11) {
				ans[i] = 1;
				ans[n-i-1] = 1;
			}
			for(int i : ans) out.print(i);
			out.println();
			out.flush();
			if(f.next().equals("N")) return;

		}
///
		out.flush(); 
	}
	public int query(int i) {
		qcnt++;
		out.println(i+1);
		out.flush();
		return f.nextInt();
	}
///
    static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
        	return Long.parseLong(next());
        }
        public double nextDouble() {
        	return Double.parseDouble(next());
        }
        public String nextLine() {
        	try {
        		return reader.readLine();
        	} catch(IOException e) {
        		throw new RuntimeException(e);
        	}
        }
    }
}
