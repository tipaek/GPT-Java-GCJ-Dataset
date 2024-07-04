import java.util.*;

public class Solution {
    private int t, n;
    private Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.takeInputAndSolve();
    }

    private void takeInputAndSolve() {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < t; caseIndex++) {
            n = scanner.nextInt();
            List<Integer> startTimes = new ArrayList<>();
            List<Integer> endTimes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                startTimes.add(startTime);
                endTimes.add(endTime);
            }

            if (isImpossible(startTimes, endTimes)) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            } else {
                populateMap(startTimes, endTimes);
                String schedule = determineSchedule();
                System.out.println("Case #" + (caseIndex + 1) + ": " + schedule);
            }
        }
    }

    private boolean isImpossible(List<Integer> startTimes, List<Integer> endTimes) {
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (startTimes.get(i + 1) > startTimes.get(i) && endTimes.get(i + 1) < Collections.max(endTimes)) {
                count++;
            }
            if (count == 2) {
                return true;
            }
        }
        return false;
    }

    private void populateMap(List<Integer> startTimes, List<Integer> endTimes) {
        map.clear();
        for (int i = 0; i < n; i++) {
            map.put(startTimes.get(i), endTimes.get(i).toString());
        }
    }

    private String determineSchedule() {
        TreeMap<Integer, String> sortedMap = new TreeMap<>(map);
        StringBuilder schedule = new StringBuilder("C");

        for (int i = 0; i < n - 1; i++) {
            int currentStart = (Integer) sortedMap.keySet().toArray()[i];
            int nextStart = (Integer) sortedMap.keySet().toArray()[i + 1];
            int currentEnd = Integer.parseInt(sortedMap.get(currentStart));
            int nextEnd = Integer.parseInt(sortedMap.get(nextStart));

            if (nextStart > currentStart && (nextEnd < currentEnd || nextStart < currentEnd)) {
                if (schedule.charAt(schedule.length() - 1) == 'C') {
                    schedule.append("J");
                } else {
                    schedule.append("C");
                }
            } else {
                schedule.append(schedule.charAt(schedule.length() - 1));
            }
        }

        return schedule.toString();
    }
}