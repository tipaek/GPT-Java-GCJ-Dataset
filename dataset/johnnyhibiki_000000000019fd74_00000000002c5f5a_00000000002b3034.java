import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Soution {

	String fnc(int n, String[] strs) {

		String left = "";
		String right = "";

		String[] lefts = new String[n];
		String[] rights = new String[n];
		String[] mids = new String[n];

		List<String> tmp = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			tmp.clear();
			String[] t = strs[i].split("\\*");
			
			for (String tt : t) {
				tmp.add(tt);
			}
			if (strs[i].endsWith("*")) {
				tmp.add("");
			} 
			
			lefts[i] = tmp.get(0);
			rights[i] = tmp.get(tmp.size()-1);

			mids[i] = "";
			for (int j = 1; j < tmp.size() - 1; j++) {
				mids[i] += tmp.get(j);
			}
		}

		Arrays.sort(lefts, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});

		Arrays.sort(rights, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});

		left = lefts[0];
		right = rights[0];

		boolean check = true;

		String mid = "";
		for (int i = 0; i < n; i++) {
			if (!left.isEmpty() && !lefts[i].isEmpty() && !left.startsWith(lefts[i])) {
				check = false;
				break;
			}

			if (!right.isEmpty() && !rights[i].isEmpty() && !right.endsWith(rights[i])) {
				check = false;
				break;
			}

			if (mids[i] != null && !mids[i].isEmpty()) {
				mid += mids[i];
			}
		}

		String ans = left + mid + right;

		return check ? ans : "*";
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				int n = sc.nextInt();
				String[] strs = new String[n];
				for (int i = 0; i < n; i++) {
					strs[i] = sc.next();
				}
				System.out.println("Case #" + t + ": " + fnc(n, strs));
			}
		}
	}

	public static void main(String[] args) {
		new Soution().run();
	}
}
