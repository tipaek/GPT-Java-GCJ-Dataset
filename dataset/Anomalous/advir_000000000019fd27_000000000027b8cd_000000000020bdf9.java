import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            int[][] intervals = new int[m][2];
            for (int j = 0; j < m; j++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[j][0] = Integer.parseInt(input[0]);
                intervals[j][1] = Integer.parseInt(input[1]);
            }

            int[] jamie = {-1, -1};
            int[] cameron = {-1, -1};
            String[] schedule = new String[m];
            boolean impossible = false;

            for (int j = 0; j < m; j++) {
                boolean cbusy = false;
                boolean jbusy = false;

                for (int k = 0; k < j; k++) {
                    if (intervals[k][0] < intervals[j][1] && intervals[j][0] < intervals[k][1]) {
                        if ("C".equals(schedule[k])) {
                            cbusy = true;
                        } else if ("J".equals(schedule[k])) {
                            jbusy = true;
                        }
                    }
                }

                if ((intervals[j][0] < cameron[1] && intervals[j][1] > cameron[0]) || cbusy) {
                    if ((intervals[j][0] < jamie[1] && intervals[j][1] > jamie[0]) || jbusy) {
                        impossible = true;
                        break;
                    } else {
                        jamie[0] = intervals[j][0];
                        jamie[1] = intervals[j][1];
                        schedule[j] = "J";
                    }
                } else {
                    cameron[0] = intervals[j][0];
                    cameron[1] = intervals[j][1];
                    schedule[j] = "C";
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