import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author peta
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().run();
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


        Comparator<? super Task> compareFrom = new Comparator<Task>() {
            @Override
            public int compare(Task t, Task t1) {
                return t.getFrom() - t1.getFrom();
            }
        };

        tasks.sort(compareFrom);
        int cBusy = 0;
        int jBusy = 0;
        for (Task task : tasks) {

            if (cBusy <= task.getFrom()) {
                task.setOwner('C');
                cBusy = task.getTo();

            } else if (jBusy <= task.getFrom()) {
                task.setOwner('J');
                jBusy = task.getTo();

            } else {
                return "IMPOSSIBLE";
            }
        }
        Comparator<? super Task> comparePosition = new Comparator<Task>() {
            @Override
            public int compare(Task t, Task t1) {
                return t.getPosition() - t1.getPosition();
            }
        };

        tasks.sort(comparePosition);
        StringBuilder sb = new StringBuilder();
        for (Task task : tasks) {
            sb.append(task.getOwner());
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

        /**
         * @return the position
         */
        public int getPosition() {
            return position;
        }

        /**
         * @param position the position to set
         */
        public void setPosition(int position) {
            this.position = position;
        }

        /**
         * @return the from
         */
        public int getFrom() {
            return from;
        }

        /**
         * @param from the from to set
         */
        public void setFrom(int from) {
            this.from = from;
        }

        /**
         * @return the to
         */
        public int getTo() {
            return to;
        }

        /**
         * @param to the to to set
         */
        public void setTo(int to) {
            this.to = to;
        }

        /**
         * @return the owner
         */
        public char getOwner() {
            return owner;
        }

        /**
         * @param owner the owner to set
         */
        public void setOwner(char owner) {
            this.owner = owner;
        }

        private int position;
        private int from;
        private int to;
        private char owner;

        public Task(int position, int from, int to) {
            this.position = position;
            this.from = from;
            this.to = to;
        }

    }
}
