package com.jackson;

import java.util.*;

public class Solution3 {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution3().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            tasks.add(new Task(start, end, i));
        }

        tasks.sort(Comparator.comparingInt(task -> task.start));

        int cEnd = 0, jEnd = 0;
        char[] schedule = new char[n];
        boolean impossible = false;

        for (Task task : tasks) {
            if (task.start >= cEnd) {
                cEnd = task.end;
                schedule[task.index] = 'C';
            } else if (task.start >= jEnd) {
                jEnd = task.end;
                schedule[task.index] = 'J';
            } else {
                impossible = true;
                break;
            }
        }

        String result = impossible ? "IMPOSSIBLE" : new String(schedule);
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private static class Task {
        int start;
        int end;
        int index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}