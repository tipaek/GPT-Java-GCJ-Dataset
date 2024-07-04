import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		long e9 = 1000000000;
		for(int i = 1 ; i <= t ; i++) {
			long ans = 0;
			long x = 0;
			long y = 0;
			x = -1 * e9;
			y = 0;
			System.out.println(x + " " + y);
			String com = scan.next();
			while(com.equalsIgnoreCase("MISS")) {
				x++;
				System.out.println(x + " " + y);
				com = scan.next();
			}
			long xhit1 = x;
			x = 1 * e9;
			y = 0;
			System.out.println(x + " " + y);
			com = scan.next();
			while(com.equalsIgnoreCase("MISS")) {
				x--;
				System.out.println(x + " " + y);
				com = scan.next();
			}
			long xhit2 = x;
			x = 0;
			y = -1 * e9;
			System.out.println(x + " " + y);
			com = scan.next();
			while(com.equalsIgnoreCase("MISS")) {
				y++;
				System.out.println(x + " " + y);
				com = scan.next();
			}
			long yhit1 = y;
			x = 0;
			y = 1 * e9;
			System.out.println(x + " " + y);
			com = scan.next();
			while(com.equalsIgnoreCase("MISS")) {
				y--;
				System.out.println(x + " " + y);
				com = scan.next();
			}
			long yhit2 = y;
			long cx = (xhit1+xhit2)/2;
			long cy = (yhit1+yhit2)/2;
			System.out.println(cx + " " + cy);
		}
	}

}
