import java.util.*;
import java.io.*;

class Solution {

    public static String assignTasks(PriorityQueue<int[]> tasks, int length) {
        char[] schedule = new char[length];
        List<int[]> cameronTasks = new ArrayList<>();
        List<int[]> jamieTasks = new ArrayList<>();

        while (!tasks.isEmpty()) {
            int[] task = tasks.poll();

            if (cameronTasks.isEmpty() || task[0] >= cameronTasks.get(cameronTasks.size() - 1)[1]) {
                cameronTasks.add(task);
            } else if (jamieTasks.isEmpty() || task[0] >= jamieTasks.get(jamieTasks.size() - 1)[1]) {
                jamieTasks.add(task);
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int[] task : cameronTasks) {
            schedule[task[2]] = 'C';
        }
        for (int[] task : jamieTasks) {
            schedule[task[2]] = 'J';
        }

        return new String(schedule);
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            PriorityQueue<int[]> pq = new PriorityQueue<>(N, Comparator.comparingInt(a -> a[0]));

            for (int j = 0; j < N; j++) {
                int[] task = new int[3];
                task[0] = in.nextInt();
                task[1] = in.nextInt();
                task[2] = j;
                pq.offer(task);
            }

            System.out.println("Case #" + i + ": " + assignTasks(pq, N));
        }
        in.close();
    }
}