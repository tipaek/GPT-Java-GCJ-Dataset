import java.io.*;
import java.util.*;

class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        int testCase = 1;

        while (numberOfCases > 0) {
            int numberOfActivities = scanner.nextInt();
            int[] startTimes = new int[numberOfActivities];
            int[] endTimes = new int[numberOfActivities];
            HashMap<Integer, Integer> activityMap = new HashMap<>();

            for (int i = 0; i < numberOfActivities; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                activityMap.put(endTimes[i], startTimes[i]);
            }

            StringBuilder schedule = new StringBuilder("C");
            boolean isCameronAvailable = true;
            boolean isJamieAvailable = false;
            boolean isImpossible = false;
            int currentIndex = 1;
            int cameronEndTime = endTimes[0];
            int jamieEndTime = 0;

            while (currentIndex < numberOfActivities) {
                if (startTimes[currentIndex] >= cameronEndTime || startTimes[currentIndex] <= activityMap.get(cameronEndTime)) {
                    isCameronAvailable = false;
                    cameronEndTime = 0;
                }
                if (startTimes[currentIndex] >= jamieEndTime || startTimes[currentIndex] <= activityMap.get(jamieEndTime)) {
                    isJamieAvailable = false;
                    jamieEndTime = 0;
                }
                if (isCameronAvailable && isJamieAvailable) {
                    isImpossible = true;
                    break;
                } else if (!isCameronAvailable) {
                    isCameronAvailable = true;
                    schedule.append("C");
                    cameronEndTime = endTimes[currentIndex];
                } else if (!isJamieAvailable) {
                    isJamieAvailable = true;
                    schedule.append("J");
                    jamieEndTime = endTimes[currentIndex];
                } else {
                    isCameronAvailable = true;
                    schedule.append("J");
                    cameronEndTime = endTimes[currentIndex];
                }
                currentIndex++;
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + schedule.toString());
            }

            numberOfCases--;
            testCase++;
        }

        scanner.close();
    }
}