import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		for (int h = 0; h < k; h++) {
			System.out.print("Case #" + (h + 1) + ": ");
			int n=5;
			int sum = sc.nextInt();
		
			int[][] arr = new int[n+1][n+1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					if (i == j || j == 1) {
						arr[i][j] = 1;
					} else {
						// Other values are sum of values just above and left of
						// above

						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					}

				}
			}
			int total=0;
			for (int i = 1; i <= n; i++) {
				for (int j = i; j >= 1; j--) {
					if(total < sum){
						total = total + arr[i][j];
						if(total == sum){
						System.out.println((i) + " " + (j));
						break;
						}else if(total < sum){
							total = total + arr[i-1][j-1];
							System.out.println((i) + " " + (j));
						}
					}
				}
			}

		}

	}

}
