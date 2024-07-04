import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int testCase = 1;

        while (testCase <= T) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Task> tasks = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                tasks.add(new Task(start, end, i));
            }

            Collections.sort(tasks, (task1, task2) -> Integer.compare(task1.start, task2.start));

            tasks.get(0).assignee = 'C';
            Task lastC = tasks.get(0);
            Task lastJ = new Task(0, 0, -1);
            boolean possible = true;

            for (int i = 1; i < N; i++) {
                Task current = tasks.get(i);
                if (current.start >= lastC.end) {
                    current.assignee = 'C';
                    lastC = current;
                } else if (current.start >= lastJ.end) {
                    current.assignee = 'J';
                    lastJ = current;
                } else {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                Collections.sort(tasks, (task1, task2) -> Integer.compare(task1.position, task2.position));
                StringBuilder result = new StringBuilder("Case #" + testCase + ": ");
                for (Task task : tasks) {
                    result.append(task.assignee);
                }
                System.out.println(result.toString());
            }

            testCase++;
        }
    }

    static class Task {
        int start;
        int end;
        int position;
        char assignee = 'x';

        Task(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }
}