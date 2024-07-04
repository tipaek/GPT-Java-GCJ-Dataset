import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			String SO = sc.next();
			int OP = 0;
			int CP = 0;
			String SF = "";

			for (char c : SO.toCharArray()) {
				int x = c - '0';
				int dop = x - OP;
				int dcp = x - CP;
				if (dop < 0) {
					SF += repeat(-dop, ")");
					SF +=c;
					OP = OP + dop ;
					CP = x;
				} else if (dop> 0) {
					SF+= repeat(dop, "(");
					SF+=c; 
					OP = OP + dop ;
					CP = x;
				} else  {
					SF+=c;
				}

			}
			SF+=repeat(CP, ")");
			System.out.println("Case #" + i + ": " + SF);
		}
	}

	private static String repeat(int n, String s) {
		String ret = "";
		for (int i = 1; i <= n; i++) {
			ret += s;
		}
		return ret;
	}
}
