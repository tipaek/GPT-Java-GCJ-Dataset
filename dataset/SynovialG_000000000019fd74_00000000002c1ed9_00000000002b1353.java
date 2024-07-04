import java.util.Scanner;
import java.util.LinkedList;

public class Solution{

	public static LinkedList<Integer> lista = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		for(int i = 1; i <= t; i++){

			int n = scan.nextInt();
			long[][] triangulo = new long[500][500];

			for(int j = 0; j < 500; j++){
				
				triangulo[j][0] = 1;
				triangulo[j][j] = 1;

				for(int x = 1; x < j; x++){

					triangulo[j][x] = triangulo[j-1][x-1] + triangulo[j-1][x];

				}

			}

			n--;
			lista.add(0);
			lista.add(0);

			if(n != 0){
				func(triangulo, 0, 0, n);
			}
			System.out.println("Case #" + i + ":");

			while(!lista.isEmpty()){

				System.out.println((lista.removeFirst()+1) + " " + (lista.removeFirst()+1));

			}			

		}

	}

	public static boolean func(long[][] triangulo, int x, int y, int n){


		for(int k = 0; k < 6; k++){

			int ax = x;
			int ay = y;

			if(k == 0){
				ax -= 1;
				ay -= 1;
			}else if(k == 1){
				ax -= 1;
			}else if(k == 2){
				ay += 1;
			}else if(k == 3){
				ay -= 1;
			}else if(k == 4){
				ax += 1;
				ay += 1;
			}else if(k == 5){
				ax += 1;
			}

			if(ax >= 0 && ax < 500 && ay >= 0 && ay < 500 && triangulo[ax][ay] != 0){

				long aux = triangulo[x][y];
				triangulo[x][y] = 0;
				n -= triangulo[ax][ay];
				lista.add(ax);
				lista.add(ay);
				
				if(n > 0){
					if(func(triangulo, ax, ay, n)){
						return true;
					}else{
						lista.removeLast();
						lista.removeLast();
					}
					
				}else if(n == 0){
					return true;
				}

				triangulo[x][y] = aux;
			}

		}
		
		return false;

	}

}