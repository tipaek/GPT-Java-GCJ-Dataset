import java.util.Scanner;

class Solution {
    static int[][] generateLatinSquare(int n, int d) {
        int[][] latinSquare = new int[n][n];
        int k = n + 1;

        for (int i = 0; i < n; i++) {
            int temp = k;
            int r = 0;

            // Fill the first part of the row
            while (temp <= n) {
                latinSquare[i][r] = (temp == 1) ? d : ((temp == d) ? 1 : temp);
                temp++;
                r++;
            }

            // Fill the remaining part of the row
            for (int j = r; j < n; j++) {
                int x = j + 1 - i;
                latinSquare[i][j] = (x == 1) ? d : ((x == d) ? 1 : x);
            }

            k--;
        }

        return latinSquare;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 44;
        int caseNumber = 0;

        while (caseNumber < t) {
            boolean isPossible = false;
            int n = sc.nextInt();
            int trace = sc.nextInt();

            for (int d = 1; d <= n; d++) {
                if (n * d == trace) {
                    isPossible = true;
                    System.out.println("Case #" + (caseNumber + 1) + ": POSSIBLE");
                    int[][] latinSquare = generateLatinSquare(n, d);

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.print(latinSquare[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + (caseNumber + 1) + ": IMPOSSIBLE");
            }

            caseNumber++;
        }

        sc.close();
    }
}