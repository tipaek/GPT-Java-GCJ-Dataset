import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    static class Schedule implements Comparable<Schedule> {
        int i;
        int begin;
        int end;

        Schedule(int i, int begin, int end) {
            this.i = i;
            this.begin = begin;
            this.end = end;
        }

        int length() {
            return end - begin;
        }

        @Override
        public int compareTo(Schedule o) {
            return o.length() - this.length();
        }

        public String toString() {
            return i + ": " + begin + ", " + end + ", " + length();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader in = new BufferedReader(new FileReader("data/input.txt"));

        int T = Integer.parseInt(in.readLine());

        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(in.readLine());

            List<Schedule> scheduleList = new ArrayList<>();
            for (int i = 0; i < N; ++i) {
                String[] sin = in.readLine().split(" ");
                scheduleList.add(new Schedule(i, Integer.parseInt(sin[0]), Integer.parseInt(sin[1])));
            }

            String result = solve(scheduleList);

            System.out.println("Case #" + (t + 1) + ": " + result);
        }

    }

    static final int C = 0;
    static final int J = 1;

    private static java.lang.String solve(List<Schedule> scheduleList) {
        Collections.sort(scheduleList);
        //scheduleList.forEach(System.out::println);
        boolean[][] timeLine = new boolean[1440][2];

        char[] result = new char[scheduleList.size()];

        for (Schedule s : scheduleList) {
            int current = -1;
            if (!timeLine[s.begin][C] && !timeLine[s.end - 1][C]) {
                current = C;
            } else if (!timeLine[s.begin][J] && !timeLine[s.end - 1][J]) {
                current = J;
            } else {
                return "IMPOSSIBLE";
            }

            boolean isDone = true;
            for (int t = s.begin; t < s.end; t ++) {
                if (timeLine[t][current]) {
                    isDone = false;
                    break;
                }
            }

            if (!isDone) {
                if (current == C) {
                    current = J;
                } else {
                    current = C;
                }

                for (int t = s.begin; t < s.end; t ++) {
                    if (timeLine[t][current]) {
                        return "IMPOSSIBLE";
                    }
                }
            }

            for (int t = s.begin; t < s.end; t ++) {
                timeLine[t][current] = true;
            }

            if (current == C) {
                result[s.i] = 'C';
            } else {
                result[s.i] = 'J';
            }
            //System.out.println(s + ": " + result[s.i]);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }
}
