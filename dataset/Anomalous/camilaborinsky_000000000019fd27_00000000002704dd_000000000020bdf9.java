import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];
        
        for (int i = 0; i < testCases; i++) {
            int numTasks = scanner.nextInt();
            int[][] tasks = new int[numTasks][2];
            
            for (int j = 0; j < numTasks; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
            }
            
            results[i] = assignTasks(tasks, numTasks);
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    public static String assignTasks(int[][] tasks, int numTasks) {
        StringBuilder result = new StringBuilder();
        List<int[]> cameronTasks = new ArrayList<>();
        List<int[]> jamieTasks = new ArrayList<>();
        
        for (int i = 0; i < numTasks; i++) {
            if (canAssignTask(cameronTasks, tasks[i])) {
                cameronTasks.add(tasks[i]);
                result.append("C");
            } else if (canAssignTask(jamieTasks, tasks[i])) {
                jamieTasks.add(tasks[i]);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return result.toString();
    }

    private static boolean canAssignTask(List<int[]> assignedTasks, int[] newTask) {
        for (int[] task : assignedTasks) {
            if (!(newTask[0] >= task[1] || newTask[1] <= task[0])) {
                return false;
            }
        }
        return true;
    }
}