import java.util.*;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		boolean cCheck = true, jCheck = true;
		int times = kbd.nextInt();
		for (int i = 1; i <= times; i++) {
			String output = "";
			boolean[] cTime = new boolean[1440];
			boolean[] jTime = new boolean[1440];
			int n = kbd.nextInt();
			kbd.skip("[\r\n]+");
			for (int j = 0; j < n; j++) { // Check this
				String line = kbd.nextLine();
				int startIn = Integer.parseInt(line.substring(0, line.indexOf(" ")));
				int endIn = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
				cCheck = cTime[startIn + 1] == false && cTime[endIn - 1] == false; // Check this
				jCheck = jTime[startIn + 1] == false && jTime[endIn - 1] == false;
				if (cCheck) {
					output += "C";
					if (endIn == 1440) {
						Arrays.fill(cTime, Integer.parseInt(line.substring(0, line.indexOf(" "))),
								Integer.parseInt(line.substring(line.indexOf(" ") + 1)), true);
					} else {
						Arrays.fill(cTime, Integer.parseInt(line.substring(0, line.indexOf(" "))),
								Integer.parseInt(line.substring(line.indexOf(" ") + 1)) + 1, true);
					}
				} else if (jCheck) {
					output += "J";
					if (endIn == 1400) {
						Arrays.fill(jTime, Integer.parseInt(line.substring(0, line.indexOf(" "))),
								Integer.parseInt(line.substring(line.indexOf(" ") + 1)), true);
					} else {
						Arrays.fill(jTime, Integer.parseInt(line.substring(0, line.indexOf(" "))),
								Integer.parseInt(line.substring(line.indexOf(" ") + 1)) + 1, true);
					}
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

