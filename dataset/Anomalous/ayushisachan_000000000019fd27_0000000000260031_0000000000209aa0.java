import java.util.Scanner;

public class Indiciium {
    public static void main(String[] args) {
        Indiciium indiciium = new Indiciium();
        indiciium.processInput();
    }

    void processInput() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int targetTrace = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, matrixSize);

            if (trace == targetTrace) {
                System.out.println("POSSIBLE");
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
        scanner.close();
    }

    int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
}