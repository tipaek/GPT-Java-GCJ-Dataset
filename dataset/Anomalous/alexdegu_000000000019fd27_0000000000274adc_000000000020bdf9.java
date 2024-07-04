import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        int[] cameron = new int[24 * 60];
        int[] jamie = new int[24 * 60];

        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt(); // Number of activities
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            // Initialize the arrays
            Arrays.fill(cameron, 24 * 60);
            Arrays.fill(jamie, 24 * 60);

            for (int i = 0; i < n; i++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();

                if (!isImpossible) {
                    if (cameron[startTime] >= endTime - startTime) {
                        assignTask(cameron, startTime, endTime);
                        schedule.append("C");
                    } else if (jamie[startTime] >= endTime - startTime) {
                        assignTask(jamie, startTime, endTime);
                        schedule.append("J");
                    } else {
                        isImpossible = true;
                    }
                }
            }

            String result = isImpossible ? "IMPOSSIBLE" : schedule.toString();
            System.out.println("Case #" + k + ": " + result);
        }
    }

    private static void assignTask(int[] person, int startTime, int endTime) {
        int temp = startTime - 1;
        int decrement = 1;
        while (temp >= 0 && person[temp] > 0) {
            person[temp] = decrement;
            decrement++;
            temp--;
        }
        Arrays.fill(person, startTime, endTime, 0);
    }
}