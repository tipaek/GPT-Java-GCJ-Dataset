import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            int[][] intervals = new int[m][2];

            for (int j = 0; j < m; j++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[j][0] = Integer.parseInt(input[0]);
                intervals[j][1] = Integer.parseInt(input[1]);
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        scanner.close();
    }

    private static String assignTasks(int[][] intervals) {
        int[] jamie = new int[1440];
        int[] cameron = new int[1440];
        String[] schedule = new String[intervals.length];

        for (int i = 0; i < 1440; i++) {
            jamie[i] = 0;
            cameron[i] = 0;
        }

        for (int j = 0; j < intervals.length; j++) {
            int start = intervals[j][0];
            int stop = intervals[j][1];

            if (start == stop) {
                return "IMPOSSIBLE";
            }

            if (isFree(jamie, start, stop)) {
                markBusy(jamie, start, stop);
                schedule[j] = "J";
            } else if (isFree(cameron, start, stop)) {
                markBusy(cameron, start, stop);
                schedule[j] = "C";
            } else {
                return "IMPOSSIBLE";
            }
        }

        return String.join("", schedule);
    }

    private static boolean isFree(int[] schedule, int start, int stop) {
        for (int i = start; i < stop; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void markBusy(int[] schedule, int start, int stop) {
        for (int i = start; i < stop; i++) {
            schedule[i] = 1;
        }
    }
}