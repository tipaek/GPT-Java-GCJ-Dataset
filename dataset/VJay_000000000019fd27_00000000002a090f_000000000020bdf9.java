import java.io.*;
import java.util.*;

public class Solution {
    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";


    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int totalTestCount = in.nextInt();

        for (int i = 1; i <= totalTestCount; i++) {
            in.nextLine();
            int taskCount = in.nextInt();
            List<Task> tasks = getTasks(taskCount, in);
            ppr(i, tasks);
        }
    }

    private static List<Task> getTasks(int taskCount, Scanner in) {
        List<Task> tasks = new ArrayList<>();
        for (int r = 0; r < taskCount; r++) {
            Task task = new Task();
            in.nextLine();
            task.setStart(in.nextInt());
            task.setEnd(in.nextInt());
            task.setTaskId(r);
            tasks.add(task);
        }
        return tasks;
    }

    private static void ppr(int testNumber, List<Task> taskList) {
        StringBuffer sequence = new StringBuffer();
        taskList.sort(Comparator.comparing(Task::getStart));
        int cameronFreeAt = 0;
        int jamieFreeAt = 0;
        for (Task task : taskList) {
            int start = task.getStart();
            int end = task.getEnd();

            if (cameronFreeAt <= start) {
                task.setPerson(CAMERON);
                cameronFreeAt = Math.max(cameronFreeAt, end);
            } else if (jamieFreeAt <= start) {
                task.setPerson(JAMIE);
                jamieFreeAt = Math.max(jamieFreeAt, end);
            } else {
                print(testNumber, IMPOSSIBLE);
                return;
            }
        }

        taskList.sort(Comparator.comparing(Task::getTaskId));

        for (Task task : taskList) {
            sequence.append(task.getPerson());
        }
        print(testNumber, sequence.toString());
    }

    private static void print(int testNumber, String allocation) {
        System.out.println("Case #" + testNumber + ": " + allocation);
    }
}

class Task {
    private int start;
    private int end;
    private int taskId;
    private String person;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
