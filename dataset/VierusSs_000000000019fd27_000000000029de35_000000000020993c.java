import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        codeJam();
    }

    public static void codeJam() throws Exception {
            Scanner myReader = new Scanner(System.in);
            int casos = Integer.parseInt(myReader.nextLine());
            for (int i = 0; i < casos; i++) {
                int tamanyo = Integer.parseInt(myReader.nextLine());
                int[][] matriz = new int[tamanyo][tamanyo];
                for (int j = 0; j < tamanyo; j++) {
                    String[] linea = myReader.nextLine().split(" ");
                    for (int k = 0; k < tamanyo; k++) {
                        matriz[j][k] = Integer.parseInt(linea[k]);
                    }
                }
                calculateMatrix(matriz, i + 1);
            }
            myReader.close();
    }

    private static void calculateMatrix(int[][] matriz, int count) throws IOException {
        System.out.println("Case #" + count + ": " + calculateDiagonal(matriz) + " " + calculateLine(matriz) + " " + calculateColumn(matriz));
    }

    private static int calculateDiagonal(int[][] matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i][i];
        }
        return suma;
    }

    private static int calculateLine(int[][] matrix) {
        int suma = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean duplicates = false;
            for (int k = 0; k < matrix.length; k++) {
                if (k != i && matrix[0][k] == matrix[0][i]){
                    duplicates = true;
                    break;
                }
            }
            if (duplicates) suma ++;
        }
        return suma;
    }

    private static int calculateColumn(int[][] matrix) {
        int suma = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean duplicates = false;
            for (int k = 0; k < matrix.length; k++) {
                if (k != i && matrix[k][0] == matrix[i][0]){
                    duplicates = true;
                    break;
                }
            }
            if (duplicates) suma ++;
        }
        return suma;
    }

}
