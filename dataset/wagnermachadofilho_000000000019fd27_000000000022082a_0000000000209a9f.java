import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		for( int x = 0; x < T; x++ ) {
			String S = input.next();
			
			String Sl = "";
			
			int previous = 0;

			for( int i = 0; i < S.length(); i++ ) {
				int d = new Integer( S.charAt(i) + "" );

				if( d > previous ) {
					int open = d - previous;
					for( int j = 0; j < open; j++ ) {
						Sl += "(";
					}
				} else if( d < previous ) {
					int close = previous - d;
					for( int j = 0; j < close; j++ ) {
						Sl += ")";
					}
				}

				Sl += d;
				previous = d;
			}

			for( int i = 0; i < previous; i++ ) {
				Sl += ")";
			}
			
			System.out.println("Case #" + ( x + 1 ) + ": " + Sl);
		}

		input.close();
	}

}
