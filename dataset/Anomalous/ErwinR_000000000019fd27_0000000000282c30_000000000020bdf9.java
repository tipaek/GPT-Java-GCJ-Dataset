import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        // Loop through each test case
        for (int i = 0; i < testCases; i++) {
            int caseNumber = i + 1;
            String result = "";

            // Read the number of schedule entries
            int n = sc.nextInt();
            int[][] schedule = new int[n][2];
            for (int k = 0; k < n; k++) {
                schedule[k][0] = sc.nextInt();
                schedule[k][1] = sc.nextInt();
            }

            int cEnd = 0; // Cameron's end time
            int jEnd = 0; // Jamie's end time

            for (int k = 0; k < n; k++) {
                if (schedule[k][0] >= cEnd) {
                    cEnd = schedule[k][1];
                    result += "C";
                } else if (schedule[k][0] >= jEnd) {
                    jEnd = schedule[k][1];
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + caseNumber + ": " + result);
        }

        sc.close();
    }
}