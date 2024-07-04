import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            int[][] intervals = new int[m][2];

            for (int j = 0; j < m; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                if (scanner.hasNextLine()) scanner.nextLine(); // Consume newline
            }

            int[] jamie = {-1, -1};
            int[] cameron = {-1, -1};
            StringBuilder schedule = new StringBuilder();
            boolean isPossible = true;

            for (int j = 0; j < m; j++) {
                int start = intervals[j][0];
                int end = intervals[j][1];

                if (isOverlapping(start, end, cameron)) {
                    if (isOverlapping(start, end, jamie)) {
                        isPossible = false;
                        break;
                    } else {
                        jamie[0] = start;
                        jamie[1] = end;
                        schedule.append("J");
                    }
                } else {
                    cameron[0] = start;
                    cameron[1] = end;
                    schedule.append("C");
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            if (isPossible) {
                System.out.println(schedule.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        scanner.close();
    }

    private static boolean isOverlapping(int start, int end, int[] interval) {
        return (start < interval[1] && end > interval[0]);
    }
}