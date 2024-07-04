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

            int[] jAvailability = new int[2];
            int[] cAvailability = new int[2];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (arrival[i] >= jAvailability[1] || departure[i] <= jAvailability[0]) {
                    jAvailability[1] = departure[i];
                    result.append("J");
                    jAvailability[0] = arrival[i];
                } else if (arrival[i] >= cAvailability[1] || departure[i] <= cAvailability[0]) {
                    cAvailability[1] = departure[i];
                    result.append("C");
                    cAvailability[0] = arrival[i];
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