package One;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = file.nextInt();
		for (int k = 1; k <=t; k++) {
			int t1 = file.nextInt();
			int[][] hey = new int[t1][t1];
			for (int i = 0; i < hey.length; i++) {
				for (int j = 0; j < hey[i].length; j++) {
					hey[i][j] = file.nextInt();
				}
			}
			System.out.println("Test Case #" + k+ ": " + method(hey));
		}
	}

	public static String method(int[][] hey) {
		int rows = 0;
		int col = 0;
		int trace = 0;
		for (int i = 0; i < hey.length; i++) {
			trace += hey[i][i];
		}
		for (int k = 0; k < hey.length; k++) {
			for (int i = 0; i < hey.length; i++) {
				boolean pp = false;
				for (int j = i + 1; j < hey.length; j++) {
					if (hey[k][i] == hey[k][j]) {
						rows++;
						pp = true;
						break;
					}
				}

				if (pp == true) {
					break;
				}
			}
		}

		for (int k = 0; k < hey.length; k++) {
			for (int i = 0; i < hey.length; i++) {
				boolean pp = false;
				for (int j = i + 1; j < hey.length; j++) {
					if (hey[i][k] == hey[j][k]) {
						col++;
						pp = true;
						break;
					}
				}

				if (pp == true) {
					break;
				}
			}
		}
		return trace + " " + rows + " " + col + " ";
	}
}
