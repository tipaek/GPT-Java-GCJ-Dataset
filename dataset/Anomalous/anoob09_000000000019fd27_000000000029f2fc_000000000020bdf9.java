import java.util.Scanner;

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                endTimes[i] = sc.nextInt();
            }

            StringBuilder schedule = new StringBuilder("C");
            boolean cBusy = true;
            boolean jBusy = false;
            boolean isImpossible = false;
            int i = 1, k = 0;
            int cEndTime = endTimes[0];
            int jEndTime = 0;

            while (i < n) {
                if (startTimes[i] < endTimes[k]) {
                    if (cBusy && jBusy) {
                        isImpossible = true;
                        break;
                    } else if (!cBusy) {
                        cBusy = true;
                        schedule.append("C");
                        cEndTime = endTimes[i];
                    } else if (!jBusy) {
                        jBusy = true;
                        schedule.append("J");
                        jEndTime = endTimes[i];
                    } else {
                        schedule.append("C");
                        cBusy = true;
                        cEndTime = endTimes[i];
                    }
                    i++;
                } else {
                    if (cEndTime <= startTimes[i]) {
                        cBusy = false;
                        cEndTime = 0;
                    }
                    if (jEndTime <= startTimes[i]) {
                        jBusy = false;
                        jEndTime = 0;
                    }
                    k++;
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
    }
}