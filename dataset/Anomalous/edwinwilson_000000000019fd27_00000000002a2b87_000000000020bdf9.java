import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int currentCase = 1; currentCase <= numCases; currentCase++) {
            result.append("Case #").append(currentCase).append(": ");
            int nbTasks = Integer.parseInt(scanner.nextLine());
            List<int[]> tasksC = new ArrayList<>();
            List<int[]> tasksJ = new ArrayList<>();
            StringBuilder currentSolution = new StringBuilder();

            for (int i = 0; i < nbTasks; i++) {
                String[] line = scanner.nextLine().split(" ");
                int start = Integer.parseInt(line[0]);
                int end = Integer.parseInt(line[1]);

                if (tasksC.isEmpty()) {
                    tasksC.add(new int[]{start, end});
                    currentSolution.append("C");
                    continue;
                }

                if (tasksJ.isEmpty()) {
                    tasksJ.add(new int[]{start, end});
                    currentSolution.append("J");
                    continue;
                }

                boolean assigned = false;

                if (canAssignTask(tasksC, start, end)) {
                    tasksC.add(new int[]{start, end});
                    currentSolution.append("C");
                    assigned = true;
                } else if (canAssignTask(tasksJ, start, end)) {
                    tasksJ.add(new int[]{start, end});
                    currentSolution.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    currentSolution = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            result.append(currentSolution).append("\n");
        }

        System.out.print(result);
    }

    private static boolean canAssignTask(List<int[]> tasks, int start, int end) {
        for (int[] task : tasks) {
            if (start < task[1] && end > task[0]) {
                return false;
            }
        }
        return true;
    }
}