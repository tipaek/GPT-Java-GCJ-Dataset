import java.util.*;

class Time implements Comparable<Time> {
    int id;
    int start;
    int end;

    Time(int id, int start, int end) {
        this.id = id;
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
        Arrays.sort(times);
        char[] assignments = new char[times.length];
        int endC = 0, endJ = 0;

        for (Time time : times) {
            if (endC <= time.start) {
                assignments[time.id] = 'C';
                endC = time.end;
            } else if (endJ <= time.start) {
                assignments[time.id] = 'J';
                endJ = time.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
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
                times[i] = new Time(i, start, end);
            }

            String result = schedule(times);
            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}