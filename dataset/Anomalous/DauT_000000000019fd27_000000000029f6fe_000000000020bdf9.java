import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static class Task {
        int startTime;
        int endTime;

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
        Map<Integer, Integer> cSchedule = new HashMap<>();
        Map<Integer, Integer> jSchedule = new HashMap<>();

        for (Task task : taskList) {
            int startTime = task.getStartTime();
            int endTime = task.getEndTime();
            boolean clashing = false;

            for (Map.Entry<Integer, Integer> entry : cSchedule.entrySet()) {
                if (isClashing(entry, startTime, endTime)) {
                    clashing = true;
                    break;
                }
            }

            if (!clashing) {
                cSchedule.put(startTime, endTime);
                solution.append("C");
                continue;
            }

            clashing = false;
            for (Map.Entry<Integer, Integer> entry : jSchedule.entrySet()) {
                if (isClashing(entry, startTime, endTime)) {
                    clashing = true;
                    break;
                }
            }

            if (!clashing) {
                jSchedule.put(startTime, endTime);
                solution.append("J");
            } else {
                return "Case #" + caseNo + ": IMPOSSIBLE";
            }
        }

        return "Case #" + caseNo + ": " + solution.toString();
    }

    static boolean isClashing(Map.Entry<Integer, Integer> entry, int startTime, int endTime) {
        return (entry.getKey() <= startTime && entry.getValue() > startTime) ||
               (entry.getKey() >= startTime && entry.getKey() < endTime);
    }
}