import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] jamie = new int[n][2];
            int[][] cameron = new int[n][2];
            int jamieCount = 0, cameronCount = 0;
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (possible) {
                    if (isAvailable(jamie, start, end, jamieCount)) {
                        schedule.append("J");
                        jamie[jamieCount][0] = start;
                        jamie[jamieCount++][1] = end;
                    } else if (isAvailable(cameron, start, end, cameronCount)) {
                        schedule.append("C");
                        cameron[cameronCount][0] = start;
                        cameron[cameronCount++][1] = end;
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                    }
                }
            }
            System.out.println("Case #" + (t + 1) + ": " + schedule);
        }
    }

    private static boolean isAvailable(int[][] schedule, int start, int end, int count) {
        for (int i = 0; i < count; i++) {
            if ((start < schedule[i][1] && end > schedule[i][0]) || 
                (start >= schedule[i][0] && end <= schedule[i][1])) {
                return false;
            }
        }
        return true;
    }
}