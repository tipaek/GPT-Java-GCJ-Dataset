import java.util.ArrayList;
import java.util.Scanner;

public class QualifierVestigium {
	static int caseCount = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "3\n" + "4\n" + "1 2 3 4\n" + "2 1 4 3\n" + "3 4 1 2\n" + "4 3 2 1\n" + "4\n" + "2 2 2 2\n"
				+ "2 3 2 3\n" + "2 2 2 3\n" + "2 2 2 2\n" + "3\n" + "2 1 3\n" + "1 3 2\n" + "1 2 3\n";

		Scanner scanner = new Scanner(System.in);
		ArrayList<String> inputLines = new ArrayList<String>();
		while(scanner.hasNext()) {
			inputLines.add(scanner.nextLine());
		}
		scanner.close();
		String[] lines = new String[inputLines.size()];
		lines = inputLines.toArray(lines);
		int count = Integer.parseInt(lines[0]);
		int index = 1;
		while (count > 0) {
			int n = Integer.parseInt(lines[index]);
			String[] rows = new String[n];
			for (int i = 0; i < n; i++) {
				index++;
				rows[i] = lines[index];
			}
			index++;
			processCase(n, rows);
			count--;
		}

	}

	public static void processCase(int n, String[] rows) {
		caseCount++;
		int[][] columns = new int[n][n];
		int repeatRows = 0;
		for (int r = 0; r < n; r++) {
			String[] rowStrings = rows[r].split(" ");
			int[] row = stringArrayToIntArray(rowStrings);
			if (hasDuplicate(row, n))
				repeatRows++;
			int c = 0;
			while (c < n) {
				columns[c][r] = Integer.parseInt(rowStrings[c]);
				c++;
			}
		}
		int repeatColumns = 0;
		for (int[] column : columns) {
			if (hasDuplicate(column, n))
				repeatColumns++;
		}
		int i = 0;
		int trace = 0;
		while (i < n) {
			trace += columns[i][i];
			i++;
		}
		System.out.println("Case #" + caseCount + ": " + trace + " " + repeatRows + " " + repeatColumns);
	}

	public static int[] stringArrayToIntArray(String[] a) {
		int[] i = new int[a.length];
		for (int x = 0; x < a.length; x++) {
			i[x] = Integer.parseInt(a[x]);
		}

		return i;
	}

	public static boolean hasDuplicate(int[] array, int n) {
		int i = 0;
		while (i < n) {
			i = i + 1;
			if (!arrayIncludes(array, i))
				return true;
		}

		return false;
	}

	public static boolean arrayIncludes(int[] array, int x) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x)
				return true;
		}

		return false;
	}
}
