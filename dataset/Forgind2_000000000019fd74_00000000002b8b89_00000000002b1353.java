import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		int max = 1 << 30;
		for (int y = 1; y <= z; y++) {
			int currMax = max;
			int currRow = 30;
			int n = in.nextInt();
			in.nextLine();
			int maxT = 1;
			boolean[] fullRows = new boolean[31];
			while (n < currMax) {
				currMax >>= 1;
				currRow--;
			}
			if (currMax + currRow > n) {
				currMax >>= 1;
				currRow--;
			}
			fullRows[currRow] = true;
			maxT = currRow;
			n -= currMax + currRow;
			currMax >>= 1;
			currRow--;
			while (n > 0 && currRow > 0) {
				if (n > currMax - 2) {
					n -= currMax - 1;
					fullRows[currRow] = true;
				}
				currMax >>= 1;
				currRow--;
			}
			System.out.println("Case #" + y + ":");
			int row = 1;
			boolean left = true;
			for (int i = 0; i <= maxT; i++) {
				if (fullRows[i]) {
					printRow(row, left);
					left = !left;
				}
				else {
					System.out.println(row + " " + (left ? 1 : row));
				}
				row++;
			}
			while (n > 0) {
				System.out.println(row + " " + (left ? 1 : row));
				row++;
				n--;
			}
		}
		in.close();
	}
	private static void printRow(int row, boolean leftStart) {
		if (leftStart) {
			for (int i = 1; i <= row; i++)
				System.out.println(row + " " + i);
		}
		else {
			for (int i = row; i > 0; i--)
				System.out.println(row + " " + i);
		}
	}
}
