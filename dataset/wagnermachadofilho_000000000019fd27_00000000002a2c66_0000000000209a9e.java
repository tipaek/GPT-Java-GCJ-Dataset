import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		int B = input.nextInt();
		
		for( int x = 0; x < T; x++ ) {
			if( B == 10 ) {
				Integer[] response = new Integer[B];
				
				for( int i = 0; i < 10; i++ ) {
					int p = ( i % 10 ) + 1;
					System.out.println( p );
					
					response[p - 1] = input.nextInt();
				}
	
				System.out.println( getResponse( response ) );
	
				String r = input.next();
				if( r.equals("N") ) {
					System.exit(-1);
				}
			} else {
				Integer[] array = new Integer[B];
				
				int initialPosition = 0;
				int finalPosition = B - 1;
				
				int q = 1;
				
				int initialTrustPosition = initialPosition;
				int finalTrustPosition = finalPosition;
				
				while( initialPosition <= finalPosition && q <= 150 ) {
					if( q > 1 && q % 10 == 1 ) {
						boolean didGuess = guessWhatHappened( array, input, initialTrustPosition, finalTrustPosition );
						
						if( didGuess ) {
							initialTrustPosition = initialPosition - 1;
							finalTrustPosition = finalPosition + 1;
						} else {
							initialTrustPosition += 2;
							finalTrustPosition -= 2;
							
							initialPosition = initialTrustPosition;
							finalPosition = finalTrustPosition;
						}
						
						q += 4;
					}
					
					if( q % 2 == 1 ) {
						System.out.println( initialPosition + 1 );
						array[initialPosition] = input.nextInt();
						initialPosition++;
					} else {
						System.out.println( finalPosition + 1 );
						array[finalPosition] = input.nextInt();
						finalPosition--;
					}
					
					q++;
				}

				System.out.println( getResponse( array ) );
				
				String r = input.next();
				if( r.equals("N") ) {
					System.exit(-1);
				}
			}
		}

		input.close();
	}

	private static boolean guessWhatHappened(Integer[] B, Scanner input, int initialPos, int finalPos) {
		System.out.println( initialPos + 1 );
		int first = input.nextInt();
		
		System.out.println( finalPos + 1 );
		int last = input.nextInt();
		
		System.out.println( initialPos + 2 );
		int second = input.nextInt();
		
		System.out.println( finalPos );
		int beforeLast = input.nextInt();

		if( first == last ) {
			if( first == B[initialPos] && last == B[finalPos] ) {
				// Nothing happened or reversed

				if( second != beforeLast ) {
					if( second == B[initialPos + 1] && beforeLast == B[finalPos - 1] ) {
						// Nothing happened
						return true;
					} else {
						// Reversed
						reverseArray( B );
						return true;
					}
				}
			} else if( first != B[initialPos] && last != B[finalPos] ) {
				// Complemented or complemented & reversed
				
				if( second != beforeLast ) {
					if( second == B[initialPos + 1] && beforeLast == B[finalPos - 1] ) {
						// Complemented & reversed
						complementArray( B );
						reverseArray( B );
						return true;
					} else {
						// Complemented
						complementArray( B );
						return true;
					}
				}
			}
		} else {
			if( first == B[initialPos] && last == B[finalPos] ) {
				// Nothing happened or complemented & reversed
				
				if( second == beforeLast ) {
					if( second == B[initialPos + 1] && beforeLast == B[finalPos - 1] ) {
						// Nothing happened
						return true;
					} else {
						// Complemented & reversed
						complementArray( B );
						reverseArray( B );
						return true;
					}
				}
			} else if( first != B[initialPos] && last != B[finalPos] ) {
				// Complemented or reversed
				
				if( second == beforeLast ) {
					if( second == B[initialPos + 1] && beforeLast == B[finalPos - 1] ) {
						// Reversed
						reverseArray( B );
						return true;
					} else {
						// Complemented
						complementArray( B );
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private static void complementArray(Integer[] B) {
		for( int i = 0; i < B.length; i++ ) {
			if( B[i] != null ) {
				if( B[i] == 0 ) {
					B[i] = 1;
				} else {
					B[i] = 0;
				}
			}
		}
	}

	private static void reverseArray(Integer[] B) {
		for( int i = 0; i < B.length / 2; i++ ) {
			Integer aux = B[i];
			if( aux != null ) {
				B[i] = B[ B.length - 1 - i ];
				B[ B.length - 1 - i ] = aux;
			}
		}
	}

	private static String getResponse(Integer[] r) {
		StringBuilder response = new StringBuilder();
		for( int i = 0; i < r.length; i++ ) {
			response.append( r[i] );
		}
		return response.toString();
	}
}
