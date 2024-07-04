
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static Scanner scan;

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = scan.nextInt();
		for (long it = 1; it <= t; ++it) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			String m = scan.next("[A-Z]+");

			String res = cal(x, y, m);
			System.out.println("Case #" + it + ": " + res);
		}
		scan.close();
	}

	private static String cal(int x, int y, String m) {
		int catx = x, caty = y;
		int sumcat = 0;
		for (int im = 0; im < m.length(); ++im) {
			int sumkon = Math.abs(catx) + Math.abs(caty);
			if (sumkon <= sumcat) {
				return String.valueOf(sumcat);
			}
			char dir = m.charAt(im);
			if (dir == 'N')
				caty++;
			else if (dir == 'S')
				caty--;
			else if (dir == 'E')
				catx++;
			else if (dir == 'W')
				catx--;
			sumcat++;
		}
		int sumkon = Math.abs(catx) + Math.abs(caty);
		if (sumkon <= sumcat) {
			return String.valueOf(sumcat);
		}
		return "IMPOSSIBLE";
	}

}