import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private final Scanner in = new Scanner(System.in);

    private void solve() {
        int n = in.nextInt();
        int cEnd = 0, jEnd = 0;
        int[][] tasks = new int[n][4];

        for (int i = 0; i < n; i++) {
            tasks[i][0] = in.nextInt(); // start time
            tasks[i][1] = in.nextInt(); // end time
            tasks[i][2] = i; // original index
        }

        // Sort tasks by start time
        Arrays.parallelSort(tasks, (task1, task2) -> Integer.compare(task1[0], task2[0]));

        for (int[] task : tasks) {
            if (cEnd <= task[0]) {
                cEnd = task[1];
                task[3] = 'C';
            } else if (jEnd <= task[0]) {
                jEnd = task[1];
                task[3] = 'J';
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        // Sort tasks back to their original order
        Arrays.parallelSort(tasks, (task1, task2) -> Integer.compare(task1[2], task2[2]));

        for (int[] task : tasks) {
            System.out.print((char) task[3]);
        }
        System.out.println();
    }

    private void run() {
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.printf("Case #%d: ", i);
            solve();
        }
    }

    public static void main(String[] args) {
        try {
            new Solution().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}