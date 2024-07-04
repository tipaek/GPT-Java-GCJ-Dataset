import java.io.*;
import java.util.*;

public class Solution {
    static class Schedule {
        int start;
        int end;
        int idx;

        Schedule(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int numSchedules = scanner.nextInt();
            Schedule[] schedules = new Schedule[numSchedules];

            for (int i = 0; i < numSchedules; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                schedules[i] = new Schedule(start, end, i);
            }

            Arrays.sort(schedules, (s1, s2) -> {
                if (s1.end != s2.end) {
                    return Integer.compare(s1.end, s2.end);
                }
                return Integer.compare(s1.start, s2.start);
            });

            char[] assignment = new char[numSchedules];
            int endJ = -1, endC = -1;
            boolean impossible = false;

            for (Schedule schedule : schedules) {
                if (schedule.start >= endJ) {
                    assignment[schedule.idx] = 'J';
                    endJ = schedule.end;
                } else if (schedule.start >= endC) {
                    assignment[schedule.idx] = 'C';
                    endC = schedule.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                result.append("Case #").append(t + 1).append(": IMPOSSIBLE\n");
            } else {
                result.append("Case #").append(t + 1).append(": ").append(new String(assignment)).append("\n");
            }
        }

        System.out.print(result);
    }
}