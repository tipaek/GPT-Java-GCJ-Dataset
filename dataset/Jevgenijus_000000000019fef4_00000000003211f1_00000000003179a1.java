import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int T = reader.nextInt();
		int sz = 10000;
				
		for (int t = 0; t < T; t++) {
			String D = "";
			TreeSet<Character>[] digits = new TreeSet[10];
			for(int j = 0; j < 10; j++) {
				digits[j] = new TreeSet<>();
			}

			
			
			int U = reader.nextInt();
			TreeSet<Character> notZeros = new TreeSet<>();
			TreeSet<Character> chars = new TreeSet<>();
			List<Pair<Long, String>> inp = new ArrayList<Pair<Long,String>>();
			for(int i = 0; i < sz; i++) {
				// from the same server
				// random number is 1 to Mi encoded 
				long Q = reader.nextLong();
				String R = reader.next();
				
				for(int j = 0; j  < R.length(); j++) {
					char c = R.charAt(j);
					chars.add(c);
					if(j == 0) {
						notZeros.add(c);
						digits[0].add(c);
					}
				}
				if(Q == -1) {
					// unknown
				}else {
					// it is Mi
					inp.add(new Pair(Q,R));
				}
			
				
			}
			Collections.sort(inp, new Comparator<Pair<Long, String>>() {
			    public int compare(Pair<Long, String> obj1, Pair<Long, String> obj2) {
			        return Long.compare(obj1.first, obj2.first);
			    }
			});
			
			TreeSet<Character> zero = new TreeSet<>();
			for(char c1: chars) {
				if(!notZeros.contains(c1)) {
					zero.add(c1);
					D = D + c1;
				}
			}
			
			
			
			
			for(int i =0;i < inp.size(); i++) {
				Pair<Long, String> p =inp.get(i);
				long M = p.first;
				String R = p.second;
				char first = p.second.charAt(0);
				int len = R.length();
				if(len > 1) {
					int up = (int) (M / (10*(len-1)));
					digits[up].add(first);
				} else if (M < 10){
					digits[(int) (M%10)].add(first);
				}
			}
			TreeSet<Character> added = new TreeSet<>(zero);

			digits[1].removeAll(zero);
			
			for(int i = 1; i<10; i++) {
				digits[i].removeAll(added);
				for(char c: digits[i]) {
					D = D + c;
					added.add(c);
					break;
				}
			}
			
			System.out.printf("Case #%d: %s\n", t + 1, D);

		}
	}

	/**
	 * Container to ease passing around a tuple of two objects. This object provides
	 * a sensible implementation of equals(), returning true if equals() is true on
	 * each of the contained objects.
	 */
	static class Pair<F, S>{
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
