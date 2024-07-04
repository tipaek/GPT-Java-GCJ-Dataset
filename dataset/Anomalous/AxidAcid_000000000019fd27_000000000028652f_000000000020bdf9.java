package Competion.Questions;

import java.util.Scanner;

public class CodeJamParenting {

    public static boolean checkOverlap(int start1, int end1, int start2, int end2) {
        return (start2 <= end1 && end2 >= start1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int r = 1; r <= t; r++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt(); // start time
                intervals[i][1] = sc.nextInt(); // end time
                intervals[i][2] = -1; // -1 indicates unassigned
            }

            boolean impossible = false;

            for (int i = 0; i < n && !impossible; i++) {
                if (intervals[i][2] == -1) {
                    intervals[i][2] = 0; // Assign 'C' initially
                }

                for (int j = i + 1; j < n; j++) {
                    if (checkOverlap(intervals[i][0], intervals[i][1], intervals[j][0], intervals[j][1])) {
                        if (intervals[j][2] == -1) {
                            intervals[j][2] = 1 - intervals[i][2]; // Alternate between 'C' (0) and 'J' (1)
                        } else if (intervals[j][2] == intervals[i][2]) {
                            impossible = true;
                            break;
                        }
                    }
                }
            }

            System.out.print("Case #" + r + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    System.out.print(intervals[i][2] == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}