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
            boolean[] seen = new boolean[size + 1];
            for (int col = 0; col < size; col++) {
                if (seen[matrix[row][col]]) {
                    rowRepeats++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }

        return rowRepeats;
    }

    private static int countColRepeats(int[][] matrix, int size) {
        int colRepeats = 0;

        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size + 1];
            for (int row = 0; row < size; row++) {
                if (seen[matrix[row][col]]) {
                    colRepeats++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }

        return colRepeats;
    }
}