import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                System.out.print("Case #" + t + ": ");
                int numActivities = scanner.nextInt();
                boolean[] cameronSchedule = new boolean[1440];
                boolean[] jamieSchedule = new boolean[1440];
                boolean isImpossible = false;
                StringBuilder schedule = new StringBuilder();

                for (int i = 0; i < numActivities; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    boolean canAssignToCameron = true;
                    boolean canAssignToJamie = true;

                    for (int j = start; j < end; j++) {
                        if (cameronSchedule[j]) {
                            canAssignToCameron = false;
                            break;
                        }
                    }

                    for (int j = start; j < end; j++) {
                        if (jamieSchedule[j]) {
                            canAssignToJamie = false;
                            break;
                        }
                    }

                    if (canAssignToCameron) {
                        for (int j = start; j < end; j++) {
                            cameronSchedule[j] = true;
                        }
                        schedule.append("C");
                    } else if (canAssignToJamie) {
                        for (int j = start; j < end; j++) {
                            jamieSchedule[j] = true;
                        }
                        schedule.append("J");
                    } else {
                        isImpossible = true;
                        break;
                    }
                }

                if (isImpossible) {
                    System.out.println("IMPOSSIBLE");
                } else {
                    System.out.println(schedule.toString());
                }
            }
        }
    }
}