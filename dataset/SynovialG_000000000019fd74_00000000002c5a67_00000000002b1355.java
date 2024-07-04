import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		for(int k = 1; k <= t; k++){



		int n = scan.nextInt();
			int m = scan.nextInt();
			int[][] pista = new int[n][m];
			boolean comp = false;
			int sum = 0;

			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){

					pista[i][j] = scan.nextInt();		

				}

			}

			do{
				comp = false;
				for(int i = 0; i < n; i++){
					for(int j = 0; j < m; j++){
						
						sum += pista[i][j];
							
						if(pista[i][j] != 0){

							int cont = 0;
							int aux = 0;
							int auxa = i;
							boolean comp2 = true;
							while(auxa-1 >= 0 && comp2){

								if(pista[auxa-1][j] != 0){
									cont++;
									aux += pista[auxa-1][j];	
									comp2 = false;
								}

								auxa--;

							}

							auxa = i;
							comp2 = true;

							while(auxa+1 < n && comp2){

								if(pista[auxa+1][j] != 0){
									cont++;
									aux += pista[auxa+1][j];
									comp2 = false;
								}

								auxa++;

							}

							comp2 = true;
							auxa = j;

							while(auxa-1 >= 0 && comp2){

								if(pista[i][auxa-1] != 0){
									cont++;
									aux += pista[i][auxa-1];
									comp2 = false;
								}

								auxa--;

							}

							auxa = j;
							comp2 = true;

							while(auxa+1 < m && comp2){

								if(pista[i][auxa+1] != 0){
									cont++;
									aux += pista[i][auxa+1];
									comp2 = false;
								}

								auxa++;

							}

							if((float)pista[i][j] < (float) aux/cont){
							
								pista[i][j] = -1;
								comp = true;

							}

						}
					}
				}
						
				for(int i = 0; i < n; i++){

					for(int j = 0; j < m; j++){

						if(pista[i][j] == -1){
							pista[i][j] = 0;
						}
					}

				}

			}while(comp);

			System.out.println("Case #" + k + ": " + sum);

	
		}

	}

}