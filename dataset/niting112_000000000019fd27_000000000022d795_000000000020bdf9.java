import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            Task[] tasks = new Task[N];
            for(int i = 0; i < N; ++i) {
                int start = in.nextInt();
                int end = in.nextInt();
                tasks[i] = new Task(start, end, i);
            }
            char[] answer = new char[N];
            Arrays.sort(tasks, Comparator.comparingInt(o -> o.end));
            int J = 1440;
            int C = 1440;
            boolean possible = true;
            for(int i = N - 1; i >= 0; --i) {
                Task task = tasks[i];
                if(task.end <= J) {
                    answer[task.index] = 'J';
                    J = task.start;
                    continue;
                }
                if(task.end <= C) {
                    answer[task.index] = 'C';
                    C = task.start;
                    continue;
                }
                possible = false;
                break;
            }
            sb.append("Case #" + t + ": ");
            if(!possible) {
                sb.append("IMPOSSIBLE\n");
            } else {
                for(int i = 0; i < N; ++i) {
                    sb.append(answer[i]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());

    }

    static class Task {
        int start;
        int end;
        int index;

        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}
