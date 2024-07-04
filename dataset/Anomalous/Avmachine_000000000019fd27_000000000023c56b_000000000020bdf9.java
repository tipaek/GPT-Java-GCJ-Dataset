import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder ans = new StringBuilder();

        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            int cameronStart = 0, cameronEnd = 0, jamieStart = 0, jamieEnd = 0;
            int cameronCount = 0, jamieCount = 0;
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();

                if (!schedule.toString().equals("IMPOSSIBLE")) {
                    if (cameronEnd <= start[i] || cameronStart >= end[i]) {
                        schedule.append("C");
                        cameronStart = Math.min(cameronStart, start[i]);
                        cameronEnd = Math.max(cameronEnd, end[i]);
                        cameronCount++;
                    } else if (jamieEnd <= start[i] || jamieStart >= end[i]) {
                        schedule.append("J");
                        jamieStart = Math.min(jamieStart, start[i]);
                        jamieEnd = Math.max(jamieEnd, end[i]);
                        jamieCount++;
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                    }
                }
            }

            ans.append("Case #").append(x).append(": ").append(schedule);
            if (x != t) {
                ans.append("\n");
            }
        }

        System.out.print(ans);
    }
}