import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int[][] array;

	public static void main(String[] args) throws IOException {
		int caseNumber = Integer.parseInt(reader.readLine());
		int caseIterater = 0;
		while (caseNumber != caseIterater++) {
			int n = Integer.parseInt(reader.readLine());
			int trace = 0;
			int rowCheck = 0;
			int columnCheck = 0;
			array = new int[101][101];
			for (int i = 0; i < n; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				int[] checked = new int[101];
				for (int j = 0; j < n; j++) {
					array[i][j] = Integer.parseInt(tokenizer.nextToken());
					checked[array[i][j]]++;
				}
				for (int j = 1; j <= n; j++) {
					if (checked[j] <= 1)continue;
					rowCheck = Math.max(rowCheck,checked[j]);
				}
			}

			for (int i = 0; i < n; i++) {
				trace += array[i][i];
			}
			for (int i = 0; i < n; i++) {
				int[] checked = new int[101];
				for (int j = 0; j < n; j++) {
					checked[array[j][i]]++;
				}
				for (int j = 1; j <= n; j++) {
					if (checked[j] <= 1)continue;
					columnCheck = Math.max(columnCheck,checked[j]);
				}
			}

			System.out.println(String.format("Case #%d: %d %d %d",caseIterater,trace,rowCheck,columnCheck));
		}
	}
}
