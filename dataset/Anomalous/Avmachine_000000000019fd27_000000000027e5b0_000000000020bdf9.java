import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder ans = new StringBuilder();

        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            Task[] tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                tasks[i] = new Task(sc.nextInt(), sc.nextInt(), i);
            }

            Arrays.sort(tasks, (a, b) -> a.start - b.start);

            int cs = -1, ce = -1, js = -1, je = -1;
            char[] result = new char[n];
            boolean possible = true;

            for (Task task : tasks) {
                if (ce <= task.start || cs >= task.end) {
                    result[task.index] = 'C';
                    cs = task.start;
                    ce = task.end;
                } else if (je <= task.start || js >= task.end) {
                    result[task.index] = 'J';
                    js = task.start;
                    je = task.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                ans.append("Case #").append(x).append(": IMPOSSIBLE\n");
            } else {
                ans.append("Case #").append(x).append(": ").append(new String(result)).append("\n");
            }
        }

        System.out.print(ans.toString().trim());
        sc.close();
    }

    static class Task {
        int start;
        int end;
        int index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}