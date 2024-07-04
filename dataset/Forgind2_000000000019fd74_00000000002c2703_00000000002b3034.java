import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		for (int y = 1; y <= z; y++) {
			int n = in.nextInt();
			in.nextLine();
			Pattern p = new Pattern();
			boolean succeeded = true;
			for (int a = 0; a < n; a++) {
				if (!p.meld(in.nextLine().trim())) {
					succeeded = false;
					break;
				}
			}
			System.out.println("Case #" + y + ": " + (succeeded ? p.getVal() : "*"));
		}
		in.close();
	}
	private static class Pattern {
		private LinkedList<String> pattern;
		public Pattern() {
			pattern = new LinkedList<String>();
		}
		public boolean meld(String x) {
			String[] y = x.split("\\*");
			if (pattern.isEmpty()) {
				if (x.charAt(0) == '*')
					pattern.add("");
				for (String t: y)
					pattern.add(t);
				if (x.charAt(x.length() - 1) == '*')
					pattern.add("");
				return true;
			}
			if (pattern.getFirst().startsWith(y[0]) || x.charAt(0) == '*') {
				if (pattern.getLast().endsWith(y[y.length - 1]) || x.charAt(x.length() - 1) == '*') {
				}
				else if (y[y.length - 1].endsWith(pattern.getLast())){
					pattern.pollLast();
					pattern.addLast(y[y.length - 1]);
				}
				else {
					return false;
				}
				for (int a = 1; a < y.length - 1; a++)
					pattern.add(1, y[a]);
			}
			else if (y[0].startsWith(pattern.getFirst())) {
				pattern.set(0, y[0]);
				if (pattern.getLast().endsWith(y[y.length - 1]) || x.charAt(x.length() - 1) == '*') {
				}
				else if (y[y.length - 1].endsWith(pattern.getLast())){
					pattern.pollLast();
					pattern.addLast(y[y.length - 1]);
				}
				else {
					return false;
				}
				for (int a = 1; a < y.length - 1; a++)
					pattern.add(1, y[a]);
			}
			return true;
		}
		public String getVal() {
			StringBuilder sb = new StringBuilder();
			for (String x: pattern)
				sb.append(x);
			return sb.toString();
		}
	}
}
