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
			if(front.length() >= front1.length()) {
				for (int j = 0; j < front1.length(); j++) {
					if(front1.charAt(j) != front.charAt(j)) return "*";
				}
				r += front;
			}else {
				for (int j = 0; j < front.length(); j++) {
					if(front.charAt(j) != front1.charAt(j)) return "*";
				}
				r += front1;
			}
			// *
			StringBuffer backS = new StringBuffer(back);
			backS = backS.reverse();
			StringBuffer backS1 = new StringBuffer(back1);
			backS1 = backS1.reverse();
			if (back.length() >= backS1.length()) {
				for (int j = 0; j < backS1.length(); j++) {
					if (backS1.charAt(j) != backS.charAt(j)) return "*";
				}
				r += back;
			} else {
				for (int j = 0; j < backS.length(); j++) {
					if (backS.charAt(j) != backS1.charAt(j)) return "*";
				}
				r += back1;
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
