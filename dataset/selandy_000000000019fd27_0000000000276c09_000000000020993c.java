import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Vestigium {

	public static void main(String[] args) throws NumberFormatException, IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			int T = Integer.parseInt(br.readLine());
			for (int testCase = 1; testCase <= T; testCase++) {
				int N = Integer.parseInt(br.readLine());

				int k = 0;
				int r = 0;
				List<HashSet<Integer>> columnSet = new ArrayList<>();

				for (int i = 0; i < N; i++) {
					columnSet.add(i, new HashSet<Integer>());
				}

				for (int i = 0; i < N; i++) {
					String[] row = br.readLine().split(" ");

					HashSet<Integer> rowSet = new HashSet<Integer>();
					for (int j = 0; j < N; j++) {
						int num = Integer.parseInt(row[j]);
						if (i == j) {
							k += num;
						}
						rowSet.add(num);
						columnSet.get(j).add(num);
					}
					if (rowSet.size() != N) {
						r++;
					}
				}

				int c = 0;
				for (int i = 0; i < N; i++) {
					if (columnSet.get(i).size() != N) {
						c++;
					}
				}

				System.out.println("Case #" + testCase + ": " + k + " " + r + " " + c);
			}
		}
	}

}
