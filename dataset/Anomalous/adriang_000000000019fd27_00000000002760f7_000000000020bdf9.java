import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numTasks = scanner.nextInt();
            scanner.nextLine();
            
            char[] schedule = new char[1440];
            Arrays.fill(schedule, ' ');
            
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < numTasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end, i));
            }
            
            tasks.sort(Comparator.comparingInt(task -> task.start));
            
            int[] assigned = new int[numTasks];
            Arrays.fill(assigned, -1);
            
            int cEnd = 0, jEnd = 0;
            for (Task task : tasks) {
                if (task.start >= cEnd) {
                    cEnd = task.end;
                    assigned[task.index] = 'C';
                } else if (task.start >= jEnd) {
                    jEnd = task.end;
                    assigned[task.index] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < numTasks; i++) {
                    result.append((char) assigned[i]);
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }

    static class Task {
        int start;
        int end;
        int index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}