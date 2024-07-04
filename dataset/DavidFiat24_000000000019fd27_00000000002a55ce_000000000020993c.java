import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int cases = Integer.parseInt(reader.nextLine());
		for (int i = 0; i < cases; i++) {
			int size = Integer.parseInt(reader.nextLine());
			int[][] m = new int[size][size];
			for (int i2 = 0; i2 < size; i2++) {
				String[] a = reader.nextLine().split(" ");

				for (int i3 = 0; i3 < size; i3++) {
					m[i2][i3] = Integer.parseInt(a[i3]);

				}

			}

			int rows = 0;
			int columns = 0;
			int trace = 0;
			for (int j = 0; j < size; j++) {
				boolean repeatedRow = false;
				boolean repeatedColumn = false;
				trace += m[j][j];
				for (int h = 0; h < size; h++) {

					int c = 0;
					int x = m[j][h];

					while (c < size) {
						if (c != h) {
							if (x == m[j][c]) {
								repeatedRow = true;
							}
							if (x == m[c][j]) {
								repeatedColumn = true;
							}
						}
						c++;

					}

				}

				if (repeatedRow == true) {
					rows++;
				}
				if (repeatedColumn == true) {
					columns++;
				}
			}
			String ms = "Case #" + (i + 1) + ": " + trace + " " + rows + " " + columns;
			System.out.println(ms);
		}

	}

}
