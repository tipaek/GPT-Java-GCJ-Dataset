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
            taskIndex = 0;
            int numberOfTasks = scanner.nextInt();
            taskMap = new HashMap<>(numberOfTasks);
            taskAssignments = new String[numberOfTasks];
            scanner.nextLine(); // Consume newline
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

    public static void assignTasks(int numberOfTasks) {
        while (++taskIndex < numberOfTasks) {
            String task = scanner.nextLine();
            int[] taskTime = parseTaskTime(task);

            boolean canAssignToC = true;
            boolean canAssignToJ = true;

            for (Map.Entry<String, String> entry : taskMap.entrySet()) {
                int[] entryTime = parseTaskTime(entry.getValue());

                if (entry.getKey().startsWith("J")) {
                    if (isOverlap(taskTime, entryTime)) {
                        canAssignToJ = false;
                    }
                } else if (entry.getKey().startsWith("C")) {
                    if (isOverlap(taskTime, entryTime)) {
                        canAssignToC = false;
                    }
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

    private static int[] parseTaskTime(String task) {
        String[] parts = task.split(" ");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }

    private static boolean isOverlap(int[] task1, int[] task2) {
        return task1[0] < task2[1] && task1[1] > task2[0];
    }
}