import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
			
		Scanner entrada = new Scanner(System.in);
		long cases = entrada.nextLong();
		entrada.nextLine();
		for(long cont = 1; cont<=cases; cont++) {
			
			String teste = entrada.nextLine();
			teste+="#";
			String aux = "";
			 
			int soma = 0;
			
			for(int index = 0; index<=teste.length(); index++) {
				
				Character current = teste.charAt(index);
				
				if(current == '#') break;
				
				Integer num = Integer.parseInt(""+current);
				
				if(num==0) {
					if(soma>0) {
						for(int index2 = 0; index2<soma;index2++) {
							aux+=')';
						}
					}

					aux+=num;
					soma = 0;
					
					continue;
				}
				
				int size = num-soma;
				
				if(size<0) {
					size = size*(-1);
					
					for(int index2 = 0; index2<size;index2++) {
						aux+=')';
					}
				}
				else {
					for(int index2 = 0; index2<size;index2++) {
						aux+='(';
					}
				}
				
				soma = num;
				aux+=num;
			}	
			
			if(soma>0) {
				for(int index2 = 0; index2<soma;index2++) {
					aux+=')';
				}
			}
				
			System.out.println("Case #" + cont + ": " + aux);
		}
	}
}
