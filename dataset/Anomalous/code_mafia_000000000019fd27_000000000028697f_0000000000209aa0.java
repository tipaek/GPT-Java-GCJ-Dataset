import java.util.Scanner;

class Solution {
    static int[][] generateLatinSquare(int n, int d) {
        int[][] square = new int[n][n];
        int k = n + 1;

        for (int i = 0; i < n; i++) {
            int temp = k;
            int r;

            for (r = 0; temp <= n; r++) {
                if (temp == 1) {
                    square[i][r] = d;
                } else if (temp == d) {
                    square[i][r] = 1;
                } else {
                    square[i][r] = temp;
                }
                temp++;
            }

            for (int j = r; j < n; j++) {
                int x = j + 1 - i;

                if (x == 1) {
                    square[i][j] = d;
                } else if (x == d) {
                    square[i][j] = 1;
                } else {
                    square[i][j] = j + 1 - i;
                }
            }
            k--;
        }
        return square;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int p = 0; p < t; p++) {
            boolean isPossible = false;
            int n = sc.nextInt();
            int trace = sc.nextInt();

            for (int d = 1; d <= n; d++) {
                if (n * d == trace) {
                    isPossible = true;
                    System.out.println("Case #" + (p + 1) + ": POSSIBLE");
                    int[][] latinSquare = generateLatinSquare(n, d);

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.print(latinSquare[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + (p + 1) + ": IMPOSSIBLE");
            }
        }

        sc.close();
    }
}