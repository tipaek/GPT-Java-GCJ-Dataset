import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int sizeOfMatrix = scanner.nextInt();
            int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
            int trace = 0;

            for (int row = 0; row < sizeOfMatrix; row++) {
                for (int col = 0; col < sizeOfMatrix; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            int rowRepeats = countRowRepeats(matrix, sizeOfMatrix);
            int colRepeats = countColRepeats(matrix, sizeOfMatrix);

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }

    private static int countRowRepeats(int[][] matrix, int size) {
        int rowRepeats = 0;
        for (int row = 0; row < size; row++) {
            if (!isUnique(matrix[row])) {
                rowRepeats++;
            }
        }
        return rowRepeats;
    }

    private static int countColRepeats(int[][] matrix, int size) {
        int colRepeats = 0;
        for (int col = 0; col < size; col++) {
            int[] colArray = new int[size];
            for (int row = 0; row < size; row++) {
                colArray[row] = matrix[row][col];
            }
            if (!isUnique(colArray)) {
                colRepeats++;
            }
        }
        return colRepeats;
    }

    private static boolean isUnique(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (num < 1 || num > array.length || seen[num]) {
                return false;
            }
            seen[num] = true;
        }
        return true;
    }
}