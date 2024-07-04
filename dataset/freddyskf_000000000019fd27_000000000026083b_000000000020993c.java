import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int k, r, c;
		for (int n = 1; n <= t; ++n) {
			k = r = c = 0;
			int size = in.nextInt();
			int vals[][] = new int[size][size];
			for (int i = 0; i < size; i++) {
				String string = in.nextLine();
				for (int j = 0; j < size; j++) {
					vals[i][j] = Integer.parseInt(string.split(" ")[j]);
					if (j == i) {
						k += vals[i][j];
					}
				}
			}
			Set<Integer> rSet, cSet;
			boolean rBool, cBool;
			for (int i = 0; i < size; i++) {
				rSet = new HashSet<>();
				cSet = new HashSet<>();
				rBool = false;
				cBool = false;
				for (int j = 0; j < size; j++) {
					if (rSet.add(vals[i][j]) == false) {
						rBool = true;
					}
					if (cSet.add(vals[j][i]) == false) {
						cBool = true;
					}
				}
				if (rBool) {
					r++;
				}
				if (cBool) {
					c++;
				}
			}

			System.out.println("Case #" + n + ": " + k + " " + r + " " + c);
		}
	}

}