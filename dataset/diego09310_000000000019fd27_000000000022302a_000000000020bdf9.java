import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();

            List<TimeFrame> tasks = new ArrayList<>();

            for (int n = 0; n < N; n++) {
                tasks.add(new TimeFrame(in.nextInt(), in.nextInt()));
            }

            Parent Cameron = new Parent('C');
            Parent Jamie = new Parent('J');

            StringBuilder taskLog = new StringBuilder();
            for (TimeFrame task : tasks) {
                if (Cameron.checkTask(task)) {
                    Cameron.addTask(task);
                    taskLog.append(Cameron.name);
                } else if (Jamie.checkTask(task)) {
                    Jamie.addTask(task);
                    taskLog.append(Jamie.name);
                } else {
                    taskLog = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + (i+1) + ": " + taskLog.toString());
        }

        in.close();
    }

    private static class Parent {
        List<TimeFrame> tasks;
        char name;

        public Parent(char name) {
            this.name = name;
            tasks = new ArrayList<>();
        }

        public void addTask(TimeFrame task) {
            tasks.add(task);
        }

        public boolean checkTask(TimeFrame task) {
            for (TimeFrame lt : tasks) {
                if ((task.start > lt.start && task.start < lt.finish)
                 || (task.finish > lt.start && task.finish < lt.finish)
                 || (task.start < lt.start && task.finish > lt.finish)) {
                    return false;
                }
            }
            return true;
        }

    }

    private static class TimeFrame {
        int start;
        int finish;

        public TimeFrame(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

    }

}
