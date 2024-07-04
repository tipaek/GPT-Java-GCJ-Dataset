import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfCases = in.nextInt();
		in.nextLine();
		f: for (int i = 0; i < numberOfCases; i++) {
			int size = in.nextInt();
			int[][] times = new int[size][3];
			String[] order = new String[size];
			// int CS = 0;
			int cE = 0;
			// int JS = 0;
			int jE = 0;

			for (int l = 0; l < size; l++) { // add to times
				times[l][0] = in.nextInt();
				// System.out.println(times[l][0]);
				times[l][1] = in.nextInt();
				times[l][2] = 0; // assigned bool
				if (numberOfCases != i + 1 || l + 1 != size) {
					in.nextLine();
				}
			}

			int currentT = 0;

			// loop here

			for (int c = 0; c < size; c++) {
				int low = Integer.MAX_VALUE;
				// Get next lowest
				int q = 0;
				for (int[] time : times) {
					if (time[2] == 1) {
						// skips if already assigned
					} else if (time[0] < low) {
						low = time[0];
						currentT = q;
					}

					q++;
				}
				System.out.println(times[currentT][0]);
				if (cE <= times[currentT][0]) {
					order[currentT] = "C";
					times[currentT][2] = 1;
					cE = times[currentT][1];
				} else if (jE <= times[currentT][0]) {
					order[currentT] = "J";
					times[currentT][2] = 1;
					jE = times[currentT][1];
				} else {
					System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
					continue f;
				}

			}

			String output = "";
			for (String letter : order) {
				output += letter;
			}

			System.out.println("Case #" + (i + 1) + ": " + output);
		}
	}
}