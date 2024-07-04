import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		
		for (int i = 0; i < T; i++) {
			String result = "";
			String S = in.next();

			int countRight = 0;
			for (int p = S.length() - 1; p >= 0; p--) {
				int digit = S.charAt(p) - '0';
				int countRightTmp = countRight;
				
				if (digit - countRightTmp > 0) {
					for (int j = 0; j < (digit - countRightTmp); j++) {
						result = ")" + result;
						countRight++;
					}
				} else if (digit - countRightTmp < 0) {
					for (int j = 0; j > (digit - countRightTmp); j--) {
						result = "(" + result;
						countRight--;
					}
				}
				
				result = S.charAt(p) + result;

				// Last
				if (p == 0) {
					for (int j = 0; j < (countRight); j++) {
						result = "(" + result;
					}
				}
			}
			
			System.out.println("Case #" + (i + 1) + ": " + result);
		}
		
	}

}
