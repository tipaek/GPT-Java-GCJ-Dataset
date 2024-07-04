import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		int n1;
		int n2;
		for (int test=1; test<=tests;test++) {
			n1 = in.nextInt();
			n2 = in.nextInt();
			print(test, n1, n2);
		}
	}
	
	private static void print(int test, int n1, int n2) {
		String answer = "Case #" + test +": ";
		String directions="";
		int pow_sum=0;
		int pow;
		int pow_i;
		if ((Math.abs(n1) % 2) + (Math.abs(n2) % 2) != 1) {
			answer+="IMPOSSIBLE";
			System.out.println(answer);
			return;
		}
		
		for (pow_i=0; pow_sum < Math.abs(n1)+Math.abs(n2); pow_i++) {
			pow = (int) Math.pow((double)2,(double)pow_i);
			pow_sum += pow;
		}
		pow_i--;
		
		for (int i=pow_i; i>=0; i--) {
			if (Math.abs(n1) > Math.abs(n2)) {
				if (n1 > 0) {
					n1 -= Math.pow((double)2,(double)i);
					directions = "E" + directions; 
				} else {
					n1 += Math.pow((double)2,(double)i);
					directions = "W" + directions;
				}
			} else {
				if (n2 > 0) {
					n2 -= Math.pow((double)2,(double)i);
					directions = "N" + directions;
				} else {
					n2 += Math.pow((double)2,(double)i);
					directions = "S" + directions;
				}
			}
		}
		
		if (n1 != 0 || n2 != 0) {
			directions = "IMPOSSIBLE";
		}
		answer+=directions;
		System.out.println(answer);
	}
		
}

