import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;

        while (caseNumber <= t) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder Cday = new StringBuilder("0".repeat(24 * 60));
            StringBuilder Jday = new StringBuilder("0".repeat(24 * 60));

            int[][] time = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().trim().split("\\s+");
                time[i][0] = Integer.parseInt(str[0]);
                time[i][1] = Integer.parseInt(str[1]);
            }

            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int start = time[i][0];
                int end = time[i][1];

                if (Cday.substring(start, end).indexOf('1') == -1) {
                    result.append('C');
                    setDaySchedule(Cday, start, end, '1');
                } else if (Jday.substring(start, end).indexOf('2') == -1) {
                    result.append('J');
                    setDaySchedule(Jday, start, end, '2');
                } else {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + caseNumber + ": " + result);
            }
            caseNumber++;
        }
    }

    private static void setDaySchedule(StringBuilder day, int start, int end, char c) {
        for (int j = start; j < end; j++) {
            day.setCharAt(j, c);
        }
    }
}