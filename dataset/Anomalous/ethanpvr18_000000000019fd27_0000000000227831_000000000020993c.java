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

            int rowRepeats = countRepeats(matrix, sizeOfMatrix, true);
            int colRepeats = countRepeats(matrix, sizeOfMatrix, false);

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }

    private static int countRepeats(int[][] matrix, int size, boolean isRow) {
        int repeats = 0;
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (seen[value]) {
                    repeats++;
                    break;
                }
                seen[value] = true;
            }
        }
        return repeats;
    }
}