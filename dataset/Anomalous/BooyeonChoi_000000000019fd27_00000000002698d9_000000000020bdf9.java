import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numTests = Integer.parseInt(reader.readLine());
            TreeSet<Integer> jSchedule = new TreeSet<>();
            TreeSet<Integer> cSchedule = new TreeSet<>();
            boolean isPossible = true;
            StringBuilder result = new StringBuilder();

            for (int testNum = 0; testNum < numTests; testNum++) {
                String[] times = reader.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                boolean canAssignToJ = canAssign(jSchedule, start, end);
                boolean canAssignToC = canAssign(cSchedule, start, end);

                if (canAssignToJ) {
                    assign(jSchedule, start, end);
                    result.append("J");
                } else if (canAssignToC) {
                    assign(cSchedule, start, end);
                    result.append("C");
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.printf("Case #%d: %s\n", caseNum, result.toString());
        }

        reader.close();
    }

    private static boolean canAssign(TreeSet<Integer> schedule, int start, int end) {
        Integer low = schedule.floor(start);
        Integer high = schedule.ceiling(start);
        return (low == null || low < start) && (high == null || high >= end);
    }

    private static void assign(TreeSet<Integer> schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule.add(i);
        }
    }
}