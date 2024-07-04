import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

class Vestigium {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String tc = br.readLine();
		int testcases = Integer.parseInt(tc);

		for (int j = 0; j < testcases; j++) {
			tc = br.readLine();
			int n = Integer.parseInt(tc);
			int trace = 0;
			int rowCount = 0;
			int columncount = 0;
			String[][] latin = new String[n][n];
			boolean[] uniqRow = new boolean[n+1];
			for (int k = 0; k < n; k++) {
				Arrays.fill(uniqRow, false);
				String row = br.readLine();
				latin[k] = row.split("\\s+");
				for (int g = 0; g < n; g++) {
					int element = Integer.parseInt(latin[k][g]);
					if (uniqRow[element] == false)
						uniqRow[element] = true;
					else {
						rowCount++;
						break;
					}
				}
				trace += Integer.parseInt(latin[k][k]);
			}
			for (int k = 0; k < n; k++) {
				Arrays.fill(uniqRow, false);
				for (int g = 0; g < n; g++) {
					int element = Integer.parseInt(latin[g][k]);
					if (uniqRow[element] == false)
						uniqRow[element] = true;
					else {
						columncount++;
						break;
					}
				}
			}

			pw.println("Case #" + (j + 1) + ": " + trace + " " + rowCount + " " + columncount);
		}
		br.close();
		pw.close();
	}

}
