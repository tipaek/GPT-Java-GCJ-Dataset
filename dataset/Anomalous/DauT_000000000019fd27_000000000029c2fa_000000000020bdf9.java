import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static class Task {
        private int startTime;
        private int endTime;

        public Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int k = 0; k < t; k++) {
            int n = in.nextInt();
            List<Task> taskList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                taskList.add(new Task(startTime, endTime));
            }
            String solution = findSolution(taskList, k + 1);
            System.out.println(solution);
        }
    }

    static String findSolution(List<Task> taskList, int caseNo) {
        StringBuilder solution = new StringBuilder();
        TreeMap<Integer, Integer> cSchedule = new TreeMap<>();
        TreeMap<Integer, Integer> jSchedule = new TreeMap<>();

        for (Task task : taskList) {
            int startTime = task.getStartTime();
            int endTime = task.getEndTime();

            if (canSchedule(cSchedule, startTime, endTime)) {
                cSchedule.put(startTime, endTime);
                solution.append("C");
            } else if (canSchedule(jSchedule, startTime, endTime)) {
                jSchedule.put(startTime, endTime);
                solution.append("J");
            } else {
                return "Case #" + caseNo + ": IMPOSSIBLE";
            }
        }

        return "Case #" + caseNo + ": " + solution.toString();
    }

    static boolean canSchedule(TreeMap<Integer, Integer> schedule, int startTime, int endTime) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            if (entry.getKey() < endTime && entry.getValue() > startTime) {
                return false;
            }
        }
        return true;
    }
}