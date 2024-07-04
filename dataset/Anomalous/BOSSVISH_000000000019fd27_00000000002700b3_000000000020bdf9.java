import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    int start;
    int end;
}

class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return Integer.compare(t1.start, t2.start);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            Task[] tasks = new Task[n];
            
            for (int j = 0; j < n; j++) {
                Task task = new Task();
                task.start = scanner.nextInt();
                task.end = scanner.nextInt();
                tasks[j] = task;
            }
            
            Arrays.sort(tasks, new TaskComparator());
            int endC = -1;
            int endJ = -1;
            StringBuilder answer = new StringBuilder();
            
            for (Task task : tasks) {
                if (endC != -1 && endC <= task.start) {
                    endC = -1;
                }
                if (endJ != -1 && endJ <= task.start) {
                    endJ = -1;
                }
                
                if (endC == -1) {
                    endC = task.end;
                    answer.append("C");
                } else if (endJ == -1) {
                    endJ = task.end;
                    answer.append("J");
                } else {
                    answer = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + answer);
        }
        
        scanner.close();
    }
}