import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfIntervals = scanner.nextInt();
            TreeMap<Integer, ArrayList<Integer>> intervalsMap = new TreeMap<>();

            for (int i = 0; i < numberOfIntervals; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                intervalsMap.computeIfAbsent(startTime, k -> new ArrayList<>()).add(endTime);
            }

            int cFreeTime = 0, jFreeTime = 0;
            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;

            outerLoop:
            for (var entry : intervalsMap.entrySet()) {
                int startTime = entry.getKey();
                for (int endTime : entry.getValue()) {
                    if (cFreeTime <= startTime) {
                        schedule.append("C");
                        cFreeTime = endTime;
                    } else if (jFreeTime <= startTime) {
                        schedule.append("J");
                        jFreeTime = endTime;
                    } else {
                        isPossible = false;
                        break outerLoop;
                    }
                }
            }

            String result = isPossible ? schedule.toString() : "IMPOSSIBLE";
            System.out.println(String.format("Case #%d: %s", testCase, result));
        }
    }
}