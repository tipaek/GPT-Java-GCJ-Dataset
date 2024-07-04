import java.util.Scanner;

class Solution {
    static int[][] generateLatinSquare(int n, int d) {
        int[][] latinSquare = new int[n][n];
        int k = n + 1;

        for (int i = 0; i < n; i++) {
            int temp = k;
            int r = 0;

            for (; temp <= n; r++) {
                if (temp == 1) {
                    latinSquare[i][r] = d;
                } else if (temp == d) {
                    latinSquare[i][r] = 1;
                } else {
                    latinSquare[i][r] = temp;
                }
                temp++;
            }

            for (int j = r; j < n; j++) {
                int x = j + 1 - i;

                if (x == 1) {
                    latinSquare[i][j] = d;
                } else if (x == d) {
                    latinSquare[i][j] = 1;
                } else {
                    latinSquare[i][j] = j + 1 - i;
                }
            }
            k--;
        }

        return latinSquare;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 44;

        for (int p = 0; p < t; p++) {
            boolean possible = false;
            int n = sc.nextInt();
            int trace = sc.nextInt();

            for (int d = 1; d <= n; d++) {
                if (n * d == trace) {
                    possible = true;
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

            if (!possible) {
                System.out.println("Case #" + (p + 1) + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }
}