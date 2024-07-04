import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt(); 
        for (int i = 1; i <= total; i++) {
            int matrixsize = in.nextInt();//Tamany matriu
            int filaActual [] = new int [matrixsize];
            int sumaFila;
            int sumaColumna;
            int sumaDiagonal;
            boolean filaRep = 0;
            boolean colRep [] = new int [matrixSize];
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
                            if (filaActual[numActual-1] == 0) {
                                filaActual[numActual-1] = 1;
                            }
                        }
                    }
                    if (!colRep[j]) {
                        if (columnes [j] [numActual-1] == 1) {
                            sumaColumna++;
                            colRep[j] = true;
                        }
                        else {
                            if (columnes [j] [numActual-1] == 0) {
                                columnes [j] [numActual-1] = 1;
                            }
                        }
                    }
                    if (j == w) {
                        sumaDiagonal += numActual;
                    }
                }
                filaRep = false;
            }
            System.out.println("Case #" + i + ": " + sumaDiagonal + " " + sumaFila + " " + sumaColumna);
        }
      }
    }