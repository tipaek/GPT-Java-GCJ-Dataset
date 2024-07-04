import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] diag = new int[1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int trace = Integer.parseInt(st.nextToken());

            diag = calculateDiagonal(size, trace);

            if (diag.length == 0) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseNum);
                continue;
            }

            int[][] matrix = new int[size][size];
            boolean[][] usedInColumn = new boolean[size][size];
            boolean[] usedInRow = new boolean[size];

            for (int i = 0; i < size; i++) {
                matrix[i][i] = diag[i];
                usedInColumn[i][diag[i]] = true;
            }

            if (generateMatrix(matrix, 0, 0, usedInColumn, usedInRow)) {
                System.out.printf("Case #%d: POSSIBLE%n", caseNum);
                printMatrix(matrix);
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseNum);
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print((cell + 1) + " ");
            }
            System.out.println();
        }
    }

    private static boolean generateMatrix(int[][] matrix, int row, int col, boolean[][] usedInColumn, boolean[] usedInRow) {
        int size = matrix.length;

        if (col >= size) {
            if (row == size - 1) {
                return true;
            }
            boolean[] newRowUsage = new boolean[size];
            newRowUsage[diag[row + 1]] = true;
            return generateMatrix(matrix, row + 1, 0, usedInColumn, newRowUsage);
        }

        if (row >= size) {
            return true;
        }

        if (row == col) {
            return generateMatrix(matrix, row, col + 1, usedInColumn, usedInRow);
        }

        for (int i = 0; i < size; i++) {
            if (usedInColumn[col][i] || usedInRow[i]) continue;
            matrix[row][col] = i;
            usedInColumn[col][i] = true;
            usedInRow[i] = true;

            if (generateMatrix(matrix, row, col + 1, usedInColumn, usedInRow)) {
                return true;
            }

            usedInColumn[col][i] = false;
            usedInRow[i] = false;
        }

        matrix[row][col] = 0;
        return false;
    }

    private static int[] calculateDiagonal(int size, int trace) {
        if ((size == 2 && trace == 3) || (size == 3 && (trace == 5 || trace == 7)) || (trace == size * size - 1 || trace == size + 1)) {
            return new int[0];
        }

        trace -= size;
        int[] result = new int[size];

        if (trace % size == 1) {
            result[0] = trace / size - 1;
            for (int i = 1; i < size - 2; i++) {
                result[i] = trace / size;
            }
            result[size - 2] = result[size - 1] = trace / size + 1;
            return result;
        }

        if (trace % size == size - 1) {
            result[0] = trace / size + 2;
            for (int i = 1; i < size - 2; i++) {
                result[i] = trace / size + 1;
            }
            result[size - 2] = result[size - 1] = trace / size;
            return result;
        }

        int num = trace % size;
        for (int i = 0; i < num; i++) {
            result[i] = trace / size + 1;
        }
        for (int i = num; i < size; i++) {
            result[i] = trace / size;
        }

        return result;
    }
}