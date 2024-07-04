
import java.util.Scanner;

public class Solution {
	static Scanner in;
	static int T;
	
	static String S;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		T = in.nextInt();
		in.nextLine();
		
		for(int c = 1; c <= T; c++) {
			readInput();
			
			System.out.println("Case #" + c + ": " + solve());
		}
		
		in.close();
	}
	
	public static void readInput() {
		S = in.nextLine();
	}
	
	public static String solve() {
		StringBuilder b = new StringBuilder();
		
		int curParens = 0;
		for(int i = 0; i < S.length(); i++) {
			int num = S.charAt(i) - '0';			
			if(num > curParens) {
				int diff = num - curParens;
				b.append("(".repeat(diff));
				curParens += diff;
			} else if(num < curParens) {
				int diff = curParens - num;
				b.append(")".repeat(diff));
				curParens -= diff;
			}
			
			b.append(num);
		}
		b.append(")".repeat(curParens));
		
		return b.toString();
	}
}
