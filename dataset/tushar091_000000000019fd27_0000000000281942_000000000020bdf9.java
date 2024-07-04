
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            Time[] times = new Time[n];
            Time[] sorted = new Time[n];
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Time time = new Time(start, end);
                times[j] = time;
                sorted[j] = time;
            }
            Arrays.sort(sorted);
            Time lastC = null;
            Time lastJ = null;
            boolean isImpossible = false;
            for (int j = 0; j < n; j++) {
                if (lastC == null) {
                    lastC = sorted[j];
                    sorted[j].s = "C";
                    continue;
                }
                if (lastJ == null) {
                    lastJ = sorted[j];
                    sorted[j].s = "J";
                    continue;
                }
                if (!isOverLap(lastC, sorted[j])) {
                    lastC = sorted[j];
                    lastC.s = "C";
                } else if (!isOverLap(lastJ, sorted[j])) {
                    lastJ = sorted[j];
                    lastJ.s = "J";
                } else {
                    isImpossible = true;
                    break;
                }
            }
            System.out.print(String.format("Case #%d: ",i));
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            for (int j = 0; j < n; j++) {
                System.out.print(times[j].s);
            }
            System.out.println();
        }
    }

    static boolean isOverLap(Time t1, Time t2) {
        return (t1.start < t2.start && t2.start < t1.end);
    }

    static class Time implements Comparable<Time> {
        int start;
        int end;
        String s;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "start=" + start +
                    ", end=" + end +
                    ", s='" + s + '\'' +
                    '}';
        }
    }
}
