import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                if (scanner.hasNextLine()) scanner.nextLine(); // Consume newline
            }

            int[] cameron = {-1, -1};
            int[] jamie = {-1, -1};
            String[] schedule = new String[n];
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                if (isAvailable(cameron, start, end)) {
                    cameron[0] = start;
                    cameron[1] = end;
                    schedule[i] = "C";
                } else if (isAvailable(jamie, start, end)) {
                    jamie[0] = start;
                    jamie[1] = end;
                    schedule[i] = "J";
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #" + t + ": ");
            if (isPossible) {
                for (String s : schedule) {
                    System.out.print(s);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        scanner.close();
    }

    private static boolean isAvailable(int[] person, int start, int end) {
        return start >= person[1] || end <= person[0];
    }
}