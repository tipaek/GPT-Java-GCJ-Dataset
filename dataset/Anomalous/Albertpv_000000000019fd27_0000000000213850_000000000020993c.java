import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private int countUniqueElements(Set<Integer>[] sets) {
        int count = 0;
        int expectedSize = sets.length;

        for (Set<Integer> set : sets) {
            if (set.size() != expectedSize) {
                count++;
            }
        }

        return count;
    }

    public void solve(int testCaseNumber, int[][] matrix) {
        int trace = 0;
        int matrixSize = matrix.length;
        Set<Integer>[] rowSets = new HashSet[matrixSize];
        Set<Integer>[] colSets = new HashSet[matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowSets[i].add(matrix[i][j]);
                colSets[j].add(matrix[i][j]);
            }
        }

        int rowDiffs = countUniqueElements(rowSets);
        int colDiffs = countUniqueElements(colSets);

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowDiffs + " " + colDiffs);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= numberOfTestCases; t++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] line = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                }
            }

            solution.solve(t, matrix);
        }

        scanner.close();
    }
}