package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ParentingPartneringReturns {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < T; i++) {
            result.append("Case #").append(i + 1).append(": ");
            int n = Integer.parseInt(reader.readLine());
            Time[] tasks = new Time[n];
            int[] timeLine = new int[1500];
            boolean impossible = false;

            for (int j = 0; j < n; j++) {
                String[] input = reader.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                tasks[j] = new Time(j, start, end);

                for (int k = start; k < end; k++) {
                    timeLine[k]++;
                    if (timeLine[k] > 2) {
                        impossible = true;
                    }
                }
            }

            if (impossible) {
                result.append("IMPOSSIBLE\n");
                continue;
            }

            Arrays.sort(tasks, (a, b) -> Integer.compare(a.end, b.end));

            for (int j = 1; j < tasks.length; j++) {
                Time previous = tasks[j - 1];
                Time current = tasks[j];
                if (previous.end > current.start) {
                    current.assignedToJ = !previous.assignedToJ;
                } else {
                    current.assignedToJ = previous.assignedToJ;
                }
            }

            Arrays.sort(tasks, (a, b) -> Integer.compare(a.task, b.task));

            for (Time task : tasks) {
                result.append(task.assignedToJ ? "J" : "C");
            }
            result.append("\n");
        }

        System.out.print(result);
    }
}

class Time {
    public int task;
    public int start;
    public int end;
    public boolean assignedToJ;

    public Time(int task, int start, int end) {
        this.task = task;
        this.start = start;
        this.end = end;
        this.assignedToJ = false;
    }

    @Override
    public String toString() {
        return "Time{" +
                "task=" + task +
                ", start=" + start +
                ", end=" + end +
                ", assignedToJ=" + assignedToJ +
                '}';
    }
}