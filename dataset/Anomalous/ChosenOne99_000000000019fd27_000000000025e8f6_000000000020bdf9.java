import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            String result = "";
            TreeMap<Integer, Integer> primaryMap = new TreeMap<>();
            TreeMap<Integer, Integer> secondaryMap = new TreeMap<>();

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (!primaryMap.containsKey(start)) {
                    primaryMap.put(start, end);
                } else if (!secondaryMap.containsKey(start)) {
                    secondaryMap.put(start, end);
                } else {
                    result = "IMPOSSIBLE";
                }
            }

            Map<Integer, Integer> jMap = new HashMap<>();
            Map<Integer, Integer> cMap = new HashMap<>();

            while (!result.equals("IMPOSSIBLE") && (!primaryMap.isEmpty() || !secondaryMap.isEmpty())) {
                int start, end;

                if (primaryMap.isEmpty()) {
                    start = secondaryMap.firstKey();
                    end = secondaryMap.remove(start);
                } else if (secondaryMap.isEmpty()) {
                    start = primaryMap.firstKey();
                    end = primaryMap.remove(start);
                } else if (primaryMap.firstKey() <= secondaryMap.firstKey()) {
                    start = primaryMap.firstKey();
                    end = primaryMap.remove(start);
                } else {
                    start = secondaryMap.firstKey();
                    end = secondaryMap.remove(start);
                }

                if (isTimeSlotAvailable(jMap, start, end)) {
                    jMap.put(start, end);
                    result += "C";
                } else if (isTimeSlotAvailable(cMap, start, end)) {
                    cMap.put(start, end);
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }

        scanner.close();
    }

    private static boolean isTimeSlotAvailable(Map<Integer, Integer> map, int start, int end) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int entryStart = entry.getKey();
            int entryEnd = entry.getValue();

            if ((start < entryStart && entryStart < end) || (start == entryStart) || 
                (start > entryStart && start < entryEnd)) {
                return false;
            }
        }
        return true;
    }
}