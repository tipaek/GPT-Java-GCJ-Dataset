import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        for (int k = 1; k <= testCases; ++k) {
            int size = Integer.parseInt(br.readLine());
            int[][] matrix = new int[size][size];
            int diagonalSum = 0, duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < size; ++i) {
                boolean[] rowCheck = new boolean[size + 1];
                String[] line = br.readLine().split(" ");
                boolean rowHasDuplicate = false;
                for (int j = 0; j < size; ++j) {
                    int value = Integer.parseInt(line[j]);
                    matrix[i][j] = value;
                    if (i == j) {
                        diagonalSum += value;
                    }
                    if (!rowHasDuplicate && rowCheck[value]) {
                        rowHasDuplicate = true;
                        duplicateRows++;
                    }
                    rowCheck[value] = true;
                }
            }

            for (int j = 0; j < size; ++j) {
                boolean[] colCheck = new boolean[size + 1];
                boolean colHasDuplicate = false;
                for (int i = 0; i < size; ++i) {
                    int value = matrix[i][j];
                    if (!colHasDuplicate && colCheck[value]) {
                        colHasDuplicate = true;
                        duplicateCols++;
                    }
                    colCheck[value] = true;
                }
            }

            System.out.println("Case #" + k + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}