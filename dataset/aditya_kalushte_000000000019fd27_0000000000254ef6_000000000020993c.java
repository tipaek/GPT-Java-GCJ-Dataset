
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testcases = sc.nextInt();
		for (int t = 0; t < testcases; t++) {
			int N = sc.nextInt();

			int arr[][] = new int[N][N];
			int k = 0;
			int r = 0;
			int c = 0;
			Set<Integer> elements = null;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					if (i == j) {
						k += arr[i][j];
					}
				}
			}

			// Check duplicates row-wise
			for (int i = 0; i < N; i++) {
				elements = new HashSet<Integer>();
				for (int j = 0; j < N; j++) {
					if (elements.contains(arr[i][j])) {
						r++;
						break;
					} else {
						elements.add(arr[i][j]);
					}
				}
			}

			for (int j = 0; j < N; j++) {
				elements = new HashSet<Integer>();
				for (int i = 0; i < N; i++) {
					if (elements.contains(arr[i][j])) {
						c++;
						break;
					} else {
						elements.add(arr[i][j]);
					}
				}
			}

			System.out.println("Case #" + (t + 1) + ": " + k + " " + r + " " + c);

		}
		sc.close();
	}

}
