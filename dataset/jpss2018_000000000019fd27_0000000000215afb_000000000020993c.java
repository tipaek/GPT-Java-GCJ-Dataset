import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {

		while(true) {
			
			Scanner entrada = new Scanner(System.in);
			long cases = entrada.nextLong();
			
			for(long cont = 1; cont<=cases; cont++) {
				
				int matrizSize = entrada.nextInt();
				int matriz[][] = new int[100][100];
				int somaD = 0;
				int somaL = 0;
				int somaC = 0;
				
				for(int i = 0; i<matrizSize; i++) {
					
					List<Integer> totalL = new ArrayList<Integer>();
					
					for(int j = 0; j<matrizSize; j++) {
						
						matriz[i][j] = entrada.nextInt();
						
						if(!totalL.contains(matriz[i][j])) totalL.add(matriz[i][j]);
						
						if(i==j) somaD+=matriz[i][j];
					}
					
					if(!totalL.isEmpty() && totalL.size() < matrizSize)  somaL+=1;
				}
				
				for(int i = 0; i<matrizSize; i++) {
					
					List<Integer> totalC = new ArrayList<Integer>();
					
					for(int j = 0; j<matrizSize; j++) {
						if(!totalC.contains(matriz[j][i])) totalC.add(matriz[j][i]);
					}
					
					if(!totalC.isEmpty() && totalC.size() < matrizSize)  somaC+=1;
				}
				
				
				System.out.println("Case #" + cont + ": " + somaD + " " + somaL + " " + somaC) ;
				
			}
			
			return;
		}
		
		

	}

}
