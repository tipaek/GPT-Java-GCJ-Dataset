/*

 */
package vestigium;
import java.util.Scanner;
//import java.io.*;

public class Vestigium {

    /**
     * Time limit: 20 seconds per test set.
        Memory limit: 1GB.
        1 ≤ T ≤ 100.
        2 ≤ N ≤ 100.
        1 ≤ Mi,j ≤ N, for all i, j.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input= new Scanner(System.in);
        short T = input.nextShort();//number of cases
        for (short i = 1; i<=T;++i){///ver si el ++ antes o despues
            short N = input.nextShort();//size of matrix
            //poniendo datos a la matriz    
            short k = 0; //k = trace
            short r = 0; //r = filas con numeros repetidos
            short c = 0; //c = columnas con numeros repetidos
            //short aux_r = 0; //ver si se debe poner mas ADENTRO            
            //crear matriz
            short[][] matriz = new short[N][N];
            //introduciendo valores a la matriz
            //al mismo tiempo ir contando filas repetidas
            for (short row = 0; row<N;row++){//verificar T o poner otro valor
                boolean counting_r = true; //para contar repetidos en fila
                for (short col = 0; col<N;col++){//verificar T o poner otro valor
                    //short value = input.nextShort();//size of matrix
                    matriz[row][col] = input.nextShort();
                    //contar la traza
                    if(row == col){
                        k = (short) (k + matriz[row][col]);
                    }
                    // para contar las filas repetidas
                    if(counting_r){
                        for (short aux_col = 0; aux_col<col;++aux_col){
                            if(matriz[row][col] == matriz[row][aux_col]){
                                r++;
                                counting_r = false;
                            }
                        }
                    }
                    
                }
            }
            //contar columnas repetidas
            for (short col = 0; col<N;++col){
                boolean counting_c = true;
                for (short row = 0; row<N;++row){
                    if(counting_c){
                        for (short aux_row = 0; aux_row<row;++aux_row){
                            if(matriz[row][col] == matriz[aux_row][col]){
                                c++;
                                counting_c = false;
                            }
                        }
                    }
                }
            }
        System.out.println("Case #"+i+": "+k+" "+r+" "+c);//ver si se tiene q imprimir por partes o todo de uno para ir guardando y al salir del for imprimir
    }   
    }    
}
