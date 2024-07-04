import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long t = Integer.parseInt(sc.nextLine());
        for (long i = 1; i <= t; i++) {
            makeAns(sc, i);
        }

    }

    private static void makeAns(Scanner sc, long i) {
        long u = Long.parseLong(sc.nextLine());
        List<Task> tasks = new ArrayList<>();
        for (long j = 0; j < 10000; j++) {
            String[] line = sc.nextLine().split(" ");
            if(line.length != 2) continue;
            long n = Long.parseLong(line[0]);
            if(n == -1) continue;
            String s = line[1];
            tasks.add(new Task(n, s));
        }

        Collections.sort(tasks);

        boolean[] used = new boolean['Z' - 'A' + 1];

        StringBuilder sb = new StringBuilder();
        for (Task task : tasks) {
            for (char c : task.s.toCharArray()) {
                int index = 'Z' - c;
                if (index >= used.length || index < 0) continue;
                if (!used[index]) {
                    used[index] = true;
                    sb = sb.append(c);
                    if (sb.length() == 10) {
                        System.out.println(String.format("Case #%s: %s", i, sb.toString().substring(9) + sb.toString().substring(0, 9)));
                        return;
                    }
                }

            }
        }
    }

    private static class Task implements Comparable<Task> {
        long n;
        String s;

        public Task(long n, String s) {
            this.n = n;
            this.s = s;
        }

        @Override
        public int compareTo(Task o) {
            return (int) (this.n - o.n); 
        }

    }

}
