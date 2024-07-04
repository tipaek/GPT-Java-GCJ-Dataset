import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		for (int i = 0; i < n; i++) {
			int n1 = Integer.parseInt(sc.next());
			String s[] = new String[n1];
			String z = "";
			ArrayList<String> res0 = new ArrayList<String>(n1);
			for (int j = 0; j < n1; j++)
				res0.add("");
			for (int j = 0; j < n1; j++) {
				String k = sc.next();
				k += " " + sc.next();
				s[j] = k;
			}
			for (int j = 0; j < n1; j++) {
				for (int k = j + 1; k < n1; k++) {
					String x0[] = s[j].split(" ");
					String x1[] = s[k].split(" ");
					if ((Integer.parseInt(x0[1]) < Integer.parseInt(x1[1])
							&& Integer.parseInt(x0[1]) > Integer.parseInt(x1[0]))
							|| (Integer.parseInt(x0[0]) > Integer.parseInt(x1[0])
									&& Integer.parseInt(x0[0]) < Integer.parseInt(x1[1]))
							|| (Integer.parseInt(x1[1]) < Integer.parseInt(x0[1])
									&& Integer.parseInt(x1[1]) > Integer.parseInt(x0[0]))
							|| (Integer.parseInt(x1[0]) > Integer.parseInt(x0[0])
									&& Integer.parseInt(x1[0]) < Integer.parseInt(x0[1]))
							|| (Integer.parseInt(x1[0]) <= Integer.parseInt(x0[0])
									&& Integer.parseInt(x1[1]) >= Integer.parseInt(x0[1]))
							|| (Integer.parseInt(x0[0]) <= Integer.parseInt(x1[0])
								&& Integer.parseInt(x0[1]) >= Integer.parseInt(x1[1]))) {
						if (res0.get(j) == "") {
							if (res0.get(k) == "") {
								res0.add(j, "C");
								res0.add(k, "J");
							} else if (res0.get(k) == "J") {
								res0.add(j, "C");
							} else if (res0.get(k) == "C") {
								res0.add(j, "J");
							}
						} else if (res0.get(j) == "C") {
							if (res0.get(k) == "") {
								res0.add(k, "J");
							} else if (res0.get(k) == "C") {
								z = "IMPOSSIBLE";
							}
						} else if (res0.get(j) == "J") {
							if (res0.get(k) == "") {
								res0.add(k, "C");
							} else if (res0.get(k) == "J") {
								z = "IMPOSSIBLE";
							}
						}
					} else {
						if (res0.get(j) == "")
							res0.add(j, "C");
						if (res0.get(k) == "")
							res0.add(k, "C");
					}
				}
			}
			if (z.length() == 0) {
				for (int j = 0; j < n1; j++) {
					z += res0.get(j);
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + z);
		}
		sc.close();
	}
}