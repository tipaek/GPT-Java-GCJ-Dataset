import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(in.readLine());
            List<int[]> times = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                times.add(new int[]{s, 0, i});
                times.add(new int[]{e, 1, i});
            }

            times.sort((a, b) -> {
                if (a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            });

            char[] ans = new char[n];
            boolean impossible = false;
            int c = -1, j = -1;

            for (int[] time : times) {
                if (time[1] == 0) {
                    if (c == -1) {
                        ans[time[2]] = 'C';
                        c = time[2];
                    } else if (j == -1) {
                        ans[time[2]] = 'J';
                        j = time[2];
                    } else {
                        impossible = true;
                        break;
                    }
                } else {
                    if (c == time[2]) {
                        c = -1;
                    } else {
                        j = -1;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                System.out.println(new String(ans));
            }
        }
    }
}