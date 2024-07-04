import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				int n = Integer.parseInt(br.readLine());

				String arr[][] = new String[n][n];
				for (int j = 0; j < n; j++) {
					arr[j] = br.readLine().split(" ");
				}

				int trace = 0;
				int rowFound = 0;
				int columnFound = 0;

				for (int k = 0; k < n; k++) {
					int indx = 0;
					trace += Integer.parseInt(arr[k][k]);
					
					boolean rowElementFound = false;
					boolean colElementFound = false;
					
					while ((indx < n) && (!rowElementFound || !colElementFound)) {

						String rowElement = arr[k][indx];
						String colElement = arr[indx][k];

						for (int jj = 0; jj < n; jj++) {
							if (indx != jj) {
								if (!rowElementFound && rowElement.equals(arr[k][jj])) {
									rowElementFound = true;
									rowFound += 1;
								}

								if (!colElementFound && colElement.equals(arr[jj][k])) {
									colElementFound = true;
									columnFound += 1;
								}
								if (rowElementFound && colElementFound) {
									break;
								}
							}
						}

						indx++;
					}
				}

				System.out.format("Case #%d: %d %d %d%n", (i+1), trace, rowFound, columnFound);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
