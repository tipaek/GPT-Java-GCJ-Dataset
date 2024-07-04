import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	static class Pair<U, V>
	{
		public final U first;		// first field of a Pair
		public final V second; 	// second field of a Pair

		// Constructs a new Pair with specified values
		private Pair(U first, V second)
		{
			this.first = first;
			this.second = second;
		}

		@Override
		// Checks specified object is "equal to" current object or not
		public boolean equals(Object o)
		{
			if (this == o)
				return true;

			if (o == null || getClass() != o.getClass())
				return false;

			Pair<?, ?> pair = (Pair<?, ?>) o;

			// call equals() method of the underlying objects
			if (!first.equals(pair.first))
				return false;
			return second.equals(pair.second);
		}

		@Override
		// Computes hash code for an object to support hash tables
		public int hashCode()
		{
			// use hash codes of the underlying objects
			return 31 * first.hashCode() + second.hashCode();
		}

		@Override
		public String toString()
		{
			return "(" + first + ", " + second + ")";
		}
		

		// Factory method for creating a Typed Pair instance
		public static <U, V> Pair <U, V> of(U a, V b)
		{
			// calls private constructor
			return new Pair<>(a, b);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer pruebas = Integer.parseInt(sc.nextLine());
		for(int i=0;i<pruebas;i++) {
			List<Pair<Integer,Integer>> ls = new ArrayList<>();
			Integer actividades = Integer.parseInt(sc.nextLine());
			for(int i2=0;i2<actividades;i2++) {
				String[] act = sc.nextLine().split(" ");
				Pair<Integer,Integer> p = Pair.of(Integer.parseInt(act[0]),Integer.parseInt(act[1])); 
				ls.add(p);
			}
			
			List<Pair<Integer,Integer>> cameron = new ArrayList<>();
			List<Pair<Integer,Integer>> jamie = new ArrayList<>();
			String res = "";
			Integer imp = 0;
			List<Pair<Integer,Integer>> fin = ls;
			ls.sort(Comparator.comparing(x->x.first));
			Map<Pair<Integer,Integer>,String> mp = new HashMap<>();
			for(int i3=0;i3<ls.size();i3++) {
				if(i3==0) {
					mp.put(ls.get(i3), "C");
					cameron.add(ls.get(i3));
				}else {
					Integer horaf = ls.get(i3).first;
					if(cameron.get(cameron.size()-1).second<=horaf) {
						cameron.add(ls.get(i3));
						mp.put(ls.get(i3), "C");
					}else if(jamie.get(jamie.size()-1).second<=horaf) {
						jamie.add(ls.get(i3));
						mp.put(ls.get(i3), "J");
					}else {
						imp = 1;
						break;
					}
				}
			}
			
			for(Pair<Integer,Integer> p : fin) {
				res = res + mp.get(p);
			}
			if(imp==0) {
				System.out.println("Case #" + (i+1) + ": " + res);
			}else {
				System.out.println("Case #" + (i+1) + ": IMPOSIBLE");
			}
			
		}
		sc.close();

	}

}
