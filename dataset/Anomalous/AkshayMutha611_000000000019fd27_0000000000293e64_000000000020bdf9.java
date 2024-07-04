import java.util.*;

public class Solution {
    private int t, n, start_time, end_time;
    private Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.takeInputAndSolve();
    }

    private void takeInputAndSolve() {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();

        for (int a = 0; a < t; a++) {
            String outputString = "";
            n = scanner.nextInt();

            List<Integer> startTimes = new ArrayList<>();
            List<Integer> endTimes = new ArrayList<>();

            for (int b = 0; b < n; b++) {
                start_time = scanner.nextInt();
                end_time = scanner.nextInt();

                startTimes.add(start_time);
                endTimes.add(end_time);
            }

            if (isImpossible(startTimes, endTimes)) {
                outputString = "IMPOSSIBLE";
            } else {
                populateMap(startTimes, endTimes);
                outputString = generateOutputString();
            }

            System.out.println(outputString);
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

    private String generateOutputString() {
        TreeMap<Integer, String> sortedMap = new TreeMap<>(map);
        StringBuilder outputString = new StringBuilder("C");

        for (int i = 0; i < n - 1; i++) {
            int currentStart = (Integer) sortedMap.keySet().toArray()[i];
            int nextStart = (Integer) sortedMap.keySet().toArray()[i + 1];
            int currentEnd = Integer.parseInt(sortedMap.get(currentStart));
            int nextEnd = Integer.parseInt(sortedMap.get(nextStart));

            if (nextStart > currentStart && (nextEnd < currentEnd || nextStart < currentEnd)) {
                char lastChar = outputString.charAt(outputString.length() - 1);
                outputString.append(lastChar == 'C' ? 'J' : 'C');
            } else {
                outputString.append(outputString.charAt(outputString.length() - 1));
            }
        }

        return outputString.toString();
    }
}