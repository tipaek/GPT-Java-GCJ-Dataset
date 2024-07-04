
import java.util.Locale;
import java.util.Scanner;

public class Solution {

	int[] mins = new int[10000000];

	void solve(int icase) {
		int x =si();
		int y = si();

		int k = mins[Math.abs(x) + Math.abs(y)];

		Boolean isValid = true;
		if(k == 0)
		{
			//printf("Case #%d: ", icase);
			isValid = false;
			System.out.println("Case #" + icase + ": " + "IMPOSSIBLE");
		}
		char[] res = new char[k];

		int currentCount= 0;
		int count = 1;
		while (x != 0 || y != 0 || k > 0) {
 			currentCount = (int)Math.pow(2, k-1);
			count++;
			char c;
			if (Math.abs(x) > Math.abs(y)) {
				if (x > 0) {
					x -= currentCount;
					c = 'E';
				} else {
					x += currentCount;
					c = 'W';
				}
			} else {
				if (y > 0) {
					y -= currentCount;
					c = 'N';
				} else {
					y += currentCount;
					c = 'S';
				}
			}
			k--;
			if(k >= 0)
			{
				res[k] = c;
			}else{
			    break;
			}
			
		}

		if(isValid)
		{
			printf("Case #%d: ", icase);
			for (int i = 0; i < res.length; i++) {
		System.out.print(res[i]);
			}

			System.out.println();
		}
		
	}

	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);
		new Solution().repSolve();
	}

	void repSolve() throws Exception {
		int k = 0;
		for (int i = 1;; i++) {
			k += Math.pow(2, i-1);
			if (k >= mins.length) {
				break;
			}
			for (int j = k; j > 0; j -= 2) {
				if (mins[j] != 0) {
					break;
				}
				mins[j] = i;
			}
		}

		scanner = new Scanner(System.in);
		// scanner = new Scanner(new java.io.File(""));
		int ncase = si();
		sline();
		for (int icase = 1; icase <= ncase; icase++) {
			solve(icase);
			//System.err.println("[[ " + icase + " ]]");
		}
	}

	Scanner scanner;

	int si() {
		return scanner.nextInt();
	}

	long sl() {
		return scanner.nextLong();
	}

	String ss() {
		return scanner.next();
	}

	String sline() {
		return scanner.nextLine();
	}

	void printf(String format, Object... args) {
		System.out.printf(format, args);
	}

}