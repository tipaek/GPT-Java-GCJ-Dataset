import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int numCases = 1; numCases <= t; numCases++) {
            int n = Integer.parseInt(br.readLine());
            int[] times = new int[2441];
            int[] assign = new int[n + 1];

            boolean valid = true;
            Map<Integer, Integer> ends = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                String[] l = br.readLine().split(" ");
                int start = Integer.parseInt(l[0]);
                int end = Integer.parseInt(l[1]);

                for (int j = start; j < end; j++) {
                    if (times[j] == -1) {
                        valid = false;
                    } else if (times[j] != 0) {
                        assign[i] = assign[times[j]] == 0 ? 1 : 0;
                        times[j] = -1;
                    } else {
                        times[j] = i;
                    }
                }

                ends.put(end, ends.getOrDefault(end, 0) + 1);
                if (ends.get(end) > 2) {
                    valid = false;
                }
            }

            if (!valid) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", numCases);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    sb.append(assign[i] == 0 ? "C" : "J");
                }
                System.out.printf("Case #%d: %s\n", numCases, sb.toString());
            }
        }

        br.close();
    }
}