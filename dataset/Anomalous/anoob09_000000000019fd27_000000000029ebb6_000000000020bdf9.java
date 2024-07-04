import java.io.*;
import java.util.*;

class TEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int caseNumber = 1;
        
        while (testCases > 0) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            HashMap<Integer, Integer> startEndMap = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
                startEndMap.put(endTimes[i], startTimes[i]);
            }
            
            StringBuilder schedule = new StringBuilder("C");
            boolean isCameronAvailable = true;
            boolean isJamieAvailable = false;
            boolean isImpossible = false;
            int currentIndex = 1;
            int cameronEndTime = endTimes[0];
            int jamieEndTime = 0;
            
            while (currentIndex < n) {
                if (startTimes[currentIndex] >= cameronEndTime || startTimes[currentIndex] <= startEndMap.get(cameronEndTime)) {
                    isCameronAvailable = false;
                    cameronEndTime = 0;
                }
                if (startTimes[currentIndex] >= jamieEndTime || startTimes[currentIndex] <= startEndMap.get(jamieEndTime)) {
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
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }
            
            testCases--;
            caseNumber++;
        }
    }
}