import java.util.Scanner;

public class Ejemplo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCasosPrueba = sc.nextInt();

        for (int x = 0; x < numCasosPrueba; x++) {
            int sumaDiagonal = 0;
            int numFilasRepetidas = 0;
            int numColumnasRepetidas = 0;
            int tamanyoMatriz = sc.nextInt();

            int[][] matriz = new int[tamanyoMatriz][tamanyoMatriz];

            for (int i = 0; i < tamanyoMatriz; i++) {
                for (int j = 0; j < tamanyoMatriz; j++) {
                    matriz[i][j] = sc.nextInt();
                    if (i == j) {
                        sumaDiagonal += matriz[i][j];
                    }
                }
            }

            for (int i = 0; i < tamanyoMatriz; i++) {
                if (hasDuplicate(matriz[i])) {
                    numFilasRepetidas++;
                }
            }

            for (int j = 0; j < tamanyoMatriz; j++) {
                if (hasDuplicate(getColumn(matriz, j))) {
                    numColumnasRepetidas++;
                }
            }

            System.out.println("Case #" + (x + 1) + ": " + sumaDiagonal + " " + numFilasRepetidas + " " + numColumnasRepetidas);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}