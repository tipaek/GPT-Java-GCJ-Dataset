package codeJam2020;

import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int row, col, sum;
		HashSet<String> set = new HashSet<String>();
		HashSet<Integer> set1 = new HashSet<Integer>();
		int times = kbd.nextInt();
		for (int i = 1; i <= times; i++) {
			int n = kbd.nextInt();
			kbd.skip("[\r\n]+");
			col = 0;
			row = 0;
			sum = 0;
			String arr[][] = new String[n][n];
			for (int j = 0; j < n; j++) {
				String[] num = kbd.nextLine().split(" ");
				arr[j] = num;
				sum += Integer.parseInt(num[j]);
				for (String w : num) {
					if (set.add(w) == false) {
						row++;
						break;
					}
				}
				set.clear();
			}
			for (int c = 0; c < n; c++) {
				for (int r = 0; r < n; r++) {
					if (set.add(arr[r][c]) == false && set1.add(c)) {
						col++;
					}
				}
				set.clear();
				set1.clear();
			}
			System.out.println("Case #" + i + ": " + sum + " " + row + " " + col);
		}
		kbd.close();
	}

}
