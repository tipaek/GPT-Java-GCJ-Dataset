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
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int k = 0; k < t; k++) {
            int n = scanner.nextInt();
            List<Task> taskList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                taskList.add(new Task(startTime, endTime));
            }
            String solution = findSolution(taskList, k + 1);
            System.out.println(solution);
        }
    }

    static String findSolution(List<Task> taskList, int caseNo) {
        Map<Integer, Integer> cSchedule = new HashMap<>();
        Map<Integer, Integer> jSchedule = new HashMap<>();
        String result = getTaskString(taskList, "", cSchedule, jSchedule, 0);

        if (result.isEmpty()) {
            return "Case #" + caseNo + ": IMPOSSIBLE";
        } else {
            return "Case #" + caseNo + ": " + result;
        }
    }

    private static String getTaskString(List<Task> taskList, String currentSolution, Map<Integer, Integer> cSchedule,
                                        Map<Integer, Integer> jSchedule, int index) {
        if (index >= taskList.size()) {
            return currentSolution;
        }

        Task task = taskList.get(index);
        int startTime = task.getStartTime();
        int endTime = task.getEndTime();

        if (isNonClashing(jSchedule, startTime, endTime)) {
            jSchedule.put(startTime, endTime);
            String solutionWithJ = getTaskString(taskList, currentSolution + "J", cSchedule, jSchedule, index + 1);
            if (!solutionWithJ.isEmpty()) {
                return solutionWithJ;
            }
            jSchedule.remove(startTime);
        }

        if (isNonClashing(cSchedule, startTime, endTime)) {
            cSchedule.put(startTime, endTime);
            String solutionWithC = getTaskString(taskList, currentSolution + "C", cSchedule, jSchedule, index + 1);
            if (!solutionWithC.isEmpty()) {
                return solutionWithC;
            }
            cSchedule.remove(startTime);
        }

        return "";
    }

    private static boolean isNonClashing(Map<Integer, Integer> schedule, int startTime, int endTime) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            int scheduledStart = entry.getKey();
            int scheduledEnd = entry.getValue();
            if ((scheduledStart < endTime && scheduledStart >= startTime) || 
                (scheduledEnd > startTime && scheduledEnd <= endTime) || 
                (scheduledStart <= startTime && scheduledEnd >= endTime)) {
                return false;
            }
        }
        return true;
    }
}