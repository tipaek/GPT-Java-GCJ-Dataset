import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            TreeMap<Integer, Integer> intervals = new TreeMap<>();
            Map<Integer, String> assignments = new LinkedHashMap<>();
            int n = scanner.nextInt();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.put(start, end);
                assignments.put(start, "");
            }

            StringBuilder result = new StringBuilder();
            int cEnd = 0, jEnd = 0, assignedCount = 0;

            for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
                int start = entry.getKey();
                int end = entry.getValue();

                if (cEnd <= start) {
                    cEnd = end;
                    assignments.put(start, "C");
                    assignedCount++;
                } else if (jEnd <= start) {
                    jEnd = end;
                    assignments.put(start, "J");
                    assignedCount++;
                }
            }

            if (assignedCount < n) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                for (String value : assignments.values()) {
                    result.append(value);
                }
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
    }
}