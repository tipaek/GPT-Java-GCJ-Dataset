import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMatrices = scanner.nextInt();

        for (int matrixIndex = 0; matrixIndex < numberOfMatrices; matrixIndex++) {
            int matrixOrder = scanner.nextInt();
            int[][] matrix = new int[matrixOrder][matrixOrder];

            for (int i = 0; i < matrixOrder; i++) {
                for (int j = 0; j < matrixOrder; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < matrixOrder; i++) {
                trace += matrix[i][i];
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < matrixOrder; i++) {
                if (hasDuplicate(matrix[i])) {
                    rowRepeats++;
                }

                int[] column = new int[matrixOrder];
                for (int j = 0; j < matrixOrder; j++) {
                    column[j] = matrix[j][i];
                }

                if (hasDuplicate(column)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + (matrixIndex + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}