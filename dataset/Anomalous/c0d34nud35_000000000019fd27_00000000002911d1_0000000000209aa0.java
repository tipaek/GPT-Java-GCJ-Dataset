import java.util.Scanner;

public class Solution {
    public static int flag;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            flag = 0;

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = i + 1;
            }

            Solution permutation = new Solution();
            permutation.permute(arr, 0, N - 1, N, K, t);

            if (flag == 0) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }

        scan.close();
    }

    private void permute(int[] arr, int l, int r, int N, int K, int t) {
        if (l == r) {
            int traceAttempt = 0;
            int[][] mat = new int[N][N];

            for (int j = 0; j < N * 2; j += 2) {
                traceAttempt += arr[j % N];
            }

            if (traceAttempt == K && flag == 0) {
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");

                for (int start = 0; start < N; start++) {
                    for (int cont = 0; cont <= start; cont++) {
                        mat[start - cont][cont] = arr[start];
                    }
                }

                for (int start = 1; start < N; start++) {
                    for (int cont = 0; cont < N - start; cont++) {
                        mat[N - 1 - cont][start + cont] = arr[start - 1];
                    }
                }

                for (int[] row : mat) {
                    for (int col : row) {
                        System.out.print(col + " ");
                    }
                    System.out.println();
                }

                flag = 1;
            }
        } else {
            for (int i = l; i <= r; i++) {
                arr = swap(arr, l, i);
                permute(arr, l + 1, r, N, K, t);
                arr = swap(arr, l, i);
            }
        }
    }

    private int[] swap(int[] arr, int i, int j) {
        int[] newArr = arr.clone();
        int temp = newArr[i];
        newArr[i] = newArr[j];
        newArr[j] = temp;
        return newArr;
    }
}