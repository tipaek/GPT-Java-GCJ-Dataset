import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTests = sc.nextInt();
        int testCase = 1;

        while (numberOfTests > 0) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            HashMap<Integer, Integer> timeMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
                timeMap.put(endTimes[i], startTimes[i]);
            }

            StringBuilder schedule = new StringBuilder("C");
            boolean isCameronAvailable = true;
            boolean isJamieAvailable = false;
            boolean isImpossible = false;
            int cameronEndTime = endTimes[0];
            int jamieEndTime = 0;

            for (int i = 1; i < n; i++) {
                if ((startTimes[i] >= cameronEndTime || startTimes[i] <= timeMap.get(cameronEndTime)) 
                        && (endTimes[i] >= cameronEndTime || endTimes[i] <= timeMap.get(cameronEndTime))) {
                    isCameronAvailable = false;
                    cameronEndTime = 0;
                }
                if (startTimes[i] >= jamieEndTime || startTimes[i] <= timeMap.get(jamieEndTime) 
                        && (endTimes[i] >= jamieEndTime || endTimes[i] <= timeMap.get(jamieEndTime))) {
                    isJamieAvailable = false;
                    jamieEndTime = 0;
                }

                if (isCameronAvailable && isJamieAvailable) {
                    isImpossible = true;
                    break;
                } else if (!isCameronAvailable) {
                    isCameronAvailable = true;
                    schedule.append("C");
                    cameronEndTime = endTimes[i];
                } else if (!isJamieAvailable) {
                    isJamieAvailable = true;
                    schedule.append("J");
                    jamieEndTime = endTimes[i];
                } else {
                    isCameronAvailable = true;
                    schedule.append("J");
                    cameronEndTime = endTimes[i];
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + schedule.toString());
            }

            numberOfTests--;
            testCase++;
        }
    }
}