import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for(int tc = 1; tc <= t; tc++) {
            int numberOfTasks = in.nextInt();

            int cameronBusyTill = 0;
            int jamieBusyTill = 0;
            char [] taskAssignment = new char[numberOfTasks];
            boolean isImpossible = false;

            List<Solution.Task> taskList = new ArrayList<>();

            for (int taskCount = 1; taskCount <= numberOfTasks; taskCount++) {
                taskList.add(new Solution.Task(in.nextShort(), in.nextShort()));
            }

            taskList.sort(Comparator.comparing(Solution.Task::getStartTime));

            int taskCount = 0;
            for (Solution.Task task : taskList) {
                if (task.getStartTime() >= cameronBusyTill) {
                    taskAssignment[taskCount++] = 'C';
                    cameronBusyTill = task.getEndTime();
                } else if (task.getStartTime() >= jamieBusyTill) {
                    taskAssignment[taskCount++] = 'J';
                    jamieBusyTill = task.getEndTime();
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String output = isImpossible ? "IMPOSSIBLE" : new String(taskAssignment);
            System.out.println("Case #" + tc + ": " + output);

        }
    }

    static class Task {
        private short startTime;
        private short endTime;

        public Task(short startTimeParam, short endTimeParam) {
            this.startTime = startTimeParam;
            this.endTime = endTimeParam;
        }

        public short getStartTime() {
            return startTime;
        }

        public short getEndTime() {
            return endTime;
        }
    }
}
