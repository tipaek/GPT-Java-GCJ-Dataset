import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();

        for (int a = 0; a < tests; a++) {
            StringBuilder result = new StringBuilder();
            int N = input.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int b = 0; b < N; b++) {
                int start = input.nextInt();
                int finish = input.nextInt();
                intervals.add(new Interval(start, finish, b));
            }

            intervals.sort(Comparator.comparingInt(i -> i.start));

            int cEnd = 0;
            int jEnd = 0;
            char[] assigned = new char[N];

            boolean possible = true;

            for (Interval interval : intervals) {
                if (interval.start >= cEnd) {
                    assigned(interval.index) = 'C';
                    cEnd = interval.finish;
                } else if (interval.start >= jEnd) {
                    assigned(interval.index) = 'J';
                    jEnd = interval.finish;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                for (char ch : assigned) {
                    result.append(ch);
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + (a + 1) + ": " + result.toString());
        }
    }

    static class Interval {
        int start;
        int finish;
        int index;

        Interval(int start, int finish, int index) {
            this.start = start;
            this.finish = finish;
            this.index = index;
        }
    }
}