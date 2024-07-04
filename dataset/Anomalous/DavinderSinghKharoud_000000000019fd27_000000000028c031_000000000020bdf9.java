import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static String solve(int[][] activities) {
        StringBuilder result = new StringBuilder();
        Map<String, int[]> currentAssignments = new HashMap<>();

        if (activities.length == 1) {
            return "J";
        }

        List<Map<String, int[]>> assignmentHistory = new ArrayList<>();
        currentAssignments.put("J", activities[0]);
        currentAssignments.put("C", activities[1]);

        assignmentHistory.add(currentAssignments);
        result.append("JC");

        for (int i = 2; i < activities.length; i++) {
            int[] activity = activities[i];
            int[] lastJimActivity = assignmentHistory.get(assignmentHistory.size() - 1).get("J");
            int[] lastCamActivity = assignmentHistory.get(assignmentHistory.size() - 1).get("C");

            if (overlap(lastJimActivity, activity) && overlap(lastCamActivity, activity)) {
                return "IMPOSSIBLE";
            }

            if (!overlap(lastJimActivity, activity) && !overlap(lastCamActivity, activity)) {
                String actor = (lastJimActivity[1] < lastCamActivity[1]) ? "J" : "C";
                currentAssignments.put(actor, activity);
                result.append(actor);
            } else if (!overlap(lastJimActivity, activity)) {
                currentAssignments.put("J", activity);
                result.append("J");
            } else {
                currentAssignments.put("C", activity);
                result.append("C");
            }
        }

        return result.toString();
    }

    public static boolean overlap(int[] first, int[] second) {
        return !(second[1] <= first[0] || second[0] >= first[1]);
    }

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int caseNum = fastReader.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            int len = fastReader.nextInt();
            int[][] activities = new int[len][2];

            for (int i = 0; i < len; i++) {
                activities[i][0] = fastReader.nextInt();
                activities[i][1] = fastReader.nextInt();
            }

            System.out.println(String.format("Case #%d: %s", ks, solve(activities)));
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}