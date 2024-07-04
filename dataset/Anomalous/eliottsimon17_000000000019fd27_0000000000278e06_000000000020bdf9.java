import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < testCount; i++) {
            int numberOfActivities = Integer.parseInt(scanner.nextLine());
            String[] schedules = new String[numberOfActivities];
            
            for (int j = 0; j < numberOfActivities; j++) {
                schedules[j] = scanner.nextLine();
            }
            
            System.out.println("Case #" + (i + 1) + ": " + findActivities(schedules));
        }
    }

    private static String findActivities(String[] schedules) {
        ArrayList<int[]> scheduleTimes = new ArrayList<>();
        
        for (String schedule : schedules) {
            int[] timeRange = Arrays.stream(schedule.split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
            scheduleTimes.add(timeRange);
        }
        
        StringBuilder result = new StringBuilder();
        String[] assignments = new String[scheduleTimes.size()];
        Arrays.fill(assignments, "J");
        
        for (int i = 0; i < scheduleTimes.size(); i++) {
            for (int j = i + 1; j < scheduleTimes.size(); j++) {
                if (isOverlapping(scheduleTimes.get(i), scheduleTimes.get(j))) {
                    if (assignments[i].equals(assignments[j])) {
                        if (assignments[i].equals("C")) {
                            return "IMPOSSIBLE";
                        } else {
                            assignments[j] = "C";
                        }
                    }
                }
            }
        }
        
        for (String assignment : assignments) {
            result.append(assignment);
        }
        
        return result.toString();
    }

    private static boolean isOverlapping(int[] time1, int[] time2) {
        return time1[1] > time2[0] && time1[0] < time2[1];
    }
}