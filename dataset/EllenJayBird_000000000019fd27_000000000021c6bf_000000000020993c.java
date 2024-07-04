import java.util.*;

class Main {
	public static void calculator(Scanner sc, int nbr) {
		int n = Integer.valueOf(sc.nextLine());
		List<List<Integer>> matrix = new ArrayList<>();
		int trace = 0;
		int repeatRow = 0, repeatCol = 0;
		for (int i = 0; i < n; i ++) {
			String row = sc.nextLine();
			String[] r = row.split("\\s+");
			boolean[] used = new boolean[n];
			boolean isRepeated = false;
			//matrix[i] = new int[n];
			List<Integer> list = new ArrayList<>();
			//matrix.add(list);
			for (int j = 0; j < r.length; j ++) {
        int val = Integer.valueOf(r[j]);
				list.add(val);
				if (i == j) {
					trace += list.get(j);
				}
				if (used[val - 1]) {
					isRepeated = true;
				}
				used[val - 1] = true;
			}
			matrix.add(list);
			if (isRepeated) {
				repeatRow += 1;
			}
		}
		for (int i = 0; i < n; i ++) {
			boolean[] used = new boolean[n];
			boolean isRepeated = false;
			for (int j = 0; j < n; j ++) {
				if (used[matrix.get(j).get(i)-1]) {
					isRepeated = true;
					break;
				}
        used[matrix.get(j).get(i)-1] = true;
			}
			if (isRepeated) {
				repeatCol += 1;
			}			
		}
		System.out.print("Case #" + nbr + ": " + trace + " " + repeatRow + " " + repeatCol);
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String testNbr = sc.nextLine();
		int tnbr = Integer.valueOf(testNbr);
		for (int i = 0; i < tnbr; i ++) {
			calculator(sc, i + 1);
		}
		return;
	}
}