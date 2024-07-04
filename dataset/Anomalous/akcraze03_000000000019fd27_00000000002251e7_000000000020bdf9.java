import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numTasks = scanner.nextInt();
            List<Task> cameronTasks = new ArrayList<>();
            List<Task> jamieTasks = new ArrayList<>();
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();
            
            for (int taskIndex = 0; taskIndex < numTasks; taskIndex++) {
                Task newTask = new Task(scanner.nextInt(), scanner.nextInt());
                
                if (isOverlap(cameronTasks, newTask)) {
                    if (isOverlap(jamieTasks, newTask)) {
                        System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    } else {
                        jamieTasks.add(newTask);
                        schedule.append("J");
                    }
                } else {
                    cameronTasks.add(newTask);
                    schedule.append("C");
                }
            }
            
            if (!isImpossible) {
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }
        }
    }

    static boolean isOverlap(List<Task> tasks, Task newTask) {
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