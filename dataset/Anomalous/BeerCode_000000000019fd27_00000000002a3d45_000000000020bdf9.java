import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int count = scanner.nextInt();
            Interval[] intervals = new Interval[count];

            for (int i = 0; i < count; i++) {
                intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt());
            }

            char[] assignments = new char[count];
            int[] jaySchedule = new int[24 * 60 + 1];
            int[] ceeSchedule = new int[24 * 60 + 1];
            boolean isPossible = true;

            for (int i = 0; i < count; i++) {
                if (isAssignable(intervals[i], jaySchedule)) {
                    assign(intervals[i], jaySchedule);
                    assignments[i] = 'J';
                } else if (isAssignable(intervals[i], ceeSchedule)) {
                    assign(intervals[i], ceeSchedule);
                    assignments[i] = 'C';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.printf("Case #%d: %s\n", testCase, new String(assignments));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
            }
        }
    }

    private static boolean isAssignable(Interval interval, int[] schedule) {
        for (int t = interval.start + 1; t <= interval.finish; t++) {
            if (schedule[t] > 0) {
                return false;
            }
        }
        return true;
    }

    private static void assign(Interval interval, int[] schedule) {
        for (int t = interval.start; t <= interval.finish; t++) {
            schedule[t]++;
        }
    }
}

class Interval {
    int start;
    int finish;

    Interval(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}