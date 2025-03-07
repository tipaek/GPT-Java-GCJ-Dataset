import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static String L = "(";
    public static String R = ")";
    public static String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        int u = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; i++) {
            makeAns(sc, i);
        }

    }

    private static void makeAns(Scanner sc, int i) {
        List<Task> tasks = new ArrayList<>();
        for (int j = 0; j < 10000; j++) {
            String[] line = sc.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            String s = line[1];
            tasks.add(new Task(n, s));
        }

        Collections.sort(tasks);

        boolean[] used = new boolean['Z' - 'A' + 1];

        StringBuilder sb = new StringBuilder();
        outer: for (Task task : tasks) {
            for (char c : task.s.toCharArray()) {
                int index = 'Z' - c;
                if (!used[index]) {
                    used[index] = true;
                    sb = sb.append(c);
                    if (sb.length() == 10) {
                        System.out.println(String.format("Case #%s: %s", i, sb.toString().substring(9) + sb.toString().substring(0, 9)));
                        break outer;
                    }
                }

            }
        }
    }

    private static class Task implements Comparable<Task> {
        int n;
        String s;

        public Task(int n, String s) {
            this.n = n;
            this.s = s;
        }

        @Override
        public int compareTo(Task o) {
            return this.n - o.n;
        }

    }

}
