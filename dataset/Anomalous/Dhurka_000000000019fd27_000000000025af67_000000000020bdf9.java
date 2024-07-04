import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] arrivals = new int[n];
            int[] departures = new int[n];

            for (int i = 0; i < n; i++) {
                arrivals[i] = scanner.nextInt();
                departures[i] = scanner.nextInt();
            }

            int jEnd = 0;
            int cEnd = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (arrivals[i] >= cEnd) {
                    cEnd = departures[i];
                    result.append("C");
                } else if (arrivals[i] >= jEnd) {
                    jEnd = departures[i];
                    result.append("J");
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