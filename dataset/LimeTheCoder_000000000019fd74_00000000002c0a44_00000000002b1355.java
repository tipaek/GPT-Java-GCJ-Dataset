import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int c = in.nextInt();

            long[][] arr = new long[r][c];
            for (int m = 0; m < r; m++) {
                for (int n = 0; n < c; n++) {
                    arr[m][n] = in.nextInt();
                }
            }

            long interest = 0;
            do {
                interest += computeInterest(arr);
                eliminate(arr);
            } while (reset(arr));

            System.out.println(String.format("Case #%d: %d", i, interest));
        }
    }

    private static long computeInterest(long[][] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    private static void eliminate(long[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }

                long sum = 0;
                int cnt = 0;
                for (int k = j - 1; k >= 0; k--) {
                    if (arr[i][k] != 0) {
                        sum += Math.abs(arr[i][k]);
                        cnt++;
                        break;
                    }
                }

                for (int k = j + 1; k < arr[0].length; k++) {
                    if (arr[i][k] != 0) {
                        sum += Math.abs(arr[i][k]);
                        cnt++;
                        break;
                    }
                }

                for (int k = i - 1; k >= 0; k--) {
                    if (arr[k][j] != 0) {
                        sum += Math.abs(arr[k][j]);
                        cnt++;
                        break;
                    }
                }

                for (int k = i + 1; k < arr.length; k++) {
                    if (arr[k][j] != 0) {
                        sum+= Math.abs(arr[k][j]);
                        cnt++;
                        break;
                    }
                }

                if (cnt != 0 && arr[i][j] < (double) sum / cnt) {
                    arr[i][j] = -arr[i][j];
                }
            }
        }
    }

    private static boolean reset(long[][] arr) {
        boolean eliminated = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] < 0) {
                    arr[i][j] = 0;
                    eliminated = true;
                }
            }
        }
        return eliminated;
    }
}