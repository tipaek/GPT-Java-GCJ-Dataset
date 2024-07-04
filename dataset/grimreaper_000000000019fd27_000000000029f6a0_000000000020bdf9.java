import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static class Task implements Comparable<Task> {
        int start, end, id;

        Task(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public int compareTo(Task task) { return start - task.start; }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        char[] chars;
        Task[] tasks;
        for (int i = 1; i <= t; i++) {
            System.out.print("\nCase #" + i + ": ");
            int n = in.nextInt();
            chars = new char[n];
            tasks = new Task[n];
            for (int j = 0; j < n; j++)
                tasks[j] = new Task(in.nextInt(), in.nextInt(), j);
            Arrays.sort(tasks);
            int c = 0;
            int j = 0;
            boolean possible = true;
            for (Task task: tasks) {
                if (c <= task.start) {
                    c = task.end;
                    chars[task.id] = 'C';
                } else if (j <= task.start) {
                    j = task.end;
                    chars[task.id] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }
            if (possible)
                System.out.print(chars);
            else
                System.out.print("IMPOSSIBLE");
        }
    }
}