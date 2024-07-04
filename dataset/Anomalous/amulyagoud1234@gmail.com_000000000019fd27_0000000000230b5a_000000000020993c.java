import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int p = 1; p <= t; p++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int sum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                sum += matrix[i][i];
            }

            System.out.println(sum);
        }
    }
}