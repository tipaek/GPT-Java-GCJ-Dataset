import java.util.Scanner;
import java.util.LinkedList;

public class Solution{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList<String> imp = new LinkedList<String>();
		LinkedList<Horas> lista = new LinkedList<Horas>();
		LinkedList<Horas> listaux = new LinkedList<Horas>();
		
		int t = scan.nextInt();

		for(int k = 1; k <= t; k++){
			
			int n = scan.nextInt();

			for(int i = 0; i < n; i++){

				int s = scan.nextInt();
				int f = scan.nextInt();

				listaux.add(new Horas(s, f));

			}

			lista.add(listaux.removeFirst());
			imp.add("C");
			
			for(int i = 0; i < listaux.size(); i++){

				int tam2 = lista.size();
				
				for(int j = 0; j < tam2; j++){

					if(listaux.get(i).s >= lista.get(j).f || listaux.get(i).f <= lista.get(j).s){

						imp.add("C");
						listaux.remove(i);
						i--;

					}else{

						imp.add("J");

					}

				}

			}

			lista.clear();

			if(!listaux.isEmpty()){
				lista.add(listaux.removeFirst());

				for(int i = 0; i < listaux.size(); i++){

					int tam2 = lista.size();
				
					for(int j = 0; j < tam2; j++){

						if(listaux.get(i).s >= lista.get(j).f || listaux.get(i).f <= lista.get(j).s){

							listaux.remove(i);
							i--;

						}

					}

				}
			}

			System.out.print("Case #" + k + ": ");
			if(listaux.isEmpty()){
				while(!imp.isEmpty()){

					System.out.print(imp.removeFirst());

				}

				System.out.println();
			}else{
				System.out.println("IMPOSSIBLE");
			}

			imp.clear();
			lista.clear();
			listaux.clear();

		}
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