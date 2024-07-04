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

        for (int testCase = 0; testCase < t; testCase++) {
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
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            } else {
                populateMap(startTimes, endTimes);
                sortAndPrintSchedule(testCase);
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
        for (int i = 0; i < n; i++) {
            map.put(startTimes.get(i), endTimes.get(i).toString());
        }
    }

    private void sortAndPrintSchedule(int testCase) {
        TreeMap<Integer, String> sortedMap = new TreeMap<>(map);
        StringBuilder schedule = new StringBuilder("C");

        Iterator<Map.Entry<Integer, String>> iterator = sortedMap.entrySet().iterator();
        Map.Entry<Integer, String> previousEntry = iterator.next();

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> currentEntry = iterator.next();
            int prevEndTime = Integer.parseInt(previousEntry.getValue());
            int currStartTime = currentEntry.getKey();

            if (currStartTime >= prevEndTime) {
                schedule.append(schedule.charAt(schedule.length() - 1));
            } else {
                char lastChar = schedule.charAt(schedule.length() - 1);
                schedule.append(lastChar == 'C' ? 'J' : 'C');
            }

            previousEntry = currentEntry;
        }

        System.out.println("Case #" + (testCase + 1) + ": " + schedule);
    }
}