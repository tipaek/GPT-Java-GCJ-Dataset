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
			int[] cTime = new int[1441];
			int[] jTime = new int[1441];
			int numActivities = Integer.parseInt(kbd.nextLine());
			String[] times = new String[numActivities];
			for (int y = 0; y < numActivities; y++) {
				times[y] = kbd.nextLine();
			}
			for (int x = 0; x < numActivities; x++) { // Check this
				String[] line = times[x].split(" ");
				cCheck = true;
				jCheck = true;
				int startIn = Integer.parseInt(line[0]);
				int endIn = Integer.parseInt(line[1]);
				int c = startIn, j = startIn;
				while(c < endIn) {
					if(cTime[c] == 1) {
						cCheck = false;
						break;
					}
					c++;
				}
				while(j < endIn) {
					if(jTime[j] == 1) {
						jCheck = false;
						break;
					}
					j++;
				}
				if (cCheck) {
					output += "C";
					Arrays.fill(cTime, startIn, endIn, 1);
					cTime[endIn] = 3;
				} else if (jCheck) {
					output += "J";
					Arrays.fill(jTime, startIn, endIn, 1);
					jTime[endIn] = 3;
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
