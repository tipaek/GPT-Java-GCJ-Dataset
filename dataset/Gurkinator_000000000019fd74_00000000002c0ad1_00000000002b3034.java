import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private Scanner scanner = new Scanner(System.in);

	private String solve() throws Exception {
		int			n	= scanner.nextInt();
		List<String>	list	= new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			list.add(scanner.next());
		}
		String	longest			= "";
		int		longestIndex	= 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() > longest.length()) {
				longest			= list.get(i);
				longestIndex	= i;
			}
		}
		list.remove(longestIndex);

		String r = "";

		String	front	= longest.substring(0, longest.length() - 1);
		String	back	= "";
		for (int i = 0; i < longest.length() - 1; i++) {
			if (longest.charAt(i) == 42) {
				front	= longest.substring(0, i);
				back	= longest.substring(i + 1, longest.length());
			}
		}
		for (int i = 0; i < list.size(); i++) {
			String	front1	= list.get(i).substring(0, list.get(i).length() - 1);
			String	back1	= "";
			for (int j = 0; j < list.get(i).length() - 1; j++) {
				if (list.get(i).charAt(j) == 42) {
					front1	= list.get(i).substring(0, j);
					back1	= list.get(i).substring(j + 1, list.get(i).length());
				}
			}
			if (front.contains(front1)) {
				r += front;
			} else if (front1.contains(front)) {
				r += front1;
			} else {
				return "*";
			}
			// *
			if (back.contains(back1)) {
				r += back;
			} else if (back1.contains(back)) {
				r += back1;
			} else {
				return "*";
			}
		}
		return r;
	}

	private void run() throws Exception {
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.printf("Case #%d: %s%n", i + 1, solve());
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
