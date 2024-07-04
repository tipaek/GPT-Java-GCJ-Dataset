import java.util.*;
import java.io.*;

public class Solution {
    
    public static void sortTime(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
    }
    
    public static void sortImp(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[3], b[3]));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][4];

            for (int i = 0; i < n; i++) {
                activities[i][3] = i;
                for (int j = 0; j < 2; j++) {
                    activities[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                activities[i][2] = 0;
            }

            sortTime(activities);
            boolean impossible = false;
            int cameronEndTime = activities[0][1];
            int jamieEndTime = 0;
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < n - 2; i++) {
                if (activities[i][1] > activities[i + 1][0] && activities[i][1] > activities[i + 2][0] && activities[i + 1][1] > activities[i + 2][0]) {
                    impossible = true;
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    break;
                }
            }

            if (!impossible) {
                for (int i = 1; i < n; i++) {
                    if (activities[i][0] < cameronEndTime) {
                        activities[i][2] = 1;
                        jamieEndTime = activities[i][1];
                    } else {
                        activities[i][2] = 0;
                        cameronEndTime = activities[i][1];
                    }
                }

                sortImp(activities);

                for (int i = 0; i < n; i++) {
                    if (activities[i][2] == 0) {
                        schedule.append("C");
                    } else {
                        schedule.append("J");
                    }
                }

                System.out.println("Case #" + caseNumber + ": " + schedule);
            }

            caseNumber++;
        }

        scanner.close();
    }
}