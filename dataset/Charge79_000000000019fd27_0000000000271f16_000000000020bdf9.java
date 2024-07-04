import java.util.Scanner;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		boolean cCheck = true, jCheck = true;
		int times = kbd.nextInt();
		for (int i = 1; i <= times; i++) {
			String output = "CJ";
			boolean[] cTime = new boolean[1440];
			boolean[] jTime = new boolean[1440];
			int n = kbd.nextInt();
			kbd.skip("[\r\n]+");
			String line = kbd.nextLine();
			String line2 = kbd.nextLine();
			// Case if endIn = 1440
			if (Integer.parseInt(line.substring(line.indexOf(" ") + 1)) == 1440 && n != 2) {
				Arrays.fill(cTime, Integer.parseInt(line.substring(0, line.indexOf(" ")).trim()),
						Integer.parseInt(line.substring(line.indexOf(" ") + 1).trim()), true);
			} else if (n != 2) {
				Arrays.fill(cTime, Integer.parseInt(line.substring(0, line.indexOf(" ")).trim()),
						Integer.parseInt(line.substring(line.indexOf(" ") + 1).trim()) + 1, true);
			}
			if (Integer.parseInt(line2.substring(line2.indexOf(" ") + 1)) == 1440 && n != 2) {
				Arrays.fill(jTime, Integer.parseInt(line2.substring(0, line.indexOf(" ")).trim()),
						Integer.parseInt(line2.substring(line.indexOf(" ") + 1).trim()), true);
			} else if (n != 2) {
				Arrays.fill(jTime, Integer.parseInt(line2.substring(0, line2.indexOf(" ")).trim()),
						Integer.parseInt(line2.substring(line.indexOf(" ") + 1).trim()) + 1, true);
			}
			for (int j = 2; j < n; j++) { // Check this
				String line3 = kbd.nextLine();
				int startIn = Integer.parseInt(line3.substring(0, line3.indexOf(" ")));
				int endIn = Integer.parseInt(line3.substring(line3.indexOf(" ") + 1));
				cCheck = cTime[startIn + 1] == false && cTime[endIn - 1] == false; // Check this
				jCheck = jTime[startIn + 1] == false && jTime[endIn - 1] == false;
				if (cCheck) {
					output += "C";
					Arrays.fill(cTime, startIn, endIn + 1, true);
				} else if (jCheck) {
					output += "J";
					Arrays.fill(jTime, startIn, endIn + 1, true);
				} else {
					output = "IMPOSSIBLE";
					break;
				}

			}
			System.out.println("Case #" + i + ": " + output);

		}
		kbd.close();

	}

}
