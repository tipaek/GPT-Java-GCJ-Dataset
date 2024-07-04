import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		boolean cCheck = true, jCheck = true;
		int testCases = Integer.parseInt(kbd.nextLine());
		String result[] = new String[testCases];
		for (int i = 0; i < testCases; i++) {
			String output = "";
			boolean[] cTime = new boolean[1441];
			boolean[] jTime = new boolean[1441];
			int numActivities = Integer.parseInt(kbd.nextLine());
			String[] times = new String[numActivities];
			for (int j = 0; j < numActivities; j++) {
				times[j] = kbd.nextLine();
			}
			for (int j = 0; j < numActivities; j++) { // Check this
				String[] line = times[j].split(" ");
				int startIn = Integer.parseInt(line[0]);
				int endIn = Integer.parseInt(line[1]);
				cCheck = cTime[startIn] == false && cTime[endIn - 1] == false; // Check this
				jCheck = jTime[startIn] == false && jTime[endIn - 1] == false;
				if (cCheck) {
					output += "C";
					Arrays.fill(cTime, startIn, endIn, true);
				} else if (jCheck) {
					output += "J";
					Arrays.fill(jTime, startIn, endIn, true);
				} else {
					output = "IMPOSSIBLE";
					break;
				}

			}
			result[i] = output;
		}
		for (int z = 0; z < testCases; z++) {
			System.out.println("Case #" + (z + 1) + ": " + result[z]);
		}
		kbd.close();

	}

}
