import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int x = 1; x <= t; x++) {

			System.out.print("Case #" + x + ": ");

			int n = sc.nextInt();

			List<SimpleEntry<Integer, Integer>> taskList = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				taskList.add(new SimpleEntry<Integer, Integer>(sc.nextInt(), sc.nextInt()));
			}

			Collections.sort(taskList, (a, b) -> a.getKey().compareTo(b.getKey()));

			boolean j_eng = true;
			boolean c_eng = true;
			Integer jTime = 0;
			Integer cTime = 0;
			boolean imp = false;

			StringBuilder sb = new StringBuilder();

			for (SimpleEntry<Integer, Integer> entry : taskList) {
				if (j_eng == true && jTime <= entry.getKey()) {
					jTime = entry.getValue();
					sb.append('J');
					continue;
				}

				if (c_eng == true && cTime <= entry.getKey()) {
					cTime = entry.getValue();
					sb.append('C');
					continue;
				}

				imp = true;
				break;
			}

			if (imp == true) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(sb.toString());
			}
		}
	}

}
