import java.util.Scanner;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            StringBuilder schedule = new StringBuilder("C");
            boolean cameronBusy = true;
            boolean jamieBusy = false;
            boolean impossible = false;
            int i = 1, k = 0;
            int cameronEndTime = endTimes[0];
            int jamieEndTime = 0;

            while (i < n) {
                if (startTimes[i] < endTimes[k]) {
                    if (cameronBusy && jamieBusy) {
                        impossible = true;
                        break;
                    } else if (!cameronBusy) {
                        cameronBusy = true;
                        schedule.append("C");
                        cameronEndTime = endTimes[i];
                    } else if (!jamieBusy) {
                        jamieBusy = true;
                        schedule.append("J");
                        jamieEndTime = endTimes[i];
                    } else {
                        schedule.append("C");
                        cameronBusy = true;
                        cameronEndTime = endTimes[i];
                    }
                    i++;
                } else {
                    if (cameronEndTime <= startTimes[i]) {
                        cameronBusy = false;
                        cameronEndTime = 0;
                    }
                    if (jamieEndTime <= startTimes[i]) {
                        jamieBusy = false;
                        jamieEndTime = 0;
                    }
                    k++;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule);
            }

            testCases--;
            caseNumber++;
        }
        scanner.close();
    }
}