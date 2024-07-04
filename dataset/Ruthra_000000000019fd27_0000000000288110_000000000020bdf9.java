
import java.util.Scanner;

public class Solution {
	static Scanner s = new Scanner(System.in);
	static int t = s.nextInt();

	public static void main(String[] args) {
		int i, m;
		int[] b = new int[t];
		String[] task = new String[t];
		for (i = 0; i < t; i++) {
			b[i] = s.nextInt();
			int[] c = new int[b[i]];
			int[] d = new int[b[i]];
			for (m = 1; m <=b[i]; m++) {
				c[m-1] = s.nextInt();
				d[m-1] = s.nextInt();
			}
			String name = sortTime(c, d);
			task[i] = name;

		}
		for (i = 0; i < t; i++) {
			System.out.println("Case #" + (i + 1) + ": " + task[i]);
		}
	}

	private static String sortTime(int[] c, int[] d) {
		int[] start = new int[1441];
		int[] end = new int[1441];
		String name = "";
		int fail = 0, i, j;
		for (i = 0; i < c.length; i++) {
			fail = 0;
			if(c[i] >= d[i]){
				fail =1;
				break;
			}
			for (j = c[i]; j <= d[i]; j++) {
				if (start[c[i]] == 2 || start[d[i]] == 2) {
					fail = 1;
					break;
				} else if (j == c[i] || j == d[i]) {
					start[j] = 3;
				} else if (start[j] == 2) {
					fail = 1;
					break;
				} else {
					start[j] = 2;
				}
				if (j == d[i]) {
					name += "C";
				}
			}
			if (fail == 1) {
				for (j = c[i]; j <= d[i]; j++) {
					if (end[c[i]] == 2 || end[d[i]] == 2) {
						fail = 1;
						break;
					} else if (j == c[i] || j == d[i]) {
						end[j] = 3;
					} else if (end[j] == 2) {
						fail = 1;
						break;
					} else {
						end[j] = 2;
					}
					if (j == d[i]) {
						name += "J";
						fail = 0;
					}
				}
			}
			if (fail == 1) {
				name = "IMPOSSIBLE";
				break;
			}
		}if (fail == 1) {
			name = "IMPOSSIBLE";
		}
		return name;
	}
}
