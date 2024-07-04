import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static int[] personOccupiedTime = new int[2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            personOccupiedTime[0] = -1;
            personOccupiedTime[1] = -1;
            int numJobs = scanner.nextInt();
            Map<Integer, Integer> startTimes = new HashMap<>();
            Map<Integer, Integer> endTimes = new HashMap<>();
            for (int job = 0; job < numJobs; job++) {
                startTimes.put(job, scanner.nextInt());
                endTimes.put(job, scanner.nextInt());
            }
            StringBuilder result = new StringBuilder();
            List<Map.Entry<Integer, Integer>> sortedEntries = startTimes.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toList());
            for (Map.Entry<Integer, Integer> entry : sortedEntries) {
                int startTime = entry.getValue();
                int endTime = endTimes.get(entry.getKey());
                String person = assignPerson(startTime, endTime);
                if (person == null) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                } else {
                    result.append(person);
                }
            }
            System.out.println(String.format("Case #%d: %s", testCase, result.toString()));
        }
    }

    private static String assignPerson(int startTime, int endTime) {
        for (int i = 0; i < 2; i++) {
            if (personOccupiedTime[i] <= startTime) {
                personOccupiedTime[i] = -1;
            }
        }
        if (personOccupiedTime[0] == -1) {
            personOccupiedTime[0] = endTime;
            return "C";
        } else if (personOccupiedTime[1] == -1) {
            personOccupiedTime[1] = endTime;
            return "J";
        }
        return null;
    }
}