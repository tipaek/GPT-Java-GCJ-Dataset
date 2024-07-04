import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] inputs = new String[n];
            for (int j = 0; j < n; j++) {
                inputs[j] = scanner.nextLine();
            }
            String message = new Solution().assignTasks(inputs);
            if (message.contains("IMPOSSIBLE")) {
                message = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + message);
        }
    }
    
    private String assignTasks(String[] inputs) {
        List<int[]> cTasks = new ArrayList<>();
        List<int[]> jTasks = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        
        for (String input : inputs) {
            String[] times = input.split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);
            int[] task = {start, end};
            
            if (canAssignTask(cTasks, task)) {
                cTasks.add(task);
                result.append("C");
            } else if (canAssignTask(jTasks, task)) {
                jTasks.add(task);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }
    
    private boolean canAssignTask(List<int[]> taskList, int[] newTask) {
        for (int[] task : taskList) {
            if (tasksOverlap(task, newTask)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean tasksOverlap(int[] task1, int[] task2) {
        return !(task1[1] <= task2[0] || task2[1] <= task1[0]);
    }
}