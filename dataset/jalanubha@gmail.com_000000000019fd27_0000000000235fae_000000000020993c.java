import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		HashSet<Integer> set = new HashSet<Integer>(100);
			
		for (int x = 0; x < T; x++) {
			int N = sc.nextInt();
			int k = 0;
			int r = 0;
			int c = 0;
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				set.clear();
				for (int j = 0; j < N; j++) {
					int val = sc.nextInt();
					set.add(val);
					arr[i][j] = val;
					if (i == j) {
						k += val;
					}
				}
				if (set.size() != N) {
					r++;
				}
			}
			
			for (int j = 0; j < N; j++) {
				set.clear();
				for(int i = 0; i < N; i++) {
					set.add(arr[i][j]);	
				}
				if (set.size() != N) {
					c++;
				}
			}

			System.out.format("Case #%d: %d %d %d\n", (x + 1), k, r, c);
		}
	}
}
