import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			for(int i = 1; i <= t; i++) {
				int n = scanner.nextInt();
				int k = scanner.nextInt();
				
				String op = "";
				if((k % n == 0) && ((k/n) <= n)) {
					op = "POSSIBLE";
				} else {
					op = "IMPOSSIBLE";
				}
				System.out.println("Case #" + i + ": " + op);
				if(op.equals("POSSIBLE")) {
					printMatrix(n, k);
				}
			}
		}
	}
	
	private static void printMatrix(int n, int k) {
		int num = k/n;
		for(int i = 0; i < n; i++) {
			String str = "";
			for(int j = 0; j < n; j++) {
				if(num <= n) {
					str += num + (j == n-1 ? "" : " ");
				} else {
					num = 1;
					str += num + (j == n-1 ? "" : " ");
				}
				num++;
			}
			System.out.println(str);
			num--;
		}
	}
}