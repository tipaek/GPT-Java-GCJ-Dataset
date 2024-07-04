import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            int K = input.nextInt();
            solve(ks, N, K);
        }
    }

    private static void solve(int ks, int n, int k) {
        boolean isPossible = isPossible(n, k);
        String result = isPossible ? "POSSIBLE" : "IMPOSSIBLE";
        System.out.println("Case #" + ks + ": " + result);
        if (isPossible) {
            int[][] latinSquare = generateLatinSquare(n, k);
            printLatinSquare(latinSquare);
        }
    }

    private static boolean isPossible(int n, int k) {
        if (n == 3) {
            return k == 3 || k == 6 || k == 9;
        } else {
            return k != n + 1 && k != n * n - 1;
        }
    }

    private static int[][] generateLatinSquare(int n, int k) {
        int[][] latinSquare = new int[n][n];
        int avg = k / n;
        int mod = k % n;

        for (int i = 0; i < n; i++) {
            latinSquare[i][i] = avg;
        }

        if (mod == 1) {
            latinSquare[n - 2][n - 2]--;
            latinSquare[n - 1][n - 1] += 2;
        } else if (mod > 1) {
            for (int i = 0; i < mod; i++) {
                latinSquare[i][i]++;
            }
        }

        int[][] cyclicMatrix = generateCyclicMatrix(n);
        for (int i = 0; i < n; i++) {
            int value = latinSquare[i][i];
            for (int j = 0; j < n; j++) {
                if (cyclicMatrix[j][i] == value) {
                    latinSquare[i] = cyclicMatrix[j];
                    break;
                }
            }
        }

        return latinSquare;
    }

    private static int[][] generateCyclicMatrix(int n) {
        int[][] cyclicMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cyclicMatrix[i][j] = (i + j) % n + 1;
            }
        }
        return cyclicMatrix;
    }

    private static void printLatinSquare(int[][] latinSquare) {
        for (int[] row : latinSquare) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}