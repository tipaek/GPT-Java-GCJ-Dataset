import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int size = in.nextInt();
            ArrayList<Task> tasks = new ArrayList<>(size * 2);
            in.nextLine();
            for (int i = 0; i < size; i++) {
                String[] times = in.nextLine().split(" ");
                tasks.add(new Task(i, Integer.valueOf(times[0]), Integer.valueOf(times[1])));
            }
            tasks.sort(Comparator.comparingInt(Task::getStart));

            System.out.println(buildOutput(tasks));
        }
    }

    private static String buildOutput(ArrayList<Task> tasks) {
        Task cTask = null;
        Task jTask = null;

        for (Task task : tasks) {

            if(cTask != null && !overlaps(cTask, task)) {
                cTask = null;
            }
            if(jTask != null && !overlaps(jTask, task)) {
                jTask = null;
            }

            if (cTask == null) {
                task.responsible = 'C';
                cTask = task;
            } else if (jTask == null) {
                task.responsible = 'J';
                jTask = task;
            } else {
                return "IMPOSSIBLE";
            }
        }

        tasks.sort(Comparator.comparingInt(Task::getOrder));
        String collect = tasks.stream().map(it -> it.responsible).map(String::valueOf).collect(Collectors.joining());
        return collect;
    }

    private static boolean overlaps(Task t1, Task t2) {
        return (t1.start < t2.end) && (t2.start < t1.end);
    }

    static class Task {
        int order;
        int start;
        int end;
        char responsible;

        public Task(int order, int start, int end) {
            this.order = order;
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return this.start;
        }

        public int getOrder() {
            return this.order;
        }

        @Override
        public String toString() {
            return String.valueOf(responsible);
        }
    }
}