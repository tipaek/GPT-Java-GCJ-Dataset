import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            ArrayList<int[]> cameron = new ArrayList<>();
            ArrayList<int[]> jamie = new ArrayList<>();
            int numActivities = Integer.parseInt(scanner.nextLine());
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < numActivities; i++) {
                int[] timeSlot = parseTimeSlot(scanner.nextLine());

                if (timeSlot.length <= 1) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }

                if (!hasOverlap(jamie, timeSlot)) {
                    jamie.add(timeSlot);
                    result.append("J");
                } else if (!hasOverlap(cameron, timeSlot)) {
                    cameron.add(timeSlot);
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static int[] parseTimeSlot(String timeSlot) {
        String[] parts = timeSlot.split(" ");
        int[] times = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            times[i] = Integer.parseInt(parts[i]);
        }
        return times;
    }

    private static boolean hasOverlap(ArrayList<int[]> schedule, int[] timeSlot) {
        for (int[] slot : schedule) {
            if (isOverlapping(slot, timeSlot)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverlapping(int[] slot1, int[] slot2) {
        return (slot1[0] < slot2[1] && slot1[1] > slot2[0]);
    }
}