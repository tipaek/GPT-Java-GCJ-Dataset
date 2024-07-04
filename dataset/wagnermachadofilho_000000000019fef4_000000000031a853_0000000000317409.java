import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		for( int t = 0; t < T; t++ ) {
			Integer x = input.nextInt();
			Integer y = input.nextInt();
			
			String m = input.next();

			System.out.println("Case #" + ( t + 1 ) + ": " + getMinutesToPeppurr( x, y, m ));
		}
		
		input.close();
	}
	
	private static String getMinutesToPeppurr(Integer x, Integer y, String m) {
		Integer myX = 0;
		Integer myY = 0;

		Integer minutes = 0;
		for( int i = 0; i < m.length(); i++ ) {
			
			if( myX == x && myY == y ) {
				return minutes.toString();
			}
			
			if( m.charAt(i) == 'S' ) {
				y--;
			} else {
				y++;
			}

			if( myX < x ) {
				myX++;
			} else if( myY != y ) {
				if( myY < y ) {
					myY++;
				} else {
					myY--;
				}
			}

			minutes++;
		}
		
		if( myX == x && myY == y ) {
			return minutes.toString();
		}
		
		return "IMPOSSIBLE";
	}

}
