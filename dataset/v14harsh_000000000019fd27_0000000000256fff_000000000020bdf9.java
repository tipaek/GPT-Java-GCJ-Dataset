import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int T = in.nextInt();
            StringBuilder b = new StringBuilder();
            Stack<int[]> C = new Stack<>();
            Stack<int[]> J = new Stack<>();
            for (int j = 0; j < T; j++) {
                int[] task = {in.nextInt(), in.nextInt()};
                if (!isBusy(C, task)) {
                    b.append("C");
                    C.push(task);
                } else if (!isBusy(J, task)) {
                    b.append("J");
                    J.push(task);
                } else {
                    b = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + b);
        }
    }

    public static boolean isBusy(Stack<int[]> tasks, int[] task) {
        int N = tasks.size();
        if (N > 0) {
            for (int[] t : tasks) {
                int s2 = task[0];
                int e2 = task[1];
                int s1 = t[0];
                int e1 = t[1];
                if (isBusy(s1, e1, s2, e2))
                    return true;
            }
        }
        return false;
    }

    private static boolean isBusy(int s1, int e1, int s2, int e2) {
        return !((e2 <= s1) || (s2 >= e1));
    }

}