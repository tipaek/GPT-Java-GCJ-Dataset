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
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            Pair[] times = new Pair[n];

            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                times[j] = new Pair(startTime, endTime);
            }

            Arrays.sort(times, new TimeComparator());

            int cIndex = 0;
            int jIndex = -1;
            StringBuilder schedule = new StringBuilder("C");
            String impossible = "IMPOSSIBLE";

            boolean possible = true;
            for (int j = 1; j < n; j++) {
                if (times[j].start < times[cIndex].end) {
                    if (jIndex == -1 || times[j].start >= times[jIndex].end) {
                        jIndex = j;
                        schedule.append("J");
                    } else {
                        possible = false;
                        break;
                    }
                } else {
                    cIndex = j;
                    schedule.append("C");
                }
            }

            if (!possible || schedule.length() < n) {
                System.out.println("Case #" + (i + 1) + ": " + impossible);
            } else {
                System.out.println("Case #" + (i + 1) + ": " + schedule.toString());
            }
        }
        scanner.close();
    }
}