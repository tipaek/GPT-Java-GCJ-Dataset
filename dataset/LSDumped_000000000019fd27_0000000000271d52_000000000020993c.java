import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt();
        for (int i = 1; i <= total; i++) {
            int matrixsize = in.nextInt();//Tamany matriu
            int filaActual [] = new int [matrixsize];
            int sumaFila = 0;
            int sumaColumna = 0;
            int sumaDiagonal = 0;
            boolean filaRep = false;
            boolean colRep [] = new boolean [matrixsize];
            int columnes [] [] = new int [matrixsize] [matrixsize];
            int numActual = 0;
            for (int w = 0;w < matrixsize;w++) {
                for (int j = 0; j < matrixsize; j++) {
                    numActual = in.nextInt();
                    if (!filaRep) {
                        if (filaActual[numActual-1] == 1) {
                            sumaFila++;
                            filaRep = true;
                        }
                        else {
                            filaActual[numActual-1] = 1;
                        }
                    }
                    if (!colRep[j]) {
                        if (columnes [j] [numActual-1] == 1) {
                            sumaColumna++;
                            colRep[j] = true;
                        }
                        else {
                            columnes [j] [numActual-1] = 1;
                        }
                    }
                    if (j == w) {
                        sumaDiagonal += numActual;
                    }
                }
                int pepe = 0;
                while (pepe < matrixsize) {
                    filaActual [pepe] = 0;
                    pepe++;
                }
                filaRep = false;
            }
            System.out.println("Case #" + i + ": " + sumaDiagonal + " " + sumaFila + " " + sumaColumna);
        }
    }
}