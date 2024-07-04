import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = s.nextInt();

            int[][][] time = new int[n][2][2];

            for (int j = 0; j < n; j++) {
                time[j][0][0] = s.nextInt();
                time[j][1][0] = s.nextInt();
                time[j][1][1] = j;
            }
            Arrays.sort(time, Comparator.comparingDouble(a -> a[0][0]));
           /* for (int[] ints : time) {
                System.out.println(Arrays.toString(ints));
            }*/

            String solve = solve(time);
            System.out.println("Case #" + i + ": " + solve);
        }

    }


    private static String solve(int[][][] time) {
        String[] sb = new String[time.length];
        int[] js = {-1, -1};
        int[] cs = {-1, -1};
        for (int i = 0; i < time.length; i++) {
            int s = time[i][0][0];
            int e = time[i][1][0];
            int pos = time[i][1][1];
            if (!isBusy(cs, s, e)) {
                sb[pos] = "C";
                cs[0] = s;
                cs[1] = e;
            } else if (!isBusy(js, s, e)) {
                sb[pos] = "J";
                js[0] = s;
                js[1] = e;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String aSb : sb) stringBuilder.append(aSb);

        return stringBuilder.toString();
    }

    static boolean isCharFree(int[] pe) {
        return pe[0] == -1 && pe[1] == -1;
    }

    static boolean isBusy(int[] p, int s, int e) {
        if (p[0] == -1 && p[1] == -1) return false;
        return s < p[1];
    }

}
