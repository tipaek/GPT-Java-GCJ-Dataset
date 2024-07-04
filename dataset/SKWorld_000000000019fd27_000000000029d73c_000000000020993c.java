

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;


class Solution{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				String s[] = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			int rc = 0;
			int cc = 0;
			long sum = 0;
			for (int i = 0; i < n; i++) {
				boolean fw = true;
				HashMap<Integer, Integer> rows = new HashMap<>();

				for (int j = 0; j < n; j++) {
					if (i == j)
						sum = sum + arr[i][j];
					if (rows.containsKey(arr[i][j])) {
						fw = false;
					} else {
						rows.put(arr[i][j], 1);
					}

				}

				if (!fw)
					rc++;

			}
			for (int i = 0; i < n; i++) {
				boolean th = true;
				HashMap<Integer, Integer> cols = new HashMap<>();

				for (int j = 0; j < n; j++) {

					if (cols.containsKey(arr[j][i])) {
						th = false;
					} else {
						cols.put(arr[j][i], 1);
					}

				}
				if (!th)
					cc++;

			}
			System.out.println("Case #" + (t + 1) + ": " + sum + " " + rc + " " + cc);

		}
	}
}
