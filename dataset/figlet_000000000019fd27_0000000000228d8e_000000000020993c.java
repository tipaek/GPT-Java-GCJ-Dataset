
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			int n = 0, rCnt = 0, cCnt = 0, element = 0;
			long sum = 0l, trace = 0l;
			long rows[] = null, cols[] = null;
			String data[] = null;
			boolean rowMatrix[][] = null;
			boolean colMatrix[][] = null;
			for (int i = 1; i <= t; i++) {
				n = Integer.parseInt(br.readLine());
				rowMatrix = new boolean[n][n];
				colMatrix = new boolean[n][n];
				sum = n * (n + 1);
				sum = sum / 2;
				rows = new long[n];
				cols = new long[n];
				for (int j = 0; j < n; j++) {
					data = br.readLine().split(" ");
					for (int k = 0; k < n; k++) {
						element = Integer.parseInt(data[k]);
						rowMatrix[j][element - 1] = true;
						colMatrix[element - 1][k] = true;
						if (j == k) {
							trace += element;
						}
					}
				}

				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						if (!rowMatrix[j][k]) {
							rCnt++;
							break;
						}
					}
				}

				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						if (!colMatrix[k][j]) {
							cCnt++;
							break;
						}
					}
				}

				System.out.println("Case #" + i + ": " + trace + " " + rCnt + " " + cCnt);
				trace = 0;
				rCnt = 0;
				cCnt = 0;

			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
