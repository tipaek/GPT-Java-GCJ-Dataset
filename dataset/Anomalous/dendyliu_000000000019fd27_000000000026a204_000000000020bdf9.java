import java.io.*;
import java.util.*;

class Solution {
    static class Schedule {
        private int start;
        private int end;
        private int idx;

        Schedule(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        StringBuilder resultBuilder = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            Schedule[] schedules = new Schedule[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                schedules[i] = new Schedule(start, end, i);
            }

            Arrays.sort(schedules, (s1, s2) -> {
                int endComparison = Integer.compare(s1.end, s2.end);
                return endComparison != 0 ? endComparison : Integer.compare(s1.start, s2.start);
            });

            char[] assignment = new char[n];
            boolean impossible = false;
            Queue<Schedule> queue = new LinkedList<>();
            int jStart = schedules[0].start, jEnd = schedules[0].end;
            int cStart = Integer.MAX_VALUE, cEnd = Integer.MIN_VALUE;
            assignment[schedules[0].idx] = 'J';

            for (int i = 1; i < schedules.length; i++) {
                int start = schedules[i].start;
                int end = schedules[i].end;
                int index = schedules[i].idx;

                if ((end <= jStart || jEnd <= start) && (end <= cStart || cEnd <= start)) {
                    queue.add(schedules[i]);
                } else if (end <= jStart || jEnd <= start) {
                    assignment[index] = 'J';
                    jStart = Math.min(jStart, start);
                    jEnd = Math.max(jEnd, end);
                } else if (end <= cStart || cEnd <= start) {
                    assignment[index] = 'C';
                    cStart = Math.min(cStart, start);
                    cEnd = Math.max(cEnd, end);
                } else {
                    impossible = true;
                    break;
                }
            }

            while (!queue.isEmpty() && !impossible) {
                Schedule schedule = queue.poll();
                int start = schedule.start;
                int end = schedule.end;
                int index = schedule.idx;

                if (end <= jStart || jEnd <= start) {
                    assignment[index] = 'J';
                    jStart = Math.min(jStart, start);
                    jEnd = Math.max(jEnd, end);
                } else if (end <= cStart || cEnd <= start) {
                    assignment[index] = 'C';
                    cStart = Math.min(cStart, start);
                    cEnd = Math.max(cEnd, end);
                } else {
                    impossible = true;
                }
            }

            if (impossible) {
                resultBuilder.append("Case #").append(t + 1).append(": IMPOSSIBLE\n");
            } else {
                resultBuilder.append("Case #").append(t + 1).append(": ").append(new String(assignment)).append("\n");
            }
        }

        System.out.print(resultBuilder);
    }
}