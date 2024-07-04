import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testNo = scanner.nextInt();
		int B = scanner.nextInt();
		
		for (int i = 1; i <= testNo; i++) {
			String ans = "";
			
			for (int j = 1; j <= 150; j++) {
				System.out.println((j-1)%10 + 1);
				if (j % 10 == 1) {
					ans = "";
				}
				String bit = scanner.next();
				ans += bit;
			}
			System.out.println(ans);
			String res = scanner.next();
			if (res.equals("N")) {
				return;
			}
		}
	}

}
