import java.util.*;

public class Solution {
    static Map<String, String> taskAssignments;
    static String[] taskDivision;
    static int taskIndex;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int caseNumber = 1;
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            taskIndex = 0;
            int numberOfTasks = scanner.nextInt();
            taskAssignments = new HashMap<>(numberOfTasks);
            taskDivision = new String[numberOfTasks];
            scanner.nextLine();
            taskAssignments.put("J", scanner.nextLine());
            taskDivision[0] = "J";

            assignTasks(numberOfTasks);

            System.out.print("Case #" + caseNumber + ": ");
            if (Arrays.asList(taskDivision).contains("IMPOSSIBLE")) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (String task : taskDivision) {
                    System.out.print(task);
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
            int taskStart = Integer.parseInt(task.split(" ")[0]);
            int taskEnd = Integer.parseInt(task.split(" ")[1]);

            boolean canAssignToC = true;
            boolean canAssignToJ = true;

            for (Map.Entry<String, String> entry : taskAssignments.entrySet()) {
                String[] times = entry.getValue().split(" ");
                int assignedStart = Integer.parseInt(times[0]);
                int assignedEnd = Integer.parseInt(times[1]);

                if (entry.getKey().startsWith("J")) {
                    if (!(taskEnd <= assignedStart || taskStart >= assignedEnd)) {
                        canAssignToJ = false;
                    }
                } else if (entry.getKey().startsWith("C")) {
                    if (!(taskEnd <= assignedStart || taskStart >= assignedEnd)) {
                        canAssignToC = false;
                    }
                }
            }

            if (canAssignToC) {
                taskDivision[taskIndex] = "C";
                taskAssignments.put("C" + taskIndex, task);
            } else if (canAssignToJ) {
                taskDivision[taskIndex] = "J";
                taskAssignments.put("J" + taskIndex, task);
            } else {
                taskDivision[taskIndex] = "IMPOSSIBLE";
                break;
            }
        }
    }
}