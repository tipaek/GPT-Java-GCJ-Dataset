import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//javac Solution.java
//python interactive_runner.py python.exe testing_tool.py 0 -- java Solution

public class Solution {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 1; i <= T; i++) {
			long l = input.nextInt();
			long r = input.nextLong();
			long pom = Math.abs(l - r) * 2L;
			long pom2 = (long)Math.sqrt(pom);
			while (true) {
				if (pom2 * pom2 + pom2 <= pom) {
					break;
				}
				pom2--;
			}
			long max = l;
			long min = r;
			if (r > max) {
				max = r;
				min = l;
			}
			max = max - ((pom2 * pom2 + pom2) / 2);
			long indexL = 0;
			long indexH = 2000000009L;
			pom2++;
			while (indexL < indexH) {
				long mid = (indexL + indexH) / 2;
				long midH = mid / 2 + mid % 2;
				long midL = mid / 2;
				long totH = pom2 * midH + (midH * midH - midH);
				long totL = (pom2 + 1) * midL + (midL * midL - midL);
				if (max < totH || min < totL) {
					indexH = mid - 1;
				} else {
					indexL = mid + 1;
				}
			}
			long mid = (indexL + indexH) / 2;
			long midH = mid / 2 + mid % 2;
			long midL = mid / 2;
			long resH = max - (pom2 * midH + (midH * midH - midH));
			long resL = min - ((pom2 + 1) * midL + (midL * midL - midL));
			if (resH < 0 || resL < 0) {
				mid = (indexL + indexH) / 2 - 1;
				midH = mid / 2 + mid % 2;
				midL = mid / 2;
				resH = max - (pom2 * midH + (midH * midH - midH));
				resL = min - ((pom2 + 1) * midL + (midL * midL - midL));
			}
			if (resH < 0 || resL < 0) {
				mid = (indexL + indexH) / 2 - 2;
				midH = mid / 2 + mid % 2;
				midL = mid / 2;
				resH = max - (pom2 * midH + (midH * midH - midH));
				resL = min - ((pom2 + 1) * midL + (midL * midL - midL));
			}
			pom2--;
			if (l >= r || max == min) {
				System.out.println("Case #" + i + ": " + (mid + pom2) + " " + resH + " " + resL);
			} else {
				System.out.println("Case #" + i + ": " + (mid + pom2) + " " + resL + " " + resH);
			}
		}
	}
}