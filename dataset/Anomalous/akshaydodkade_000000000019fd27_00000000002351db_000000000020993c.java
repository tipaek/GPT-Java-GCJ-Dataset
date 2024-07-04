import java.util.Scanner;

public class A {

    int N;
    int[][] matrix;

    int[] calculateTraceAndDuplicates() {
        int trace = 0, duplicateRows = 0, duplicateCols = 0;
        int[] result = new int[3];

        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];

            // Check for duplicate rows
            boolean rowHasDuplicate = false;
            for (int j = 0; j < N && !rowHasDuplicate; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (matrix[i][j] == matrix[i][k]) {
                        duplicateRows++;
                        rowHasDuplicate = true;
                        break;
                    }
                }
            }

            // Check for duplicate columns
            boolean colHasDuplicate = false;
            for (int j = 0; j < N && !colHasDuplicate; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (matrix[j][i] == matrix[k][i]) {
                        duplicateCols++;
                        colHasDuplicate = true;
                        break;
                    }
                }
            }
        }

        result[0] = trace;
        result[1] = duplicateRows;
        result[2] = duplicateCols;

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            A obj = new A();
            obj.N = scanner.nextInt();
            obj.matrix = new int[obj.N][obj.N];

            // Input
            for (int i = 0; i < obj.N; i++) {
                for (int j = 0; j < obj.N; j++) {
                    obj.matrix[i][j] = scanner.nextInt();
                }
            }

            // Output
            int[] result = obj.calculateTraceAndDuplicates();
            System.out.println("Case #" + t + ": " + result[0] + " " + result[1] + " " + result[2]);
        }

        scanner.close();
    }
}