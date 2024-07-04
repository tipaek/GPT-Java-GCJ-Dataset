import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            int[] scheduleC = new int[1440];
            int[] scheduleJ = new int[1440];
            boolean isImpossible = false;

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assignedToC = true;

                if (!isImpossible) {
                    boolean isOccupied = false;

                    // Check if Cameron can take the activity
                    for (int j = start; j < end; j++) {
                        if (scheduleC[j] != 0) {
                            isOccupied = true;
                            break;
                        }
                    }

                    if (!isOccupied) {
                        for (int j = start; j < end; j++) {
                            scheduleC[j]++;
                        }
                    } else {
                        assignedToC = false;
                        isOccupied = false;

                        // Check if Jamie can take the activity
                        for (int j = start; j < end; j++) {
                            if (scheduleJ[j] != 0) {
                                isOccupied = true;
                                break;
                            }
                        }

                        if (!isOccupied) {
                            for (int j = start; j < end; j++) {
                                scheduleJ[j]++;
                            }
                        } else {
                            isImpossible = true;
                        }
                    }
                }

                result.append(assignedToC ? "C" : "J");
            }

            if (isImpossible) {
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}