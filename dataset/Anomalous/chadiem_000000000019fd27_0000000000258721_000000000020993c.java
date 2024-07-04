import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<TestCase> testCases = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfTestCases = scanner.nextInt();
            for (int i = 0; i < numberOfTestCases; i++) {
                TestCase testCase = new TestCase();
                testCase.readInput(scanner);
                testCases.add(testCase);
            }
        }

        for (int i = 0; i < testCases.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + testCases.get(i).getSolution());
        }
    }

    private static class TestCase {
        private int size;
        private int[][] matrix;

        public void readInput(Scanner scanner) {
            size = scanner.nextInt();
            matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
        }

        public String getSolution() {
            long diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];
                if (containsDuplicates(matrix[i])) {
                    duplicateRows++;
                }
                if (containsDuplicates(getColumn(matrix, i))) {
                    duplicateCols++;
                }
            }

            return diagonalSum + " " + duplicateRows + " " + duplicateCols;
        }

        private boolean containsDuplicates(int[] array) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : array) {
                if (!uniqueElements.add(element)) {
                    return true;
                }
            }
            return false;
        }

        private int[] getColumn(int[][] matrix, int colIndex) {
            int[] column = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                column[i] = matrix[i][colIndex];
            }
            return column;
        }
    }
}