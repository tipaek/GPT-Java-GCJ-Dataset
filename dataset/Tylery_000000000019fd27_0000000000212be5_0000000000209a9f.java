import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		
		for (int i = 1; i <= tests; i++) {
			String nums = s.next();
			nums = "0" + nums + "0";
			
			System.out.print("Case #" + i + ": ");
			
			for (int j = 0; j < nums.length()-1; j++) {
				if (j > 0)
					System.out.print(nums.charAt(j));
				print((int) nums.charAt(j+1) - (int) nums.charAt(j));
			}
			
			System.out.println();
		}
		
		s.close();
	}
	
	public static void print(int num) {
		boolean open = num > 0;
		for (int i = 0; i < Math.abs(num); i++) {
			if (open)
				System.out.print("(");
			else
				System.out.print(")");
		}
	}

}