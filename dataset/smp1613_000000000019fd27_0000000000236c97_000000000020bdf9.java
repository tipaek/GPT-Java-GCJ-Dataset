import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {

            int n = sc.nextInt();

            int[] start = new int[n + 1];
            int[] end = new int[n + 1];
            int bj = 0;
            int bc = 0;
            for (int j = 1; j <= n; j++) {
                start[j] = sc.nextInt();
                end[j] = sc.nextInt();
            }
            int flag = 0;
            for (int m = 1; m < n; m++) {
                flag = 0;
                for (int p = 1; p <= n - m - 1; p++) {
                    if (start[p] > start[p + 1]) {
                        flag = 1;
                        int temp = start[p];
                        start[p] = start[p + 1];
                        start[p + 1] = temp;

                        temp = end[p];
                        end[p] = end[p + 1];
                        end[p + 1] = temp;

                    }
                }
                if (flag == 0) {
                    break;
                }
            }
            int k;
            String ans = "";
            for (k = 1; k <= n; k++) {

                if (bj <= start[k]) {
                    bj = end[k];
                    ans += "J";
                } else if (bc <= start[k]) {
                    bc = end[k];
                    ans += "C";
                } else {
                    ans = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + ans);

        }
    }
}