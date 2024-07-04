import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            Task[] nextCase = readCase(in);
            String res = solve(nextCase);
            System.out.printf("Case #%d: %s%n", i, res);
        }
    }

    private static String solve(Task[] aCase) {
        Arrays.sort(aCase, Comparator.comparing(Task::getStart).thenComparingInt(task -> -task.getEnd()));
        StringBuilder res = new StringBuilder(new String(new char[aCase.length]));
        int cBusyTill = 0;
        int jBusyTill = 0;
        for (Task task : aCase) {
            if (task.start >= cBusyTill) {
                res.setCharAt(task.num, 'C');
                cBusyTill = task.end;
            } else if (task.start >= jBusyTill) {
                res.setCharAt(task.num, 'J');
                jBusyTill = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return res.toString();
    }

    static Task[] readCase(Scanner in) {
        int items = in.nextInt();
        Task[] res = new Task[items];
        for (int i = 0; i < items; i++) {
            res[i] = new Task();
            res[i].num = i;
            res[i].start = in.nextInt();
            res[i].end = in.nextInt();
        }
        return res;
    }

    private static class Task {
        int num;
        int start;
        int end;

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}