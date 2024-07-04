import java.util.Scanner;

public class Solution {
    public static int flag;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T, N, K;
        int[] arr;
        Permutation permutation = new Permutation();

        T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            N = scan.nextInt();
            K = scan.nextInt();
            flag = 0;

            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = i + 1;
            }

            permutation.permute(arr, 0, N - 1, N, K, t);

            if (flag == 0) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
    }
}

class Permutation {
    public void permute(int[] arr, int l, int r, int N, int K, int t) {
        if (l == r) {
            int traceAttempt = 0;
            int[][] mat = new int[N][N];

            for (int j = 0; j < N * 2; j += 2) {
                traceAttempt += arr[j % N];
            }

            if (traceAttempt == K && Solution.flag == 0) {
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");

                // Create matrix grid
                // Top diagonal
                for (int start = 0; start < N; start++) {
                    for (int cont = 0; cont <= start; cont++) {
                        mat[start - cont][cont] = arr[start];
                    }
                }

                // Bottom diagonal
                for (int start = 1; start < N; start++) {
                    for (int cont = 0; cont < N - start; cont++) {
                        mat[N - 1 - cont][start + cont] = arr[start - 1];
                    }
                }

                // Print matrix
                for (int row = 0; row < N; row++) {
                    for (int col = 0; col < N; col++) {
                        System.out.print(mat[row][col] + " ");
                    }
                    System.out.println();
                }
                Solution.flag = 1;
            }
        } else {
            for (int i = l; i <= r; i++) {
                arr = swap(arr, l, i);
                permute(arr, l + 1, r, N, K, t);
                arr = swap(arr, l, i);
            }
        }
    }

    private int[] swap(int[] g, int i, int j) {
        int[] h = g.clone();
        int temp = h[i];
        h[i] = h[j];
        h[j] = temp;
        return h;
    }
}