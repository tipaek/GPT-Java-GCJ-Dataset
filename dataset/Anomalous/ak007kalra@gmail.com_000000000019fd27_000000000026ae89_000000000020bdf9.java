import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int t = input.nextInt();
            testCases: for (int i = 1; i <= t; i++) {
                int n = input.nextInt();
                int[][] activities = new int[n][2];
                for (int j = 0; j < n; j++) {
                    activities[j][0] = input.nextInt();
                    activities[j][1] = input.nextInt();
                }

                StringBuilder schedule = new StringBuilder();
                int[] cEnd = new int[]{0, 0}; // Cameron's end time
                int[] jEnd = new int[]{0, 0}; // Jamie's end time

                schedule.append('C');
                cEnd[0] = activities[0][0];
                cEnd[1] = activities[0][1];

                for (int j = 1; j < n; j++) {
                    int start = activities[j][0];
                    int end = activities[j][1];

                    if (start >= cEnd[1]) {
                        schedule.append('C');
                        cEnd[0] = start;
                        cEnd[1] = end;
                    } else if (start >= jEnd[1]) {
                        schedule.append('J');
                        jEnd[0] = start;
                        jEnd[1] = end;
                    } else if (start >= jEnd[0] && end <= jEnd[1]) {
                        schedule.append('J');
                        jEnd[0] = start;
                        jEnd[1] = end;
                    } else if (start >= cEnd[0] && end <= cEnd[1]) {
                        schedule.append('C');
                        cEnd[0] = start;
                        cEnd[1] = end;
                    } else {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        continue testCases;
                    }
                }
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}