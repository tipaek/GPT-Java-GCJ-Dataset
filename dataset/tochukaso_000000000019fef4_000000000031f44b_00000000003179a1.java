import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution_2 {

    public static String L = "(";
    public static String R = ")";
    public static String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= t; i++) {
            int u = Integer.parseInt(sc.nextLine());
            List<Task> tasks = new ArrayList<>();
            for (int j = 0; j < 10000; j++) {
                int n = sc.nextInt();
                String s = sc.next();
                tasks.add(new Task(n, s));
            }

            Collections.sort(tasks);

            boolean[] used = new boolean['Z' - 'A'];

            StringBuilder sb = new StringBuilder();
            for (Task task : tasks) {
                for (char c : task.s.toCharArray()) {
                    int index = 'Z' - c;
                    System.out.println(index);
                    if (!used[index]) {
                        used[index] = true;
                        sb = sb.append(c);
                        if (sb.length() == 10) {
                            System.out.println(sb.toString().substring(9) + sb.toString().substring(0, 9));
                            return;
                        }
                    }

                }
            }

            System.out.println(sb.toString());
            System.out.println("end");
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

    private static String makeAns(int x, int y, char[] directions) {

        for (int i = 0; i < directions.length; i++) {
            char c = directions[i];

            if (c == 'S') {
                y--;
            } else if (c == 'N') {
                y++;
            } else if (c == 'W') {
                x--;
            } else {
                x++;
            }

            if (Math.abs(x) + Math.abs(y) <= i + 1) {
                return String.valueOf(i + 1);
            }

        }

        return IMPOSSIBLE;
    }
}
