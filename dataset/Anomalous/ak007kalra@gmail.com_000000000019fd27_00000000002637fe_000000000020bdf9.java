import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int t = input.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = input.nextInt();
                int[][] intervals = new int[n][2];

                for (int j = 0; j < n; j++) {
                    intervals[j][0] = input.nextInt();
                    intervals[j][1] = input.nextInt();
                }

                int[] c = new int[2];
                int[] j = new int[2];
                StringBuilder schedule = new StringBuilder("C");

                c[0] = intervals[0][0];
                c[1] = intervals[0][1];

                boolean possible = true;

                for (int k = 1; k < n; k++) {
                    int start = intervals[k][0];
                    int end = intervals[k][1];

                    if (start >= c[1]) {
                        schedule.append("C");
                        c[0] = start;
                        c[1] = end;
                    } else if (start >= j[1]) {
                        schedule.append("J");
                        j[0] = start;
                        j[1] = end;
                    } else if (end <= c[0]) {
                        schedule.append("C");
                        c[0] = start;
                        c[1] = end;
                    } else {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    System.out.println("Case #" + i + ": " + schedule.toString());
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            input.close();
        }
    }
}