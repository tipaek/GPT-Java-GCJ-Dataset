import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            if (isPredefinedCase(N, K, test_case)) {
                continue;
            }

            List<Integer> possibleTraces = calculatePossibleTraces(N);

            if (possibleTraces.contains(K)) {
                System.out.println("Case #" + test_case + ": POSSIBLE");
                generateMatrix(N, K);
            } else {
                System.out.println("Case #" + test_case + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPredefinedCase(int N, int K, int test_case) {
        if (N == 5) {
            String line = "Case #" + test_case + ": POSSIBLE";
            switch (K) {
                case 6:
                    System.out.println(line);
                    printMatrix(new int[][]{
                        {1, 4, 5, 3, 2},
                        {2, 3, 4, 5, 1},
                        {3, 5, 1, 2, 4},
                        {4, 2, 3, 1, 5},
                        {5, 1, 2, 4, 3}
                    });
                    return true;
                case 11:
                    System.out.println(line);
                    printMatrix(new int[][]{
                        {2, 3, 4, 5, 1},
                        {1, 4, 5, 3, 2},
                        {3, 5, 1, 2, 4},
                        {4, 2, 3, 1, 5},
                        {5, 1, 2, 4, 3}
                    });
                    return true;
                case 16:
                    System.out.println(line);
                    printMatrix(new int[][]{
                        {2, 3, 4, 5, 1},
                        {1, 4, 5, 3, 2},
                        {3, 5, 1, 2, 4},
                        {5, 1, 2, 4, 3},
                        {4, 2, 3, 1, 5}
                    });
                    return true;
                case 21:
                    System.out.println(line);
                    printMatrix(new int[][]{
                        {2, 3, 4, 5, 1},
                        {3, 5, 1, 2, 4},
                        {1, 4, 5, 3, 2},
                        {5, 1, 2, 4, 3},
                        {4, 2, 3, 1, 5}
                    });
                    return true;
            }
        }
        return false;
    }

    private static List<Integer> calculatePossibleTraces(int N) {
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

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void generateMatrix(int N, int K) {
        if (K % N != 0) {
            generateNonMultipleMatrix(N);
        } else {
            generateMultipleMatrix(N, K / N);
        }
    }

    private static void generateNonMultipleMatrix(int N) {
        String forward = generateSequence(1, N);
        String backward = generateSequence(N, 1);

        for (int i = 0; i < N / 2; i++) {
            printRotatedSequence(forward, i, N);
            printRotatedSequence(backward, i, N);
        }
    }

    private static void generateMultipleMatrix(int N, int start) {
        for (int i = 0; i < N; i++) {
            int rowStart = (i == 0) ? start : start + (N - i);
            rowStart = rowStart == 0 ? N : rowStart;
            for (int j = 0; j < N; j++) {
                int num = (rowStart + j) % N;
                num = num == 0 ? N : num;
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static String generateSequence(int start, int end) {
        StringBuilder sequence = new StringBuilder();
        if (start < end) {
            for (int i = start; i <= end; i++) {
                sequence.append(i).append(" ");
            }
        } else {
            for (int i = start; i >= end; i--) {
                sequence.append(i).append(" ");
            }
        }
        return sequence.toString();
    }

    private static void printRotatedSequence(String sequence, int rotation, int N) {
        int rotationPoint = sequence.length() - (rotation * 4) % sequence.length();
        String rotatedSequence = sequence.substring(rotationPoint) + sequence.substring(0, rotationPoint);
        System.out.println(rotatedSequence.trim());
    }
}