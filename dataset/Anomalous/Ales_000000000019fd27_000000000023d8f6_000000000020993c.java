import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                boolean rowFlag = false, colFlag = false;

                for (int j = 0; j < matrixSize; j++) {
                    if (!rowFlag && !rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        rowFlag = true;
                    }
                    if (!colFlag && !colSet.add(matrix[j][i])) {
                        colDuplicates++;
                        colFlag = true;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}