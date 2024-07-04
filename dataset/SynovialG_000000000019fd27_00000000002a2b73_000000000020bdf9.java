import java.util.Scanner;
import java.util.LinkedList;

public class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList<Horas> lista = new LinkedList<Horas>();
		LinkedList<Horas> ac = new LinkedList<Horas>();
		LinkedList<Horas> aj = new LinkedList<Horas>();
		LinkedList<String> print = new LinkedList<String>();

		int t = scan.nextInt();
		
		for(int k = 1; k <= t; k++){

			int n = scan.nextInt();

			for(int i = 0; i < n; i++){

				lista.add(new Horas(scan.nextInt(), scan.nextInt()));

			}

			ac.add(lista.removeFirst());
			print.add("C");
			aj.add(lista.removeFirst());
			print.add("J");
			boolean comp = true;

			for(int i = 2; i < n; i++){

				int aux = ac.size();

				for(int j = 0; j < aux; j++){

					if(!compare(lista.getFirst().s, lista.getFirst().f, ac.get(j).s, ac.get(j).f)){

						comp = false;
						j = aux;

					}

				}

				if(!comp){

					aux = aj.size();
					comp = true;

					for(int j = 0; j < aux; j++){

						if(!compare(lista.getFirst().s, lista.getFirst().f, aj.get(j).s, aj.get(j).f)){

							comp = false;
							j = aux;
							i = n;

						}
					}

					print.add("J");
					aj.add(lista.removeFirst());

				}else{
			
					print.add("C");
					ac.add(lista.removeFirst());

				}

			}

			System.out.print("Case #" + k + ": ");

			if(comp){

				while(!print.isEmpty()){

					System.out.print(print.removeFirst());

				}

				System.out.println();

			}else{

				System.out.println("IMPOSSIBLE");

			}



			lista.clear();
			ac.clear();
			aj.clear();
			print.clear();

		}	

	}

	public static boolean compare(int x1, int y1, int x2, int y2){

		if(x1 >= x2 && x1 < y2){

			return false;

		}else if(y1 <= y2 && y1 > x2){

			return false;

		}else if(x1 < x2 && y1 > x2){

			return false;

		}

		return true;

	}

}

class Horas{

	public int s;
	public int f;

	public Horas(int sa, int fa){

		s = sa;
		f = fa;

	}

}