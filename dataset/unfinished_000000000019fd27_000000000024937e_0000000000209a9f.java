import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		for (int i = 1; i <= T; i++) {
			String s = input.next();
			StringBuilder ss = new StringBuilder("");
			int prev = 0;
			List<Integer> ints = Arrays.stream(s.split("")).map(Integer::parseInt).collect(Collectors.toList());
			for (int j = 0; j < ints.size(); j++) {
				int d = ints.get(j);
				// System.out.println(d);
				int diff = prev - d;
				prev = d;
				StringBuilder paraN = new StringBuilder("");
				if (diff < 0) {
					diff = -diff;
					for (int k = 0; k < diff; k++) {
						paraN.append("(");
					}
					paraN.append(d);

				} else if (diff > 0) {
					for (int k = 0; k < diff; k++) {
						paraN.append(")");
					}
					paraN.append(d);

				} else {
					paraN.append(d);
				}
				ss.append(paraN);

			}
			int last = ints.get(ints.size() - 1);
			if (last > 0) {
				for (int k = 0; k < last; k++) {
					ss.append(")");
				}
			}
			System.out.println("Case #" + i + ": " + ss);

		}
		input.close();

	}

}
