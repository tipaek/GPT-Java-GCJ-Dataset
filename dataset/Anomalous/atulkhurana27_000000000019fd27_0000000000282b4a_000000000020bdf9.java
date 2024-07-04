import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = sc.nextInt();
            Pair[] intervals = new Pair[n];
            Pair[] originalIntervals = new Pair[n];

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[j] = new Pair(start, end);
                originalIntervals[j] = new Pair(start, end);
            }

            Arrays.sort(intervals, Comparator.comparingInt(Pair::getX));

            char[] assignments = new char[n];
            Integer cEnd = null, jEnd = null;
            boolean impossible = false;

            for (int j = 0; j < n; j++) {
                int start = intervals[j].getX();
                int end = intervals[j].getY();

                if (cEnd == null || cEnd <= start) {
                    cEnd = end;
                    assignments[j] = 'C';
                } else if (jEnd == null || jEnd <= start) {
                    jEnd = end;
                    assignments[j] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            String result = impossible ? "IMPOSSIBLE" : getResult(assignments, intervals, originalIntervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String getResult(char[] assignments, Pair[] sortedIntervals, Pair[] originalIntervals) {
        StringBuilder result = new StringBuilder();
        for (Pair original : originalIntervals) {
            int index = getIndex(sortedIntervals, original.getX());
            result.append(assignments[index]);
        }
        return result.toString();
    }

    private static int getIndex(Pair[] intervals, int x) {
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].getX() == x) {
                return i;
            }
        }
        return -1;
    }

    static class Pair {
        private final int x;
        private final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}