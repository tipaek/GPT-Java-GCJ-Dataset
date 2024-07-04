import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int t1 = 0; t1 < t; t1++) {
            int n = sc.nextInt();
            int[][] activities = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                activities[i][0] = sc.nextInt();
                activities[i][1] = sc.nextInt();
                activities[i][2] = i;
            }
            
            // Sort activities by start time, then by end time if start times are equal
            java.util.Arrays.sort(activities, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
            
            int[] assignments = new int[n];
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            int cameronEnd = 0, jamieEnd = 0;
            
            for (int i = 0; i < n; i++) {
                if (activities[i][0] >= cameronEnd) {
                    assignments[activities[i][2]] = 0;
                    cameronEnd = activities[i][1];
                } else if (activities[i][0] >= jamieEnd) {
                    assignments[activities[i][2]] = 1;
                    jamieEnd = activities[i][1];
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (!isPossible) {
                System.out.println("Case #" + (t1 + 1) + ": IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    result.append(assignments[i] == 0 ? 'C' : 'J');
                }
                System.out.println("Case #" + (t1 + 1) + ": " + result.toString());
            }
        }
        sc.close();
    }
}