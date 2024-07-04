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
            int[][] activities = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                String[] row = sc.nextLine().split(" ");
                activities[i][0] = Integer.parseInt(row[0]);
                activities[i][1] = Integer.parseInt(row[1]);
            }

            Arrays.sort(activities, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });

            List<int[]> cList = new ArrayList<>();
            List<int[]> jList = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;

            cList.add(activities[0]);
            schedule.append("C");

            for (int i = 1; i < n; i++) {
                if (activities[i][0] >= cList.get(cList.size() - 1)[1]) {
                    cList.add(activities[i]);
                    schedule.append("C");
                } else if (jList.isEmpty() || activities[i][0] >= jList.get(jList.size() - 1)[1]) {
                    jList.add(activities[i]);
                    schedule.append("J");
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                out.println("Case #" + tt + ": IMPOSSIBLE");
            } else {
                out.println("Case #" + tt + ": " + schedule.toString());
            }
        }
        out.flush();
        out.close();
    }
}