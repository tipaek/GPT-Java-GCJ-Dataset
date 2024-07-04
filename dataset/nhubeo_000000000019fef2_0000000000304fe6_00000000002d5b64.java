import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i=0; i<testCase; i++) {
			int R = sc.nextInt();
			int S = sc.nextInt();
			
			System.out.println("Case #" + (i+1) + ": " + ((R-1)*(S-1)));
			printSolution(R,S);
		}
	}

	private static void printSolution(int r, int s) {
		int total = r*s;
		for (int i=r; i>1; i--) {
			for (int j=s; j>1; j--) {
				System.out.println((total-i) + " " + (i-1));
				total = total-1;
			}
			total = total-1;
		}
		
	}

}
