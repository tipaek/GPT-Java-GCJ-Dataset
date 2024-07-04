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

            for (int taskIndex = 0; taskIndex < numberOfTasks; taskIndex++) {
                String[] taskTimes = br.readLine().split(" ");
                int taskStart = Integer.parseInt(taskTimes[0]);
                int taskEnd = Integer.parseInt(taskTimes[1]);
                boolean assigned = false;

                if (cameronStartTimes.isEmpty()) {
                    schedule.append("C");
                    cameronStartTimes.add(taskStart);
                    cameronEndTimes.add(taskEnd);
                    assigned = true;
                } else {
                    boolean canAssignToCameron = true;
                    for (int i = 0; i < cameronStartTimes.size(); i++) {
                        if (!(taskStart >= cameronEndTimes.get(i) || taskEnd <= cameronStartTimes.get(i))) {
                            canAssignToCameron = false;
                            break;
                        }
                    }
                    if (canAssignToCameron) {
                        schedule.append("C");
                        cameronStartTimes.add(taskStart);
                        cameronEndTimes.add(taskEnd);
                        assigned = true;
                    }
                }

                if (!assigned) {
                    if (jamieStartTimes.isEmpty()) {
                        schedule.append("J");
                        jamieStartTimes.add(taskStart);
                        jamieEndTimes.add(taskEnd);
                        assigned = true;
                    } else {
                        boolean canAssignToJamie = true;
                        for (int i = 0; i < jamieStartTimes.size(); i++) {
                            if (!(taskStart >= jamieEndTimes.get(i) || taskEnd <= jamieStartTimes.get(i))) {
                                canAssignToJamie = false;
                                break;
                            }
                        }
                        if (canAssignToJamie) {
                            schedule.append("J");
                            jamieStartTimes.add(taskStart);
                            jamieEndTimes.add(taskEnd);
                            assigned = true;
                        }
                    }
                }

                if (!assigned) {
                    for (int i = taskIndex + 1; i < numberOfTasks; i++) {
                        br.readLine();
                    }
                    break;
                }
            }

            System.out.print("Case #" + caseIndex + ": ");
            if (schedule.length() < numberOfTasks) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(schedule);
            }
        }
    }
}