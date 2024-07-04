import java.util.Scanner;
import java.util.Arrays;

public class ParentingPartneringReturns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            boolean[] cTime = new boolean[1440];
            boolean[] jTime = new boolean[1440];
            StringBuilder output = new StringBuilder("CJ");

            scanner.nextLine(); // Consume the newline character

            String firstTask = scanner.nextLine();
            String secondTask = scanner.nextLine();

            fillTimeArray(cTime, firstTask);
            fillTimeArray(jTime, secondTask);

            boolean possible = true;

            for (int j = 2; j < n; j++) {
                String task = scanner.nextLine();
                int start = Integer.parseInt(task.split(" ")[0]);
                int end = Integer.parseInt(task.split(" ")[1]);

                boolean cAvailable = isTimeSlotAvailable(cTime, start, end);
                boolean jAvailable = isTimeSlotAvailable(jTime, start, end);

                if (cAvailable) {
                    output.append("C");
                    fillTimeArray(cTime, start, end);
                } else if (jAvailable) {
                    output.append("J");
                    fillTimeArray(jTime, start, end);
                } else {
                    output = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + output);
        }

        scanner.close();
    }

    private static void fillTimeArray(boolean[] timeArray, String task) {
        String[] times = task.split(" ");
        int start = Integer.parseInt(times[0]);
        int end = Integer.parseInt(times[1]);

        Arrays.fill(timeArray, start, end == 1440 ? end : end + 1, true);
    }

    private static void fillTimeArray(boolean[] timeArray, int start, int end) {
        Arrays.fill(timeArray, start, end == 1440 ? end : end + 1, true);
    }

    private static boolean isTimeSlotAvailable(boolean[] timeArray, int start, int end) {
        for (int i = start; i < end; i++) {
            if (timeArray[i]) {
                return false;
            }
        }
        return true;
    }
}