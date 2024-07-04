import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int T = reader.nextInt();
		for (int t = 0; t < T; t++) {
			int N = reader.nextInt();
			int D = reader.nextInt();
			int[] arr = new int[10000];
			
			long[] As = new long[N];
			Set<Long> set = new HashSet<>();
			HashMap<Long, Integer> reps = new HashMap<>();
			for(int i =0 ; i < N; i++) {
				As[i] = reader.nextLong();
				if(!reps.containsKey(As[i])) {
					reps.put(As[i], 0);
				}
				reps.put(As[i], reps.get(As[i])+1);
				set.add(As[i]);
			}
			
			int maxrep = 1;
			long maxi  = -1;
			for(long l: reps.keySet()) {
				int val = reps.get(l);
				if (val > maxrep) {
					maxrep = val;
					maxi = l;
				}
			}
			
			Arrays.sort(As);
			int res = D-1;
			
			if(N == 1) {
				res = D-1; // 2
			}else if (maxrep > N) {
				res = 0;
			} else if (N == 2 && D == 3){
				res =3;
			}else if ( N < D) {
				
			} else {
				// N >= D
				res = D-maxrep;

			}
			
			for(long i: set) {
				if(set.contains(2*i)) {
					res = Math.min(1,res);
				}
			}
			
			
			System.out.printf("Case #%d: %d\n", t + 1, res);

		}
	}
}
