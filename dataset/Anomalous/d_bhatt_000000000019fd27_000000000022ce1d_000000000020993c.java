import java.util.Scanner;

public class TraceMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of matrices: ");
        int numberOfMatrices = scanner.nextInt();

        for (int n = 1; n <= numberOfMatrices; n++) {
            System.out.print("Enter size of matrix: ");
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Reading matrix elements
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Display matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }

            int trace = calculateTrace(matrix, size);
            int rowRepeats = countRowRepeats(matrix, size);
            int colRepeats = countColRepeats(matrix, size);

            System.out.println("Case #" + n + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix, int size) {
        int rowRepeats = 0;
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            boolean hasRepeat = false;
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    hasRepeat = true;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
            if (hasRepeat) {
                rowRepeats++;
            }
        }
        return rowRepeats;
    }

    private static int countColRepeats(int[][] matrix, int size) {
        int colRepeats = 0;
        for (int j = 0; j < size; j++) {
            boolean[] seen = new boolean[size + 1];
            boolean hasRepeat = false;
            for (int i = 0; i < size; i++) {
                if (seen[matrix[i][j]]) {
                    hasRepeat = true;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
            if (hasRepeat) {
                colRepeats++;
            }
        }
        return colRepeats;
    }
}