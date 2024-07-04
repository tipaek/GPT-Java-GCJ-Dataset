import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numTasks = scanner.nextInt();
            List<Task> cTasks = new ArrayList<>();
            List<Task> jTasks = new ArrayList<>();
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();
            
            for (int taskIndex = 0; taskIndex < numTasks; taskIndex++) {
                Task newTask = new Task(scanner.nextInt(), scanner.nextInt());
                
                if (hasOverlap(cTasks, newTask)) {
                    if (hasOverlap(jTasks, newTask)) {
                        System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    } else {
                        jTasks.add(newTask);
                        result.append("J");
                    }
                } else {
                    cTasks.add(newTask);
                    result.append("C");
                }
            }
            
            if (!isImpossible) {
                System.out.println("Case #" + caseNum + ": " + result.toString());
            }
        }
    }

    static boolean hasOverlap(List<Task> tasks, Task newTask) {
        List<Task> taskList = new ArrayList<>(tasks);
        taskList.add(newTask);
        taskList.sort(Comparator.comparingInt(Task::getStart));
        
        for (int i = 1; i < taskList.size(); i++) {
            if (taskList.get(i - 1).getEnd() > taskList.get(i).getStart()) {
                return true;
            }
        }
        
        return false;
    }
}

class Task {
    private final int start;
    private final int end;
    
    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    int getStart() {
        return start;
    }
    
    int getEnd() {
        return end;
    }
}