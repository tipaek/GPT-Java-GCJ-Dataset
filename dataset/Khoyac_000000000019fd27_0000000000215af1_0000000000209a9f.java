import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < x; i++) {
			
			String cadena = sc.nextLine()+ "0";
			String ncadena = "";
			String cadenaaux = "";
			int count = 0;
			
			int numero;
			
			char[] numeros = cadena.toCharArray();
			
			for (int j = 0; j < numeros.length; j++) {
				
				numero = Integer.parseInt(Character.toString(numeros[j]));
				cadenaaux = "";
				while ( numero != count) {
					if (numero > count ) {
						cadenaaux = "(" + cadenaaux;
						count++;
					} else if (numero < count ) {
						cadenaaux = ")" + cadenaaux;
						count--;
					}
				}
				
				ncadena += cadenaaux + numero;
				
			}
			
			System.out.println("Case #"+(i+1)+": " + ncadena.substring(0, ncadena.length()-1));
			
			
		}


	}

}
