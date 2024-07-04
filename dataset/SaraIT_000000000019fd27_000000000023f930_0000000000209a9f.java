import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	static String print(int a, int n, int nextInt, int beforeInt) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < a-beforeInt; i++) {
			s.append("(");
		}
		for (int i = 0; i < n; i++) {
			s.append(a);
		}
		for (int i = 0; i < a-nextInt; i++) {
			s.append(")");
		}
		return s.toString();
	}
	
	static String solveAllCases(String s) {
		StringBuilder solu = new StringBuilder();
		int n = 1;
		int lastInt =Integer.parseInt(s.charAt(0)+"");
		int nextInt = 0;
		int beforInt = 0;
		
		for (int i = 1; i < s.length(); i++) {
			if (Integer.parseInt(s.charAt(i)+"") != lastInt) {
				if (i+1 < s.length()) nextInt = Integer.parseInt(s.charAt(i)+"");
				solu.append(print(lastInt, n,Integer.parseInt(s.charAt(i)+"") ,beforInt));
				beforInt = lastInt;
				lastInt = Integer.parseInt(s.charAt(i)+"");
				n = 1;
			} else {
				n++;
			}
		}
		solu.append(print(lastInt, n,0,beforInt));
		
		return solu.toString();
	}


	public static void main(String[] args) {
		int T = Integer.parseInt(in.nextLine());
		String solution;
		String s;
		for (int i = 1; i <= T; i++) {
			s = in.nextLine().trim();

			solution = solveAllCases(s);
			System.out.println("Case #" + i + ": " + solution);

		}

	}

}
