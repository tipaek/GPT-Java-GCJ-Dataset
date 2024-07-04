import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        int num = scanner.nextInt();
        int sum =0;
        int r =0;
        int c =0;
        int counter = 0;
        while (num != counter) {
            counter++;
            int N = scanner.nextInt();
            int[][] A = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    A[j][i] = scanner.nextInt();
                }
            }

            sum = trace(A, N);

            r = findRepeatedRows(A, N);

            c = findRepeatedCols(A, N);
            System.out.printf("Case #%d: %d %d %d \n",counter, sum, r, c);

        }

        scanner.close();
    }
}
