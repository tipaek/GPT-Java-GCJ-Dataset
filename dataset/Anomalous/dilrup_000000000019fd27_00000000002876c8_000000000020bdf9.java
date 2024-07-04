import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            Map<Integer, Integer> scheduleMap = new HashMap<>();
            List<Integer> startTimes = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                startTimes.add(start);
                scheduleMap.put(start, end);
            }

            Collections.sort(startTimes);
            int cameronEnd = 0, jamieEnd = 0;

            for (int start : startTimes) {
                int end = scheduleMap.get(start);
                if (cameronEnd <= start) {
                    result.append("C");
                    cameronEnd = end;
                } else if (jamieEnd <= start) {
                    result.append("J");
                    jamieEnd = end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}