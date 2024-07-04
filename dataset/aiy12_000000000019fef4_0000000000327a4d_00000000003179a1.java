import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
 
public class Solution {
	
	HashMap<Character, Character> confirmedMaps;
	HashMap<Character, HashSet<Character>> digitMapping;
	
	class Query implements Comparable<Query> {
		String M, R;
		
		public Query (String M, String R) {
			this.M = M+"";
			this.R = R+"";
			
			for (int i = 0; i < R.length(); i++) {
				digitMapping.put(R.charAt(i), new HashSet<Character>(Arrays.asList('0','1','2','3','4','5','6','7','8','9')));
			}
		}
		
		public int compareTo(Query q) {
			return M.compareTo(q.M);
		}
	}
	
	public void run() throws Exception {
		FastScanner file = new FastScanner();
		
// 		Scanner file = new Scanner(new File("input.txt"));
		
		int T = file.nextInt();
		
		for (int test = 1; test <= T; test++) {
			int U = file.nextInt();
			
			confirmedMaps = new HashMap<Character, Character>();
			digitMapping = new HashMap<Character, HashSet<Character>>();
			
			ArrayList<Query> queries = new ArrayList<Query>();			
			for (int i = 0; i < 10000; i++) {
				queries.add(new Query(file.next(), file.next()));
			}
			
			Collections.sort(queries);
			
			boolean ok = false;
			
			for (int i = 0; i < queries.size(); i++) {
				Query q = queries.get(i);
				
				if (q.M.equals("-1")) {
					ok = true;
					break;
				}
				
				if (q.M.length() == q.R.length()) {
					
//					System.out.println(q.M + " " + q.R);
					
					int idx = 0;
					
					while (idx < q.M.length() && confirmedMaps.containsKey(q.R.charAt(idx)) 
							&& confirmedMaps.get(q.R.charAt(idx)) == q.M.charAt(idx)) {
						idx++;
					}
					
					if (idx != q.M.length() && !confirmedMaps.containsKey(q.R.charAt(idx))) {
						HashSet<Character> toRemove = new HashSet<Character>();
						for (char c : digitMapping.get(q.R.charAt(idx))) {
							
							if (c >= q.M.charAt(idx)) {
//								System.out.println(c + " " + q.M.charAt(idx));
								toRemove.add(c);
							}
						}
						digitMapping.get(q.R.charAt(idx)).removeAll(toRemove);
						
						if (digitMapping.get(q.R.charAt(idx)).size() == 1) {
							char ans = 1;
							for (char c : digitMapping.get(q.R.charAt(idx))) {
								ans = c;
							}
							
							confirmedMaps.put(q.R.charAt(idx), ans);
							
							for (char c : digitMapping.keySet()) {
								digitMapping.get(c).remove(ans);
							}
						}
						
						
					}
				}
			}
			
			if (!ok) {
			
				for (char c : digitMapping.keySet()) {
					if (digitMapping.get(c).size() == 1) {
						char ans = 1;
						for (char cc : digitMapping.get(c)) {
							ans = cc;
						}
						
						confirmedMaps.put(c, ans);
					}
				}
				
	//			System.out.println(digitMapping);
	//			System.out.println(confirmedMaps);
				
				char[] mapping = new char[11];
				for (char c : confirmedMaps.keySet()) {
					mapping[confirmedMaps.get(c)-'0'+1] = c;
				}
				mapping[0]=mapping[10];
				
				System.out.print("Case #" + test + ": ");
				for (int i = 0; i < 10; i++) {
					System.out.print(mapping[i]);
				}
				System.out.println();
			} else {
				
				HashMap<Character,Integer> digitFrequency = new HashMap<Character, Integer>();
				
				for (int i = 0; i < queries.size(); i++) {
					Query q = queries.get(i);
					for (int j = 0; j < q.R.length(); j++) {
						if (!digitFrequency.containsKey(q.R.charAt(j))) {
							digitFrequency.put(q.R.charAt(j), 0);
						}
						digitFrequency.put(q.R.charAt(j), digitFrequency.get(q.R.charAt(j)) + 1);
					}
				}
				
				ArrayList<Pair> arr = new ArrayList<Pair>();
				for(char c : digitFrequency.keySet()) {
					arr.add(new Pair(digitFrequency.get(c),c));
				}
				
				Collections.sort(arr);
				
				char[] mapping = new char[11];
				for (int i = 1; i < 11; i++ ) {
					mapping[i] = arr.get(i-1).let;
				}
				mapping[0] = mapping[10];
				
				System.out.print("Case #" + test + ": ");
				for (int i = 0; i < 10; i++) {
					System.out.print(mapping[i]);
				}
				System.out.println();
			}
		}
	}
	
	class Pair implements Comparable<Pair>{
		int frq;
		char let;
		public Pair(int a, char b) {
			frq = a;
			let = b;
		}
		
		public int compareTo(Pair p) {
			return p.frq - frq;
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