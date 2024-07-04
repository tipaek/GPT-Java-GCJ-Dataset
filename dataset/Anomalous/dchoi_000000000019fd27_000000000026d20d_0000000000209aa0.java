import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            List<Integer> possibleTraces = new ArrayList<>();
            int sum = 0;

            for (int n = 1; n <= N; n++) {
                sum += n;
                possibleTraces.add(n * N);
            }
            if (N > 2) {
                possibleTraces.add(sum);
            }

            String result = "Case #" + test_case + ": ";
            if (isSpecialCase(N, K)) {
                printSpecialCase(N, K, result);
            } else if (possibleTraces.contains(K)) {
                System.out.println(result + "POSSIBLE");
                if (K % N != 0) {
                    printDiagonalMatrix(N);
                } else {
                    printCyclicMatrix(N, K / N);
                }
            } else {
                System.out.println(result + "IMPOSSIBLE");
            }
        }
    }

    private static boolean isSpecialCase(int N, int K) {
        return (N == 4 && (K == 6 || K == 7 || K == 9 || K == 11 || K == 13 || K == 14)) ||
               (N == 5 && (K == 7 || K == 8 || K == 9 || K == 11 || K == 12 || K == 13 || K == 14 || K == 16 || K == 17 || K == 18 || K == 19 || K == 21 || K == 22 || K == 23));
    }

    private static void printSpecialCase(int N, int K, String result) {
        System.out.println(result + "POSSIBLE");
        if (N == 4) {
            if (K == 6) printMatrix(new int[][]{{1, 4, 3, 2}, {3, 2, 1, 4}, {4, 1, 2, 3}, {2, 3, 4, 1}});
            else if (K == 7) printMatrix(new int[][]{{1, 4, 2, 3}, {2, 3, 4, 1}, {3, 2, 1, 4}, {4, 1, 3, 2}});
            else if (K == 9) printMatrix(new int[][]{{1, 4, 2, 3}, {2, 3, 1, 4}, {4, 2, 3, 1}, {3, 1, 4, 2}});
            else if (K == 11) printMatrix(new int[][]{{3, 2, 1, 4}, {1, 4, 2, 3}, {4, 1, 3, 2}, {2, 3, 4, 1}});
            else if (K == 13) printMatrix(new int[][]{{3, 2, 1, 4}, {1, 4, 2, 3}, {2, 3, 4, 1}, {4, 1, 3, 2}});
            else if (K == 14) printMatrix(new int[][]{{3, 1, 2, 4}, {2, 4, 3, 1}, {1, 3, 4, 2}, {4, 2, 1, 3}});
        } else if (N == 5) {
            if (K == 7) printMatrix(new int[][]{{1, 5, 4, 3, 2}, {2, 1, 5, 3, 4}, {4, 3, 2, 1, 5}, {5, 4, 1, 2, 3}, {3, 2, 4, 5, 1}});
            else if (K == 8) printMatrix(new int[][]{{1, 4, 5, 3, 2}, {4, 2, 3, 1, 5}, {5, 1, 2, 4, 3}, {3, 5, 1, 2, 4}, {2, 3, 4, 5, 1}});
            else if (K == 9) printMatrix(new int[][]{{1, 4, 5, 3, 2}, {4, 2, 3, 1, 5}, {3, 5, 1, 2, 4}, {5, 1, 2, 4, 3}, {2, 3, 4, 5, 1}});
            else if (K == 11) printMatrix(new int[][]{{2, 3, 4, 5, 1}, {1, 4, 5, 3, 2}, {3, 5, 1, 2, 4}, {4, 2, 3, 1, 5}, {5, 1, 2, 4, 3}});
            else if (K == 12) printMatrix(new int[][]{{1, 4, 5, 3, 2}, {2, 3, 4, 5, 1}, {4, 2, 3, 1, 5}, {3, 5, 1, 2, 4}, {5, 1, 2, 4, 3}});
            else if (K == 13) printMatrix(new int[][]{{1, 4, 5, 3, 2}, {2, 3, 4, 5, 1}, {5, 1, 2, 4, 3}, {3, 5, 1, 2, 4}, {4, 2, 3, 1, 5}});
            else if (K == 14) printMatrix(new int[][]{{1, 4, 5, 3, 2}, {2, 3, 4, 5, 1}, {3, 5, 1, 2, 4}, {5, 1, 2, 4, 3}, {4, 2, 3, 1, 5}});
            else if (K == 16) printMatrix(new int[][]{{2, 3, 4, 5, 1}, {1, 4, 5, 3, 2}, {3, 5, 1, 2, 4}, {5, 1, 2, 4, 3}, {4, 2, 3, 1, 5}});
            else if (K == 17) printMatrix(new int[][]{{1, 4, 5, 3, 2}, {3, 5, 1, 2, 4}, {4, 2, 3, 1, 5}, {2, 3, 4, 5, 1}, {5, 1, 2, 4, 3}});
            else if (K == 18) printMatrix(new int[][]{{1, 4, 5, 3, 2}, {3, 5, 1, 2, 4}, {5, 1, 2, 4, 3}, {2, 3, 4, 5, 1}, {4, 2, 3, 1, 5}});
            else if (K == 19) printMatrix(new int[][]{{1, 4, 5, 3, 2}, {3, 5, 1, 2, 4}, {2, 3, 4, 5, 1}, {5, 1, 2, 4, 3}, {4, 2, 3, 1, 5}});
            else if (K == 21) printMatrix(new int[][]{{2, 3, 4, 5, 1}, {3, 5, 1, 2, 4}, {1, 4, 5, 3, 2}, {5, 1, 2, 4, 3}, {4, 2, 3, 1, 5}});
            else if (K == 22) printMatrix(new int[][]{{4, 3, 1, 2, 5}, {3, 5, 4, 1, 2}, {2, 4, 5, 3, 1}, {5, 1, 2, 4, 3}, {1, 2, 3, 5, 4}});
            else if (K == 23) printMatrix(new int[][]{{5, 2, 1, 3, 4}, {1, 4, 5, 2, 3}, {3, 5, 4, 1, 2}, {4, 3, 2, 5, 1}, {2, 1, 3, 4, 5}});
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }

    private static void printDiagonalMatrix(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((i + j) % N + 1 + " ");
            }
            System.out.println();
        }
    }

    private static void printCyclicMatrix(int N, int start) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((start + j) % N + 1 + " ");
            }
            System.out.println();
            start = (start + N - 1) % N;
        }
    }
}