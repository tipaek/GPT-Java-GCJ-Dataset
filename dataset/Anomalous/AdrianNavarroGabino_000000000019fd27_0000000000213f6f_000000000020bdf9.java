import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int index = 1; index <= cases; index++) {
            int numOfActivities = scanner.nextInt();
            int[][] activities = new int[numOfActivities][3];
            char[] assigned = new char[numOfActivities];

            for (int i = 0; i < numOfActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int cEnds = 0;
            int jEnds = 0;
            boolean possible = true;

            for (int i = 0; i < numOfActivities; i++) {
                if (activities[i][0] >= cEnds) {
                    cEnds = activities[i][1];
                    assigned[activities[i][2]] = 'C';
                } else if (activities[i][0] >= jEnds) {
                    jEnds = activities[i][1];
                    assigned[activities[i][2]] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(assigned) : "IMPOSSIBLE";
            System.out.println("Case #" + index + ": " + result);
        }

        scanner.close();
    }
}