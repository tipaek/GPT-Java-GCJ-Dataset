import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            Map<Integer, Integer> jMap = new HashMap<>();
            Map<Integer, Integer> cMap = new HashMap<>();

            for (int i = 0; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assigned = false;

                if (i % 2 == 0) {
                    if (canAssign(jMap, start, end)) {
                        jMap.put(start, end);
                        result.append("J");
                        assigned = true;
                    } else if (canAssign(cMap, start, end)) {
                        cMap.put(start, end);
                        result.append("C");
                        assigned = true;
                    }
                } else {
                    if (canAssign(cMap, start, end)) {
                        cMap.put(start, end);
                        result.append("C");
                        assigned = true;
                    } else if (canAssign(jMap, start, end)) {
                        jMap.put(start, end);
                        result.append("J");
                        assigned = true;
                    }
                }

                if (!assigned) {
                    impossible = true;
                }
            }

            if (impossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static boolean canAssign(Map<Integer, Integer> map, int start, int end) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int existingStart = entry.getKey();
            int existingEnd = entry.getValue();
            if ((start < existingEnd && end > existingStart) || start == existingStart) {
                return false;
            }
        }
        return true;
    }
}