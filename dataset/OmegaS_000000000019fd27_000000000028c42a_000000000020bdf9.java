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

            for (short taskCount = 0; taskCount < numberOfTasks; taskCount++) {
                taskList.add(new Solution.Task(in.nextShort(), in.nextShort(), taskCount));
            }

            taskList.sort(Comparator.comparing(Solution.Task::getStartTime));


            for (Solution.Task task : taskList) {
                if (task.getStartTime() >= cameronBusyTill) {
                    taskAssignment[task.getTaskNumber()] = 'C';
                    cameronBusyTill = task.getEndTime();
                } else if (task.getStartTime() >= jamieBusyTill) {
                    taskAssignment[task.getTaskNumber()] = 'J';
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
        private short taskNumber;

        public Task(short startTimeParam, short endTimeParam, short taskNumberParam) {
            this.startTime = startTimeParam;
            this.endTime = endTimeParam;
            this.taskNumber = taskNumberParam;
        }

        public short getStartTime() {
            return startTime;
        }

        public short getEndTime() {
            return endTime;
        }

        public short getTaskNumber() {
            return taskNumber;
        }
    }
}
