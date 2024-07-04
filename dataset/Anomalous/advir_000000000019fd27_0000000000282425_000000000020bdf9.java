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

            int[] cameron = {-1, -1};
            int[] jamie = {-1, -1};
            String[] schedule = new String[m];
            boolean impossible = false;

            for (int j = 0; j < m; j++) {
                boolean cameronBusy = isBusy(cameron, intervals[j]);
                boolean jamieBusy = isBusy(jamie, intervals[j]);

                if (cameronBusy && jamieBusy) {
                    impossible = true;
                    break;
                } else if (!cameronBusy) {
                    cameron = intervals[j];
                    schedule[j] = "C";
                } else {
                    jamie = intervals[j];
                    schedule[j] = "J";
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (String s : schedule) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }
        scanner.close();
    }

    private static boolean isBusy(int[] person, int[] interval) {
        return (interval[0] < person[1] && interval[1] > person[0]);
    }
}