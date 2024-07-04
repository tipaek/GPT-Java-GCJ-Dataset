import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][3];

            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int endC = 0, endJ = 0;
            boolean isImpossible = false;
            char[] schedule = new char[n];

            for (int[] activity : activities) {
                if (endC <= activity[0]) {
                    endC = activity[1];
                    schedule[activity[2]] = 'C';
                } else if (endJ <= activity[0]) {
                    endJ = activity[1];
                    schedule[activity[2]] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            System.out.print("Case #" + caseNum + ": ");
            if (isImpossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(new String(schedule));
            }
        }
    }
}