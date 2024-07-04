import java.util.*;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfTests = scan.nextInt();
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int numberOfTasks = scan.nextInt();
            Integer[][] tasks = new Integer[numberOfTasks][2];
            for (int taskIndex = 0; taskIndex < numberOfTasks; taskIndex++) {
                tasks[taskIndex][0] = scan.nextInt();
                tasks[taskIndex][1] = scan.nextInt();
            }
            System.out.println("Case #" + (testIndex + 1) + ": " + allocateTasks(tasks));
        }
    }

    private static String allocateTasks(Integer[][] tasks) {
        StringBuilder allocationResult = new StringBuilder();
        Map<Integer, Integer> jSchedule = new HashMap<>();
        Map<Integer, Integer> cSchedule = new HashMap<>();
        
        for (Integer[] task : tasks) {
            int start = task[0];
            int end = task[1];
            if (isAvailable(jSchedule, start, end)) {
                allocationResult.append("J");
            } else if (isAvailable(cSchedule, start, end)) {
                allocationResult.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return allocationResult.toString();
    }

    private static boolean isAvailable(Map<Integer, Integer> schedule, int start, int end) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            int existingStart = entry.getKey();
            int existingEnd = entry.getValue();
            if (!(end <= existingStart || start >= existingEnd)) {
                return false;
            }
        }
        schedule.put(start, end);
        return true;
    }
}