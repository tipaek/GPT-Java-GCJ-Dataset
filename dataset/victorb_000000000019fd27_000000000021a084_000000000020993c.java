import java.util.*;

public class Solution {
	

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);	
		for(int tNum = sc.nextInt(), tCurr = 1; tCurr <= tNum; tCurr++ ) {
			
			int n = sc.nextInt();					
			int k = 0, r = 0, c = 0;
			Set<Integer>[] rowMet = new Set[n], colMet = new Set[n];						
			for(int i = 0; i < n; i++) {
				rowMet[i] = new HashSet<Integer>();
				colMet[i] = new HashSet<Integer>();
			}
			
			for(int ri = 0; ri < n; ri++) {
				for(int ci = 0; ci < n; ci++) {				
					int v = sc.nextInt();
					
					if (rowMet[ri] != null) {
						if (rowMet[ri].contains(v)) {
							rowMet[ri] = null;
						} else {
							rowMet[ri].add(v);
						}						
					}
					
					if (colMet[ci] != null) {
						if (colMet[ci].contains(v)) {
							colMet[ci] = null;
						} else {
							colMet[ci].add(v);
						}						
					}
					
					if (ci == ri) {
						k += v;
					}
				}				
			}
			
			for(int i = 0; i < n; i++) {
				if (rowMet[i] == null) {
					r++;
				}
				if (colMet[i] == null) {
					c++;
				}
			}
			
			System.out.println(String.format("Case #%d: %d %d %d", tCurr, k, r, c));					
			
			
		}
		System.out.flush();
		
	}
	
}