import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ParentingPartneringReturns {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
		boolean cCheck = true, jCheck = true;
		int times = Integer.parseInt(kbd.readLine());
		String result[] = new String[times];
		for (int i = 0; i < times; i++) {
			String output = "";
			boolean[] cTime = new boolean[1440];
			boolean[] jTime = new boolean[1440];
			int n = Integer.parseInt(kbd.readLine());
			for (int j = 0; j < n; j++) { // Check this
				String line = kbd.readLine();
				int startIn = Integer.parseInt(line.substring(0, line.indexOf(" ")));
				int endIn = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
				cCheck = cTime[startIn + 1] == false && cTime[endIn - 1] == false; // Check this
				jCheck = jTime[startIn + 1] == false && jTime[endIn - 1] == false;
				if (cCheck) {
					output += "C";
					if (endIn == 1440) {
						Arrays.fill(cTime, startIn, endIn, true);
					} else {
						Arrays.fill(cTime, startIn, endIn + 1, true);
					}
				} else if (jCheck) {
					output += "J";
					if (endIn == 1400) {
						Arrays.fill(jTime, startIn, endIn, true);
					} else {
						Arrays.fill(jTime, startIn, endIn + 1, true);
					}
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
