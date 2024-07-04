import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[][] c = new int[N][2];
            int[][] j = new int[N][2];
            int cCount = 0;
            int jCount = 0;
            StringBuilder order = new StringBuilder();

            for (int n = 0; n < N; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (hasTime(start, end, c, cCount)) {
                    c[cCount][0] = start;
                    c[cCount][1] = end;
                    cCount++;
                    order.append('C');
                } else if (hasTime(start, end, j, jCount)) {
                    j[jCount][0] = start;
                    j[jCount][1] = end;
                    jCount++;
                    order.append('J');
                }
            }
        }
    }

    static boolean hasTime(int start, int end, int[][] schedule, int count) {
        for (int i = 0; i < count; i++) {
            if ((start > schedule[i][0] && start < schedule[i][1]) || (end > schedule[i][0] && end < schedule[i][1])) {
                return false;
            }
        }
        return true;
    }
}