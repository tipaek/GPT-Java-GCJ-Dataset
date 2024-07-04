import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		for( int t = 0; t < T; t++ ) {
			Integer n = input.nextInt();
			Integer d = input.nextInt();
			
			Map<Long, Integer> mapSlices = new HashMap<Long, Integer>();

			for( int i = 0; i < n; i++ ) {
				Long size = input.nextLong();
				
				if( mapSlices.containsKey( size ) ) {
					mapSlices.put( size, mapSlices.get( size ) + 1 );
				} else {
					mapSlices.put( size, 1 );
				}
			}

			if( mapSlices.containsValue( d ) ) {
				System.out.println("Case #" + ( t + 1 ) + ": 0");
			} else if( containsTwoSlices( mapSlices ) ) {
				System.out.println("Case #" + ( t + 1 ) + ": 1");
			} else if( containsSpecialSlices( mapSlices ) ) {
				System.out.println("Case #" + ( t + 1 ) + ": 1");
			} else {
				System.out.println("Case #" + ( t + 1 ) + ": 2");
			}
		}
		
		input.close();
	}

	private static boolean containsTwoSlices(Map<Long, Integer> mapSlices) {
		for( Integer quantity : mapSlices.values() ) {
			if( quantity.equals( 2 ) ) {
				return true;
			}
		}
		return false;
	}

	private static boolean containsSpecialSlices(Map<Long, Integer> mapSlices) {
		Object[] values = mapSlices.keySet().toArray();
		for( int i = 0; i < values.length; i++ ) {
			for( int j = 0; j < values.length; j++ ) {
				if( i != j ) {
					if( (Long)values[i] / (Long)values[j] == 2 && (Long)values[i] % (Long)values[j] == 0 ) {
						return true;
					}
				}
			}
		}
		return false;
	}
}

class Slice {
	public Long size;
	public Integer quantity;

	public Slice(Long size, Integer quantity) {
		super();
		this.size = size;
		this.quantity = quantity;
	}

}