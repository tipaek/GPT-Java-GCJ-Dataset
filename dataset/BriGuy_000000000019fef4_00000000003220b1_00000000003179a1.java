import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader in = new BufferedReader(new FileReader("rand.in"));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int U = Integer.parseInt(in.readLine());
			
			//count[16][10] + HashMap<Character, Integer>
			int[][] count = new int[16][10];
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			HashMap<Integer, Character> rmap = new HashMap<Integer, Character>();
			int curr = 0;
			
			for(int x = 0; x < 10000; x++) {
				
				StringTokenizer st = new StringTokenizer(in.readLine());
				long M = Long.parseLong(st.nextToken());
				String R = st.nextToken();
				char c = R.charAt(0);
				
				if(!map.containsKey(c)) {
					map.put(c, curr);
					rmap.put(curr, c);
					curr++;
				}
				
				if(curr == 9) {
					for(int i = 0; i < R.length(); i++) {
						if(!map.containsKey(R.charAt(i))) {
							map.put(R.charAt(i), curr);
							rmap.put(curr, R.charAt(i));
							curr++;
						}
					}
				}
				
				count[R.length()-1][map.get(c)]++;
			}
			
			String D = "";
			boolean[] done = new boolean[10];
			
			for(int i = 15; i >= 0; i--) {
				PriorityQueue<int[]> pq = new PriorityQueue<int[]>(1, new Comparator<int[]>() {
					public int compare(int[] a, int[] b) {
						return b[0] - a[0];
					}
				});
				
				for(int j = 0; j < 10; j++) {
					pq.add(new int[] {count[i][j], j});
				}
				
				while(!pq.isEmpty()) {
					int[] rem = pq.remove();
					if(rem[0] == 0) {
						if(i == 0) {
							if(!done[rem[1]]) {
								D = rmap.get(rem[1]) + D;
								break;
							} else continue;
						} else break;
					}
					
					if(!done[rem[1]]) {
						D += rmap.get(rem[1]);
						done[rem[1]] = true;
					}
				}
			}
			
			System.out.println("Case #" + t + ": " + D);
		}
	}
}
