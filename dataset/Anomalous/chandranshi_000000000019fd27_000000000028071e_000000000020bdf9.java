import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                String[] parts = br.readLine().split(" ");
                int s = Integer.parseInt(parts[0]);
                int e = Integer.parseInt(parts[1]);
                intervals.add(new int[]{s, e, j});
            }

            intervals.sort((a, b) -> Integer.compare(a[0], b[0]));

            int[] endCameron = {0};
            int[] endJamie = {0};
            char[] result = new char[n];

            boolean possible = true;
            for (int[] interval : intervals) {
                if (interval[0] >= endCameron[0]) {
                    endCameron[0] = interval[1];
                    result[interval[2]] = 'C';
                } else if (interval[0] >= endJamie[0]) {
                    endJamie[0] = interval[1];
                    result[interval[2]] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            StringBuilder ans = new StringBuilder("Case #" + (i + 1) + ": ");
            if (possible) {
                ans.append(new String(result));
            } else {
                ans.append("IMPOSSIBLE");
            }

            System.out.println(ans);
        }
    }
}