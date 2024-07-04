import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			String s = scn.next();
			sb.append("Case #"+(t+1)+": ");
			int tb = 0;

			for (int i = 0; i < s.length(); i++) {
				int req = s.charAt(i) - '0';
				if (req > tb) {
					int v = req - tb;
					while (v > 0) {
						sb.append("(");
						v--;
					}
				} else if (req < tb) {
					int v = tb-req;
					while (v > 0) {
						sb.append(")");
						v--;
					}
				}
				sb.append(req);
				tb = req;
			}
			while (tb > 0) {
				sb.append(")");
				tb--;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
