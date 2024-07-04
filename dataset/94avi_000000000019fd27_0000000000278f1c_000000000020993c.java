
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Vestigium {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int testCase = Integer.valueOf(br.readLine());

		for (int test = 1; test <= testCase; test++) {

			int n = Integer.valueOf(br.readLine());

			int sum = 0;
			List<HashSet<Integer>> rowList = new ArrayList<HashSet<Integer>>();
			List<HashSet<Integer>> columnList = new ArrayList<HashSet<Integer>>();
			for (int row = 0; row < n; row++) {
				String inputData[] = br.readLine().split(" ");
				HashSet<Integer> currentRowData = new HashSet<Integer>();
				rowList.add(currentRowData);
				for (int column = 0; column < n; column++) {
					Integer number = Integer.valueOf(inputData[column]);
					currentRowData.add(number);
					if (row == 0) {
						columnList.add(new HashSet<Integer>());
					}
					columnList.get(column).add(number);
					if (row == column)
						sum = sum + number;

				}
			}
			int rowSum = 0;
			int columnSum = 0;
			for (HashSet<Integer> currentRow : rowList) {
				if (currentRow.size() != n)
					rowSum++;
			}

			for (HashSet<Integer> currentColumn : columnList) {
				if (currentColumn.size() != n)
					columnSum++;
			}

			System.out.println("Case #" + test + ": " + sum + " " + rowSum + " " + columnSum);

		}
	}

}
