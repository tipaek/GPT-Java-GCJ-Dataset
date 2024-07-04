import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int T = sc.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            int n = sc.nextInt();
            sc.nextLine();

            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] parts = sc.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(parts[0]);
                intervals[i][1] = Integer.parseInt(parts[1]);
            }

            Map<int[], Integer> indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indexMap.put(intervals[i], i);
            }

            Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });

            List<int[]> cList = new ArrayList<>();
            List<int[]> jList = new ArrayList<>();
            StringBuilder result = new StringBuilder(" ".repeat(n));

            cList.add(intervals[0]);
            result.setCharAt(indexMap.get(intervals[0]), 'C');
            boolean possible = true;

            int lastC = intervals[0][1], lastJ = 0;
            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= lastC) {
                    cList.add(intervals[i]);
                    result.setCharAt(indexMap.get(intervals[i]), 'C');
                    lastC = intervals[i][1];
                } else if (jList.isEmpty() || intervals[i][0] >= lastJ) {
                    jList.add(intervals[i]);
                    result.setCharAt(indexMap.get(intervals[i]), 'J');
                    lastJ = intervals[i][1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                out.println("Case #" + tt + ": IMPOSSIBLE");
            } else {
                out.println("Case #" + tt + ": " + result.toString());
            }
        }

        out.flush();
        sc.close();
    }
}