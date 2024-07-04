import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    class Task implements Comparable<Task> {
        int start;
        int end;
        int index;
        String person;

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int i = 1; i <= testCases; i++) {
            int cameronEndTime = 0;
            int jamieEndTime = 0;
            int numTasks = scanner.nextInt();
            boolean impossible = false;

            Task[] tasks = new Task[numTasks];
            for (int j = 0; j < numTasks; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Task task = solution.new Task();
                task.start = start;
                task.end = end;
                task.index = j;
                task.person = "J";
                tasks[j] = task;
            }

            Task[] originalTasks = Arrays.copyOf(tasks, numTasks);
            Arrays.sort(tasks);

            for (Task task : tasks) {
                if (cameronEndTime <= task.start) {
                    task.person = "C";
                    cameronEndTime = task.end;
                } else if (jamieEndTime <= task.start) {
                    task.person = "J";
                    jamieEndTime = task.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                String[] result = new String[numTasks];
                for (Task task : tasks) {
                    result[task.index] = task.person;
                }
                StringBuilder resultString = new StringBuilder();
                for (String res : result) {
                    resultString.append(res);
                }
                System.out.println("Case #" + i + ": " + resultString);
            }
        }
    }
}