import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();

            List<TimeFrame> tasks = new ArrayList<>();

            for (int n = 0; n < N; n++) {
                tasks.add(new TimeFrame(in.nextInt(), in.nextInt(), n));
            }
            Collections.sort(tasks);

            Parent cameron = new Parent('C');
            Parent jamie = new Parent('J');

            char[] taskLog = new char[N];
            for (TimeFrame task : tasks) {
                if (cameron.checkTask(task)) {
                    cameron.addTask(task);
                    taskLog[task.order] = cameron.name;
                } else if (jamie.checkTask(task)) {
                    jamie.addTask(task);
                    taskLog[task.order] = jamie.name;
                } else {
                    taskLog = "IMPOSSIBLE".toCharArray();
                    break;
                }
            }

            System.out.println("Case #" + (i+1) + ": " + new String(taskLog));
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
                if (task.start >= lt.start && task.start <  lt.finish) {
                    return false;
                }
            }
            return true;
        }

    }

    private static class TimeFrame implements Comparable<TimeFrame> {
        int start;
        int finish;
        int order;

        public TimeFrame(int start, int finish, int order) {
            this.start = start;
            this.finish = finish;
            this.order = order;
        }

        @Override public int compareTo(TimeFrame o) {
            return start - o.start;
        }
    }

}
