import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] board = new int[N][N];
            int[] diagonal = new int[N];
            if (isValidDiagonal(diagonal, N, K)) {
                for (int i = 0; i < N; i++) {
                    board[i][i] = diagonal[i];
                }
                if (solveBoard(board, N)) {
                    System.out.printf("Case #%d: POSSIBLE\n%s", t, formatBoard(board, N));
                } else {
                    System.out.printf("Case #%d: IMPOSSIBLE\n", t);
                }
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            }
        }
    }

    public static boolean solveBoard(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= N; k++) {
                        board[i][j] = k;
                        if (isValidPlacement(board, i, j, N) && solveBoard(board, N)) {
                            return true;
                        }
                        board[i][j] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidDiagonal(int[] diagonal, int N, int K) {
        if (N == 3 && K % N != 0) {
            return false;
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(N, N);
        Arrays.fill(diagonal, N);
        int sum = N * N;
        for (int i = 0; sum > K; i = (i + 1) % N) {
            int count = frequencyMap.getOrDefault(diagonal[i], 0);
            frequencyMap.put(diagonal[i], count - 1);
            diagonal[i] -= 1;
            sum -= 1;
            count = frequencyMap.getOrDefault(diagonal[i], 0);
            frequencyMap.put(diagonal[i], count + 1);
        }
        for (int i = 0; i < N - 1; i++) {
            if (frequencyMap.getOrDefault(diagonal[i], 0) == N - 1) {
                if (diagonal[i] == 1 || diagonal[i] == N) {
                    return false;
                }
                diagonal[i]++;
                diagonal[i + 1]--;
            }
        }
        return sum == K;
    }

    public static boolean isValidPlacement(int[][] board, int row, int col, int N) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int k = 0; k < N; k++) {
            if (uniqueNumbers.contains(board[row][k])) {
                return false;
            }
            if (board[row][k] != 0) {
                uniqueNumbers.add(board[row][k]);
            }
        }
        uniqueNumbers.clear();
        for (int k = 0; k < N; k++) {
            if (uniqueNumbers.contains(board[k][col])) {
                return false;
            }
            if (board[k][col] != 0) {
                uniqueNumbers.add(board[k][col]);
            }
        }
        return true;
    }

    public static String formatBoard(int[][] board, int N) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result.append(board[i][j]);
                if (j < N - 1) {
                    result.append(" ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}