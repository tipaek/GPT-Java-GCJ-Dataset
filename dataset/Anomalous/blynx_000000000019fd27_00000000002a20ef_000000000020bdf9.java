import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numTasks = scanner.nextInt();
            List<Task> taskList = readTasks(scanner, numTasks);
            
            taskList.sort((task1, task2) -> {
                if (task1.start != task2.start) {
                    return Integer.compare(task1.start, task2.start);
                } else if (task1.end != task2.end) {
                    return Integer.compare(task1.end, task2.end);
                } else {
                    return Integer.compare(task1.index, task2.index);
                }
            });
            
            int cameronEnd = -1;
            int jamieEnd = -1;
            boolean isImpossible = false;
            
            for (Task task : taskList) {
                if (cameronEnd <= task.start) {
                    task.assignedTo = 'C';
                    cameronEnd = task.end;
                } else if (jamieEnd <= task.start) {
                    task.assignedTo = 'J';
                    jamieEnd = task.end;
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                printResult(caseNum, "IMPOSSIBLE");
            } else {
                taskList.sort((task1, task2) -> Integer.compare(task1.index, task2.index));
                StringBuilder result = new StringBuilder(numTasks);
                for (Task task : taskList) {
                    result.append(task.assignedTo);
                }
                printResult(caseNum, result.toString());
            }
        }
        
        scanner.close();
    }
    
    private static List<Task> readTasks(Scanner scanner, int numTasks) {
        List<Task> tasks = new ArrayList<>(numTasks);
        for (int i = 0; i < numTasks; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            tasks.add(new Task(start, end, i));
        }
        return tasks;
    }
    
    private static void printResult(int caseNum, String result) {
        System.out.println("Case #" + caseNum + ": " + result);
    }
    
    private static class Task {
        int start;
        int end;
        int index;
        char assignedTo;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}