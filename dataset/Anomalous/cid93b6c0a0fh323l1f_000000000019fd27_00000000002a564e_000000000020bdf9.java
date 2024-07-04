import java.io.*;
import java.util.*;

class Parent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][3];

            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }

            Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));

            int endC = 0, endJ = 0;
            boolean isImpossible = false;
            char[] schedule = new char[numActivities];

            for (int i = 0; i < numActivities; i++) {
                if (endC <= activities[i][0]) {
                    endC = activities[i][1];
                    schedule[activities[i][2]] = 'C';
                } else if (endJ <= activities[i][0]) {
                    endJ = activities[i][1];
                    schedule[activities[i][2]] = 'J';
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (t + 1) + ": ");
                for (char ch : schedule) {
                    System.out.print(ch);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}