import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseCounter = 1; caseCounter <= testCases; caseCounter++) {
            int numIntervals = scanner.nextInt();
            int[] schedule = new int[24 * 60 + 1];
            boolean isImpossible = false;
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < numIntervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end, i));

                if (!isImpossible) {
                    for (int j = start; j < end; j++) {
                        schedule[j]++;
                        if (schedule[j] > 2) {
                            isImpossible = true;
                            break;
                        }
                    }
                }
            }

            intervals.sort((a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

            String result;
            if (isImpossible) {
                result = "IMPOSSIBLE";
            } else {
                char[] assignments = new char[numIntervals];

                for (Interval interval : intervals) {
                    boolean canAssignC = true;

                    for (int j = interval.start; j < interval.end; j++) {
                        if (schedule[j] < 0) {
                            canAssignC = false;
                            break;
                        }
                    }

                    if (canAssignC) {
                        for (int j = interval.start; j < interval.end; j++) {
                            schedule[j] *= -1;
                        }
                    }

                    assignments[interval.index] = canAssignC ? 'C' : 'J';
                }

                result = new String(assignments);
            }

            System.out.printf("Case #%d: %s\n", caseCounter, result);
        }
        scanner.close();
    }

    static class Interval {
        int start;
        int end;
        int index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}