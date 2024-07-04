import java.io.*;
import java.util.*;

public class Parent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][3];

            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int endTimeC = 0;
            int endTimeJ = 0;
            boolean isImpossible = false;
            char[] schedule = new char[activityCount];

            for (int[] activity : activities) {
                if (endTimeC <= activity[0]) {
                    endTimeC = activity[1];
                    schedule[activity[2]] = 'C';
                } else if (endTimeJ <= activity[0]) {
                    endTimeJ = activity[1];
                    schedule[activity[2]] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                System.out.println(new String(schedule));
            }
        }
    }
}