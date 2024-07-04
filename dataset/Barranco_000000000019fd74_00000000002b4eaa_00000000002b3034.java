
import java.util.*;

class Solution {
	
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int cases = Integer.parseInt(sc.next());
		
		int ncase = 1;
		
		while(ncase<=cases) {
			
			int palabras = Integer.parseInt(sc.next());
			List<String> p = new ArrayList<>();
			for (int x = 0; x<palabras; x++) {
				String palabra = sc.next();
				p.add(palabra);
			}
			
			String max = Collections.max(p, Comparator.comparing(x->x.length()));
			boolean br = true;
			for(String palabra: p) {
				String pal = palabra.substring(1);
				
				String maxCortado = max.substring(max.length()-pal.length(),max.length());
		

				if(!maxCortado.equals(pal)) {
					br = false;
					break;
				}
				
			}
			if(br) {
				System.out.println("Case #"+ncase+": "+max.substring(1));
			
			}
			
			else
				System.out.println("Case #"+ncase+": *");
			
			
			
			ncase++;
		}
		
	}

}
