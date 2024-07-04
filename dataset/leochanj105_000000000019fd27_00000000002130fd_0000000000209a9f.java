import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt(), i, j, k, len, cur, digit;
		String s;
		for(i = 0; i < T; i++) {
			s = input.next();
			len = s.length();
			System.out.print("Case #" + (i + 1) + ": ");
			cur = 0;
			for(j = 0; j < len; j++) {
				digit =  s.charAt(j) - '0';
				if(digit > cur) {
					for(k = 0; k < digit - cur;k++) System.out.print("(");
					cur = digit;
				}
				else if(digit < cur) {
					for(k = 0; k < cur - digit;k++) System.out.print(")");
					cur = digit;
				}
				System.out.print(digit);
			}
			for(j = 0; j < cur; j++) System.out.print(")");
			System.out.println();
		}
		input.close();
	}

}
