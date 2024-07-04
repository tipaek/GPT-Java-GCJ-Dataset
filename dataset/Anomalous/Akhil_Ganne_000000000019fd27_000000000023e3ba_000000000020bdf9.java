import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            writer.write("Case #" + caseNum + ": ");
            int n = Integer.parseInt(reader.readLine());
            int[] cSchedule = new int[24 * 60 + 1];
            int[] jSchedule = new int[24 * 60 + 1];
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int k = 0; k < n; k++) {
                String[] times = reader.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                boolean assignedToC = canAssign(cSchedule, start, end);

                if (assignedToC) {
                    result.append("C");
                    markSchedule(cSchedule, start, end);
                } else {
                    boolean assignedToJ = canAssign(jSchedule, start, end);
                    if (assignedToJ) {
                        result.append("J");
                        markSchedule(jSchedule, start, end);
                    } else {
                        possible = false;
                    }
                }
            }
            writer.write(possible ? result.toString() + "\n" : "IMPOSSIBLE\n");
        }
        writer.flush();
    }

    private static boolean canAssign(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}