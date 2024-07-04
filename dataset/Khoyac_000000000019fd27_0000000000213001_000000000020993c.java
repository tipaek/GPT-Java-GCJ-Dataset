import java.util.*;

public class Solution {        

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int casos = sc.nextInt();

        for (int i=1; i <= casos; i++){
            int n = sc.nextInt();

            int[][] matriz = new int [n][n];

            int traza=0;
            int filas=0;
            int columnas=0;

            for (int j=0; j < n; j++){
                for (int k=0; k < n; k++){
                    matriz[j][k] = sc.nextInt();
                    if (j==k) traza += matriz[j][k];
                }
            }

            //filas
            boolean f;
            for (int j=0; j < n; j++){
                f = false;
                for (int k=0; k < n-1 && !f; k++){
                    for (int l=k+1; l < n; l++){
                        if (matriz[j][k] == matriz[j][l] ){
                            f = true;
                            filas += 1; break;
                        }
                    }
                }
            }

            //columnas
            for (int j=0; j < n; j++){
                f = false;
                for (int k=0; k < n-1 && !f; k++){
                    for (int l=k+1; l < n; l++){
                        if (matriz[k][j] == matriz[l][j] ){
                            f = true;
                            columnas += 1; break;
                        }
                    }
                }
            }
            

            System.out.printf("Case #%d: %d %d %d\n",i,traza,filas,columnas);
                
        }

        sc.close();
    
    }


}