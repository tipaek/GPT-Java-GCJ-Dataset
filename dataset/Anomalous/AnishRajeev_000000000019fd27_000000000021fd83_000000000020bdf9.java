import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int testcase = 1; testcase <= T; testcase++) {
            int N = scanner.nextInt();
            List<Time> unsorted = new ArrayList<>();
            List<Time> sorted = new ArrayList<>();
            List<String> sortedAnswer = new ArrayList<>();
            List<String> answer = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                Time time = new Time(scanner.nextInt(), scanner.nextInt());
                unsorted.add(time);
                sorted.add(time);
            }

            Collections.sort(sorted);

            int C = 0;
            int J = 0;
            boolean impossible = false;

            for (Time t : sorted) {
                if (C <= t.start) {
                    C = t.end;
                    sortedAnswer.add("C");
                } else if (J <= t.start) {
                    J = t.end;
                    sortedAnswer.add("J");
                } else {
                    sortedAnswer.clear();
                    answer.add("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                for (Time t : unsorted) {
                    answer.add(sortedAnswer.get(sorted.indexOf(t)));
                }
            }

            System.out.print("Case #" + testcase + ": ");
            for (String ans : answer) {
                System.out.print(ans);
            }
            System.out.println();
        }
    }

    public static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Time time = (Time) obj;
            return start == time.start && end == time.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}