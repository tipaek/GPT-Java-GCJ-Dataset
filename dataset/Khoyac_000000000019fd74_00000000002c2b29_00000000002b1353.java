import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		for (int i = 1; i <= x; i++) {
			
			int n = sc.nextInt();
			if (n < 500) {
				System.out.println("Case #" + i + ":");
				for (int j = 1; j <= n; j++) {
					System.out.println(j+ " 1");
				}
			} else {
				System.out.println("Case #" + i + ":");
				System.out.println("1 1");
				System.out.println("2 1");
				System.out.println("2 2");
				System.out.println("3 2");
				System.out.println("3 1");
				
				for (int j = 1; j <= n-6; j++) {
					System.out.println((j+3)+ " 1");
				}
			}
			
		}

	}

}

