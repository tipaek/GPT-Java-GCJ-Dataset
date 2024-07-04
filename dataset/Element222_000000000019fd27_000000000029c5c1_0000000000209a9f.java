import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int casos = Integer.parseInt(sc.nextLine());
		for (int c = 0; c < casos; c++) {
			System.out.print("Case #"+(c+1)+": ");
			String numero = sc.nextLine();
			String[] digitos = numero.split("");
			boolean faltaParentesisAdelante = false;
			boolean hayParentesisAtras = false;
			for (int i = 0; i < digitos.length; i++) {
				if (Integer.parseInt(digitos[i]) == 1) {
					if (!hayParentesisAtras) {
						hayParentesisAtras = true;
						faltaParentesisAdelante = true;
						System.out.print("(");
					}
				} else if (Integer.parseInt(digitos[i]) == 0) {
					if (faltaParentesisAdelante) {
						System.out.print(")");
						faltaParentesisAdelante = false;
						hayParentesisAtras = false;
					}
				}
				System.out.print(digitos[i]);

				if (i == digitos.length - 1 && faltaParentesisAdelante) {
					System.out.println(")");
				} else if(i==digitos.length-1){
					System.out.println();
				}
			}
		}
	}
}