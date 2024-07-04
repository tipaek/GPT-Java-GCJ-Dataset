import java.util.*;

class Task {
    int id;
    int start;
    int end;
}

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.nextLine());
        
        for (int x = 1; x <= t; x++) {
            int n = Integer.parseInt(sc.nextLine());
            
            List<Task> taskList = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split(" ");
                Task task = new Task();
                task.id = i;
                task.start = Integer.parseInt(input[0]);
                task.end = Integer.parseInt(input[1]);
                
                taskList.add(task);
            }
            
            List<Task> cameronTasks = new ArrayList<>();
            List<Task> jamieTasks = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            
            for (Task currentTask : taskList) {
                boolean canAssignToCameron = true;
                
                for (Task task : cameronTasks) {
                    if ((currentTask.start < task.end && currentTask.end > task.start)) {
                        canAssignToCameron = false;
                        break;
                    }
                }
                
                if (canAssignToCameron) {
                    cameronTasks.add(currentTask);
                    result.append("C");
                    continue;
                }
                
                boolean canAssignToJamie = true;
                
                for (Task task : jamieTasks) {
                    if ((currentTask.start < task.end && currentTask.end > task.start)) {
                        canAssignToJamie = false;
                        break;
                    }
                }
                
                if (canAssignToJamie) {
                    jamieTasks.add(currentTask);
                    result.append("J");
                    continue;
                }
                
                isPossible = false;
                System.out.println("Case #" + x + ": IMPOSSIBLE");
                break;
            }
            
            if (isPossible) {
                System.out.println("Case #" + x + ": " + result.toString());
            }
        }
    }
}