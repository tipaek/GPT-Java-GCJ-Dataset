import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("02.in"));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] angles = new long[n];
            for (int j = 0; j < n; j++) {
                angles[j] = in.nextLong();
            }
            int res = solve(n, d, angles);

            System.out.println("Case #" + caseNum + ": " + res);
        }
    }

    private static int solve(int n, int d, long[] angles) {
        Arrays.sort(angles);
        Map<Long, Integer> set = new HashMap<>();
        int res = 2;
        for (int i = 0; i < n; i++) {
            if (d == 2) {
                if (set.containsKey(angles[i])) return 0;
                int f = set.getOrDefault(angles[i], 0);
                set.put(angles[i], f + 1);
            } else if (d == 3) {
                int f = set.getOrDefault(angles[i], 0);
                if (f == 2) return 0;
                if (f == 1) res = Math.min(res, 1);
                set.put(angles[i], f + 1);
                if(set.containsKey(angles[i] / 2)) res = Math.min(res, 1);
            }
        }
        if(d == 2) return 1;
        return res;
    }
}
