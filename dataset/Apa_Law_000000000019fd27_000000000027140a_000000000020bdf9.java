import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static class Pair<U, V,W>
	{
		public  U first;		// first field of a Pair
		public  V second;
		public  W indicein;
		public  String letra;

		// Constructs a new Pair with specified values
		public Pair(U first, V second, W indicidein)
		{
			this.first = first;
			this.second = second;
			this.indicein = indicidein;
		}
		
		

		public Pair(U first, V second, W indicein, String letra) {
			super();
			this.first = first;
			this.second = second;
			this.indicein = indicein;
			this.letra = letra;
		}



		public String toString()
		{
			return "(" + indicein + ")";
		}
		
		public W getIndicein() {
			return indicein;
		}
		
		public String getLetra() {
			return letra;
		}

		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((first == null) ? 0 : first.hashCode());
			result = prime * result + ((indicein == null) ? 0 : indicein.hashCode());
			result = prime * result + ((letra == null) ? 0 : letra.hashCode());
			result = prime * result + ((second == null) ? 0 : second.hashCode());
			return result;
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (first == null) {
				if (other.first != null)
					return false;
			} else if (!first.equals(other.first))
				return false;
			if (indicein == null) {
				if (other.indicein != null)
					return false;
			} else if (!indicein.equals(other.indicein))
				return false;
			if (letra == null) {
				if (other.letra != null)
					return false;
			} else if (!letra.equals(other.letra))
				return false;
			if (second == null) {
				if (other.second != null)
					return false;
			} else if (!second.equals(other.second))
				return false;
			return true;
		}



		// Factory method for creating a Typed Pair instance
		public static <U, V, W> Pair <U, V, W> of(U a, V b, W c)
		{
			// calls private constructor
			return new Pair<>(a, b, c);
		}
		
		public static <U, V, W> Pair <U, V, W> of(U a, V b, W c, String d)
		{
			// calls private constructor
			return new Pair<>(a, b, c, d);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer pruebas = Integer.parseInt(sc.nextLine());
		for(int i=0;i<pruebas;i++) {
			List<Pair<Integer,Integer,Integer>> ls = new ArrayList<>();
			Integer actividades = Integer.parseInt(sc.nextLine());
			for(int i2=0;i2<actividades;i2++) {
				String[] act = sc.nextLine().split(" ");
				Pair<Integer,Integer,Integer> p = Pair.of(Integer.parseInt(act[0]),Integer.parseInt(act[1]),i2); 
				ls.add(p);
			}
			
			Pair<Integer,Integer,Integer> cameron = Pair.of(2000,2001,3000);
			Pair<Integer,Integer,Integer> jamie = Pair.of(2000,2001,3000);
			String res = "";
			Integer imp = 0;
			List<Pair<Integer,Integer,Integer>> fin = new ArrayList<>(ls);
			ls.sort(Comparator.comparing(x->x.first));
			for(int i3=0;i3<ls.size();i3++) {
				if(i3==0) {
					fin.add(Pair.of(ls.get(i3).first,ls.get(i3).second,ls.get(i3).indicein,"C"));
					cameron = ls.get(i3);
				}else {
					Integer horaf = ls.get(i3).first;
					if(cameron.second<=horaf) {
						cameron = ls.get(i3);
						fin.add(Pair.of(ls.get(i3).first,ls.get(i3).second,ls.get(i3).indicein,"C"));
					}else if(jamie.second==2001) {
						jamie = ls.get(i3);
						fin.add(Pair.of(ls.get(i3).first,ls.get(i3).second,ls.get(i3).indicein,"J"));
					}else if(jamie.second<=horaf) {
						jamie = ls.get(i3);
						fin.add(Pair.of(ls.get(i3).first,ls.get(i3).second,ls.get(i3).indicein,"J"));
					}else {
						imp = 1;
						break;
					}
				}
			}
			
			fin.sort(Comparator.comparing(x->x.indicein));
			for(int x=1;x<fin.size();x=x+2) {
				res = res + fin.get(x).getLetra();
			}
			if(imp==0) {
				System.out.println("Case #" + (i+1) + ": " + res);
			}else {
				System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
			}
			
		}
		sc.close();

	}

}