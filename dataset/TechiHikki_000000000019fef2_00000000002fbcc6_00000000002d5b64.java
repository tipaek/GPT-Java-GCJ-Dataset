import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int T = stdIn.nextInt();
		
		for(int i = 0; i < T; i++) {
			int R = stdIn.nextInt();
			int S = stdIn.nextInt();
			System.out.println("Case #" +(i+1)+ ": " +(R-1)*(S-1));
			int b = R*S-R-1;
			for(int j = 0; j < R-1; j++) {
				for(int k = 0; k < S-1; k++) {
					System.out.println((R-j)+ " " +b);
					b--;
				}
			}
		}

	}

}