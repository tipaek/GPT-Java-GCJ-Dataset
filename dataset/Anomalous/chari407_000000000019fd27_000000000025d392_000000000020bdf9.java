import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            int[] cameron = {0, 0};
            int[] jamie = {0, 0};
            boolean isImpossible = false;

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (cameron[1] <= start) {
                    cameron[0] = start;
                    cameron[1] = end;
                    schedule.append('C');
                } else if (jamie[1] <= start) {
                    jamie[0] = start;
                    jamie[1] = end;
                    schedule.append('J');
                } else {
                    isImpossible = true;
                    // Consume remaining input for this test case
                    for (int j = i + 1; j < numActivities; j++) {
                        scanner.nextInt(); // start
                        scanner.nextInt(); // end
                    }
                    break;
                }
            }

            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
            } else {
                System.out.printf("Case #%d: %s\n", testCase, schedule.toString());
            }
        }
    }
}