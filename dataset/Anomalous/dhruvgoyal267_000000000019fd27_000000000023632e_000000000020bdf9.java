import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            HashMap<String, ArrayList<Integer>> scheduleMap = new HashMap<>();
            scheduleMap.put("J", new ArrayList<>());
            scheduleMap.put("C", new ArrayList<>());

            boolean isPossible = true;
            String[] result = new String[n];

            for (int i = 0; i < n; i++) {
                if (canSchedule(scheduleMap.get("J"), startTimes, endTimes, i)) {
                    scheduleMap.get("J").add(i);
                    result[i] = "J";
                } else if (canSchedule(scheduleMap.get("C"), startTimes, endTimes, i)) {
                    scheduleMap.get("C").add(i);
                    result[i] = "C";
                } else {
                    isPossible = false;
                    break;
                }
            }

            String output = isPossible ? String.join("", result) : "IMPOSSIBLE";
            System.out.println("Case #" + caseNumber + ": " + output);
            caseNumber++;
        }
    }

    private static boolean canSchedule(ArrayList<Integer> schedule, int[] startTimes, int[] endTimes, int currentIndex) {
        for (int index : schedule) {
            if (startTimes[currentIndex] < endTimes[index] && endTimes[currentIndex] > startTimes[index]) {
                return false;
            }
        }
        return true;
    }
}