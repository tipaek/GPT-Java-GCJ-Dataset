import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    protected static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int cases = Integer.parseInt(in.nextLine());
        for (int caso = 0; caso < cases; caso++) {
            int dimension = Integer.parseInt(in.nextLine());

            int diagonal = 0;
            int repetidosFila = 0;
            int repetidosColumna = 0;

            int[][] matrix = new int[dimension][dimension];
            for (int fila = 0; fila < dimension; fila++) {
                String[] str = in.nextLine().split(" ");
                int[] filaCaracteres = getArrayFromString(str);
                for (int columna = 0; columna < dimension; columna++) {
                    matrix[fila][columna] = filaCaracteres[columna];
                }
            }

            for (int fila = 0; fila < dimension; fila++) {
                diagonal = diagonal + matrix[fila][fila];
                repetidosFila = repetidosFila + numeroRepetidos(matrix[fila]);
                int[] column = getColumn(matrix, fila);
                repetidosColumna += numeroRepetidos(column);
            }


            System.out.printf("Case #%d: %d %d %d", caso + 1, diagonal, repetidosFila, repetidosColumna);
            System.out.println();
        }
    }

    static int[] getColumn(int[][] matrix, int numeroColumna) {
        int[] columna = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            columna[i] = matrix[i][numeroColumna];
        }
        return columna;
    }

    static int[] getArrayFromString(String[] str) {
        int size = str.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }

    static int numeroRepetidos(int[] fila) {
        int[] copiedArray = Arrays.copyOf(fila, fila.length);
        Arrays.sort(copiedArray);
        for (int caracter = 0; caracter < copiedArray.length - 1; caracter++) {
            if (copiedArray[caracter] == copiedArray[caracter + 1]) {
                return 1;
            }
        }
        return 0;
    }
}
