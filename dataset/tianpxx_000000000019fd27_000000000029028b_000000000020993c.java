package codingjam1;

import java.util.HashSet;
import java.util.Scanner;


public class CodingJam1 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        for(int i = 1; i<= casos; i++){
            int tam = sc.nextInt();
            int traza = 0;
            int[][] matrix = new int[tam][tam];
            for(int j = 0; j<tam; j++){
                for(int k =0; k<tam; k++){
                    int aux = sc.nextInt();
                    matrix[j][k] = aux;
                    if(j == k){
                        traza = traza + matrix[j][k];
                    }
                }
            }
            
            int contFil = 0;
            for(int j = 0; j<tam; j++){
                boolean[] visitadosFila = new boolean[100];
                for(int k = 0; k<tam; k++){
                    int auxI = matrix[j][k];
                    if(visitadosFila[auxI]){
                        contFil++;
                        break;
                    }
                    visitadosFila[auxI] = true;
                }
            }
            
            int contCol = 0;
            for(int k = 0; k<tam; k++){
                boolean[] visitadosCol = new boolean[100];
                for(int j = 0; j<tam; j++){
                    int auxI = matrix[j][k];
                    if(visitadosCol[auxI]){
                        contCol++;
                        break;
                    }
                    visitadosCol[auxI] = true;
                }
            }
            String sAux = "Case #"+i+": ";
            System.out.print(sAux);
            System.out.print(traza + " ");
            System.out.print(contFil + " ");
            System.out.println(contCol);
            
        }
            
        }
    }
    

