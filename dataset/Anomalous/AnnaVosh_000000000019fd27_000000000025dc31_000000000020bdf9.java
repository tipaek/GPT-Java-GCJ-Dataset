import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = Integer.parseInt(scanner.nextLine());

        for (int test = 1; test <= testCount; test++) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] times = new String[n];

            for (int i = 0; i < n; i++) {
                times[i] = scanner.nextLine();
            }

            String result = createSchedule(times);
            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static String createSchedule(String[] times) {
        int n = times.length;
        int[][] timeIntervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] parts = times[i].split(" ");
            timeIntervals[i][0] = Integer.parseInt(parts[0]);
            timeIntervals[i][1] = Integer.parseInt(parts[1]);
        }

        Arrays.sort(timeIntervals, Comparator.comparingInt(a -> a[0]));

        Map<String, Character> scheduleMap = new HashMap<>();
        int endC = 0, endJ = 0;

        for (int[] interval : timeIntervals) {
            int start = interval[0];
            int end = interval[1];
            String key = start + " " + end;

            if (endC <= start) {
                scheduleMap.put(key, 'C');
                endC = end;
            } else if (endJ <= start) {
                scheduleMap.put(key, 'J');
                endJ = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (String time : times) {
            result.append(scheduleMap.get(time));
        }

        return result.toString();
    }
}