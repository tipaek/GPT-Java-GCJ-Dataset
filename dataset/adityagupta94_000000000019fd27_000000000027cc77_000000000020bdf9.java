import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static int[] personOccupiedTime = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for (int count = 0; count < numTestCases; count++) {
            personOccupiedTime[0] = -1;
            personOccupiedTime[1] = -1;
            int numJobs = sc.nextInt();
            Map<Integer, Integer> startTimes = new HashMap<>();
            Map<Integer, Integer> endTimes = new HashMap<>();
            for (int i = 0; i < numJobs; i++) {
                startTimes.put(i, sc.nextInt());
                endTimes.put(i, sc.nextInt());
            }
            String result = "";
            List<Map.Entry<Integer, Integer>> entries = startTimes.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
            for (Map.Entry<Integer, Integer> entry : entries) {
                int startTime = entry.getValue();
                int endTime = endTimes.get(entry.getKey());
                String person = getAvailablePerson(startTime, endTime);
                if (Objects.isNull(person)) {
                    result = "IMPOSSIBLE";
                    break;
                } else {
                    result = result.concat(person);
                }
            }
            System.out.println(String.format("Case #%s: %s", count + 1, result));
        }
    }

    private static String getAvailablePerson(int startTime, int endTime) {
        for (int i = 0; i < 2; i++) {
            if (personOccupiedTime[i] <= startTime) {
                personOccupiedTime[i] = -1;
            }
        }
        String person = null;
        if (personOccupiedTime[0] == -1) {
            person = "C";
            personOccupiedTime[0] = endTime;
        } else if (personOccupiedTime[1] == -1) {
            person = "J";
            personOccupiedTime[1] = endTime;
        }
        return person;
    }

}
