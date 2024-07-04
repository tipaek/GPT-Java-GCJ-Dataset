import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int T = in.nextInt();
            StringBuilder b = new StringBuilder();
            int[][] C = new int[T][2];
            int[][] J = new int[T][2];
            for (int j = 0; j < T; j++) {
                int[] task = {in.nextInt(), in.nextInt()};
                if (isAvailable(C, task)) {
                    b.append("C");
                    C[j] = task;
                } else if (isAvailable(J, task)) {
                    b.append("J");
                    J[j] = task;
                } else {
                    b = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + b.toString());
        }
    }

    public static boolean isAvailable(int[][] tasks, int[] task) {
        int N = tasks.length;
        for (int c = 0; c < N; c++) {
            int aStart = tasks[c][0];
            int aEnd = tasks[c][1];
            int xStart = task[0];
            int xEnd = task[1];
            if (!isAvailable(aStart, aEnd, xStart, xEnd))
                return false;
        }
        return true;
    }

    private static boolean isAvailable(int s1, int e1, int s2, int e2) {
        return (e2 <= s1) || (s2 >= e1);
    }

}