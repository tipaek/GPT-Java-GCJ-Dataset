
import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	
	public static void main (String args[]) {
	Scanner inp = new Scanner(System.in);
	int T = inp.nextInt();
	for(int t = 0 ;t < T; t++) {
		double N = inp.nextInt();
		double K = inp.nextInt();
		if((K/N)%1==0) {
			System.out.println("Case #"+(t+1)+": POSSIBLE");
		}else {
			System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
		}
	}
		
	}

}