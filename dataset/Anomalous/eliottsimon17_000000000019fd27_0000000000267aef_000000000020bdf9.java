import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(in.nextLine());

        for (int i = 0; i < testCount; i++) {
            int numberOfActivities = Integer.parseInt(in.nextLine());
            String[] schedules = new String[numberOfActivities];

            for (int j = 0; j < numberOfActivities; j++) {
                schedules[j] = in.nextLine();
            }

            String result = findActivities(schedules);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String findActivities(String[] schedules) {
        ArrayList<int[]> scheduleTimes = new ArrayList<>();

        for (String schedule : schedules) {
            int[] times = Arrays.stream(schedule.split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            scheduleTimes.add(times);
        }

        String[] assignments = new String[schedules.length];
        Arrays.fill(assignments, "");

        for (int i = 0; i < scheduleTimes.size(); i++) {
            if (assignments[i].isEmpty()) {
                assignments[i] = "J";
            }

            for (int j = i + 1; j < scheduleTimes.size(); j++) {
                if (assignments[j].isEmpty()) {
                    if (overlap(scheduleTimes.get(i), scheduleTimes.get(j))) {
                        assignments[j] = assignments[i].equals("J") ? "C" : "J";
                    } else {
                        assignments[j] = assignments[i];
                    }
                } else if (overlap(scheduleTimes.get(i), scheduleTimes.get(j)) && assignments[i].equals(assignments[j])) {
                    return "IMPOSSIBLE";
                }
            }
        }

        return String.join("", assignments);
    }

    private static boolean overlap(int[] a, int[] b) {
        return a[1] > b[0] && a[0] < b[1];
    }
}