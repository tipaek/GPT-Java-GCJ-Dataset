import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for (int t=1; t<=T; t++) {
            int tasks = in.nextInt();
            Person cameron = new Person();
            Person jamei = new Person();
            StringBuilder result = new StringBuilder();
            for (int i=1; i <= tasks; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Task task = new Task(start, end);
                if (!cameron.isOverlapping(task)) {
                    cameron.addTask(task);
                    result.append("C");
                } else if (!jamei.isOverlapping(task)) {
                    jamei.addTask(task);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }


            System.out.println("Case #" + t +": " + result.toString());
        }
    }

    static class Task {
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Person {
        List<Task> tasks = new ArrayList<>();

        boolean isOverlapping(Task newTask) {
            for (Task task : tasks) {
                if (newTask.start >= task.start && newTask.start < task.end) {
                    return true;
                }

                if (newTask.end > task.start && newTask.end <= task.end) {
                    return true;
                }
            }

            return false;
        }

        void addTask(Task newTask) {
            tasks.add(newTask);
        }
    }

}