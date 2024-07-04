import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int[][] tasks = new int[N][3];
            char[] result = new char[N];

            for (int j = 0; j < N; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
                tasks[j][2] = j;
            }

            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

            int cEnd = 0, jEnd = 0;
            boolean isPossible = true;

            for (int[] task : tasks) {
                if (task[0] >= cEnd) {
                    cEnd = task[1];
                    result[task[2]] = 'C';
                } else if (task[0] >= jEnd) {
                    jEnd = task[1];
                    result[task[2]] = 'J';
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.print("Case #" + i + ": ");
                System.out.println(result);
            }
        }
    }
}