import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		boolean cCheck = true, jCheck = true;
		int times = Integer.parseInt(kbd.nextLine());
		String result[] = new String[times];
		for (int i = 0; i < times; i++) {
			String output = "";
			boolean[] cTime = new boolean[1441];
			boolean[] jTime = new boolean[1441];
			int n = Integer.parseInt(kbd.nextLine());
			for (int j = 0; j < n; j++) {
				String[] line = kbd.nextLine().split(" ");
				int startIn = Integer.parseInt(line[0]);
				int endIn = Integer.parseInt(line[1]);
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
			result[i] = output;
		}
		for (int z = 0; z < times; z++) {
			System.out.println("Case #" + (z + 1) + ": " + result[z]);
		}
		kbd.close();

	}

}
