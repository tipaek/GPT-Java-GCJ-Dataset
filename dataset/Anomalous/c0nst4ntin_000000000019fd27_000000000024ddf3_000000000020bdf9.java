import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = in.nextInt();
            int[][] activities = new int[n][3];
            for (int i = 0; i < n; i++) {
                activities[i][0] = in.nextInt();
                activities[i][1] = in.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            Stack<int[]> cameron = new Stack<>();
            Stack<int[]> jamie = new Stack<>();
            char[] result = new char[n];

            cameron.push(activities[0]);
            result[activities[0][2]] = 'C';

            boolean possible = true;
            for (int i = 1; i < n; i++) {
                if (cameron.peek()[1] <= activities[i][0]) {
                    cameron.push(activities[i]);
                    result[activities[i][2]] = 'C';
                } else if (jamie.isEmpty() || jamie.peek()[1] <= activities[i][0]) {
                    jamie.push(activities[i]);
                    result[activities[i][2]] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNum + ": " + new String(result));
            }
        }
    }
}