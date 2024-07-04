import java.util.*;

public class Solution {
    private static Map<String, String> taskMap;
    private static String[] taskAssignments;
    private static int taskIndex;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int caseNumber = 1;
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            taskIndex = 0;
            int numberOfTasks = scanner.nextInt();
            taskMap = new HashMap<>(numberOfTasks);
            taskAssignments = new String[numberOfTasks];
            scanner.nextLine(); // Consume the newline character

            taskMap.put("J", scanner.nextLine());
            taskAssignments[0] = "J";

            assignTasks(numberOfTasks);

            System.out.print("Case #" + caseNumber + ": ");
            if (Arrays.asList(taskAssignments).contains("IMPOSSIBLE")) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (String assignment : taskAssignments) {
                    System.out.print(assignment);
                }
            }
            System.out.println();
            caseNumber++;
        }
        scanner.close();
    }

    private static void assignTasks(int numberOfTasks) {
        while (++taskIndex < numberOfTasks) {
            String currentTask = scanner.nextLine();
            int[] currentTaskTimes = Arrays.stream(currentTask.split(" "))
                                           .mapToInt(Integer::parseInt)
                                           .toArray();

            boolean canAssignToC = true;
            boolean canAssignToJ = true;

            for (Map.Entry<String, String> entry : taskMap.entrySet()) {
                int[] existingTaskTimes = Arrays.stream(entry.getValue().split(" "))
                                                .mapToInt(Integer::parseInt)
                                                .toArray();

                if (entry.getKey().startsWith("J")) {
                    if (!(currentTaskTimes[1] <= existingTaskTimes[0] || currentTaskTimes[0] >= existingTaskTimes[1])) {
                        canAssignToJ = false;
                    }
                } else if (entry.getKey().startsWith("C")) {
                    if (!(currentTaskTimes[1] <= existingTaskTimes[0] || currentTaskTimes[0] >= existingTaskTimes[1])) {
                        canAssignToC = false;
                    }
                }
            }

            if (canAssignToC) {
                taskAssignments[taskIndex] = "C";
                taskMap.put("C" + taskIndex, currentTask);
            } else if (canAssignToJ) {
                taskAssignments[taskIndex] = "J";
                taskMap.put("J" + taskIndex, currentTask);
            } else {
                taskAssignments[taskIndex] = "IMPOSSIBLE";
            }
        }
    }
}