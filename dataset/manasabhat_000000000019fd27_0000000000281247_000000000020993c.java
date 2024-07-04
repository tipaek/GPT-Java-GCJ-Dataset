import java.util.Scanner;

public class Solution {

    private static int trace(int[][] A, int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i][i];
        }
        return sum;

    }

    private static int findRepeatedRows(int[][] A, int N) {
        int r = 0;
        boolean[] check;
        for (int i = 0; i < N; i++) {
            check = new boolean[N];
            for (int j = 0; j < N; j++) {
                if (check[A[i][j] - 1]) {
                    r++;
                    break;
                }
                check[A[i][j] - 1] = true;
            }
        }
        return r;
    }

    private static int findRepeatedCols(int[][] A, int N) {
        int c = 0;
        boolean[] check;
        for (int i = 0; i < N; i++) {
            check = new boolean[N];
            for (int j = 0; j < N; j++) {
                if (check[A[j][i] - 1]) {
                    c++;
                    break;
                }
                check[A[j][i] - 1] = true;
            }
        }
        return c;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int num = scanner.nextInt();
        while (num != 0) {
            int N = scanner.nextInt();
            int[][] A = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    A[j][i] = scanner.nextInt();
                }
            }

            int sum = trace(A, N);

            int r = findRepeatedRows(A, N);

            int c = findRepeatedCols(A, N);
            System.out.printf("%d %d %d", sum, r, c);
            num--;
        }
        scanner.close();
    }
}
