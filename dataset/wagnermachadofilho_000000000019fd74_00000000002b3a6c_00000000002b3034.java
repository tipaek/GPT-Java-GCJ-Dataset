import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		for( int x = 0; x < T; x++ ) {
			Integer n = input.nextInt();
			
			List<String> patterns = new ArrayList<String>(n);
			
			for( int i = 0; i < n; i++ ) {
				patterns.add( input.next().replace("*", "") );
			}
			
			Collections.sort( patterns, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					return new Integer( s1.length() ).compareTo( s2.length() );
				}
			} );
			
			if( checkPattterns( patterns ) ) {
				System.out.println("Case #" + ( x + 1 ) + ": " + patterns.get( n - 1 ));
			} else {
				System.out.println("Case #" + ( x + 1 ) + ": *");
			}
		}

		input.close();
	}

	private static boolean checkPattterns(List<String> patterns) {
		for( int i = 0; i < patterns.size() - 1; i++ ) {
			if( !patterns.get( i + 1 ).endsWith( patterns.get( i ) ) ) {
				return false;
			}
		}
		
		return true;
	}

}
