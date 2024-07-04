import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activities = scanner.nextInt();
            int[] jamieSchedule = new int[1440];
            int[] cameronSchedule = new int[1440];
            StringBuilder result = new StringBuilder();

            outerLoop:
            for (int i = 0; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (result.toString().equals("IMPOSSIBLE")) {
                    continue;
                }

                boolean canJamieDoIt = true;
                for (int j = start; j < end; j++) {
                    if (jamieSchedule[j] == 1) {
                        canJamieDoIt = false;
                        break;
                    }
                }

                if (canJamieDoIt) {
                    for (int j = start; j < end; j++) {
                        jamieSchedule[j] = 1;
                    }
                    result.append("J");
                } else {
                    boolean canCameronDoIt = true;
                    for (int j = start; j < end; j++) {
                        if (cameronSchedule[j] == 1) {
                            canCameronDoIt = false;
                            break;
                        }
                    }

                    if (canCameronDoIt) {
                        for (int j = start; j < end; j++) {
                            cameronSchedule[j] = 1;
                        }
                        result.append("C");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}