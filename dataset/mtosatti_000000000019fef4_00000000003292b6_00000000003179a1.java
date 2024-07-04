import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	public static class L implements Comparable<L> {
		Character c;
		int lim;
		
		public L(Character c, int lim) {
			this.c = c;
			this.lim = lim;
		}
		
		@Override
		public int compareTo(L o) {
			return this.lim > o.lim ? 1:-1;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int s = in.nextInt();

			Map<Character, L> l = new HashMap<Character, L>();
			
			for(int i = 0 ; i < 10000; i++) {
				String Q = in.next();
				String R = in.next();
				if(Q.length() == R.length()) {
					int lim = Integer.valueOf(Q.charAt(0));
					char c = R.charAt(0);
					if(!l.containsKey(c)) {
						l.put(c, new L(c,lim));
					}
					l.get(c).lim = Math.min(lim, l.get(c).lim);
				}
			}
			List<L> f = new ArrayList<L>();
			for(Entry<Character, L> e: l.entrySet()) {
				f.add(e.getValue());
			}
			Collections.sort(f);
			
			System.out.print("Case #" + t + ": ");
			for(L fk: f) {
				System.out.print(fk.c);
			}
			System.out.println();
		}
	}

}
