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
        int rowRepeats = 0;
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    rowRepeats++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return rowRepeats;
    }

    private static int countColRepeats(int[][] matrix, int size) {
        int colRepeats = 0;
        for (int j = 0; j < size; j++) {
            boolean[] seen = new boolean[size + 1];
            for (int i = 0; i < size; i++) {
                if (seen[matrix[i][j]]) {
                    colRepeats++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return colRepeats;
    }
}