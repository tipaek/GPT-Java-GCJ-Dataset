import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int[] cameron = new int[24 * 60];
        int[] jamie = new int[24 * 60];

        for (int k = 1; k <= t; k++) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            Arrays.fill(cameron, 24 * 60);
            Arrays.fill(jamie, 24 * 60);

            for (int i = 0; i < n; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isImpossible) {
                    continue;
                }

                if (canAssignTask(cameron, startTime, endTime)) {
                    assignTask(cameron, startTime, endTime);
                    result.append("C");
                } else if (canAssignTask(jamie, startTime, endTime)) {
                    assignTask(jamie, startTime, endTime);
                    result.append("J");
                } else {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + k + ": " + result.toString());
            }
        }
    }

    private static boolean canAssignTask(int[] schedule, int startTime, int endTime) {
        return schedule[startTime] >= (endTime - startTime);
    }

    private static void assignTask(int[] schedule, int startTime, int endTime) {
        int temp = startTime - 1;
        int br = 1;
        while (temp >= 0 && schedule[temp] > 0) {
            schedule[temp] = br++;
            temp--;
        }

        for (int j = startTime; j < endTime; j++) {
            schedule[j] = 0;
        }
    }
}