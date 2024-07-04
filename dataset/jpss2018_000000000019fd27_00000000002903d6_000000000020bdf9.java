import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {

		while(true) {
			
			Scanner entrada = new Scanner(System.in);
			long cases = entrada.nextLong();
			
			for(long cont = 1; cont<=cases; cont++) {
				
				int interacoes = entrada.nextInt();
				int[][] matriz = new int[interacoes][2];
				char[] resposta = new char[interacoes];
				
				for(int i = 0; i<interacoes; i++) {
					matriz[i][0] = entrada.nextInt(); 
					matriz[i][1] = entrada.nextInt();
				}
				
				boolean isImpossible = false;
				
				for(int i = 0; i<interacoes; i++) {
					
					int impossibleCount = 0;
					
					for(int j = 0; j<interacoes; j++) {
						if(i!=j) {
							if(impossible(matriz[i][0], matriz[i][1], matriz[j][0], matriz[j][1])) impossibleCount++;
						}
					}
					
					if(impossibleCount == interacoes - 1) {
						isImpossible = true;
						break;
					}
				}
				

				if(isImpossible) {
					System.out.println("Case #" + cont + ": IMPOSSIBLE");
					continue;
				}
				
				HashSet<Integer> rowIntersect = new HashSet<Integer>();
				Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
								
				for(int i = 0; i<interacoes; i++) {
					
					HashSet<Integer> keys = new HashSet<Integer>();
					
					for(int j = 0; j<interacoes; j++) {
						if(i!=j) {
							boolean hasIntersect = intersect(matriz[i][0], matriz[i][1], matriz[j][0], matriz[j][1]);
							if(hasIntersect == true) {
								keys.add(j);
							}
						}
					}
					
					map.put(i, keys);
				}
				
				
				String answer = "";
				List<Integer> usados = new ArrayList<Integer>();
				
				for (Map.Entry<Integer, HashSet<Integer>> it : map.entrySet()) {
					
					Integer key = it.getKey();
					HashSet<Integer> values = it.getValue();
					
					if(!usados.contains(key)) resposta[key] = 'C';
					
					usados.add(key);
					
					
					for(Integer val: values) {
						
						if(!usados.contains(val)) resposta[val] = 'J';
						
						usados.add(val);
					}
				}
				
				
				System.out.println("Case #" + cont + ": " + new String(resposta)) ;
			}
			
			return;
		}
	}
	
	public static boolean intersect(int A, int B, int C, int D) {
		
		boolean regraA = B>C && B<D;
		boolean regraB = A>C && A<D;
		
		return regraA || regraB;
	}
	
	public static boolean impossible(int A, int B, int C, int D) {
		
		boolean regraC = C>A && D<B;
		
		return regraC;
	}

}
