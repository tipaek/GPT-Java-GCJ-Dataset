import java.util.*;

public class Solution {
    public static void print(int x) {
		if (x == 1) {
			System.out.println("1 1");
			return;
		}
		if (x == 2) {
			System.out.println("1 1\n2 1");
			return;
		}
		if (x == 3) {
			System.out.println("1 1\n2 1\n3 1");
			return;
		}
//		if (x == 4) {
//			System.out.println("1 1\n2 1\n3 1\n4 1");
//			return;
//		}
//		if (x == 5) {
//			System.out.println("1 1\n2 1\n3 1\n4 1\n5 1");
//			return;
//		}
//		if (x == 6) {
//			System.out.println("1 1\n2 1\n3 1\n4 1\n5 1\n6 1");
//			return;
//		}
		
		System.out.println("1 1\n2 1\n3 1");
		int n = (int) ((Math.sqrt(8 * x) - 1) / 2);
		int ones = x - n * (n + 1) / 2;
		int r = 4;
		for (int i = 0; i < n - 2; i++) {
//			r = i + 4;
			if (ones > 0) {
				System.out.println(r + " 1");
				ones--;
			}
			System.out.println(r++ + " 2");
		}
		while(ones > 0) {
			System.out.println(r + " 1");
			ones--; r++;
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int q = 1; q <= t; q++) {
			int x = scn.nextInt();
			System.out.println("Case #" + q + ": ");
			print(x);
		}

	}
    
}