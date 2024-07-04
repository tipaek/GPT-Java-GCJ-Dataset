import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] arrival = new int[n];
            int[] departure = new int[n];

            for (int i = 0; i < n; i++) {
                arrival[i] = scanner.nextInt();
                departure[i] = scanner.nextInt();
            }

            int[] jTimes = new int[2];
            int[] cTimes = new int[2];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (arrival[i] >= jTimes[1] || departure[i] <= jTimes[0]) {
                    jTimes[1] = departure[i];
                    result.append("J");
                    jTimes[0] = arrival[i];
                } else if (arrival[i] >= cTimes[1] || departure[i] <= cTimes[0]) {
                    cTimes[1] = departure[i];
                    result.append("C");
                    cTimes[0] = arrival[i];
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