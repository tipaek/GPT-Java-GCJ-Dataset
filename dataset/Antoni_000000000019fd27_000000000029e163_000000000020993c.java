import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        codeJam();
    }

    public static void codeJam() {

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
            calculateMatrix(matriz, i + 1);System.out.print("\n");
        }
        myReader.close();
    }

    private static void calculateMatrix(int[][] matriz, int count) {
        int[] result = calculateLine(matriz);
        System.out.print("Case #" + count + ": " + result[0] + " " + result[1] + " " + result[2]);
    }

    private static int[] calculateLine(int[][] matrix) {
        int sumaLine = 0;
        int sumaColunm = 0;
        int diagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            diagonal += matrix[i][i];
            boolean duplicatesLine = false;
            boolean duplicatesColunm = false;
            for (int k = 0; k < matrix.length; k++) {
                if (k != i && matrix[0][k] == matrix[0][i]) {
                    duplicatesLine = true;
                }
                if (k != i && matrix[k][0] == matrix[i][0]) {
                    duplicatesColunm = true;
                }
            }
            if (duplicatesLine) sumaLine++;
            if (duplicatesColunm) sumaColunm++;
        }
        return new int[]{diagonal, sumaLine, sumaColunm};
    }


}
