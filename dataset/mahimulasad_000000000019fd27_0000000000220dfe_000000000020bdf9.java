import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        int test;
        Scanner in = new Scanner(System.in);
        test = in.nextInt();
        in.nextLine();

        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            List<Task> taskList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Task task = new Task();
                task.index = i;
                task.start = in.nextInt();
                task.end = in.nextInt();
                taskList.add(task);
            }

            Collections.sort(taskList);

            char[] chars = new char[n];
            int cEnd = -1, jEnd = -1;
            boolean impossible = false;
            for (Task task : taskList) {
                if (task.start >= cEnd) {
                    cEnd = task.end;
                    chars[task.index] = 'C';
                } else if (task.start >= jEnd) {
                    jEnd = task.end;
                    chars[task.index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }
            String result;
            if (impossible) {
                result = "IMPOSSIBLE";
            } else {
                result = new String(chars);
            }


            System.out.println(String.format("Case #%d: %s", t, result));
        }
    }

    static class Task implements Comparable<Task> {
        public int index, start, end;

        @Override
        public int compareTo(Task o) {
            return this.start - o.start;
        }
    }
}
