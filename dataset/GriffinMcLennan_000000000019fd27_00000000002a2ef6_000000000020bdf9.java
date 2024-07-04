import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numCases = scanner.nextInt();

        for (int i = 0; i < numCases; i++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][3];

            for (int j = 0; j < N; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                activities[j][2] = j;
            }

            solve(i + 1, activities);
        }
    }

    private static void solve(int c, int[][] activities) {
        StringBuilder ans = new StringBuilder();

        //int[] a = {id, time, +-1 = end/start}
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        char[] cArr = new char[activities.length];

        for (int[] activity : activities) {
            queue.offer(new int[] {activity[2], activity[0], 1});
            queue.offer(new int[] {activity[2], activity[1], -1});
        }

        int C = -1;
        int J = -1;
        int threads = 0;

        while (!queue.isEmpty()) {
            int[] t = queue.poll();
            threads += t[2];

            if (threads > 2) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", c);
                return;
            }

            //if adding a task
            if (t[2] == 1) {
                //try to give to C
                if (C == -1) {
                    C = t[0];
                    cArr[t[0]] = 'C'; 
                }
                else {
                    J = t[0];
                    cArr[t[0]] = 'J';
                }
            }
            else {
                //remove task
                if (C == t[0]) {
                    C = -1;
                }
                else {
                    J = -1;
                }
            }
        }

        System.out.printf("Case #%d: %s\n", c, String.valueOf(cArr));
    }
}