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

            int endC = 0, endJ = 0;
            boolean isImpossible = false;
            char[] schedule = new char[activityCount];

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

            if (isImpossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                for (char c : schedule) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}