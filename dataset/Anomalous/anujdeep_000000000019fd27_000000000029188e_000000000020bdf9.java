import java.util.*;

public class Solution {

    static class Interval {
        int start, end, index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class Answer {
        char assigned;
        int index;

        Answer(char assigned, int index) {
            this.assigned = assigned;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(start, end, i);
            }

            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));

            Answer[] answers = new Answer[n];
            answers[0] = new Answer('C', intervals[0].index);
            int cameronEnd = intervals[0].end;
            int jamieEnd = -1;
            boolean possible = true;

            for (int i = 1; i < n; i++) {
                Interval current = intervals[i];

                if (cameronEnd <= current.start) {
                    answers[i] = new Answer('C', current.index);
                    cameronEnd = current.end;
                } else if (jamieEnd <= current.start) {
                    answers[i] = new Answer('J', current.index);
                    jamieEnd = current.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                Arrays.sort(answers, Comparator.comparingInt(answer -> answer.index));
                System.out.print("Case #" + caseNum + ": ");
                for (Answer answer : answers) {
                    System.out.print(answer.assigned);
                }
                System.out.println();
            }
        }
    }
}