import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (isPossible(n, k)) {
                System.out.println("Case #" + i + ": POSSIBLE");
                int[][] latinSquare = generateLatinSquare(n);
                adjustLatinSquare(latinSquare, n, k);
                printLatinSquare(latinSquare);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossible(int n, int k) {
        return k % n == 0 && k >= n && k <= n * n;
    }

    private static int[][] generateLatinSquare(int n) {
        int[][] square = new int[n][n];
        int start = n + 1;

        for (int i = 0; i < n; i++) {
            int temp = start;
            int count = 0;

            while (temp <= n) {
                square[i][count++] = temp++;
            }

            for (int j = 1; j < start; j++) {
                square[i][count++] = j;
            }

            start--;
        }

        return square;
    }

    private static void adjustLatinSquare(int[][] square, int n, int k) {
        int change = k / n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (square[i][j] == change) {
                    square[i][j] = 1;
                } else if (square[i][j] == 1) {
                    square[i][j] = change;
                }
            }
        }
    }

    private static void printLatinSquare(int[][] square) {
        int n = square.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(square[i][j]);
                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}