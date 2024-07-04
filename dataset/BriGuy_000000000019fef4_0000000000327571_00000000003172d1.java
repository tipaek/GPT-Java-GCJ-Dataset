import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			
			if(D == 2) {
				boolean zero = false;
				HashSet<Long> set = new HashSet<Long>();
				for(int i = 0; i < N; i++) {
					long x = Long.parseLong(st.nextToken());
					if(set.contains(x)) {
						zero = true;
						break;
					}
					set.add(x);
				}
				
				if(zero) System.out.println("Case #" + t + ": 0");
				else System.out.println("Case #" + t + ": 1");
				
			} else {
				boolean zero = false;
				boolean one = false;
				long max = 0;
				long minone = Long.MAX_VALUE;
				HashMap<Long, Integer> map = new HashMap<Long, Integer>();
				for(int i = 0; i < N; i++) {
					long x = Long.parseLong(st.nextToken());
					if(map.containsKey(x) && map.get(x) == 2) {
						zero = true;
						break;
					}
						
//					if(t == 3) {
//						System.out.println(x*2);
//						System.out.println(map.containsKey(x*2));
//					}
					
					if(x % 2 == 0 && map.containsKey(x/2)) {
						one = true;
					}
						
					if(map.containsKey(x*2)) {
						one = true;
					}
						
					if(map.containsKey(x)) {
						map.put(x, 2);
						minone = Math.min(minone, x);
					} else {
						map.put(x, 1);
					}
					
					max = Math.max(max, x);
				}
					
//					if(t == 3) System.out.println(x + " " + zero + " " + one);
				
				if(zero) System.out.println("Case #" + t + ": 0");
				else if(one || minone < max) System.out.println("Case #" + t + ": 1");
				else System.out.println("Case #" + t + ": 2");
			}
		}
	}
}
