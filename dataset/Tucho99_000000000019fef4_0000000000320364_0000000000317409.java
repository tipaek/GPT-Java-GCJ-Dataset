import java.util.*;
import java.lang.Math;

public class Solution{


    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        int numberTest = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<numberTest;i++){
            String[] testData = scanner.nextLine().split(" ");
            int[] x = {Integer.parseInt(testData[0])};
            int[] y = {Integer.parseInt(testData[1])};
            String camino = testData[2];
            int cont =0;
            int exito =0;

            for(int j=0;j<camino.length(); j++){
                cont++;
                avanzaCamino(camino.charAt(j), x, y);
                if( calculaDistancia(x,y) <= cont){
                    exito=1;
                    imprimeExito(cont, i+1);
                    break;
                }//if
            }//for
            if(exito==0){
                imprimeFracaso(i+1);
            }


        }//Cierra test


    }//Cierra main

     static void avanzaCamino(char direccion, int[] x, int[] y){

        switch(direccion){
            case 'N': y[0]++;
                break;
            case 'S': y[0]--;
                break;
            case 'E': x[0]++;
                break;
            case 'W': x[0]--;
                break;

        }//switch


    }//avanzaCamino

    static int calculaDistancia(int[] x, int[] y){
        return  Math.abs(x[0]) + Math.abs(y[0]);

    }

    static void imprimeExito(int cont, int test){

        System.out.println("Case #"+ test+ ": "+cont);

    }//imprimeExito

    static void imprimeFracaso(int test){
        System.out.println("Case #"+ test+ ": "+"IMPOSSIBLE");

    }

}//class Solution