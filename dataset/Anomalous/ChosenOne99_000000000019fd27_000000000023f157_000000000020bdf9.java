import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            Map<Integer, Integer> jSchedule = new HashMap<>();
            Map<Integer, Integer> cSchedule = new HashMap<>();

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assigned = false;

                // Check if the activity can be assigned to J
                for (Map.Entry<Integer, Integer> entry : jSchedule.entrySet()) {
                    int jStart = entry.getKey();
                    int jEnd = entry.getValue();
                    if ((start < jEnd && end > jStart) || start == jStart) {
                        assigned = true;
                        break;
                    }
                }

                if (!assigned) {
                    jSchedule.put(start, end);
                    result.append("J");
                } else {
                    assigned = false;

                    // Check if the activity can be assigned to C
                    for (Map.Entry<Integer, Integer> entry : cSchedule.entrySet()) {
                        int cStart = entry.getKey();
                        int cEnd = entry.getValue();
                        if ((start < cEnd && end > cStart) || start == cStart) {
                            assigned = true;
                            break;
                        }
                    }

                    if (!assigned) {
                        cSchedule.put(start, end);
                        result.append("C");
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}