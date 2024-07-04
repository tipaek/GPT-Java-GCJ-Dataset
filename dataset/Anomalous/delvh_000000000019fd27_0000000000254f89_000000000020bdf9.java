import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private Scanner scanner = new Scanner(System.in);

    private void solve() throws Exception {
        int endTimeC = 0;
        int endTimeJ = 0;
        int numTasks = scanner.nextInt();

        if (numTasks == 2) {
            System.out.print("CJ");
            return;
        }

        int[][] tasks = new int[numTasks][4];
        for (int i = 0; i < numTasks; i++) {
            tasks[i][0] = scanner.nextInt();
            tasks[i][1] = scanner.nextInt();
            tasks[i][2] = i;
        }

        Arrays.sort(tasks, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] task : tasks) {
            if (endTimeC <= task[0]) {
                endTimeC = task[1];
                task[3] = 'C';
            } else if (endTimeJ <= task[0]) {
                endTimeJ = task[1];
                task[3] = 'J';
            } else {
                System.out.print("IMPOSSIBLE\n");
                return;
            }
        }

        Arrays.sort(tasks, (a, b) -> Integer.compare(a[2], b[2]));

        for (int[] task : tasks) {
            System.out.print((char) task[3]);
        }
        System.out.print("\n");
    }

    private void run() throws Exception {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            System.out.printf("Case #%d: ", i);
            solve();
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}