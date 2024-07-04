import java.util.Scanner;
import java.util.LinkedList;

public class PPR{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList<Horas> lista = new LinkedList<Horas>();

		int t = scan.nextInt();

		for(int k = 1; k <= t; k++){
			
			boolean comp = true;
			int n = scan.nextInt();

			for(int i = 0; i < n; i++){

				int s = scan.nextInt();
				int f = scan.nextInt();

				if(comp){

					String aux = "C";
					boolean ac = true;

					for(int j = 0; j < lista.size(); j++){

						if(s > lista.get(j).s && s < lista.get(j).f || f > lista.get(j).s && f < lista.get(j).f){

							if(ac){

								ac = false;	
								if(lista.get(j).id.equals("C")){
									aux = "J";
								}else{
									aux = "C";
								}

							}else{
							
								j = lista.size();
								comp = false;
							
							}	

						}

					}

					lista.add(new Horas(s, f, aux));

				}


			}

			System.out.print("Case #" + k + ": ");

			if(comp){
				while(!lista.isEmpty()){

					System.out.print(lista.removeFirst().id);

				}
			}else{

				System.out.print("IMPOSSIBLE");
				lista.clear();
			
			}

			System.out.println();

		}
	}

}

class Horas{

	public int s;
	public int f;
	public String id;

	public Horas(int sa, int fi, String p){

		s = sa;
		f = fi;
		id = p;

	}

}