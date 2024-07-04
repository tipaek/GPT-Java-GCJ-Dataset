import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] time = new int[n][2];
            for (int j = 0; j < n; j++) {
                time[j][0] = in.nextInt();
                time[j][1] = in.nextInt();
            }
            String ans = helper2(time);
            System.out.println("Case #" + i + ": " + ans);
        }
    }
    private static String helper2(int[][] time) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(time, Comparator.comparingInt(obj -> obj[0]));
        int c = -1;
        int j = -1;
        for (int i = 0; i < time.length; i++) {
            if (c <= time[i][0]) {
                sb.append('C');
                c = time[i][1];
            } else if (j <= time[i][0]){
                sb.append('J');
                j = time[i][1];
            } else return "IMPOSSIBLE";
        }
        return sb.toString();
    }
}