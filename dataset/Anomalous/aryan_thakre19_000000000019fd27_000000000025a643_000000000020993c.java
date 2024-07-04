import java.util.Scanner;

public class Main {
    public static boolean check(int[] array, int element) {
        for (int value : array) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String casePrefix = "Case #";

        while (t-- > 0) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int diagonalSum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            String caseNumber = Integer.toString(t + 1);
            System.out.println(casePrefix + caseNumber + ": " + diagonalSum);
        }
    }
}