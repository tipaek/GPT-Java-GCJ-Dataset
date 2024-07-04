
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
				p.add(palabra.replace("*", ".*"));
			}
			
			String max = Collections.max(p, Comparator.comparing(x->x.length()));
			String maxSinReg = max.replace(".*","");
		
			String maxSinReg2 ="";
			boolean br = true;
			for(String palabra: p) {
				String pal = palabra;
				maxSinReg2 = max.replace(".*", pal.replace(".*",""));
				Pattern pattern = Pattern.compile(pal);
				 Matcher matcher = pattern.matcher(maxSinReg2);

				if(!matcher.matches()) {
					br = false;
					break;
				}
				
			}
			if(br) {
				System.out.println("Case #"+ncase+": "+maxSinReg2);
			
			}
			
			else
				System.out.println("Case #"+ncase+": *");
			
			
			
			ncase++;
		}
		
	}

}
