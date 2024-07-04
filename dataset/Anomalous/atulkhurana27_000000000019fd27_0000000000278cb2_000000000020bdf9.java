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
            Integer cEnd = null, jEnd = null;
            boolean impossible = false;
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals[j] = new Pair(start, end);
            }

            Arrays.sort(intervals, Comparator.comparingInt(Pair::getX));

            for (Pair interval : intervals) {
                int start = interval.getX();
                int end = interval.getY();

                if (cEnd == null || cEnd <= start) {
                    cEnd = end;
                    result.append('C');
                } else if (jEnd == null || jEnd <= start) {
                    jEnd = end;
                    result.append('J');
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + i + ": " + result);
        }
        sc.close();
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