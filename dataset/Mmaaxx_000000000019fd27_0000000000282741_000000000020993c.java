import java.util.*;

public class Solution {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testCases = sc.nextInt();

			for (int i = 0; i < testCases; i++) {
				int matSize = sc.nextInt();
				int trace = 0;
				int columnRepeats = 0;
				int rowRepeats = 0;

				List<HashMap<Integer, Integer>> columns = new ArrayList<>();

				for (int j = 0; j < matSize; j++) {
					columns.add(new HashMap<>());
				}

				for (int j = 0; j < matSize; j++) {
					HashMap<Integer, Integer> rows = new HashMap<>();
					for (int k = 0; k < matSize; k++) {
						int num = sc.nextInt();

						if (k == j) {
							trace += num;
						}

						if (!rows.containsKey(num)) {
							rows.put(num, 1);
						} else {
							if(rows.get(num) == 1) {
								rowRepeats++;
								rows.put(rows.get(num), 2);
							}
						}

						if(!columns.get(k).containsKey(num)) {
							columns.get(k).put(num, 1);
						} else {
							if (columns.get(k).get(num) == 1) {
								columnRepeats++;
								columns.get(k).put(num, 2);
							}
						}
					}
				}

				System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + columnRepeats);

			}

		}
	}
}