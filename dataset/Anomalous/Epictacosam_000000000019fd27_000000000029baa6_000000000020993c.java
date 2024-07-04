import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int rowRepeats = 0;
            int colRepeats = 0;
            int diagonalSum = 0;
            int matrixSize = scanner.nextInt();

            int[][] matrix = new int[matrixSize][matrixSize];
            List<Set<Integer>> rowSets = new ArrayList<>();
            List<Set<Integer>> colSets = new ArrayList<>();

            boolean[] rowRepeatFlags = new boolean[matrixSize];
            boolean[] colRepeatFlags = new boolean[matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                rowSets.add(new HashSet<>());
                colSets.add(new HashSet<>());
            }

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;

                    if (i == j) {
                        diagonalSum += value;
                    }

                    if (!rowSets.get(i).add(value) && !rowRepeatFlags[i]) {
                        rowRepeats++;
                        rowRepeatFlags[i] = true;
                    }

                    if (!colSets.get(j).add(value) && !colRepeatFlags[j]) {
                        colRepeats++;
                        colRepeatFlags[j] = true;
                    }
                }
            }

            System.out.printf("Case: #%d %d %d %d%n", t + 1, diagonalSum, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}