import java.util.*;

class Pair {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class TimeComparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.start, p2.start);
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            Pair[] intervals = new Pair[n];

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[j] = new Pair(start, end);
            }

            Arrays.sort(intervals, new TimeComparator());

            int cIndex = 0;
            int jIndex = -1;
            StringBuilder schedule = new StringBuilder("C");
            String impossible = "IMPOSSIBLE";

            for (int j = 1; j < n; j++) {
                if (intervals[j].start < intervals[cIndex].end) {
                    if (jIndex == -1 || intervals[j].start >= intervals[jIndex].end) {
                        jIndex = j;
                        schedule.append("J");
                    } else if (intervals[j].start < intervals[jIndex].end) {
                        break;
                    }
                } else {
                    cIndex = j;
                    schedule.append("C");
                }
            }

            int caseNumber = i + 1;
            if (schedule.length() < n) {
                System.out.println("Case #" + caseNumber + ": " + impossible);
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }
        }
    }
}