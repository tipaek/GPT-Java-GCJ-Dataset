
import java.util.Scanner;

public class Solution {
     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        for (int i=0; i<casos; i++){
            int matriz = sc.nextInt();
            int cuadro[][] = new int [matriz][matriz];
            int suma = 0;
            for(int j=0; j<matriz; j++){
                for(int k=0; k<matriz; k++){
                    cuadro[j][k]=sc.nextInt();
                    if(j==k){
                        suma = suma+cuadro[j][k];
                    }
                }
            }
            int columnas = 0;
            int filas = 0;
            boolean banderaF = false;
            boolean banderaC = false;
            for(int j=0; j<matriz; j++){
                for(int k=0; k<matriz; k++){
                    for(int h=0; h<matriz; h++){
                        if(cuadro[j][k]==cuadro[j][h]&&k!=h){
                            banderaF = true;
                        }
                        if(cuadro[k][j]==cuadro[h][j]&&k!=h){
                            banderaC = true;
                        }
                    }
                }
                if(banderaF){
                    filas++;
                }
                if(banderaC){
                    columnas++;
                }
            }
            System.out.println("Case #"+(i+1)+": "+suma+" "+filas+" "+columnas);
        }
     }
}
