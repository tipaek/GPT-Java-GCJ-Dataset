import java.io.*;
import java.util.*;
public class Solution {

	public static String recurse(int counter, int[][] times, boolean[] cameron, boolean[] jamie,
			String out) {
		if (counter == times.length) {
			counter -= 1;
			if (cameron[times[counter][0]] == true) {
				if (cameron[times[counter][1]] == true && cameron[times[counter][1]+1] == true) {
					if (jamie[times[counter][0]] == true) {
						if (jamie[times[counter][1]] == true && jamie[times[counter][1]+1] == true) {
							return "IMPOSSIBLE";
						}
					}
				}
			}
			return out;
		}
		if (cameron[times[counter][1]] == false) {
			if (cameron[times[counter][0]] == false || (cameron[times[counter][0]] == true && 
					cameron[times[counter][0]+1] == false)) {
				for (int j = times[counter][0]; j <= times[counter][1]; j++) {
					cameron[j] = true;
				}
				return recurse(counter + 1, times, cameron, jamie, out + "C");
			}
		}
		if (jamie[times[counter][1]] == false) {
			if (jamie[times[counter][0]] == false || (jamie[times[counter][0]] == true && 
					jamie[times[counter][0]+1] == false)) {
				for (int j = times[counter][0]; j <= times[counter][1]; j++) {
					jamie[j] = true;
				}
				return recurse(counter + 1, times, cameron, jamie, out+"J");
			}
		}
		return "IMPOSSIBLE";
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numcases = Integer.parseInt(br.readLine());

		for (int i = 0; i < numcases; i++) {
			int l = Integer.parseInt(br.readLine());
			int[][] arr = new int[l][2];
			boolean[] cameron = new boolean[1442];
			boolean[] jamie = new boolean[1442];

			for (int k = 0; k < l; k++) {
				String[] dummy = br.readLine().split(" ");
				for (int p = 0; p < 2; p++) {
					arr[k][p] = Integer.parseInt(dummy[p]);
				}
			}
			System.out.println("Case #" + (i+1) + ": " + recurse(0, arr, cameron, jamie, ""));
		}
	}

}
