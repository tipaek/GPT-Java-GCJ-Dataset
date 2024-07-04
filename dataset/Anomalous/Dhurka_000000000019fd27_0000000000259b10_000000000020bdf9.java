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

            int jStart = 0, jEnd = 0, cStart = 0, cEnd = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (arrival[i] >= jEnd) {
                    jEnd = departure[i];
                    result.append("J");
                    jStart = arrival[i];
                } else if (arrival[i] >= cEnd) {
                    cEnd = departure[i];
                    result.append("C");
                    cStart = arrival[i];
                } else if (departure[i] <= jStart) {
                    result.append("J");
                    jStart = arrival[i];
                    jEnd = departure[i];
                } else if (departure[i] <= cStart) {
                    result.append("C");
                    cStart = arrival[i];
                    cEnd = departure[i];
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