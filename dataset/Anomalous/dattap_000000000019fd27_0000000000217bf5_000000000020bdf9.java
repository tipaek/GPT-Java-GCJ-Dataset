import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numIntervals = Integer.parseInt(scanner.nextLine());
            Interval[] intervals = new Interval[numIntervals];

            for (int i = 0; i < numIntervals; i++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[i] = new Interval(i + 1, Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }

            Arrays.sort(intervals);
            char[] result = new char[numIntervals];
            result[intervals[0].pos - 1] = 'J';
            int lastEndJ = intervals[0].end;
            int lastEndC = 0;

            boolean impossible = false;

            for (int i = 1; i < numIntervals; i++) {
                if (intervals[i - 1].end > intervals[i].start) {
                    if (result[intervals[i - 1].pos - 1] == 'J') {
                        if (lastEndC > intervals[i].start) {
                            impossible = true;
                            break;
                        } else {
                            result[intervals[i].pos - 1] = 'C';
                            lastEndC = intervals[i].end;
                        }
                    } else {
                        if (lastEndJ > intervals[i].start) {
                            impossible = true;
                            break;
                        } else {
                            result[intervals[i].pos - 1] = 'J';
                            lastEndJ = intervals[i].end;
                        }
                    }
                } else {
                    if (result[intervals[i - 1].pos - 1] == 'J') {
                        result[intervals[i].pos - 1] = 'J';
                        lastEndJ = intervals[i].end;
                    } else {
                        result[intervals[i].pos - 1] = 'C';
                        lastEndC = intervals[i].end;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + new String(result));
            }
        }
    }

    static class Interval implements Comparable<Interval> {
        int pos;
        int start;
        int end;

        Interval(int pos, int start, int end) {
            this.pos = pos;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }
    }
}