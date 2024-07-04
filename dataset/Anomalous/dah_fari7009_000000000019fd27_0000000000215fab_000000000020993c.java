import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= totalTests; testCase++) {
            int dim = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[dim][dim];
            int trace = 0, numRows = 0, numCols = 0;

            for (int i = 0; i < dim; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                String[] line = scanner.nextLine().split("\\s");

                for (int j = 0; j < dim; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                    if (!rowSet.add(matrix[i][j])) {
                        numRows++;
                        break;
                    }
                }
            }

            for (int j = 0; j < dim; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                trace += matrix[j][j];

                for (int i = 0; i < dim; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        numCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + numRows + " " + numCols);
        }

        scanner.close();
    }
}