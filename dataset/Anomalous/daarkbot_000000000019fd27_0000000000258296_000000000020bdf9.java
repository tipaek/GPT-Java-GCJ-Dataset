import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int K = T;

        while (T-- > 0) {
            int N = sc.nextInt();
            int[][] tasks = new int[N][3];
            char[] result = new char[N];

            for (int i = 0; i < N; i++) {
                tasks[i][0] = sc.nextInt();
                tasks[i][1] = sc.nextInt();
                tasks[i][2] = i;
            }

            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

            char[] workers = {'C', 'J'};
            int[] endTimes = {Integer.MAX_VALUE, Integer.MAX_VALUE};
            boolean isAssigned = false;

            for (int i = N - 1; i >= 0; i--) {
                isAssigned = false;
                int firstWorker = endTimes[0] <= endTimes[1] ? 0 : 1;
                int secondWorker = firstWorker == 0 ? 1 : 0;

                if (tasks[i][1] <= endTimes[firstWorker]) {
                    isAssigned = true;
                    result[tasks[i][2]] = workers[firstWorker];
                    endTimes[firstWorker] = tasks[i][0];
                } else if (tasks[i][1] <= endTimes[secondWorker]) {
                    isAssigned = true;
                    result[tasks[i][2]] = workers[secondWorker];
                    endTimes[secondWorker] = tasks[i][0];
                }

                if (!isAssigned) {
                    System.out.println("Case #" + (K - T) + ": IMPOSSIBLE");
                    break;
                }
            }

            if (isAssigned) {
                StringBuilder sb = new StringBuilder();
                for (char c : result) {
                    sb.append(c);
                }
                System.out.println("Case #" + (K - T) + ": " + sb.toString());
            }
        }
    }
}