import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int totalCase = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= totalCase; i++) {
			int size = Integer.parseInt(sc.nextLine()); // size
			int[][] box = new int[size][size];
			int sum1 = 0;
			for (int j = 0; j < size; j++) {
				String[] in = sc.nextLine().split(" ");
				for (int k = 0; k < size; k++) {
					box[j][k] = Integer.parseInt(in[k]);
					if (j == k)
						sum1 += box[j][k];
				}
			}

			// #1 ans (pre calua done)
			// #2 ans
			int sum2 = 0;
			boolean[] arr = new boolean[size + 1];
			boolean[] dep = new boolean[size];

			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (arr[box[j][k]]) {
						// dup case
						dep[j] = true;
						for (int j1 = 0; j1 < size; j1++) {
							for (int k1 = 0; k1 < k; k1++) {
								if (arr[box[j1][k1]]) {
									dep[j1] = true;
								}
							}
						}

					} else {
						// not dup
						arr[box[j][k]] = true;
					}

				}
				arr = new boolean[size + 1];
			}

			for (int j = 0; j < size; j++)
				if (dep[j]) {
					sum2++;
				}

			// #3 ans
			int sum3 = 0;
			arr = new boolean[size + 1];
			dep = new boolean[size];
			for (int k = 0; k < size; k++) {
				for (int j = 0; j < size; j++) {
					
					
					if (arr[box[j][k]]) {
						// dup case
						dep[j] = true;
						for (int j1 = 0; j1 < size; j1++) {
							for (int k1 = 0; k1 < k; k1++) {
								if (arr[box[j1][k1]]) {
									dep[j1] = true;
								}
							}
						}

					} else {
						// not dup
						arr[box[j][k]] = true;
					}
				}
				arr = new boolean[size + 1];
			}

			for (int j = 0; j < size; j++)
				if (dep[j]) {
					sum3++;
				}

			result.append("Case #" + i + ": " + sum1 + " " + sum2 + " " + sum3 + "\n");
		}
		System.out.print(result.toString());

	}

}
