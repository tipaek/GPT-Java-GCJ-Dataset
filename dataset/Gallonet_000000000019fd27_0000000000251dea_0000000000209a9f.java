import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numCasosPrueba = sc.nextInt(); sc.nextLine();
		
		for (int x = 0; x < numCasosPrueba; x++) {
			String cadena = sc.nextLine() + "0";
			char [] aux = cadena.toCharArray();
			String cadenaFinal = "";
			int cont = 0;
			for (int i = 0; i < aux.length; i++) {
				int numero = Integer.parseInt(Character.toString(aux[i]));
				
				String parentesis = "";
				
				while (numero != cont) {
					if (cont < numero) {
						parentesis += "(";
						cont++;
					} else {
						parentesis += ")";
						cont--;
					}
					
				}
				cadenaFinal += parentesis + numero;
				
			}
			
			System.out.println("Case #" + (x+1) + ": " +cadenaFinal.substring(0, cadenaFinal.length()-1));
		}

	}

}
