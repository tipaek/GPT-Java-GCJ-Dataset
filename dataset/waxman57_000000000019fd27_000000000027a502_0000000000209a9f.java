import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int x = 0; x < T; x++) {
			String S = s.next();
			char[] sInput = S.toCharArray();
			int depth = 0;
			depth += (sInput[0] - '0');
			System.out.print("Case #" + (x + 1) + ": ");
			for(int y = 0; y < sInput[0] - '0'; y++) {
				System.out.print("(");
			}
			System.out.print(sInput[0]);
			for(int y = 1; y < sInput.length; y++) {
				int diff = (sInput[y] - '0') - depth;
				depth = sInput[y] - '0';
				if(diff > 0) {
					for(int z = 0; z < diff; z++) {
						System.out.print("(");
					}
				} else if(diff < 0) {
					for(int z = 0; z < Math.abs(diff); z++) {
						System.out.print(")");
					}
				}
				System.out.print(sInput[y]);
			}
			for(int y = 0; y < depth; y++) {
				System.out.print(")");
			}
			System.out.println();
		}
	}
	
}
