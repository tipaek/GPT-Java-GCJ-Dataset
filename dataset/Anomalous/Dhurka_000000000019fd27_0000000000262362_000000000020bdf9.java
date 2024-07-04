import java.util.Scanner;

public class Solution {
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

            int[] schedule = new int[4];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (arrivalTimes[i] >= schedule[1] || departureTimes[i] <= schedule[0]) {
                    schedule[1] = departureTimes[i];
                    result.append("J");
                    schedule[0] = arrivalTimes[i];
                } else if (arrivalTimes[i] >= schedule[3] || departureTimes[i] <= schedule[2]) {
                    schedule[3] = departureTimes[i];
                    result.append("C");
                    schedule[2] = arrivalTimes[i];
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}