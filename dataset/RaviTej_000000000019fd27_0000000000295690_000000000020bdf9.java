import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int x = 1; x <= t; x++) {

			System.out.print("Case #" + x + ": ");

			int n = sc.nextInt();

			List<SimpleEntry<Integer, SimpleEntry<Integer, Integer>>> taskList = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				Integer st = sc.nextInt();
				Integer et = sc.nextInt();
				taskList.add(new SimpleEntry<Integer, SimpleEntry<Integer, Integer>>(i,
						new SimpleEntry<Integer, Integer>(st, et)));
			}

			Collections.sort(taskList, (a, b) -> a.getValue().getKey().compareTo(b.getValue().getKey()));

			Integer jTime = -1;
			Integer cTime = -1;
			boolean imp = false;

			// System.out.println(taskList);

			StringBuilder sb = new StringBuilder();

			for (SimpleEntry<Integer, SimpleEntry<Integer, Integer>> entry : taskList) {

				if (jTime <= entry.getValue().getKey()) {
					jTime = entry.getValue().getValue();
					sb.append('J');
				} else if (cTime <= entry.getValue().getKey()) {
					cTime = entry.getValue().getValue();
					sb.append('C');
				} else {
					imp = true;
					break;
				}
			}

			if (imp) {
				System.out.println("IMPOSSIBLE");
			} else {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						int index = taskList.get(j).getKey();

						if (index == i) {
							System.out.print(sb.charAt(j));
							break;
						}
					}
				}

				System.out.println();
			}
		}
	}

}
