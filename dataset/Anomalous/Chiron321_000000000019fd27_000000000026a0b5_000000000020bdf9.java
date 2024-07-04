import java.util.*;

public class Solution {
    static Map<String, String> taskMap;
    static String[] taskAssignments;
    static int currentIndex;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int caseNumber = 1;
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            currentIndex = 0;
            int numberOfTasks = scanner.nextInt();
            taskMap = new HashMap<>(numberOfTasks);
            taskAssignments = new String[numberOfTasks];
            scanner.nextLine();
            taskMap.put("J", scanner.nextLine());
            taskAssignments[0] = "J";

            assignTasks(numberOfTasks);

            System.out.print("Case #" + caseNumber + ": ");
            for (String assignment : taskAssignments) {
                if (Arrays.asList(taskAssignments).contains("IMPOSSIBLE")) {
                    System.out.print("IMPOSSIBLE");
                    break;
                }
                System.out.print(assignment);
            }
            System.out.println();
            caseNumber++;
        }
        scanner.close();
    }

    public static void assignTasks(int numberOfTasks) {
        while (++currentIndex < numberOfTasks) {
            String task = scanner.nextLine();
            boolean isAssigned = false;

            for (String key : taskMap.keySet()) {
                String[] existingTask = taskMap.get(key).split(" ");
                int existingStart = Integer.parseInt(existingTask[0]);
                int existingEnd = Integer.parseInt(existingTask[1]);
                String[] newTask = task.split(" ");
                int newStart = Integer.parseInt(newTask[0]);
                int newEnd = Integer.parseInt(newTask[1]);

                if (key.startsWith("J") && (newEnd <= existingStart || newStart >= existingEnd)) {
                    taskAssignments[currentIndex] = "J";
                    taskMap.put("J" + currentIndex, task);
                    isAssigned = true;
                    break;
                } else if (key.startsWith("C") && (newEnd <= existingStart || newStart >= existingEnd)) {
                    taskAssignments[currentIndex] = "C";
                    taskMap.put("C" + currentIndex, task);
                    isAssigned = true;
                    break;
                }
            }

            if (!isAssigned) {
                taskAssignments[currentIndex] = "IMPOSSIBLE";
                break;
            }
        }
    }
}