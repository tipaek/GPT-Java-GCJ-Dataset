import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int f = 0;
        while (f++ < t) {
            int n = scan.nextInt();
            int k = scan.nextInt();

            int[][] ar = new int[n][n];
            
            boolean b = fillUpMatrix(ar, n, k);
            if (b) {
                System.out.println("Case #" + f + ": POSSIBLE");
                for (int i = 0; i < ar.length; i++) {
                    for (int j = 0; j < ar.length; j++) {
                        System.out.print(ar[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + f + ": IMPOSSIBLE");
            }


        }
    }

    private static boolean fillUpMatrix(int[][] ar, int n, int kk) {
        int r = -1;
        int c = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ar[i][j] == 0) {
                    isEmpty = false;
                    r = i;
                    c = j;
                }
            }
        }

        if (isEmpty) {
            long sum = 0;
            for (int i = 0; i < ar.length; i++) {
                sum+=ar[i][i];
            }
            return sum == kk;
        }
        for (int k = 1; k <= n; k++) {
            if (isSafe(ar, r, c, k, kk)) {
                ar[r][c] = k;
                if (fillUpMatrix(ar, n, kk)) {
                    return true;
                }
                ar[r][c] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] ar, int r, int c, int i, int k) {
        for (int j = 0; j < ar.length; j++) {
            if (j == r) {
                continue;
            }
            if (ar[j][c] == i) {
                return false;
            }
        }

        for (int j = 0; j < ar.length; j++) {
            if (j == c) continue;
            if (ar[r][j] == i) return false;
        }

        long sum = 0;
        for (int j = 0; j < ar.length; j++) {
            if(ar[j][j] == 0) return true;
            sum+=ar[j][j];
        }
        if(sum != k) return false;
        return true;
    }
}
