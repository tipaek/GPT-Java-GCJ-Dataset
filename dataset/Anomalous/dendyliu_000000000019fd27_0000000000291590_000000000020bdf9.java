import java.io.*;
import java.util.*;

class Solution {
    static class Schedule {
        int start, end, idx;
        Schedule(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < T; ++i) {
            int N = scan.nextInt();
            Schedule[] schedules = new Schedule[N];
            for (int j = 0; j < N; ++j) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                schedules[j] = new Schedule(start, end, j);
            }

            Arrays.sort(schedules, (s1, s2) -> {
                int endComparison = Integer.compare(s1.end, s2.end);
                return endComparison != 0 ? endComparison : Integer.compare(s1.start, s2.start);
            });

            char[] result = new char[N];
            boolean impossible = false;
            int endJ = -1, endC = -1;

            for (Schedule schedule : schedules) {
                if (schedule.start >= endJ) {
                    result[schedule.idx] = 'J';
                    endJ = schedule.end;
                } else if (schedule.start >= endC) {
                    result[schedule.idx] = 'C';
                    endC = schedule.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                answer.append("Case #").append(i + 1).append(": IMPOSSIBLE\n");
            } else {
                answer.append("Case #").append(i + 1).append(": ").append(new String(result)).append("\n");
            }
        }

        System.out.print(answer);
    }
}