import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for (int t = 0; t < N; t++) {
			StringBuilder str = new StringBuilder();
			int depth = 0;
			char[] digits = scan.next().strip().toCharArray();
			for (char c : digits) {
				int d = c - '0';
				if (d > depth) {
					str.append("(".repeat(d-depth));
				} else {
					str.append(")".repeat(depth-d));
				}
				depth = d;
				str.append(c);
			}
			str.append(")".repeat(depth));
			System.out.println("Case #"+(t+1)+": "+str.toString());
		}
		scan.close();
	}
}