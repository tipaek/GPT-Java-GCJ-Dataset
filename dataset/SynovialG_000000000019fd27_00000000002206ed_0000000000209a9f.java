import java.util.Scanner;
import java.util.LinkedList;

public class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList <Character> lista = new LinkedList<Character>();

		int t = scan.nextInt();

		for(int k = 1; k <= t; k++){

			String n = scan.next();
			int cont = 0;

			for(int i = 0; i < n.length(); i++){

				lista.add(n.charAt(i));

			}

			System.out.print("Case #" + k + ": ");

			while(!lista.isEmpty()){

				int aux = lista.removeFirst()-48;

				if(cont < aux){
					for(int i = cont; i < aux; i++){
						
						System.out.print("(");

					}
					cont = aux;
				}else if(cont > aux){
					for(int i = cont; i > aux; i--){

						System.out.print(")");

					}
					cont = aux;
				}
				System.out.print(aux);
			}

			for(int i = 0; i < cont; i++){
				System.out.print(")");
			}

			System.out.println();

		}

	}
}