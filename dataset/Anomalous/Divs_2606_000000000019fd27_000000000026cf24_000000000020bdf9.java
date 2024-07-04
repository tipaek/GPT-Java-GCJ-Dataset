import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            int[] lastEndTimes = new int[2]; // lastEndTimes[0] for C, lastEndTimes[1] for J
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;
            
            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= lastEndTimes[0]) {
                    lastEndTimes[0] = intervals[i][1];
                    schedule.append('C');
                } else if (intervals[i][0] >= lastEndTimes[1]) {
                    lastEndTimes[1] = intervals[i][1];
                    schedule.append('J');
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
        }
    }
}