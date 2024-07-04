import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean[] c = new boolean[1441];
		boolean[] j = new boolean[1441];
		boolean cPuede = true;
		boolean jPuede = true;
		ArrayList<String> orden = new ArrayList<String>();
		for (int i = 0; i < 1441; i++) {
			c[i] = false;
			j[i] = false;
		}
		int cases = sc.nextInt();
		int horas;
		int s;
		int e;
		int turno = 1;
		for (int i = 0; i < cases; i++) {
			horas = sc.nextInt();
			orden.clear();
			System.out.print("Case #" + (i + 1) + ": ");
			for (int t = 0; t < 1441; t++) {
				c[t] = false;
				j[t] = false;
			}
			for (int p = 0; p < horas; p++) {
				s = sc.nextInt();
				e = sc.nextInt();
				turno = 1;
				cPuede=true;
				jPuede=true;
				for (int recorrido = s; recorrido < e && turno != 0; recorrido++) {
					if (c[recorrido]) {
						cPuede = false;
					}
					if (j[recorrido]) {
						jPuede = false;
					}
				}
				if (cPuede) {
					orden.add("C");
					for (int llenado = s; llenado < e; llenado++) {
						c[llenado] = true;
					}
				} else if (jPuede) {
					orden.add("J");
					for (int llenado = s; llenado < e; llenado++) {
						j[llenado] = true;
					}
				} else {
					turno = 0;
				}
			}
			if (turno == 0) {
				System.out.println("IMPOSSIBLE");
			} else {
				for (String elemento : orden) {
					System.out.print(elemento);
				}
				System.out.println();
			}
		}
	}
}