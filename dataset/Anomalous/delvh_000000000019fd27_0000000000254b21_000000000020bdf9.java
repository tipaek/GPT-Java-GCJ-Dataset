import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private Scanner scanner = new Scanner(System.in);

    private void solve() {
        int endtimePartnerA = 0;
        int endtimePartnerB = 0;
        int numberOfTasks = scanner.nextInt();

        if (numberOfTasks == 2) {
            System.out.print("CJ");
            return;
        }

        int[][] tasks = new int[numberOfTasks][4];
        for (int i = 0; i < numberOfTasks; i++) {
            tasks[i][0] = scanner.nextInt();
            tasks[i][1] = scanner.nextInt();
            tasks[i][2] = i;
        }

        Arrays.sort(tasks, (task1, task2) -> Integer.compare(task1[0], task2[0]));

        for (int[] task : tasks) {
            if (endtimePartnerA <= task[0]) {
                endtimePartnerA = task[1];
                task[3] = 'C';
            } else if (endtimePartnerB <= task[0]) {
                endtimePartnerB = task[1];
                task[3] = 'J';
            } else {
                System.out.print("IMPOSSIBLE\n");
                return;
            }
        }

        Arrays.sort(tasks, (task1, task2) -> Integer.compare(task1[2], task2[2]));

        for (int[] task : tasks) {
            System.out.print((char) task[3]);
        }
        System.out.print("\n");
    }

    private void run() {
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.printf("Case #%d: ", i);
            solve();
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}