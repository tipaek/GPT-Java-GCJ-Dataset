import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            char[] assignments = new char[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            int jEnd = 0, cEnd = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (startTimes[i] >= jEnd) {
                    assignments[i] = 'J';
                    jEnd = endTimes[i];
                } else if (startTimes[i] >= cEnd) {
                    assignments[i] = 'C';
                    cEnd = endTimes[i];
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.print("Case #" + caseNum + ": ");
            if (possible) {
                for (char ch : assignments) {
                    System.out.print(ch);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}