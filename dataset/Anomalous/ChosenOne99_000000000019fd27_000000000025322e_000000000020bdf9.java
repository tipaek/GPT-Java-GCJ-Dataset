import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            Map<Integer, Integer> jSchedule = new HashMap<>();
            Map<Integer, Integer> cSchedule = new HashMap<>();

            for (int i = 0; i < numberOfActivities; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                boolean canAssignToJ = true;
                boolean canAssignToC = true;

                for (Map.Entry<Integer, Integer> entry : jSchedule.entrySet()) {
                    int jStart = entry.getKey();
                    int jEnd = entry.getValue();
                    if ((startTime < jEnd && endTime > jStart) || startTime == jStart) {
                        canAssignToJ = false;
                        break;
                    }
                }

                if (canAssignToJ) {
                    jSchedule.put(startTime, endTime);
                    result.append("J");
                } else {
                    for (Map.Entry<Integer, Integer> entry : cSchedule.entrySet()) {
                        int cStart = entry.getKey();
                        int cEnd = entry.getValue();
                        if ((startTime < cEnd && endTime > cStart) || startTime == cStart) {
                            canAssignToC = false;
                            break;
                        }
                    }

                    if (canAssignToC) {
                        cSchedule.put(startTime, endTime);
                        result.append("C");
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                result.setLength(0); // Clear the current result
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}