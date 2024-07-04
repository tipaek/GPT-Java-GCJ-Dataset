import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			outputSolution(i, x, y);
		}
		sc.close();
	}

	private static void outputSolution(int i, int x, int y) {
		
		String z = solve(x, y, 1);
		if (z == null) {
			System.out.println("Case #"+i+": IMPOSSIBLE");
		} else {
			System.out.println("Case #"+i+": "+z);
		}

		
	}
	
	private static String solve(int xdif, int ydif, int curJump) {
		if (xdif == 0 && ydif == 0) {
			return "";
		}
		if (!((mod(xdif,curJump * 2) == curJump) ^ (mod(ydif, curJump * 2) == curJump))) {
			return null;
		}
		
		
		if ((mod(xdif,curJump * 2) == curJump)) {
			//curJump is x
			String z1 = null;
			String z2 = null;
			
			if (!(ydif == 0 && xdif + curJump == 0)) {
				z1 = solve(xdif - curJump, ydif, curJump * 2);
			}
			if (!(ydif == 0 && xdif - curJump == 0)) {
				z2 = solve(xdif + curJump, ydif, curJump * 2);
			}
			if (z1 != null && z2 == null) {
				return "E" + z1;
			}
			if (z2 != null && z1 == null) {
				return "W" + z2;
			}
			if (z1 == null && z2 == null) {
				return null;
			}
			if (z1.length() < z2.length()) {
				return "E" + z1;
			}
			return "W" + z2;
		} else {
			//curJump is x
			
			String z1 = null;
			String z2 = null;
			
			if (!(xdif == 0 && ydif + curJump == 0)) {
				z1 = solve(xdif, ydif - curJump, curJump * 2);
			}
			if (!(xdif == 0 && ydif - curJump == 0)) {
				z2 = solve(xdif , ydif + curJump, curJump * 2);
				
			}
			if (z1 != null && z2 == null) {
				return "N" + z1;
			}
			if (z2 != null && z1 == null) {
				return "S" + z2;
			}
			if (z1 == null && z2 == null) {
				return null;
			}
			if (z1.length() < z2.length()) {
				return "N" + z1;
			}
			return "S" + z2;
		}
		
	}
	
	private static int mod(int a, int b){
		
		return (a % b + b) % b;
		
	}
}
