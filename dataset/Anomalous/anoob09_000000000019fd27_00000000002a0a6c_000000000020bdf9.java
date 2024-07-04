import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        int currentTestCase = 1;

        while (testCaseCount > 0) {
            int activityCount = sc.nextInt();
            int[] startTimes = new int[activityCount];
            int[] endTimes = new int[activityCount];
            HashMap<Integer, Integer> endToStartMap = new HashMap<>();

            for (int i = 0; i < activityCount; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
                endToStartMap.putIfAbsent(endTimes[i], startTimes[i]);
            }

            StringBuilder schedule = new StringBuilder("C");
            boolean cameronAvailable = true;
            boolean jamieAvailable = false;
            boolean isImpossible = false;
            int cameronEndTime = endTimes[0];
            int jamieEndTime = 0;

            for (int i = 1; i < activityCount; i++) {
                int currentStart = startTimes[i];
                int currentEnd = endTimes[i];

                boolean canCameronTake = (currentStart >= cameronEndTime || currentStart <= endToStartMap.get(cameronEndTime)) &&
                                         (currentEnd >= cameronEndTime || currentEnd <= endToStartMap.get(cameronEndTime));
                boolean canJamieTake = (currentStart >= jamieEndTime || currentStart <= endToStartMap.get(jamieEndTime)) &&
                                       (currentEnd >= jamieEndTime || currentEnd <= endToStartMap.get(jamieEndTime));

                if (canCameronTake && canJamieTake) {
                    isImpossible = true;
                    break;
                } else if (canCameronTake) {
                    cameronAvailable = true;
                    schedule.append("C");
                    cameronEndTime = currentEnd;
                } else if (canJamieTake) {
                    jamieAvailable = true;
                    schedule.append("J");
                    jamieEndTime = currentEnd;
                } else {
                    cameronAvailable = true;
                    schedule.append("J");
                    cameronEndTime = currentEnd;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + currentTestCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + currentTestCase + ": " + schedule.toString());
            }

            testCaseCount--;
            currentTestCase++;
        }

        sc.close();
    }
}