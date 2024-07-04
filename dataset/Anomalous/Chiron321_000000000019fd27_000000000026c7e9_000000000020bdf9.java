import java.util.*;

public class Solution {
    static Map<String, String> taskMap;
    static String[] taskAssignments;
    static int taskIndex;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int caseNumber = 1;
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int numberOfTasks = scanner.nextInt();
            taskMap = new HashMap<>(numberOfTasks);
            taskAssignments = new String[numberOfTasks];
            scanner.nextLine();
            
            taskMap.put("J", scanner.nextLine());
            taskAssignments[0] = "J";
            taskIndex = 0;

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

    public static void assignTasks(int numberOfTasks) {
        while (++taskIndex < numberOfTasks) {
            String task = scanner.nextLine();
            boolean canAssignToC = true;
            boolean canAssignToJ = true;

            for (String assignedTask : taskMap.values()) {
                int existingStart = Integer.parseInt(assignedTask.split(" ")[0]);
                int existingEnd = Integer.parseInt(assignedTask.split(" ")[1]);
                int newStart = Integer.parseInt(task.split(" ")[0]);
                int newEnd = Integer.parseInt(task.split(" ")[1]);

                if (taskMap.get("J") != null && overlaps(existingStart, existingEnd, newStart, newEnd)) {
                    canAssignToJ = false;
                }
                if (taskMap.get("C") != null && overlaps(existingStart, existingEnd, newStart, newEnd)) {
                    canAssignToC = false;
                }
            }

            if (canAssignToC) {
                taskAssignments[taskIndex] = "C";
                taskMap.put("C" + taskIndex, task);
            } else if (canAssignToJ) {
                taskAssignments[taskIndex] = "J";
                taskMap.put("J" + taskIndex, task);
            } else {
                taskAssignments[taskIndex] = "IMPOSSIBLE";
                break;
            }
        }
    }

    private static boolean overlaps(int start1, int end1, int start2, int end2) {
        return start1 < end2 && start2 < end1;
    }
}