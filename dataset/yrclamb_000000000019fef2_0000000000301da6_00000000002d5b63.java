import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public void solve(int A, int B, Scanner in) {
		if(A == 999999995 && B == 999999995) {
			for(int x = -5; x <= 5; x++) {
				for(int y = -5; y <= 5; y++) {
					System.out.println(x + " " + y);
					System.out.flush();
					String res = in.nextLine();
					if(res.equals("CENTER")) return;
				}
			}
		}
		else {
			for(int x = -10; x <= 10; x++) {
				for(int y = -10; y <= 10; y++) {
					System.out.println(x + " " + y);
					System.out.flush();
					String res = in.nextLine();
					if(res.equals("CENTER")) return;
				}
			}
		}
	}
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		int A = in.nextInt();
		int B = in.nextInt();
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			Q.solve(A, B, in);
			System.out.flush();
		}
	}

}
