import java.util.*;
import java.io.*;
public class Solution {
    static String schedule(int[][] tasks) {
        int n = tasks.length;
        Arrays.sort(tasks,
                    (task1, task2) -> task1[0] - task2[0]);

        int cFreeTime = 0, jFreeTime = 0;
        char[] assign = new char[n];
        for (int i = 0; i < n; i ++) {
            int start = tasks[i][0];
            int end = tasks[i][1];
            int index = tasks[i][2];

            if (cFreeTime <= start) {
                cFreeTime = end;
                assign[index] = 'C';
            } else if (jFreeTime <= start) {
                jFreeTime = end;
                assign[index] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return String.valueOf(assign);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test_case; t++) {
            int n = in.nextInt();
            int[][] tasks = new int[n][3];
            for (int i = 0; i < n; i ++) {
                tasks[i][0] = in.nextInt();
                tasks[i][1] = in.nextInt();
                tasks[i][2] = i;
            }
            System.out.println("Case #" + t + ": " + schedule(tasks));
        }
    }
}
