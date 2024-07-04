import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());
        int caseNumber = 0;

        while (caseNumber++ < testCases) {
            int n = scanner.nextInt();
            int[] schedule = new int[24 * 60 + 1];
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                if (!isImpossible) {
                    for (int j = startTimes[i]; j < endTimes[i]; j++) {
                        schedule[j]++;
                        if (schedule[j] > 2) {
                            isImpossible = true;
                            break;
                        }
                    }
                }
            }

            String result;
            if (isImpossible) {
                result = "IMPOSSIBLE";
            } else {
                char[] assignments = new char[n];
                for (int i = 0; i < n; i++) {
                    boolean canBeC = true;

                    for (int j = startTimes[i]; j < endTimes[i]; j++) {
                        if (schedule[j] < 0) {
                            canBeC = false;
                            break;
                        }
                    }

                    if (canBeC) {
                        for (int j = startTimes[i]; j < endTimes[i]; j++) {
                            schedule[j] *= -1;
                        }
                    }

                    assignments[i] = canBeC ? 'C' : 'J';
                }
                result = new String(assignments);
            }

            System.out.printf("Case #%d: %s\n", caseNumber, result);
        }

        scanner.close();
    }
}