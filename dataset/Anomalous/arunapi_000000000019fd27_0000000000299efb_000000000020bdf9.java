import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int numActivities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            int[] minuteOccupation = new int[25 * 60];
            Arrays.fill(minuteOccupation, -1);

            boolean isPossible = true;
            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int freeStatus = -1;

                for (int k = start; k <= end; k++) {
                    if (minuteOccupation[k] > freeStatus) {
                        if (minuteOccupation[k] == 0) {
                            freeStatus = 0;
                        } else if (minuteOccupation[k] == 1) {
                            freeStatus = 1;
                        } else {
                            freeStatus = minuteOccupation[k];
                            break;
                        }
                    }
                }

                if (freeStatus == -1 || freeStatus == 0) {
                    schedule.append('C');
                    updateOccupation(minuteOccupation, start, end, 2);
                } else if (freeStatus == 1) {
                    schedule.append('J');
                    updateOccupation(minuteOccupation, start, end, 1);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    private static void updateOccupation(int[] minuteOccupation, int start, int end, int person) {
        for (int k = start; k <= end; k++) {
            minuteOccupation[k] += person;
        }
    }
}