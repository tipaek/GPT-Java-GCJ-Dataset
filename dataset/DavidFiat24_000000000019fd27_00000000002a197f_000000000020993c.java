import java.util.Arrays;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int cases = Integer.parseInt(reader.nextLine());
		for (int i = 0; i < cases; i++) {
			int size = Integer.parseInt(reader.nextLine());
			int[][] m = new int[size][size];
			for (int i2 = 0; i2 < size; i2++) {
				for (int i3 = 0; i2 < size; i3++) {
					String[] a = reader.nextLine().split(" ");
					m[i2][i3] = Integer.parseInt(a[i3]);

				}

			}
			int rows = 0;
			int columns = 0;
			int trace = 0;
			for (int j = 0; j < size; j++) {
				boolean repeatedRow = false;
				boolean repeatedColumn = false;
				int h = 0;
				int x = m[j][h];
				while (h < size) {
					trace += m[h][h];
					if (h + 1 != size) {
						if (x == m[j][h + 1]) {
							repeatedRow = true;
						}
						if (x == m[h + 1][j]) {
							repeatedColumn = true;
						}
					}
					h++;
				}
				if (repeatedRow == true) {
					rows++;
				}
				if (repeatedColumn == true) {
					rows++;
				}
			}
			String ms = "Case #" + (i + 1) + ": " + trace + " " + rows + " " + columns;
			System.out.println(ms);
		}

	}

}
