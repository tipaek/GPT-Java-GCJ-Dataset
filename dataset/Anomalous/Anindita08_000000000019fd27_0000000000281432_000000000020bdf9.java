import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Task {
    int start, end, index;

    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(tokenizer.nextToken());

        for (int t = 1; t <= T; t++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            Task[] tasks = new Task[N];

            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                tasks[i] = new Task(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()), i);
            }

            char[] result = new char[N];
            Arrays.sort(tasks, new Comparator<Task>() {
                @Override
                public int compare(Task t1, Task t2) {
                    return Integer.compare(t1.end, t2.end);
                }
            });

            int cEnd = tasks[0].end;
            int jEnd = 0;
            boolean possible = true;
            result[tasks[0].index] = 'C';

            for (int i = 1; i < N; i++) {
                if (tasks[i].start < cEnd) {
                    if (tasks[i].start >= jEnd) {
                        jEnd = tasks[i].end;
                        result[tasks[i].index] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                } else {
                    cEnd = tasks[i].end;
                    result[tasks[i].index] = 'C';
                }
            }

            if (possible) {
                System.out.print("Case #" + t + ": ");
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}