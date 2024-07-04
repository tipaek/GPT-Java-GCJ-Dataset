import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		for( int x = 0; x < T; x++ ) {
			Integer n = input.nextInt();
			
			List<Position> walk = new ArrayList<Position>( 500 );
			if( n < 501 ) {
				for( int i = 1; i <= n; i++ ) {
					walk.add( new Position( i, 1 ) );
				}
			} else if( n == 501 ) {
				walk.add( new Position( 1, 1 ) );
				walk.add( new Position( 2, 1 ) );
				walk.add( new Position( 3, 2 ) );
				walk.add( new Position( 3, 1 ) );
				Integer sum = 5;
				
				Integer r = 4;
				while( sum < n ) {
					walk.add( new Position( r, 1 ) );
					r++;
					sum++;
				}
			} else if( n > 501 ) {
				walk.add( new Position( 1, 1 ) );
				walk.add( new Position( 2, 1 ) );
				walk.add( new Position( 3, 2 ) );
				
				Integer sum = 4;
				
				Integer r = 4;
				Integer k = 2;
				while( sum < n ) {
					if( sum + r - 1 < n ) {
						walk.add( new Position( r, k ) );
						sum += r - 1;
					} else {
						k = 1;
						walk.add( new Position( r - 1, k ) );
						sum++;
					}
					r++;
				}
			}

			System.out.println("Case #" + ( x + 1 ) + ":");
			printWalk( walk );
		}

		input.close();
	}

	private static void printWalk(List<Position> walk) {
		for( Position p : walk ) {
			System.out.println( p );
		}
	}

}

class Position {
	public Integer r;
	public Integer k;

	public Position(Integer r, Integer k) {
		super();
		this.r = r;
		this.k = k;
	}

	@Override
	public String toString() {
		return r + " " + k;
	}

}
