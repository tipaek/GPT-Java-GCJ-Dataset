import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casosPrueba = sc.nextInt(); sc.nextLine();
		
		for (int x = 0; x < casosPrueba; x++) {
			int palabrasAComprobar = sc.nextInt(); sc.nextLine();
			ArrayList<String> listaPalabras = new ArrayList<>(); 
			Boolean seContienen = false;
			String palabraAux = "";
			
			for (int y = 0; y < palabrasAComprobar; y++) {
				String aux = sc.nextLine();
				
				if (aux.substring(0,1).equals("*")) {
					String despuesAsterisco = aux.split("\\*")[1];
					listaPalabras.add(despuesAsterisco);
					if (y >= 1) {
						if (despuesAsterisco.contains(listaPalabras.get(y-1))) {
							seContienen = true;
							palabraAux = despuesAsterisco;
						} else if (listaPalabras.get(y-1).contains(despuesAsterisco)) {
							seContienen = true;
						}
					}
				} 
			}
			
			if (seContienen) {
				System.out.println("Case #" + (x + 1) + ": " +palabraAux);
			} else {
				System.out.println("Case #" + (x + 1) + ": *");
			}
		}
	}

}