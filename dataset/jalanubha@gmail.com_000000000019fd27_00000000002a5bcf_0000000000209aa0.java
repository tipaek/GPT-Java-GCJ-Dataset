import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	
			
		for (int x = 0; x < T; x++) {
			String y = "IMPOSSIBLE";
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] Karr = new int[N];
			Arrays.fill(Karr, 1);
			int sum = N;
			int lastAdded = 1;
			int[][] mat = new int[N][N];
			while (sum != K) {
				int left = K - sum;
				int toAdd = left/N;
				if (toAdd > 0) {
					Arrays.fill(Karr, toAdd + lastAdded);
					lastAdded = toAdd;
					sum = sum + N*toAdd;
				} else {
					for(int i = 0; i < left; i++) {
						Karr[i] += 1;
						sum++;
					}
				}
			}
			
			//fill diagonal values
			for (int i = 0; i < N; i++) {
				mat[i][i] = Karr[i];
			}
			
			boolean breaked = false;
			for(int i = 0; i < N; i++) {
				HashSet<Integer> set = new HashSet<Integer>(N);
				int j = i;
				int val = Karr[i];
				mat[i][j] = val;
				set.add(val);
				breaked = false;
				int runs = 1;
				while(set.size() < N) {
					j = (j + 1)%N;
					HashSet<Integer> colSet = new HashSet<Integer>(N);
					int internalRuns = 1;
					for(int l = 0; l < N; l++) {
						colSet.add(mat[l][j]);
					}					
					while(set.contains(val) || colSet.contains(val)) {
						val++;
						val = (val <= N? val: 1);
						internalRuns++;
						if(internalRuns > N) {
							breaked = true;
							break;
						}
					}	
					
					if(breaked) break;
					
					set.add(val);
					mat[i][j] = val;
					runs++;
					if(runs > N) {
						breaked = true;
						break;
					}
				}
				
				if(breaked)
					break;
			}
			
			if(breaked) {
				y = "IMPOSSIBLE";
				System.out.format("Case #%d: %s\n", (x + 1), y);
			} else {
				y = "POSSIBLE";
				System.out.format("Case #%d: %s\n", (x + 1), y);
				for(int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						String token = mat[i][j] + "";
						if(j != N - 1) token = token + " ";
						System.out.print(token);
					}
					System.out.println();
				}
			}
			
			
		}

		sc.close();
	}
}
