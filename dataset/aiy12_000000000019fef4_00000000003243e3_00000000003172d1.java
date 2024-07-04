import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
 
public class Solution {
	
	public void run() throws Exception {
		FastScanner file = new FastScanner();
		
		int T = file.nextInt();
		
		for (int test = 1; test <= T; test++) {
			System.out.print("Case #" + test + ": ");
			
			int N = file.nextInt();
			int D = file.nextInt();
			
			long[] slices = new long[N];
			
			long max = -1;
			
			HashSet<Long> distinct = new HashSet<>();
			
			for (int i = 0; i < N; i++) {
				slices[i] = file.nextLong();
				distinct.add(slices[i]);
				max = Math.max(max, slices[i]);
			}
			
			if (D == 2) {
				if (distinct.size() != N) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
			} else {
				TreeMap<Long, Integer> frq = new TreeMap<>();
				long best = -1;
				long loc = -1;
				for (int i = 0; i < N; i++) {
					if (!frq.containsKey(slices[i]))
						frq.put(slices[i], 0);
					frq.put(slices[i], frq.get(slices[i]) + 1);
					if (frq.get(slices[i]) > best) {
						best = frq.get(slices[i]);
						loc = slices[i];
					} else if (frq.get(slices[i]) == best) {
						loc = Math.min(loc, slices[i]);
					}
				}

				
				if (best == 3) {
					System.out.println(0);
				} else if (best == 2 && loc != max) {
					System.out.println(1);
				} else {
					boolean ok = false;
					for (int i = 0; i < N; i++) {
						if(distinct.contains(2*slices[i])) {
							ok = true;
							break;
						}
					}
					if (ok) {
						System.out.println(1);
					} else {
						System.out.println(2);
//						boolean div3 = false;
//						for(int i=0; i<N; i++) {
//							if (slices[i]%3==0) div3 = true;
//							if(div3) break;
//						}
//						
//						Arrays.sort(slices);
//						boolean atLeast2=false;
//						for(int i=1; !div3 && i<N; i++) {
//							if(slices[i] > 2*slices[i-1]) {
//								atLeast2=true;
//							}
//							if(atLeast2)break;
//						}
//						
//						boolean evenNumInRange=false;
//						for(int i=0; !div3 && !atLeast2 && i<N; i++) {
//							if (slices[i]%2==0) {
//								if (i!=N-1) evenNumInRange=true;
//								else {
//									if (N>=2 && slices[i]/2 <= slices[N-2]) evenNumInRange = true;
//								}
//							}
//							if(evenNumInRange) break;
//						}
//						if(div3 || atLeast2 || evenNumInRange)
//							System.out.println(2);
//						else
//							System.out.println(3);
					}
				}
			}
		}
	}
 
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
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Solution().run();
	}
}