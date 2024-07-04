import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 0; caseNum < numCases; caseNum++) {
            int numTasks = Integer.parseInt(reader.readLine());
            Set<Integer> jSet = new HashSet<>();
            Set<Integer> cSet = new HashSet<>();
            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder();

            for (int taskNum = 0; taskNum < numTasks; taskNum++) {
                String[] timeRange = reader.readLine().split(" ");
                int start = Integer.parseInt(timeRange[0]);
                int end = Integer.parseInt(timeRange[1]);

                boolean canAssignToJ = isTimeSlotAvailable(jSet, start, end);
                boolean canAssignToC = !canAssignToJ && isTimeSlotAvailable(cSet, start, end);

                if (canAssignToJ) {
                    assignTimeSlot(jSet, start, end);
                    schedule.append("J");
                } else if (canAssignToC) {
                    assignTimeSlot(cSet, start, end);
                    schedule.append("C");
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.println(isPossible ? schedule.toString() : "IMPOSSIBLE");
        }

        reader.close();
    }

    private static boolean isTimeSlotAvailable(Set<Integer> set, int start, int end) {
        for (int time = start; time < end; time++) {
            if (set.contains(time)) {
                return false;
            }
        }
        return true;
    }

    private static void assignTimeSlot(Set<Integer> set, int start, int end) {
        for (int time = start; time < end; time++) {
            set.add(time);
        }
    }
}