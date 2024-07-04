import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());

        for (int test = 1; test <= cases; test++) {
            int N = Integer.parseInt(sc.nextLine());
            int[][] activities = new int[N][3];

            for (int i = 0; i < N; i++) {
                String[] input = sc.nextLine().split("\\s");
                activities[i][0] = Integer.parseInt(input[0]);
                activities[i][1] = Integer.parseInt(input[1]);
                activities[i][2] = i;
            }

            // Sort activities by starting time
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            String[] assignedActivity = new String[N];
            int endC = 0, endJ = 0;
            boolean possible = true;

            for (int i = 0; i < N; i++) {
                if (activities[i][0] >= endC) {
                    assignedActivity[activities[i][2]] = "C";
                    endC = activities[i][1];
                } else if (activities[i][0] >= endJ) {
                    assignedActivity[activities[i][2]] = "J";
                    endJ = activities[i][1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                StringBuilder result = new StringBuilder();
                for (String activity : assignedActivity) {
                    result.append(activity);
                }
                System.out.println("Case #" + test + ": " + result);
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }
}