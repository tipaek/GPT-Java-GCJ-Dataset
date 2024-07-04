import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int i=0;i<T;i++) {
			int N = scan.nextInt();
			int arr[][] = new int[N][N];
			int trace = 0;
			int r = 0;
			int c = 0;
			for (int j=0;j<N;j++) {
				for (int k=0;k<N;k++) {
					arr[j][k] = scan.nextInt();
					if (j == k) {
						trace += arr[j][k];
					}
				}
			}
			for (int j=0;j<N;j++) {
				HashSet<Integer> row = new HashSet<Integer>();
				HashSet<Integer> column = new HashSet<Integer>();
				for (int k=0;k<N;k++) {
					row.add(arr[j][k]);
					column.add(arr[k][j]);
				}
				if (row.size() != N) {
					r++;
				}
				if (column.size() != N) {
					c++;
				}
			}
			System.out.println("Case #" + (i+1) + ": " + trace + " " + r + " " + c);
		}

	}

}
