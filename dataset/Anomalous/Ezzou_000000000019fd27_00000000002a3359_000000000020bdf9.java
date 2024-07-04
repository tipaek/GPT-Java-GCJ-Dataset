import java.io.IOException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        executeAlgorithm();
    }

    static void executeAlgorithm() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = Integer.parseInt(scanner.nextLine().trim());
            int[] timeSlots = new int[1441];
            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int activity = 0; activity < numActivities; activity++) {
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);

                if (!impossible && canSchedule(timeSlots, start, end)) {
                    int maxIndex = timeSlots[start];
                    for (int time = start; time <= end; time++) {
                        maxIndex = Math.max(timeSlots[time], maxIndex);
                    }
                    result.append(maxIndex == 1 ? "C" : "J");
                } else {
                    impossible = true;
                }
            }

            if (impossible) {
                result.setLength(0);
                result.append("IMPOSSIBLE");
            }

            System.out.printf("Case #%d: %s%n", testCase, result.toString());
        }
    }

    static boolean canSchedule(int[] timeSlots, int start, int end) {
        for (int time = Math.max(0, start); time <= Math.min(timeSlots.length - 1, end); time++) {
            if (timeSlots[time] > 1 && time != start && time != end) {
                return false;
            }
            timeSlots[time]++;
        }
        return true;
    }
}