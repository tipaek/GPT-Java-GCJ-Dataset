import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		
		for (int test = 1; test <= tests; test++) {
			int n = s.nextInt();
			
			int r = 3;
			int k = 3;
			int value = 3;
			
			System.out.println("Case #" + test + ":");
			
			System.out.println("1 1");
			n--;
			if (n == 0)
				continue;
			
			System.out.println("2 2");
			n--;
			if (n == 0)
				continue;
			
			System.out.println("3 3");
			n--;
			if (n == 0)
				continue;
			
			if (n == 1) {
				System.out.println("4 4");
				continue;
			}
			
			if (n > 1000) {
				
				r = 5;
				k = 5;
				value = 5;
				
				System.out.println("4 4");
				n--;
				if (n == 0)
					continue;
				
				System.out.println("5 5");
				n--;
				if (n == 0)
					continue;
				
				
				
				while (n > 2*value) {
					r++;
					n -= value;
					System.out.println(r + " " + k);
					value = value(r+1, k);
				}
				
				k--;
				System.out.println(r + " " + k);
				value = value(r, k);
				n -= value;
				
				while (n > 2*value) {
					r++;
					n -= value;
					System.out.println(r + " " + k);
					value = value(r+1, k);
				}
				
				k--;
				System.out.println(r + " " + k);
				value = value(r, k);
				n -= value;
				
			}
			
			while (n > value + r) {
				r++;
				n -= value;
				System.out.println(r + " " + k);
				value = value(r+1, k);
			}
			
			k--;
			System.out.println(r + " " + k);
			value = value(r, k);
			n -= value;
			
			while (n > value) {
				r++;
				System.out.println(r + " " + k);
				value++;
				n -= value;
			}
			
			if (n > 0) {
				k--;
			}
			
			while (n > 0) {
				System.out.println(r + " " + k);
				n--;
				r++;
			}
			
		}
		
		s.close();
	}
	
	private static int value(int r, int k) {
		if (k == 1 || k == r)
			return 1;
		return value(r-1, k-1) + value(r-1, k);
	}

}