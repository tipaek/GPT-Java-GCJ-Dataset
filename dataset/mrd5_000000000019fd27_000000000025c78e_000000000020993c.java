import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));) {
			int t = Integer.parseInt(br.readLine());

			for (int x = 0; x < t; x++) {
				int n = Integer.parseInt(br.readLine());
				int[][] arr = new int[n][n];

				int k = 0;
				for (int i = 0; i < n; i++) {
					String[] s = br.readLine().split("\\s+");
					for (int j = 0; j < n; j++) {
						arr[i][j] = Integer.parseInt(s[j]);
					}
					k += arr[i][i];
				}

				int r = 0;
				int c = 0;
				for (int i = 0; i < n; i++) {
					Set<Integer> set = new HashSet<>();
					for (int j = 0; j < n; j++) {
						if (set.contains(arr[i][j])) {
							r++;
							break;
						}
						set.add(arr[i][j]);
					}

					set = new HashSet<>();
					for (int j = 0; j < n; j++) {
						if (set.contains(arr[j][i])) {
							c++;
							break;
						}
						set.add(arr[j][i]);
					}
				}

				System.out.println("Case #" + (x+1) + ": " + k + " " + r + " " + c);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
