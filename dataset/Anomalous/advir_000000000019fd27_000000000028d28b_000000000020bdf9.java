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

            int[] jamieSchedule = new int[1440];
            int[] cameronSchedule = new int[1440];
            String[] result = new String[m];
            boolean isPossible = true;

            System.out.print("Case #" + (i + 1) + ": ");

            for (int j = 0; j < m; j++) {
                int start = intervals[j][0];
                int end = intervals[j][1];
                boolean jamieBusy = false;
                boolean cameronBusy = false;

                for (int k = start; k < end; k++) {
                    if (jamieSchedule[k] != 0) {
                        jamieBusy = true;
                        break;
                    }
                }

                if (!jamieBusy) {
                    for (int k = start; k < end; k++) {
                        jamieSchedule[k] = 1;
                    }
                    result[j] = "J";
                } else {
                    for (int k = start; k < end; k++) {
                        if (cameronSchedule[k] != 0) {
                            cameronBusy = true;
                            break;
                        }
                    }

                    if (!cameronBusy) {
                        for (int k = start; k < end; k++) {
                            cameronSchedule[k] = 1;
                        }
                        result[j] = "C";
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) {
                for (String res : result) {
                    System.out.print(res);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}