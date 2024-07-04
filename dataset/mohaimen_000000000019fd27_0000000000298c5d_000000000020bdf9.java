
import java.util.*;
import java.util.Scanner;

public class Solution {
	
	public static class Activity implements Comparable<Activity>{
		
		public int start;
		public int end;
		public int pos;
		
		Activity(int start, int end, int pos){
			this.start = start;
			this.end = end;
			this.pos = pos;
		}

		@Override
		public int compareTo(Activity o) {
			// TODO Auto-generated method stub
			return this.start - o.start;
		}
		
	}
	
	
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();
	
		for(int t = 0; t< tests; t++) {
			
			int n = scanner.nextInt();
			List<Activity> list = new ArrayList<Activity>();
			List<Activity> sorted = new ArrayList<Activity>();
			
			for(int i = 0; i < n; i++) {
				int s = scanner.nextInt();
				int e = scanner.nextInt();
				
				Activity a = new Activity(s, e, i);
				list.add(a);
				sorted.add(a);
			}
			
			Collections.sort(sorted);
			
			int cend = 0, jend = 0;
			Map<Integer, Character> map = new HashMap<Integer, Character>();
			
			StringBuilder res = new StringBuilder();
			boolean flag = false;
			
			for(int i = 0; i < n; i++) {
				if(sorted.get(i).start >= cend) {
					map.put(sorted.get(i).pos, 'C');
					cend = sorted.get(i).end;
				}else if(sorted.get(i).start >= jend) {
					map.put(sorted.get(i).pos, 'J');
					jend = sorted.get(i).end;
				}else {
					flag = true;
					break;
				}
			}
			
			for(int i = 0; i < n; i++) {
				if(flag) {
					res = new StringBuilder("IMPOSSIBLE");
					break;
				}else {
					res.append(map.get(i));
				}
			}
			
			System.out.println("Case #" + (t + 1) + ": " + res);
			
		}
	
	}
}
