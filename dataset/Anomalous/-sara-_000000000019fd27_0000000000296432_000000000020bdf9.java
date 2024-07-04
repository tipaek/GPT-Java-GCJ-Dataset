import java.util.*;
import java.util.stream.Collectors;

public abstract class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            Integer[] overlaps = new Integer[1440];
            Arrays.fill(overlaps, 0);
            Map<Integer, Integer> beginTimes = new HashMap<>();
            Map<Integer, Integer> endTimes = new HashMap<>();

            for (int j = 0; j < n; j++) {
                int beginTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                beginTimes.put(j, beginTime);
                endTimes.put(j, endTime);
                for (int k = beginTime; k < endTime; k++) {
                    overlaps[k]++;
                }
            }

            List<Integer> overlapList = Arrays.asList(overlaps);
            String solution = "";

            if (overlapList.contains(3)) {
                solution = "IMPOSSIBLE";
            } else if (!overlapList.contains(2)) {
                solution = "J".repeat(n);
            } else {
                Map<Integer, String> assignments = new HashMap<>();
                int endTime = -1;
                String lastAssignment = "J";

                Map<Integer, Integer> sortedMap = beginTimes.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        ));

                for (int choreNumber : sortedMap.keySet()) {
                    int beginTime = beginTimes.get(choreNumber);
                    if (assignments.isEmpty()) {
                        assignments.put(choreNumber, "J");
                        endTime = endTimes.get(choreNumber);
                    } else {
                        if (beginTime >= endTime) {
                            assignments.put(choreNumber, lastAssignment);
                        } else if (lastAssignment.equals("J")) {
                            assignments.put(choreNumber, "C");
                            lastAssignment = "C";
                        } else {
                            assignments.put(choreNumber, "J");
                            lastAssignment = "J";
                        }
                        endTime = endTimes.get(choreNumber);
                    }
                }

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(assignments.get(j));
                }
                solution = sb.toString();
            }

            System.out.println("Case #" + i + ": " + solution);
        }

        scanner.close();
    }
}