import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int taskCount = Integer.parseInt(reader.readLine());

            ArrayList<Integer> cameronStartTimes = new ArrayList<>();
            ArrayList<Integer> jamieStartTimes = new ArrayList<>();
            ArrayList<Integer> cameronEndTimes = new ArrayList<>();
            ArrayList<Integer> jamieEndTimes = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            boolean isPossible = true;

            for (int taskIndex = 0; taskIndex < taskCount; taskIndex++) {
                String[] task = reader.readLine().split(" ");
                int startTime = Integer.parseInt(task[0]);
                int endTime = Integer.parseInt(task[1]);

                boolean assigned = false;

                if (canAssignTask(cameronStartTimes, cameronEndTimes, startTime, endTime)) {
                    schedule.append("C");
                    cameronStartTimes.add(startTime);
                    cameronEndTimes.add(endTime);
                    assigned = true;
                } else if (canAssignTask(jamieStartTimes, jamieEndTimes, startTime, endTime)) {
                    schedule.append("J");
                    jamieStartTimes.add(startTime);
                    jamieEndTimes.add(endTime);
                    assigned = true;
                }

                if (!assigned) {
                    isPossible = false;
                    for (int skip = taskIndex + 1; skip < taskCount; skip++) {
                        reader.readLine();
                    }
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + caseNumber + ": " + schedule);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean canAssignTask(ArrayList<Integer> startTimes, ArrayList<Integer> endTimes, int startTime, int endTime) {
        for (int i = 0; i < startTimes.size(); i++) {
            if (!(startTime >= endTimes.get(i) || endTime <= startTimes.get(i))) {
                return false;
            }
        }
        return true;
    }
}