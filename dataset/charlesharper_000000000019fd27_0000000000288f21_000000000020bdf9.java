import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numcases = Integer.parseInt(br.readLine());

		for (int i = 0; i < numcases; i++) {
			int l = Integer.parseInt(br.readLine());
			int[][] arr = new int[l][2];
			boolean[] cameron = new boolean[1442];
			boolean[] jamie = new boolean[1442];
			String out = "";

			for (int k = 0; k < l; k++) {
				String[] dummy = br.readLine().split(" ");
				for (int p = 0; p < 2; p++) {
					arr[k][p] = Integer.parseInt(dummy[p]);
				}
			}
			System.out.println("Case #" + (i+1) + ": " + recurse(0, arr, cameron, jamie, new char[arr.length]));
			for (int k = 0; k < arr.length; k++) {
				if (cameron[arr[k][0]] == false) {
					if (cameron[arr[k][1]] == false || (cameron[arr[k][1]] == true && cameron[arr[k][1]+1] == false)) {
						out += "C";
						for (int j = arr[k][0]; j <= arr[k][1]; j++) {
							cameron[j] = true;
						}
					}
				}
				else if (jamie[arr[k][0]] == false) {
					if (jamie[arr[k][1]] == false || (jamie[arr[k][1]] == true && jamie[arr[k][1]+1] == false)) {
						out += "J";
						for (int j = arr[k][0]; j <= arr[k][1]; j++) {
							jamie[j] = true;
						}
					}
				}
				else {
					System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
					out = "";
					break;
				}
			}
			if (out.length() > 0) {
				System.out.println("Case #" + (i+1) + ": " + out.toString());
			}
		}
	}

}
