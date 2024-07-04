import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Interval implements Comparable<Interval> {
        int index, start, end, person;

        public Interval(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
            this.person = -1;
        }

        @Override
        public int compareTo(Interval other) {
            int comparison = this.start - other.start;
            if (comparison == 0) {
                comparison = other.end - this.end;
            }
            return comparison == 0 ? this.index - other.index : comparison;
        }
    }

    private void process() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfIntervals = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < numberOfIntervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(i, start, end));
            }

            Collections.sort(intervals);

            Interval cameron = null;
            Interval jamie = null;
            boolean isPossible = true;
            for (Interval interval : intervals) {
                if (cameron != null && cameron.end <= interval.start) {
                    cameron = null;
                }
                if (jamie != null && jamie.end <= interval.start) {
                    jamie = null;
                }

                if (cameron != null && jamie != null) {
                    isPossible = false;
                    break;
                }

                if (cameron == null && jamie == null) {
                    interval.person = 0;
                    cameron = interval;
                } else if (cameron == null) {
                    interval.person = 1 - jamie.person;
                    cameron = interval;
                } else {
                    interval.person = 1 - cameron.person;
                    jamie = interval;
                }
            }

            String result = "IMPOSSIBLE";
            char[] assignedPersons = {'C', 'J'};
            if (isPossible) {
                char[] answer = new char[numberOfIntervals];
                for (Interval interval : intervals) {
                    answer[interval.index] = assignedPersons[interval.person];
                }
                result = String.valueOf(answer);
            }

            System.out.printf("Case #%d: %s\n", caseNumber, result);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Solution().process();
    }
}