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
                boolean cameronBusy = (intervals[j][0] < cameron[1]);
                boolean jamieBusy = (intervals[j][0] < jamie[1]);

                if (!cameronBusy) {
                    cameron[0] = intervals[j][0];
                    cameron[1] = intervals[j][1];
                    schedule[j] = "C";
                } else if (!jamieBusy) {
                    jamie[0] = intervals[j][0];
                    jamie[1] = intervals[j][1];
                    schedule[j] = "J";
                } else {
                    impossible = true;
                    break;
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
}