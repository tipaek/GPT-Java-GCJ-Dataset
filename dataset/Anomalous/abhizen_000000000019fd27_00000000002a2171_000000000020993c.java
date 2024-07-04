import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= tests; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] inputMatrix = new int[N][N];
            
            for (int j = 0; j < N; j++) {
                String[] elems = scanner.nextLine().split("\\s+");
                for (int col = 0; col < N; col++) {
                    inputMatrix[j][col] = Integer.parseInt(elems[col]);
                }
            }

            printRepeatedRowColumns(inputMatrix, N, i);
        }
    }

    private static void printRepeatedRowColumns(int[][] inputMatrix, int N, int caseNo) {
        int trace = 0;
        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < N; i++) {
            boolean[] rowCheck = new boolean[N];
            boolean[] colCheck = new boolean[N];
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    trace += inputMatrix[i][j];
                }

                if (rowCheck[inputMatrix[i][j] - 1]) {
                    rowHasDuplicate = true;
                } else {
                    rowCheck[inputMatrix[i][j] - 1] = true;
                }

                if (colCheck[inputMatrix[j][i] - 1]) {
                    colHasDuplicate = true;
                } else {
                    colCheck[inputMatrix[j][i] - 1] = true;
                }
            }

            if (rowHasDuplicate) {
                rowCount++;
            }

            if (colHasDuplicate) {
                colCount++;
            }
        }

        System.out.println("Case #" + caseNo + ": " + trace + " " + rowCount + " " + colCount);
    }
}