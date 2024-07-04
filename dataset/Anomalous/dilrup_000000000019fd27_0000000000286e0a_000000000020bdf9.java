import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
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

            int cameronStart = startTimes.get(0);
            int cameronEnd = schedule.get(cameronStart);
            startTimes.remove(0);

            int jamieStart = startTimes.get(0);
            int jamieEnd = schedule.get(jamieStart);
            startTimes.remove(0);

            boolean possible = true;

            while (!startTimes.isEmpty()) {
                int start = startTimes.get(0);
                startTimes.remove(0);
                int end = schedule.get(start);

                if (cameronEnd <= start) {
                    result.append("C");
                    cameronEnd = end;
                } else if (jamieEnd <= start) {
                    result.append("J");
                    jamieEnd = end;
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                result.insert(0, "CJ");
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}