import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		for(int i = 0; i < t; i++) {
			int n = kb.nextInt();
			int trace = 0;
			int rowT = 0;
			int colT = 0;
			HashMap <Integer, HashSet<Integer>> colVals = new HashMap <Integer, HashSet<Integer>>();
			boolean [] c = new boolean[n + 1];
			for(int j = 1; j < n + 1; j++) {
				boolean [] row = new boolean[n + 1];
				boolean r = false;
				for(int k = 1; k < n + 1; k++) {
					int next = kb.nextInt();
					if(!r && row[next]) {
						rowT++;
						r = true;
					}
					if(colVals.get(k) == null) {
						HashSet<Integer> col = new HashSet<Integer>();
						colVals.put(k, col);
					}
					else if(!c[k] && colVals.get(k).contains(next)) {
						colT++;
						c[k] = true;
					}
					row[next] = true;
					colVals.get(k).add(next);
					colVals.put(k, colVals.get(k));
					if(j == k)
						trace += next;
				}
			}
			System.out.println("Case #"+(i+1)+": "+trace+" "+rowT+" "+colT);
		}
	}

}
