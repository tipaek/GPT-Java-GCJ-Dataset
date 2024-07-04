import java.util.Vector;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution{


	final static int maxN = 100;
	static Vector<Integer> V = new Vector<Integer>(maxN+1);
	static Vector<Integer> S = new Vector<Integer>(maxN+1);	// para cada i de  1 a N/2  indica si  V[i] es igual o diferente de V[n+1-i]  (0: iguales, 1: diferentes)
	static Vector<Integer> id = new Vector<Integer>();
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t,n,opIgual,opDiferente,x,y,i,j,l;
		t = sc.nextInt();
		n = sc.nextInt();

		for(i=0; i<=maxN; i++){
			V.add(0);
			S.add(0);
		}
		for(l=1; l<=t; l++){
			for(i=(n/2); i>=1; i--){
				j = n + 1 - i;
				pw.println(i);	pw.flush();
				V.set(i, sc.nextInt());
				pw.println(j);	pw.flush();
				V.set(j, sc.nextInt());
				if(V.get(i) == V.get(j))
				S.set(i,0);
				else
				S.set(i,1);
			}

			int posIgual = 0, posDiferente = 0;
			for(i=1; i<=(n/2); i++){
				if(S.get(i) == 0){
					posIgual = i;
					break;
				}
			}
			for(i=1; i<=(n/2); i++){
				if(S.get(i) == 1){
					posDiferente = i;
					break;
				}
			}


			if(posIgual == 0 || posDiferente == 0){
				pw.println(1);	pw.flush();
				x = sc.nextInt();
				if(x != V.get(1)){
					for(i=1; i<=n; i++)
					V.set(i, (V.get(i) + 1) % 2);
				}
			}
			else if(n > 10){
				// Los id se insertan en este orden los 5 primeros,
				// Si todos los 5 primeros son iguales -> 	 los diferentes, los iguales
				// De otra forma ->		los iguales, los diferentes
				for(i=1; i<=5; i++)
				id.add(i);

				if(posDiferente == 0 || posDiferente >= 6){
					for(i=6; i<=(n/2); i++){
						if(S.get(i) == 1)
						id.add(i);
					}
					for(i=6; i<=(n/2); i++){
						if(S.get(i) == 0)
						id.add(i);
					}
				}
				else{
					for(i=6; i<=(n/2); i++){
						if(S.get(i) == 0)
						id.add(i);
					}
					for(i=6; i<=(n/2); i++){
						if(S.get(i) == 1)
						id.add(i);
					}
				}

				// Lee los siguientes 9 y (1 que complemente el igual-diferente en caso de que sea posible) hasta que finalice
				int pos = 0;
				for(i=0; i<=4; i++){
					if(S.get(id.get(i)) != S.get(id.get(5))){
						pos = i;
						break;
					}
				}
				for(i=5; i<(n/2); i++){
					if(i % 9 == 5){
						if(S.get(id.get(i)) == S.get(id.get(pos))){
							for(j=i-1; j>=0; j--){
								if(S.get(id.get(i)) != S.get(id.get(j))){
									pos = j;
									break;
								}
							}
						}

						pw.println(id.get(i));	pw.flush();
						x = sc.nextInt();
						pw.println(id.get(pos));	pw.flush();
						y = sc.nextInt();

						if(x != V.get(id.get(i))){
							for(j=0; j<i; j++){
								if(S.get(id.get(j)) == S.get(id.get(i)))
								V.set(id.get(j), (V.get(id.get(j)) + 1) % 2);
							}
						}
						if(y != V.get(id.get(pos))){
							for(j=0; j<i; j++){
								if(S.get(id.get(j)) == S.get(id.get(pos)))
								V.set(id.get(j), (V.get(id.get(j)) + 1) % 2);
							}
						}
						V.set(id.get(i), x);
						V.set(id.get(pos), y);
					}
					else{
						pw.println(id.get(i));	pw.flush();
						V.set(id.get(i), sc.nextInt());
					}
				}
			}

			// Completa la otra mitad
			for(i=1; i<=(n/2); i++){
				j = n+1-i;
				if(S.get(i) == 0)
				V.set(j, V.get(i));
				else
				V.set(j, (V.get(i) + 1) % 2);
			}

			//string ans = "";
			for(i=1; i<=n; i++)
			pw.print((char)('0' + V.get(i)));
			pw.println();	pw.flush();
			
			String code = sc.next();
			id = new Vector<Integer>();

			if(code.equals('N'))
			break;
		
		}
	}
}