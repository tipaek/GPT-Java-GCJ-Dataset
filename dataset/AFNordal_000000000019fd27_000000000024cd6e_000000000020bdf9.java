import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 0; t < T; t++) {
			
			System.out.println("Case #"+(t+1)+": "+work(scan));

		}
		scan.close();
		
	}

	public static String work(Scanner scan) {
		int N = scan.nextInt();
		int[][] acts = new int[N][3];
		for (int i = 0; i < N; i++) {
			acts[i][0] = scan.nextInt();
			acts[i][1] = scan.nextInt();
			acts[i][2] = i;
		}
		Arrays.sort(acts, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});
		int lc = 0;
		int lj = 0;
		char[] str = new char[N];
		for (int i = 0; i < N; i++) {
			if (lc <= acts[i][0]) {
				lc = acts[i][1];
				str[acts[i][2]] = 'C';
			} else if (lj <= acts[i][0]) {
				lj = acts[i][1];
				str[acts[i][2]] = 'J';
			} else {
				return "IMPOSSIBLE";
			}
		}
		return new String(str);
	}
}