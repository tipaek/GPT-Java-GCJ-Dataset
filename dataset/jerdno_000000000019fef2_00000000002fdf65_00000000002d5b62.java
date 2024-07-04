import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

//javac Solution2.java
//python interactive_runner.py python.exe testing_tool.py 0 -- java Solution2
//change name before submit

public class Solution {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 1; i <= T; i++) {
			long orgX = input.nextInt();
			long orgY = input.nextInt();
			long x = abs(orgX);
			long y = abs(orgY);
			if ((x + y) % 2 == 0) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
				continue;
			}
			long max = 0;
			int step = 0;
			while(max < (x + y)) {
				max = max + (long)Math.pow(2, step);
				step++;
			}
			step--;
			String res = "";
			for (int ii = step; ii >= 0; ii--) {
				long pom = (long)Math.pow(2, ii);
				if (abs(orgX) > abs(orgY)) {
					if (orgX > 0) {
						orgX = orgX - pom;
						res = "E" + res;
					} else {
						orgX = orgX + pom;
						res = "W" + res;
					}
				} else {
					if (orgY > 0) {
						orgY = orgY - pom;
						res = "N" + res;
					} else {
						orgY = orgY + pom;
						res = "S" + res;
					}
				}
			}
			System.out.println("Case #" + i + ": " + res);
		}
	}
}