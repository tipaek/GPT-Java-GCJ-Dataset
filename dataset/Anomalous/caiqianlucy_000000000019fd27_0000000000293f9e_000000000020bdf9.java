import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<int[]> cTasks = new ArrayList<>();
            List<int[]> jTasks = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split("\\s+");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                int[] task = {start, end};
                
                if (canInsert(cTasks, task)) {
                    result.append('C');
                } else if (canInsert(jTasks, task)) {
                    result.append('J');
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + t + ": " + result);
        }
    }
    
    private static boolean canInsert(List<int[]> schedule, int[] task) {
        int start = task[0];
        int end = task[1];
        
        for (int i = 0; i < schedule.size(); i++) {
            int[] current = schedule.get(i);
            
            if (start < current[0]) {
                if (end <= current[0]) {
                    schedule.add(i, task);
                    return true;
                } else {
                    return false;
                }
            } else if (start < current[1]) {
                return false;
            }
        }
        
        if (!schedule.isEmpty()) {
            int[] lastTask = schedule.get(schedule.size() - 1);
            if (lastTask[1] <= start) {
                schedule.add(task);
                return true;
            }
        } else {
            schedule.add(task);
            return true;
        }
        
        return false;
    }
}