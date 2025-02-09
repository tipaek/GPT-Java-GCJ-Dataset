import java.util.Objects;
import java.util.Scanner;

public class Solution {
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int T = reader.nextInt();
		int A = reader.nextInt();
		int B = reader.nextInt();
		
		// guarantee them to be positive
		int AA = A + 1_000_000_000;
		int BB = B + 1_000_000_000;
				
		for (int t = 0; t < T; t++) {
			Pair last =new Pair(0,0);
			int diff = 1_000_000_000/2;
//			System.out.println("0 0");
//			String res = reader.next();
//
//			if(res.equals("HIT")) {
//				diff = diff/2;
//			} else if (res.equals("MISS")){
//				
//			} else if (res.equals("CENTER")) {
//				
//				break;
//			} else {
//				return;
//			}
			outer:
			for(int i = -5; i < 6; i++) {
				for(int j =-5 ;j < 6; j++) {
				
				System.out.printf("%d %d\n", i, j);
				 String res = reader.next();
				if(res.equals("HIT")) {
					
				} else if (res.equals("MISS")){
					
				} else if (res.equals("CENTER")) {
					
					
					break outer;
				} else {
					return;
				}
				}
			}
			
			//System.out.printf("Case #%d: %d %d\n", t + 1,);

		}
	}

	/**
	 * Container to ease passing around a tuple of two objects. This object provides
	 * a sensible implementation of equals(), returning true if equals() is true on
	 * each of the contained objects.
	 */
	static class Pair<F, S> {
		public final F first;
		public final S second;

		/**
		 * Constructor for a Pair.
		 *
		 * @param first  the first object in the Pair
		 * @param second the second object in the pair
		 */
		public Pair(F first, S second) {
			this.first = first;
			this.second = second;
		}

		/**
		 * Checks the two objects for equality by delegating to their respective
		 * {@link Object#equals(Object)} methods.
		 *
		 * @param o the {@link Pair} to which this one is to be checked for equality
		 * @return true if the underlying objects of the Pair are both considered equal
		 */
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Pair)) {
				return false;
			}
			Pair<?, ?> p = (Pair<?, ?>) o;
			return Objects.equals(p.first, first) && Objects.equals(p.second, second);
		}

		/**
		 * Compute a hash code using the hash codes of the underlying objects
		 *
		 * @return a hashcode of the Pair
		 */
		@Override
		public int hashCode() {
			return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
		}

		@Override
		public String toString() {
			return "Pair{" + String.valueOf(first) + " " + String.valueOf(second) + "}";
		}

		/**
		 * Convenience method for creating an appropriately typed pair.
		 * 
		 * @param a the first object in the Pair
		 * @param b the second object in the pair
		 * @return a Pair that is templatized with the types of a and b
		 */
		public static <A, B> Pair<A, B> create(A a, B b) {
			return new Pair<A, B>(a, b);
		}
	}
}
