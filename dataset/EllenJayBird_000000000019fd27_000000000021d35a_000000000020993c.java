import java.util.*;

class Main {
	public static void calculator(Scanner sc, int nbr) {
		int n = 0;
		if (sc.hasNextLine()) {
		    n = Integer.valueOf(sc.nextLine());
		} else {
		    return;
		}
		int[][] matrix = new int[n][n];
		int trace = 0;
		int repeatRow = 0, repeatCol = 0;
		for (int i = 0; i < n; i ++) {
			String row = sc.nextLine();
			String[] r = row.split("\\s+");
			boolean[] used = new boolean[n];
			boolean isRepeated = false;
			matrix[i] = new int[n];
			for (int j = 0; j < r.length; j ++) {
                int val = Integer.valueOf(r[j]);
				matrix[i][j] = val;
				if (i == j) {
					trace += matrix[i][j];
				}
				if (used[val - 1]) {
					isRepeated = true;
				}
				used[val - 1] = true;
			}
			if (isRepeated) {
				repeatRow += 1;
			}
		}
		for (int i = 0; i < n; i ++) {
			boolean[] used = new boolean[n];
			boolean isRepeated = false;
			for (int j = 0; j < n; j ++) {
				if (used[matrix[j][i]-1]) {
					isRepeated = true;
					break;
				}
                used[matrix[j][i]-1] = true;
			}
			if (isRepeated) {
				repeatCol += 1;
			}			
		}
		System.out.println("Case #" + nbr + ": " + trace + " " + repeatRow + " " + repeatCol);
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tnbr = 0;
		if (sc.hasNextLine()) {
		    String testNbr = sc.nextLine();
		    tnbr = Integer.valueOf(testNbr);
		}

		for (int i = 0; i < tnbr; i ++) {
			calculator(sc, i + 1);
		}
		return;
	}
}