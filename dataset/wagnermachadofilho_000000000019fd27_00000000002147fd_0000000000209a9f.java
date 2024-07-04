import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		for( int x = 0; x < T; x++ ) {
			String S = input.next();
			
			String Sl = "";
			
			boolean previousIsOne = false;

			for( int i = 0; i < S.length(); i++ ) {
				int d = new Integer( S.charAt(i) + "" );

				if( d == 1 && !previousIsOne ) {
					Sl += "(";
					previousIsOne = true;
				} else if( d == 0 && previousIsOne ) {
					Sl += ")";
					previousIsOne = false;
				}

				Sl += d;
			}
			
			if( previousIsOne ) {
				Sl += ")";
			}
			
			System.out.println("Case #" + ( x + 1 ) + ": " + Sl);
		}

		input.close();
	}
}
