import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(br.readLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numberOfTasks = Integer.parseInt(br.readLine());

            ArrayList<Integer> cameronStartTimes = new ArrayList<>();
            ArrayList<Integer> jamieStartTimes = new ArrayList<>();
            ArrayList<Integer> cameronEndTimes = new ArrayList<>();
            ArrayList<Integer> jamieEndTimes = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();

            boolean isPossible = true;

            for (int taskIndex = 0; taskIndex < numberOfTasks; taskIndex++) {
                String[] task = br.readLine().split(" ");
                int taskStart = Integer.parseInt(task[0]);
                int taskEnd = Integer.parseInt(task[1]);

                boolean assigned = false;

                if (cameronStartTimes.isEmpty() || canAssignTask(cameronStartTimes, cameronEndTimes, taskStart, taskEnd)) {
                    schedule.append("C");
                    cameronStartTimes.add(taskStart);
                    cameronEndTimes.add(taskEnd);
                    assigned = true;
                } else if (jamieStartTimes.isEmpty() || canAssignTask(jamieStartTimes, jamieEndTimes, taskStart, taskEnd)) {
                    schedule.append("J");
                    jamieStartTimes.add(taskStart);
                    jamieEndTimes.add(taskEnd);
                    assigned = true;
                }

                if (!assigned) {
                    isPossible = false;
                    for (int remainingTasks = taskIndex + 1; remainingTasks < numberOfTasks; remainingTasks++) {
                        br.readLine();
                    }
                    break;
                }
            }

            System.out.print("Case #" + caseIndex + ": ");
            if (isPossible) {
                System.out.println(schedule.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static boolean canAssignTask(ArrayList<Integer> startTimes, ArrayList<Integer> endTimes, int taskStart, int taskEnd) {
        for (int i = 0; i < startTimes.size(); i++) {
            if (!(taskStart >= endTimes.get(i) || taskEnd <= startTimes.get(i))) {
                return false;
            }
        }
        return true;
    }
}