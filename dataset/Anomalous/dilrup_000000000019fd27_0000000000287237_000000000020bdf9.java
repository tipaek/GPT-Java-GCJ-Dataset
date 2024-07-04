import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            Map<Integer, Integer> schedule = new HashMap<>();
            List<Integer> startTimes = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                startTimes.add(start);
                schedule.put(start, end);
            }

            Collections.sort(startTimes);
            int cStart = startTimes.get(0);
            int cEnd = schedule.get(cStart);
            startTimes.remove(0);

            int jStart = startTimes.get(0);
            int jEnd = schedule.get(jStart);
            startTimes.remove(0);

            result.append("CJ");

            while (!startTimes.isEmpty()) {
                int start = startTimes.remove(0);
                int end = schedule.get(start);

                if (cEnd <= start) {
                    result.append("C");
                    cEnd = end;
                } else if (jEnd <= start) {
                    result.append("J");
                    jEnd = end;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}