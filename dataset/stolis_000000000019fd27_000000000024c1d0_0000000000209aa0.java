import java.util.Scanner;

// Indicium
public class Solution {

    public static void main(String[] args) {
        //verifyAll();
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();
            int[][] A = build(N, K);
            String output;
            if (A == null) {
                output = "IMPOSSIBLE\n";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("POSSIBLE\n");
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        sb.append(A[r][c]);
                        sb.append(c == N - 1 ? '\n' : ' ');
                    }
                }
                output = sb.toString();
            }
            System.out.printf("Case #%d: %s", t, output);
        }
    }

    private static int[][] build(int N, int K) {
        if (K == N + 1 || K == N * N - 1 || (N == 3 && K % N != 0)) {
            return null; // impossible
        }

        // build base latin square
        int[][] A = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                A[r][c] = 1 + ((N - r + c) % N);
            }
        }

        if (K % N == 0) {
            swap(A, 1, K / N);
            return A;
        }

        if (N == 4 && K == 10) {
            int[][] C = build(4, 6);
            swap(C, 1, 3);
            return C;
        }

        if (K == N + 2 || K == N * N - 2) {
            if (N % 2 == 0) {
                int[][] B = build(N / 2, N / 2);
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        A[r][c] = 2 * B[r / 2][c / 2] - 1 + ((r + c) % 2);
                    }
                }
            } else {
                A[N - 3][0] = 2;
                for (int c = 1; c < N - 3; c++) {
                    A[N - 3][c] = c + 3;
                }
                A[N - 3][N - 2] = N;
                A[N - 3][N - 1] = 3;

                A[N - 2][0] = 3;
                for (int c = 1; c < N - 2; c += 2) {
                    A[N - 2][c] = c + 4;
                }
                for (int c = 2; c < N - 2; c += 2) {
                    A[N - 2][c] = c + 2;
                }

                A[N - 1][N - 3] = N;
                for (int c = 1; c < N - 3; c += 2) {
                    A[N - 1][c] = c + 2;
                }
                for (int c = 0; c < N - 3; c += 2) {
                    A[N - 1][c] = c + 4;
                }
            }
            A[N - 2][N - 2] = A[N - 1][N - 1] = 2;
            A[N - 2][N - 1] = A[N - 1][N - 2] = 1;
            if (K == N * N - 2) {
                swap(A, 1, N);
                swap(A, 2, N - 1);
            }
            return A;
        }

        int da = -1;
        int db = -1;
        int dc = -1;
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                if (b == a) {
                    continue;
                }
                for (int c = 1; c <= N; c++) {
                    if (c == b || c == a) {
                        continue;
                    }
                    if (b + c + (N - 2) * a == K) {
                        da = a;
                        db = b;
                        dc = c;
                    }
                }
            }
        }
        if (da == -1) {
            return null; // PENDING
        }

        // build latin square with 1,...1,N,2 on diag
        int[] temp = A[N - 1];
        A[N - 1] = A[N - 2];
        A[N - 2] = temp;

        // replace 1,N,2 with da,db,dc
        swap(A, 1, da);
        int dn = (da == N) ? 1 : N;
        int d2 = (da == 2) ? 1 : 2;
        swap(A, dn, db);
        d2 = (db == 2) ? dn : d2;
        swap(A, d2, dc);

        return A;
    }

    private static void swap(int[][] A, int x, int y) {
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A.length; c++) {
                int a = A[r][c];
                if (a == x) {
                    A[r][c] = y;
                } else if (a == y) {
                    A[r][c] = x;
                }
            }
        }
    }

    private static void print(int[][] A) {
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A.length; c++) {
                System.out.print(A[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean verify(int[][] A, int K) {
        int N = A.length;
        int trace = 0;
        for (int n = 0; n < N; n++) {
            trace += A[n][n];
        }
        if (trace != K) {
            return false;
        }
        for (int r = 0; r < N; r++) {
            boolean[] used = new boolean[N];
            for (int c = 0; c < N; c++) {
                if (used[A[r][c] - 1]) {
                    return false;
                }
                used[A[r][c] - 1] = true;
            }
        }
        for (int c = 0; c < N; c++) {
            boolean[] used = new boolean[N];
            for (int r = 0; r < N; r++) {
                if (used[A[r][c] - 1]) {
                    return false;
                }
                used[A[r][c] - 1] = true;
            }
        }
        return true;
    }

    private static void verifyAll() {
        for (int N = 2; N <= 50; N++) {
            for (int K = N; K <= N * N; K++) {
                int[][] A = build(N, K);
                if (A == null) {
                    if (K != N + 1 && K != N * N - 1 && (N != 3 || K%N == 0)) {
                        System.out.println("not implemented: " + N + " " + K);
                    }
                } else if (!verify(A, K)) {
                    System.out.println("BUG: " + N + " " + K);
                }
            }
        }
        System.out.println("DONE");
        System.exit(0);
    }

}
