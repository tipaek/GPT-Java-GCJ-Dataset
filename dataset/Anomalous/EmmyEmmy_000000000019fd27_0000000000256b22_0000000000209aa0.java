import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            if (k % n == 0) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                int[][] latinSquare = generateLatinSquare(n);
                int increment = k / n - 1;
                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {
                        latinSquare[row][col] += increment;
                        if (latinSquare[row][col] > n) {
                            latinSquare[row][col] -= n;
                        }
                        System.out.print(latinSquare[row][col] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }

    private static int[][] generateLatinSquare(int n) {
        int[][] latinSquare = new int[n][n];
        int startValue = n + 1;
        for (int row = 0; row < n; row++) {
            int tempValue = startValue;
            int col = 0;
            while (tempValue <= n) {
                latinSquare[row][col++] = tempValue++;
            }
            for (int value = 1; value < startValue; value++) {
                latinSquare[row][col++] = value;
            }
            startValue--;
        }
        return latinSquare;
    }
}