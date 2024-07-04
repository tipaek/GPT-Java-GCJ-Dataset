import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		int A = input.nextInt();
		int B = input.nextInt();
		
		for( int t = 0; t < T; t++ ) {
			
			String response = "";
			
			int x = -5;
			int y = -5;

			while( response != "CENTER" ) {
				System.out.println( x +  " " + y );
				
				response = input.next();
				
				if( y == 5 ) {
					 x++;
					 y = -5;
				} else {
					y++;
				}
			}
		}

		input.close();
	}

}
