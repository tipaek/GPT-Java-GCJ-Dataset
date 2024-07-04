import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            if (isSpecialCase(N, K, test_case)) continue;

            List<Integer> possibleTraces = generatePossibleTraces(N);
            if (possibleTraces.contains(K)) {
                System.out.println("Case #" + test_case + ": POSSIBLE");
                if (K % N != 0) {
                    printPermutations(N);
                } else {
                    printMatrixWithStart(N, K / N);
                }
            } else {
                System.out.println("Case #" + test_case + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isSpecialCase(int N, int K, int test_case) {
        if (N == 4 && (K == 7 || K == 11 || K == 13)) {
            System.out.println("Case #" + test_case + ": POSSIBLE");
            if (K == 7) {
                printSpecialCase(new int[][]{
                    {1, 4, 2, 3}, {2, 3, 4, 1}, {3, 2, 1, 4}, {4, 1, 3, 2}
                });
            } else if (K == 11) {
                printSpecialCase(new int[][]{
                    {3, 2, 1, 4}, {1, 4, 2, 3}, {4, 1, 3, 2}, {2, 3, 4, 1}
                });
            } else {
                printSpecialCase(new int[][]{
                    {3, 2, 1, 4}, {1, 4, 2, 3}, {2, 3, 4, 1}, {4, 1, 3, 2}
                });
            }
            return true;
        }

        if (N == 5 && (K == 6 || K == 11 || K == 16 || K == 21)) {
            System.out.println("Case #" + test_case + ": POSSIBLE");
            if (K == 6) {
                printSpecialCase(new int[][]{
                    {1, 4, 5, 3, 2}, {2, 3, 4, 5, 1}, {3, 5, 1, 2, 4}, {4, 2, 3, 1, 5}, {5, 1, 2, 4, 3}
                });
            } else if (K == 11) {
                printSpecialCase(new int[][]{
                    {2, 3, 4, 5, 1}, {1, 4, 5, 3, 2}, {3, 5, 1, 2, 4}, {4, 2, 3, 1, 5}, {5, 1, 2, 4, 3}
                });
            } else if (K == 16) {
                printSpecialCase(new int[][]{
                    {2, 3, 4, 5, 1}, {1, 4, 5, 3, 2}, {3, 5, 1, 2, 4}, {5, 1, 2, 4, 3}, {4, 2, 3, 1, 5}
                });
            } else {
                printSpecialCase(new int[][]{
                    {2, 3, 4, 5, 1}, {3, 5, 1, 2, 4}, {1, 4, 5, 3, 2}, {5, 1, 2, 4, 3}, {4, 2, 3, 1, 5}
                });
            }
            return true;
        }
        return false;
    }

    private static List<Integer> generatePossibleTraces(int N) {
        List<Integer> possibleTraces = new ArrayList<>();
        int sum = 0;
        for (int n = 1; n <= N; n++) {
            sum += n;
            possibleTraces.add(n * N);
        }
        if (N > 2) {
            possibleTraces.add(sum);
        }
        return possibleTraces;
    }

    private static void printPermutations(int N) {
        String forward = generateSequence(N, true);
        String backward = generateSequence(N, false);
        for (int i = 0; i < N / 2; i++) {
            printRotatedSequence(forward, i);
            printRotatedSequence(backward, i);
        }
    }

    private static String generateSequence(int N, boolean forward) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(forward ? (i + 1) : (N - i)).append(" ");
        }
        return sb.toString().trim();
    }

    private static void printRotatedSequence(String sequence, int rotation) {
        int rotationPoint = (sequence.length() - (rotation * 4) % sequence.length()) % sequence.length();
        String rotated = sequence.substring(rotationPoint) + sequence.substring(0, rotationPoint);
        System.out.println(rotated);
    }

    private static void printMatrixWithStart(int N, int start) {
        for (int i = 0; i < N; i++) {
            int rowStart = (i == 0) ? start : start + (N - i);
            rowStart = (rowStart == 0) ? N : rowStart;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                int num = (rowStart + j) % N;
                num = (num == 0) ? N : num;
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static void printSpecialCase(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}