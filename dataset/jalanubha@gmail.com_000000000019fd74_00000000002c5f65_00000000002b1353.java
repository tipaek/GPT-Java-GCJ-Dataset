import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int x = 0; x < T; x++) {
			int N = sc.nextInt();
			int sum = 0;
			System.out.println("Case #" + (x + 1) + ":");
			int c = 1;
			int r = 1;
			if (N == 1) {
				System.out.println("1 1");
			} else if (N == 2) {
				System.out.println("1 1");
				System.out.println("2 1");
			} else if (N == 3) {
				System.out.println("1 1");
				System.out.println("2 1");
				System.out.println("2 2");
			} else {
				System.out.println("1 1");
				System.out.println("2 1");
				System.out.println("2 2");
				r = 3;
				sum = 3;
				while(sum < N) {
					System.out.println(r + " " + r);
					sum++;
					r++;
				}
			}
			
		}
	}
}
