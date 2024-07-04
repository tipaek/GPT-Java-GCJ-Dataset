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
				taskList.add(new SimpleEntry<Integer, SimpleEntry<Integer, Integer>>(i + 1,
						new SimpleEntry<Integer, Integer>(st, et)));
			}

			Collections.sort(taskList, (a, b) -> a.getValue().getKey().compareTo(b.getValue().getKey()));

			Integer jTime = 0;
			Integer cTime = 0;
			boolean imp = false;

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
				List<Integer> order = taskList.stream().mapToInt(s -> s.getKey()).boxed().collect(Collectors.toList());
				for (Integer ent : order) {
					System.out.print(sb.charAt(ent - 1));
				}
				System.out.println();
			}
		}
	}

}
