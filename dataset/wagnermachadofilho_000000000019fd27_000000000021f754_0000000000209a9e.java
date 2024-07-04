import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		int B = input.nextInt();
		
		for( int x = 0; x < T; x++ ) {
			
			int[] response = new int[B];
			
			for( int i = 0; i < 150; i++ ) {
				int p = ( i % 10 ) + 1;
				System.out.println( p );
				
				response[p - 1] = input.nextInt();
			}

			System.out.println( getResponse( response ) );

			String r = input.next();
			if( r.equals("N") ) {
				System.exit(-1);
			}
		}
		input.close();
	}

	private static String getResponse(int[] r) {
		StringBuilder response = new StringBuilder();
		for( int i = 0; i < r.length; i++ ) {
			response.append( r[i] );
		}
		return response.toString();
	}
}
