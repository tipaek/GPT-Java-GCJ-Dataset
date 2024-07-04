import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int b = sc.nextInt();

		for (int tC = 1; tC <= t; tC++) {
			StringBuilder toPrint = new StringBuilder("");

			for (int i = 1; i <= 10; i++) {
				System.out.println(i);
				System.out.flush();
				
				int next = sc.nextInt();
				
				toPrint.append(next);
			}
			System.out.println(toPrint);
			System.out.flush();
			
			sc.nextLine();
			String a = sc.nextLine();
			if(a.equals("N")) {
				System.exit(0);
			}
		}
	}
}
