import java.util.Scanner;

public class Solution{

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
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					
					if (!arr[box[j][k]]) {
						arr[box[j][k]] = true;
					}else {
						sum2++;
						k=size+1;
					}
				}
				arr = new boolean[size + 1];
			}
			

			// #3 ans
			int sum3 = 0;
			arr = new boolean[size + 1];
			for (int k = 0; k < size; k++) {
				for (int j = 0; j < size; j++) {
					
					if (!arr[box[j][k]]) {
						arr[box[j][k]] = true;
					}else {
						sum3++;
						j=size+1;
					}
				}
				arr = new boolean[size + 1];
			}

			result.append("Case #" + i + ": " + sum1 + " " + sum2 + " " + sum3 + "\n");
		}
		System.out.print(result.toString());

	}

}
