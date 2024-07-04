import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        int testNum = 1;

        while (testCases > 0) {
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            scanner.nextLine();
            for (int i = 0; i < size; i++) {
                String[] input = scanner.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(input[j]);
                }
            }

            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            for (int i = 0; i < size; i++) {
                boolean[] rowCheck = new boolean[size];
                boolean rowFlag = false;
                for (int j = 0; j < size; j++) {
                    int num = matrix[i][j];
                    if (rowCheck[num - 1]) {
                        if (!rowFlag) {
                            rowDuplicates++;
                            rowFlag = true;
                        }
                    }
                    rowCheck[num - 1] = true;
                }
            }

            for (int i = 0; i < size; i++) {
                boolean[] colCheck = new boolean[size];
                boolean colFlag = false;
                for (int j = 0; j < size; j++) {
                    int num = matrix[j][i];
                    if (colCheck[num - 1]) {
                        if (!colFlag) {
                            colDuplicates++;
                            colFlag = true;
                        }
                    }
                    colCheck[num - 1] = true;
                }
            }

            System.out.println("#" + testNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
            testCases--;
            testNum++;
        }
    }
}