import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author peta
 */
public class CParenting {
    public static void main(String[] args) {
        new CParenting().run();
    }

    Scanner in;

    public void run() {
        in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();
        for (int i = 0; i < tests; i++) {
            List<Task> tasks = addTasks();
            String result = solveTestcase(tasks);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }

    }

    public String solveTestcase(List<Task> tasks) {


        Comparator<Task> compareFrom = (Task t, Task t1) -> t.from - t1.from;

        tasks.sort(compareFrom);
        int cBusy = 0;
        int jBusy = 0;
        for (Task task : tasks) {

            if (cBusy <= task.from) {
                task.owner = 'C';
                cBusy = task.to;

            } else if (jBusy <= task.from) {
                task.owner = 'J';
                jBusy = task.to;

            } else {
                return "IMPOSSIBLE";
            }
        }
        Comparator<Task> comparePosition = (Task t, Task t1) -> t.position - t1.position;

        tasks.sort(comparePosition);
        StringBuilder sb = new StringBuilder();
        for (Task task : tasks) {
            sb.append(task.owner);
        }
        return sb.toString();

    }

    private List<Task> addTasks() {
        int tasksNum = in.nextInt();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < tasksNum; i++) {
            tasks.add(new Task(i, in.nextInt(), in.nextInt()));
        }
        return tasks;
    }

    private class Task {

        public int position;
        public int from;
        public int to;
        public char owner;

        public Task(int position, int from, int to) {
            this.position = position;
            this.from = from;
            this.to = to;
        }

    }
}
