import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int testCases = in.nextInt();
			for (int i = 1; i <= testCases; ++i) {
				String out = "IMPOSSIBLE";
				Boolean flag = false;
				Integer x = in.nextInt();
				Integer y = in.nextInt();
				Integer east = x;
				Integer north = y;
				String dir = in.next();
				char[] dirCharArray = dir.toCharArray();
				int counter = 0;
				Integer min = east + north;
				for (int c = 0; c < dirCharArray.length; c++) {
					counter++;
					if (dirCharArray[c] == 'S') {
						north--;
					} else if (dirCharArray[c] == 'W') {
						east--;
					} else if (dirCharArray[c] == 'N') {
						north++;
					} else if (dirCharArray[c] == 'E') {
						east++;
					}
					if (min >= Math.abs(east) + Math.abs(north)) {
						min = Math.abs(east) + Math.abs(north);
						if (min <= counter) {
							flag = true;
							break;
						}
					}
				}
				if (flag) {
					out = Integer.toString(counter);
				}
				output(i, out);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	private static void output(int caseNumber, String s) {
		System.out.println("Case #" + caseNumber + ": " + s);
	}
}