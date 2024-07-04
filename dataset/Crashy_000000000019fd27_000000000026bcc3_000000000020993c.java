/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jam;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Jam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lee = new Scanner(System.in);
        int numVeces = lee.nextLine().charAt(0);
        int[][] vector = null;
        for (int i = 0; i < numVeces; i++) {
            int tam = lee.nextLine().charAt(0);
            int k = 0;
            int r = 0;
            int c = 0;
            vector = null;

            for (int j = 0; j < tam; j++) {
                for (int a = 0; a < tam; a++) {
                    vector[j][a] = lee.nextLine().charAt(0);
                }
            }

            for (int j = 0; j < tam; j++) {

                k += vector[j][j];

            }
            boolean flag = false;
            for (int j = 0; j < tam; j++) {
                for (int a = 0; a < tam; a++) {
                    int u = 0;
                    do {

                        if (vector[a][j] == vector[u][j]) {
                            flag = true;
                            r++;

                        }
                    } while (flag = false && u < tam);

                }
            }
            flag = false;
            for (int j = 0; j < tam; j++) {
                for (int a = 0; a < tam; a++) {
                    int u = 0;
                    do {

                        if (vector[j][a] == vector[j][u]) {
                            flag = true;
                            c++;

                        }
                    } while (flag = false && u < tam);

                }

            }
            System.out.println("Case #x: "+k+" "+r+" "+c+"\n");
        }

        
    }

}


