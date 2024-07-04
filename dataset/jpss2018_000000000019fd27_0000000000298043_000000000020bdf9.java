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
				
				for(int i = 0; i<interacoes; i++) {
					matriz[i][0] = entrada.nextInt(); 
					matriz[i][1] = entrada.nextInt();
				}
				
				boolean isImpossible = false;
				List<Integer> list = new ArrayList<Integer>();
				Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
				
				loop:for(int i = 0; i<interacoes; i++) {
					
					List<Integer> list2 = new ArrayList<Integer>();
					
					for(int j = i+1; j<interacoes; j++) {
						boolean hasIntersect = intersect(matriz[i][0], matriz[i][1], matriz[j][0], matriz[j][1]);
						
						if(hasIntersect == true) {
							if(list.contains(j)) {
								isImpossible = true;
								break loop;
							}
							
							list.add(j);
							list2.add(j);
						}
					}
					
					map.put(i, list2);
				}
				
				if(isImpossible) {
					System.out.println("Case #" + cont + ": IMPOSSIBLE") ;
					continue;
				}
				
				List<Integer> usados = new ArrayList<Integer>();
				String resposta = "";
				
				for (Map.Entry<Integer, List<Integer>> it : map.entrySet()) {
				    
					Integer row = it.getKey();
					
					if(!usados.contains(row)) {
						resposta+='C';
						usados.add(row);
						
						for(Integer val: it.getValue()) {
							if(!usados.contains(val)) resposta+='J';
							usados.add(val);
						}
					}
				}
				
				System.out.println("Case #" + cont + ": " + resposta) ;
				
			}
			
			return;
		}
	}
	
	public static boolean intersect(int A, int B, int C, int D) {
		
		boolean regraA = B>C && B<=D;
		boolean regraB = A>=C && A<D;
		boolean regraC = C>A && D<B;
					
		return regraA || regraB || regraC;
	}
	
}
