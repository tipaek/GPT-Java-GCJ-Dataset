import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String result = assignTasks(n, scanner);
            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }

    private static String assignTasks(int n, Scanner scanner) {
        boolean[] cTime = new boolean[1440];
        boolean[] jTime = new boolean[1440];
        StringBuilder output = new StringBuilder();

        for (int j = 0; j < n; j++) {
            String[] times = scanner.nextLine().split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);

            boolean cAvailable = isTimeSlotAvailable(cTime, start, end);
            boolean jAvailable = isTimeSlotAvailable(jTime, start, end);

            if (cAvailable) {
                output.append("C");
                fillTimeSlot(cTime, start, end);
            } else if (jAvailable) {
                output.append("J");
                fillTimeSlot(jTime, start, end);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return output.toString();
    }

    private static boolean isTimeSlotAvailable(boolean[] timeArray, int start, int end) {
        for (int k = start; k < end; k++) {
            if (timeArray[k]) {
                return false;
            }
        }
        return true;
    }

    private static void fillTimeSlot(boolean[] timeArray, int start, int end) {
        for (int k = start; k < end; k++) {
            timeArray[k] = true;
        }
    }
}