import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testCases = sc.nextInt();

			for (int i = 0; i < testCases; i++) {
				int matSize = sc.nextInt();
				int trace = 0;
				int columnRepeats = 0;
				int rowRepeats = 0;

				List<HashSet<Integer>> columns = new ArrayList<>();
				boolean[] columRepeated = new boolean[matSize];

				for (int j = 0; j < matSize; j++) {
					columns.add(new HashSet<>());
				}

				for (int j = 0; j < matSize; j++) {
					HashSet<Integer> rows = new HashSet<>();
					boolean rowRepeated = false;
					for (int k = 0; k < matSize; k++) {
						int num = sc.nextInt();

						if (k == j) {
							trace += num;
						}

						if (rows.contains(num) && !rowRepeated) {
							rowRepeats++;
							rowRepeated = true;
						} else {
							rows.add(num);
						}

						if (columns.get(k).contains(num) && !columRepeated[k]) {
							columnRepeats++;
							columRepeated[k] = true;
						} else {
							columns.get(k).add(num);
						}
					}
				}

				System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + columnRepeats);

			}

		}
	}
}