import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int sizeOfMatrix = scanner.nextInt();
            int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

            int trace = 0;

            for (int i = 0; i < sizeOfMatrix; i++) {
                for (int j = 0; j < sizeOfMatrix; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
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
        int repeats = 0;

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                repeats++;
            }
        }

        return repeats;
    }

    private static int countColRepeats(int[][] matrix, int size) {
        int repeats = 0;

        for (int i = 0; i < size; i++) {
            int[] col = new int[size];
            for (int j = 0; j < size; j++) {
                col[j] = matrix[j][i];
            }
            if (hasDuplicates(col)) {
                repeats++;
            }
        }

        return repeats;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}