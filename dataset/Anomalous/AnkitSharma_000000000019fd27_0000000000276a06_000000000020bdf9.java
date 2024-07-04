import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean[] cSchedule = new boolean[1440];
            boolean[] jSchedule = new boolean[1440];
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignToC = true;
                boolean canAssignToJ = true;

                for (int k = start; k < end; k++) {
                    if (cSchedule[k]) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (canAssignToC) {
                    for (int k = start; k < end; k++) {
                        cSchedule[k] = true;
                    }
                    result.append("C");
                } else {
                    for (int k = start; k < end; k++) {
                        if (jSchedule[k]) {
                            canAssignToJ = false;
                            break;
                        }
                    }

                    if (canAssignToJ) {
                        for (int k = start; k < end; k++) {
                            jSchedule[k] = true;
                        }
                        result.append("J");
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (!isPossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}