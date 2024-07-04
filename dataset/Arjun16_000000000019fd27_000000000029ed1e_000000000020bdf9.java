import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= t; i++) {
			int a = Integer.parseInt(sc.nextLine());
			int[][] arr = new int[a][3];
			for (int j = 0; j < a; j++) {
				String s = sc.nextLine();
				arr[j][0] = Integer.parseInt(s.split(" ")[0]);
				arr[j][1] = Integer.parseInt(s.split(" ")[1]);
				arr[j][2] = 0;
			}

			System.out.println("Case #" + i + ": " + overlap(arr));

		}

	}

	private static String overlap(int[][] arr) {
		String order = "";
		for (int i = 0; i < arr.length; i++) {
			int c = -1;
			for (int j = 0; j < arr.length; j++) {
				if ((arr[i][0] > arr[j][0] && arr[i][0] < arr[j][1]) || (arr[i][1] > arr[j][0] && arr[i][1] < arr[j][1])
						|| (arr[j][0] > arr[i][0] && arr[j][0] < arr[i][1])
						|| (arr[j][1] > arr[i][0] && arr[j][1] < arr[i][1])) {

					if (c == -1) {
						c = j;
					} else if ((arr[c][0] > arr[j][0] && arr[c][0] < arr[j][1])
							|| (arr[c][1] > arr[j][0] && arr[c][1] < arr[j][1])
							|| (arr[j][0] > arr[c][0] && arr[j][0] < arr[c][1])
							|| (arr[j][1] > arr[c][0] && arr[j][1] < arr[c][1])) {
						return "IMPOSSIBLE";
					}
					c = j;
					if (c != -1 && arr[i][2] == 0) {
						arr[c][2] = 1;
					} else if (c != -1 && arr[i][2] == 1) {
						arr[c][2] = 0;
					}
				}
			}

		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][2] == 0)
				order += "J";

			else
				order += "C";
			System.out.println(order);
		}
		return order;

	}

}
