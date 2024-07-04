import java.util.*;
import java.io.*;

public class ParentingPartner {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int i = 1; i <= testCaseCount; i++) {
            int taskCount = scanner.nextInt();
            List<Task> cTasks = new ArrayList<>();
            List<Task> jTasks = new ArrayList<>();
            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < taskCount; j++) {
                Task newTask = new Task(scanner.nextInt(), scanner.nextInt());
                
                if (hasOverlap(cTasks, newTask)) {
                    if (hasOverlap(jTasks, newTask)) {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
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
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
    }

    private static boolean hasOverlap(List<Task> taskList, Task newTask) {
        List<Task> tempList = new ArrayList<>(taskList);
        tempList.add(newTask);
        tempList.sort(new TaskComparator());
        
        for (int i = 1; i < tempList.size(); i++) {
            if (tempList.get(i - 1).getEnd() > tempList.get(i).getStart()) {
                return true;
            }
        }
        return false;
    }
}

class Task {
    private final int start;
    private final int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        return Integer.compare(task1.getStart(), task2.getStart());
    }
}