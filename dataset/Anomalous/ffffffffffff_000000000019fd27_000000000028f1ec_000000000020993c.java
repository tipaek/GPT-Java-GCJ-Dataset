import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;

            // Read matrix and calculate trace
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            // Check for row repetitions
            for (int j = 0; j < N; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for column repetitions
            for (int j = 0; j < N; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < N; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}