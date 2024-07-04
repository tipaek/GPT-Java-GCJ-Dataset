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
        while (++currentIndex < numberOfTasks) {
            String task = scanner.nextLine();
            int taskStart = Integer.parseInt(task.split(" ")[0]);
            int taskEnd = Integer.parseInt(task.split(" ")[1]);

            boolean canAssignToC = true;
            boolean canAssignToJ = true;

            for (Map.Entry<String, String> entry : taskMap.entrySet()) {
                String[] entryTimes = entry.getValue().split(" ");
                int entryStart = Integer.parseInt(entryTimes[0]);
                int entryEnd = Integer.parseInt(entryTimes[1]);

                if (entry.getKey().startsWith("C")) {
                    if (taskStart < entryEnd && taskEnd > entryStart) {
                        canAssignToC = false;
                    }
                } else if (entry.getKey().startsWith("J")) {
                    if (taskStart < entryEnd && taskEnd > entryStart) {
                        canAssignToJ = false;
                    }
                }
            }

            if (canAssignToC) {
                taskAssignments[currentIndex] = "C";
                taskMap.put("C" + currentIndex, task);
            } else if (canAssignToJ) {
                taskAssignments[currentIndex] = "J";
                taskMap.put("J" + currentIndex, task);
            } else {
                taskAssignments[currentIndex] = "IMPOSSIBLE";
                break;
            }
        }
    }
}