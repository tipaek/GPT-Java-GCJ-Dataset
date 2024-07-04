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
            Group C = new Group(T);
            Group J = new Group(T);
            for (int j = 0; j < T; j++) {
                int[] task = {in.nextInt(), in.nextInt()};
                if (!isBusy(C, task)) {
                    b.append("C");
                    C.add(task);
                } else if (!isBusy(J, task)) {
                    b.append("J");
                    J.add(task);
                } else {
                    b = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + b);
        }
    }

    public static boolean isBusy(Group tasks, int[] task) {
        int N = tasks.getCount();
        if (N > 0) {
            for (int c = 0; c < N; c++) {
                int s2 = task[0];
                int e2 = task[1];
                int[] g = tasks.get(c);
                int s1 = g[0];
                int e1 = g[1];
                if (isBusy(s1, e1, s2, e2))
                    return true;
            }
        }
        return false;
    }

    private static boolean isBusy(int s1, int e1, int s2, int e2) {
        return !((e2 <= s1) || (s2 >= e1));
    }

    static class Group {
        private final int[][] arr;
        private int count = 0;
        Group(int size) {
            arr = new int[size][2];
        }

        public void add(int[] task) {
            arr[count++] = task;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public int[] get(int i) {
            return arr[i];
        }

        public int getCount() {
            return count;
        }
    }

}