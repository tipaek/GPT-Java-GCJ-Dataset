import java.util.*;

public class MyClass {

    static class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Pair[] intervals = new Pair[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Pair(scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(intervals, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return Integer.compare(p1.start, p2.start);
                }
            });

            StringBuilder schedule = new StringBuilder();
            Pair cameron = new Pair(0, 0);
            Pair jamie = new Pair(0, 0);
            boolean possible = true;

            for (Pair interval : intervals) {
                if (interval.start >= cameron.end) {
                    cameron = interval;
                    schedule.append("C");
                } else if (interval.start >= jamie.end) {
                    jamie = interval;
                    schedule.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? schedule.toString() : "IMPOSSIBLE";
            System.out.println("Case #" + t + ": " + result);
        }
    }
}