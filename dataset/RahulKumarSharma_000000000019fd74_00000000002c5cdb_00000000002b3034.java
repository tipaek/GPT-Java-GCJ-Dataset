import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cases = Integer.parseInt(sc.nextLine().trim());

		for (int cs = 1; cs <= cases; cs++) {

			int n = Integer.parseInt(sc.nextLine().trim());

			String[] inputs = new String[n];
			String[] start = new String[n];
			String[] end = new String[n];

			for (int i = 0; i < n; i++) {
				inputs[i] = sc.nextLine().trim();
				start[i] = inputs[i].substring(0, inputs[i].indexOf("*"));
				end[i] = inputs[i].substring(inputs[i].indexOf("*") + 1);
			}

			String result = "*";

			boolean found = true;

			for (int i = 0; i < n; i++) {
				found = true;
				for (int j = 0; j < n; j++) {

					if (!start[i].contains(start[j])) {
						found = false;
						break;
					}
				}

				if (found) {
					result = start[i];
					break;
				}
			}

			if (found) {
				for (int i = 0; i < n; i++) {
					found = true;
					for (int j = 0; j < n; j++) {

						if (!end[i].contains(end[j])) {
							found = false;
							break;
						}
					}

					if (found) {
						result += end[i];
						break;
					}
				}
			}

			System.out.println("Case #" + cs + ": " + (found ? result.replaceAll("\\*", "") : "*"));
		}
	}

}
