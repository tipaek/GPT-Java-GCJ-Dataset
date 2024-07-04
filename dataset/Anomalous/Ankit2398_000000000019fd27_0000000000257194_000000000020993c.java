import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowRepeats = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> seen = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!seen.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            int colRepeats = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> seen = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!seen.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
    }
}