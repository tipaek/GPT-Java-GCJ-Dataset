import java.util.*;
import java.io.*;

public class ParentingPartner {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("parenting.in"));
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

    static boolean hasOverlap(List<Task> tasks, Task newTask) {
        List<Task> taskList = new ArrayList<>(tasks);
        taskList.add(newTask);
        taskList.sort(Comparator.comparingInt(Task::getStartTime));
        
        for (int i = 1; i < taskList.size(); i++) {
            if (taskList.get(i - 1).getEndTime() > taskList.get(i).getStartTime()) {
                return true;
            }
        }
        return false;
    }
}

class Task {
    private final int startTime;
    private final int endTime;

    Task(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    int getStartTime() {
        return startTime;
    }

    int getEndTime() {
        return endTime;
    }
}