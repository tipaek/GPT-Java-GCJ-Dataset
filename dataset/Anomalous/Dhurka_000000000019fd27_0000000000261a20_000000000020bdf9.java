import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] arrivalTimes = new int[n];
            int[] departureTimes = new int[n];

            for (int i = 0; i < n; i++) {
                arrivalTimes[i] = scanner.nextInt();
                departureTimes[i] = scanner.nextInt();
            }

            int[] jSchedule = new int[2];
            int[] cSchedule = new int[2];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (arrivalTimes[i] >= jSchedule[1] || departureTimes[i] <= jSchedule[0]) {
                    jSchedule[1] = departureTimes[i];
                    result.append("J");
                    jSchedule[0] = arrivalTimes[i];
                } else if (arrivalTimes[i] >= cSchedule[1] || departureTimes[i] <= cSchedule[0]) {
                    cSchedule[1] = departureTimes[i];
                    result.append("C");
                    cSchedule[0] = arrivalTimes[i];
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }

        scanner.close();
    }
}