import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(System.out)) {

            int testcases = Integer.parseInt(br.readLine().trim());

            for (int j = 0; j < testcases; j++) {
                int activities = Integer.parseInt(br.readLine().trim());
                Map<Integer, Integer> JTime = new HashMap<>();
                Map<Integer, Integer> CTime = new HashMap<>();
                StringBuilder turns = new StringBuilder();
                boolean isImpossible = false;

                for (int k = 0; k < activities; k++) {
                    String[] time = br.readLine().trim().split("\\s+");
                    int startTime = Integer.parseInt(time[0]);
                    int endTime = Integer.parseInt(time[1]);

                    boolean problemToJ = overlapsWithExistingTime(JTime, startTime, endTime);
                    boolean problemToC = overlapsWithExistingTime(CTime, startTime, endTime);

                    if (!problemToJ) {
                        JTime.put(startTime, endTime);
                        turns.append("J");
                    } else if (!problemToC) {
                        CTime.put(startTime, endTime);
                        turns.append("C");
                    } else {
                        isImpossible = true;
                        break;
                    }
                }

                if (isImpossible) {
                    pw.println("Case #" + (j + 1) + ": IMPOSSIBLE");
                } else {
                    pw.println("Case #" + (j + 1) + ": " + turns.toString());
                }
            }
        }
    }

    private static boolean overlapsWithExistingTime(Map<Integer, Integer> timeMap, int startTime, int endTime) {
        for (Map.Entry<Integer, Integer> entry : timeMap.entrySet()) {
            int existingStartTime = entry.getKey();
            int existingEndTime = entry.getValue();
            if ((startTime >= existingStartTime && startTime < existingEndTime) ||
                (endTime > existingStartTime && endTime <= existingEndTime)) {
                return true;
            }
        }
        return false;
    }
}