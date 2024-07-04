import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(scanner.nextLine());
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[i] = new Interval(i + 1, Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }

            Arrays.sort(intervals);

            char[] result = new char[n];
            result[intervals[0].position - 1] = 'J';
            int lastEndJ = intervals[0].end;
            int lastEndC = 0;

            boolean possible = true;

            for (int i = 1; i < n; i++) {
                if (result[intervals[i - 1].position - 1] == 'J') {
                    if (lastEndC <= intervals[i].start) {
                        result[intervals[i].position - 1] = 'C';
                        lastEndC = intervals[i].end;
                    } else if (lastEndJ <= intervals[i].start) {
                        result[intervals[i].position - 1] = 'J';
                        lastEndJ = intervals[i].end;
                    } else {
                        possible = false;
                        break;
                    }
                } else {
                    if (lastEndJ <= intervals[i].start) {
                        result[intervals[i].position - 1] = 'J';
                        lastEndJ = intervals[i].end;
                    } else if (lastEndC <= intervals[i].start) {
                        result[intervals[i].position - 1] = 'C';
                        lastEndC = intervals[i].end;
                    } else {
                        possible = false;
                        break;
                    }
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNumber + ": " + new String(result));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }

    static class Interval implements Comparable<Interval> {
        int position;
        int start;
        int end;

        Interval(int position, int start, int end) {
            this.position = position;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }
    }
}