import java.util.*;

class Time implements Comparable<Time> {
    int start;
    int end;

    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time other) {
        return Integer.compare(this.start, other.start);
    }
}

public class Solution {
    public static String schedule(Time[] times) {
        StringBuilder scheduleBuilder = new StringBuilder();
        Arrays.sort(times);

        int cEnd = 0;
        int jEnd = 0;

        for (Time time : times) {
            if (cEnd <= time.start) {
                scheduleBuilder.append("C");
                cEnd = time.end;
            } else if (jEnd <= time.start) {
                scheduleBuilder.append("J");
                jEnd = time.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return scheduleBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCaseCount; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            Time[] times = new Time[n];

            for (int i = 0; i < n; i++) {
                String[] timeRange = scanner.nextLine().split(" ");
                int start = Integer.parseInt(timeRange[0]);
                int end = Integer.parseInt(timeRange[1]);
                times[i] = new Time(start, end);
            }

            String result = schedule(times);
            System.out.println("Case #" + t + ": " + result);
        }
        scanner.close();
    }
}