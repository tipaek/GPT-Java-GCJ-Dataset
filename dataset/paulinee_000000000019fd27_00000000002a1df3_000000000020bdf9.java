import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int tt = kb.nextInt();
		for(int t = 0; t < tt; t++) {
			int n = kb.nextInt();
			pair[] pairs = new pair[n];
			for(int i = 0; i < n; i++) {
				pairs[i] = new pair(kb.nextInt(), kb.nextInt(), i);
			}
			Arrays.sort(pairs);
//			System.out.println(Arrays.toString(pairs));

			int j = 0, c = 0;
			boolean flag = false;
			char[] ans = new char[n];
			for(int i = 0; i < n && !flag; i++) {
				if(pairs[i].x >= j) {
					j = pairs[i].y;
					ans[pairs[i].idx]='J';
				}
				else if(pairs[i].x >= c) {
					c = pairs[i].y;
					ans[pairs[i].idx]='C';
				}
				else {
					flag = true;
				}
			}
			if(flag) 
				System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
			else 
				System.out.println("Case #"+(t+1)+": "+new String(ans));

		}

	}
	static class pair implements Comparable<pair>{
		int x, y, idx;
		pair(int x, int y, int idx){
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
		public int compareTo(pair p) {
			if(x-p.x==0) return y-p.y;
			return x-p.x;
		}
		public String toString() {
			return x + " " + y;
		}
	}
}
