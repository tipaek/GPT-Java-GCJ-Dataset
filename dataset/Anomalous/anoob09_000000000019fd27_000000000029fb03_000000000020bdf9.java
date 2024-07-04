import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int numActivities = sc.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];

            for (int i = 0; i < numActivities; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
            }

            StringBuilder schedule = new StringBuilder("C");
            boolean cameronBusy = true;
            boolean jamieBusy = false;
            boolean isImpossible = false;

            int currentIndex = 1;
            int lastIndex = 0;
            int cameronEndTime = endTimes[0];
            int jamieEndTime = 0;

            while (currentIndex < numActivities) {
                if (startTimes[currentIndex] < endTimes[lastIndex]) {
                    if (cameronBusy && jamieBusy) {
                        isImpossible = true;
                        break;
                    } else if (!cameronBusy) {
                        cameronBusy = true;
                        schedule.append("C");
                        cameronEndTime = endTimes[currentIndex];
                    } else if (!jamieBusy) {
                        jamieBusy = true;
                        schedule.append("J");
                        jamieEndTime = endTimes[currentIndex];
                    } else {
                        schedule.append("C");
                        cameronBusy = true;
                        cameronEndTime = endTimes[currentIndex];
                    }
                    currentIndex++;
                } else {
                    if (cameronEndTime <= startTimes[currentIndex]) {
                        cameronBusy = false;
                        cameronEndTime = 0;
                    }
                    if (jamieEndTime <= startTimes[currentIndex]) {
                        jamieBusy = false;
                        jamieEndTime = 0;
                    }
                    lastIndex++;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }

            testCases--;
            caseNumber++;
        }

        sc.close();
    }
}