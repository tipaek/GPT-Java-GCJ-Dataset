import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		for (int y = 1; y <= z; y++) {
			String x = in.nextLine().trim();
			Digit[] digs = new Digit[x.length()];
			int soFar = 0;
			for (int a = 0; a < x.length(); a++) {
				digs[a] = new Digit(Integer.parseInt("" + x.charAt(a)));
				if (soFar > digs[a].needs) {
					digs[a-1].after = soFar - digs[a].needs;
				}
				else if (soFar < digs[a].needs) {
					digs[a].before = digs[a].needs - soFar;
				}
				soFar = digs[a].needs;
			}
			digs[digs.length - 1].after = soFar;
			StringBuilder sb = new StringBuilder();
			for (int a = 0; a < x.length(); a++) {
				for (int b = 0; b < digs[a].before; b++)
					sb.append('(');
				sb.append(digs[a].needs);
				for (int b = 0; b < digs[a].after; b++)
					sb.append(')');
			}
			System.out.println("Case #" + y + ": " + sb.toString());
		}
		in.close();
	}
	private static class Digit {
		private int before;
		private int after;
		private int needs;
		public Digit(int x) {
			before = 0;
			after = 0;
			needs = x;
		}
	}
}
