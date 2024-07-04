import java.util.*;
import java.io.*;
public class Solution {
	static int n;
	public static void main(String[] args) throws IOException {
		FastScanner sc = new FastScanner(System.in);
		int T = sc.nextInt();
		
		n = sc.nextInt();
		for (int ca = 1 ; ca <= T ; ca++) {
			int round = 0;
			int[] type = new int[n];
			int[] prev = new int[n];
			Arrays.fill(type, -1);
			Arrays.fill(prev, -1);
			ArrayList<Integer> same = new ArrayList<>();
			ArrayList<Integer> diff = new ArrayList<>();
			
			int index = 0;
			while (++round < 150 && index < n/2) {
				if (round%10==1 && round != 1) {
					round++;
					if (same.size() > 0 && diff.size() > 0) {
						int query = same.get(0)+1;
						System.out.println(query);
						System.out.flush();
						int receivedSame = sc.nextInt();
						
						query = diff.get(0)+1;
						System.out.println(query);
						System.out.flush();
						int receivedDiff = sc.nextInt();
						
						if (isSame(receivedSame, prev, same.get(0))) { // nothing/rev
							if (isSame(receivedDiff, prev, diff.get(0))) {
								//nothing
							} else {
								reverse(type);
							}
						} else { // both/complement
							if (isSame(receivedSame,prev,diff.get(0))) {
								reverse(type);
							}
							
							complement(type);
						}
						
					} else {
						if (same.size() > 0) {
							int query = same.get(0)+1;
							System.out.println(query);
							System.out.flush();
							int receivedSame = sc.nextInt();
							if (!isSame(receivedSame, prev, same.get(0))) {
								complement(type);
							}
						} else {
							int query = diff.get(0)+1;
							System.out.println(query);
							System.out.flush();
							int receivedDiff = sc.nextInt();
							if (!isSame(receivedDiff, prev, diff.get(0))) {
								complement(type);
							}
						}
						
						int query = 1;
						System.out.println(query);
						System.out.flush();
						int received = sc.nextInt();
					}
				} else {
					int query = index+1;
					if (round%2 == 1) { //back
						query = n-index;
					}
					
					System.out.println(query);
					System.out.flush();
					
					type[query-1] = sc.nextInt();
					
					if (round%2 == 0) {
						if (type[index] == type[n-index-1]) {
							same.add(index);
						} else {
							diff.add(index);
						}
						index++;
					}
				}
				
				if (round%10 == 0) {
					for (int i = 0 ; i < n ; i++) {
						prev[i] = type[i];
					}
				}
			}
			
			for (Integer e : type) {
				System.out.print(e);
			}
			System.out.println();
			System.out.flush();
			char ans = sc.next().charAt(0);
			
			if (ans == 'N') {
				return;
			}
		}
	}
	
	static boolean isSame(int newType, int[] prev, int index) {
		return newType == prev[index];
	}
	
	static void reverse(int[] type) {
		for (int i = 0 ; i < n/2 ; i++) {
			int temp = type[i];
			type[i] = type[n-1-i];
			type[n-1-i] = temp;
		}
	}
	
	static void complement(int[] type) {
		for (int i = 0 ; i < n ; i++) {
			if (type[i] == 1) {
				type[i] = 0;
			} else if (type[i] == 0) {
				type[i] = 1;
			}
		}
	}

	static class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;
		
	    public FastScanner(InputStream i) {
	        br = new BufferedReader(new InputStreamReader(i));
	        st = new StringTokenizer("");
	    }
				
	    public String next() throws IOException {
	        if(st.hasMoreTokens())
	            return st.nextToken();
	        else
	            st = new StringTokenizer(br.readLine());
	        return next();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	}

}
