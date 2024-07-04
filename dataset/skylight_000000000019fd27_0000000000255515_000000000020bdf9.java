import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tt = 0; tt < t; tt++) {
            int n = sc.nextInt(), jamie = 0, cameron = 0;
            int[][] activities = new int[n][3];
            StringBuilder assignment = new StringBuilder(n);
            for(int i = 0; i < n; i++) {
                assignment.append(" ");
                activities[i][0] = sc.nextInt();
                activities[i][1] = sc.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(o -> o[0]));
            for(int i = 0; i < n; i++) {
                if(jamie <= activities[i][0]) {
                    jamie = activities[i][1];
                    assignment.setCharAt(activities[i][2],'J');
                } else if(cameron <= activities[i][0]) {
                    cameron = activities[i][1];
                    assignment.setCharAt(activities[i][2],'C');
                } else {
                    assignment = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println(String.format("Case #%d: %s", tt+1, assignment));
        }
    }
}
