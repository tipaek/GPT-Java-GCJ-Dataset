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
        StringBuilder schedule = new StringBuilder();
        Arrays.sort(times);

        int endC = 0;
        int endJ = 0;

        for (Time time : times) {
            if (endC <= time.start) {
                schedule.append("C");
                endC = time.end;
            } else if (endJ <= time.start) {
                schedule.append("J");
                endJ = time.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            Time[] times = new Time[n];

            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                times[i] = new Time(start, end);
            }

            System.out.println("Case #" + t + ": " + schedule(times));
        }

        scanner.close();
    }
}