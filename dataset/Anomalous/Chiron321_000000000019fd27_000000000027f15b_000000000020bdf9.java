import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
            scanner.nextLine();  // Consume the newline character

            taskMap.put("J", scanner.nextLine());
            taskAssignments[0] = "J";

            assignTasks(numberOfTasks);

            System.out.print("Case #" + caseNumber + ": ");
            boolean isImpossible = Arrays.asList(taskAssignments).contains("IMPOSSIBLE");
            if (isImpossible) {
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
            boolean canAssignToJ = true;
            boolean canAssignToC = true;

            int taskStart = Integer.parseInt(task.split(" ")[0]);
            int taskEnd = Integer.parseInt(task.split(" ")[1]);

            for (Map.Entry<String, String> entry : taskMap.entrySet()) {
                String[] times = entry.getValue().split(" ");
                int entryStart = Integer.parseInt(times[0]);
                int entryEnd = Integer.parseInt(times[1]);

                if (entry.getKey().startsWith("J")) {
                    if (!(taskEnd <= entryStart || taskStart >= entryEnd)) {
                        canAssignToJ = false;
                    }
                } else if (entry.getKey().startsWith("C")) {
                    if (!(taskEnd <= entryStart || taskStart >= entryEnd)) {
                        canAssignToC = false;
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
            }
        }
    }
}