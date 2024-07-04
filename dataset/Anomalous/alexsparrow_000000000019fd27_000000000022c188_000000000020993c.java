import java.util.Scanner;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    static int row = 0;
    static int col = 0;

    public static void main(String[] args) {
        int t = scan.nextInt();
        for (int i = 0; i < t; ++i) {
            int dia = 0;
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    arr[j][k] = scan.nextInt();
                }
                dia += arr[j][j];
            }
            System.out.print(dia + " ");
            for (int j = 0; j < n; ++j) {
                add(arr[j]);
            }
            System.out.print(row + " ");
            row = 0;

            rotateMatrix(arr, n);

            for (int j = 0; j < n; ++j) {
                add(arr[j]);
            }
            System.out.print(row + " ");
        }
    }

    private static void add(int[] arr) {
        int[] cnt = new int[100];
        for (int i = 0; i < arr.length; ++i) {
            ++cnt[arr[i]];
            if (cnt[arr[i]] > 1) {
                ++row;
                return;
            }
        }
    }

    private static void rotateMatrix(int[][] a, int n) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = a[i][j];
                a[i][j] = a[n - 1 - j][i];
                a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
                a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
                a[j][n - 1 - i] = temp;
            }
        }
    }
}