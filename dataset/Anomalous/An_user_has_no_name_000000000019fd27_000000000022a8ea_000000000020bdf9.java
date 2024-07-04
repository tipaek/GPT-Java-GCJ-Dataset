import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases

        for (int i = 1; i <= t; i++) {
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];
            boolean possible = true;
            StringBuilder result = new StringBuilder("C");

            int n = in.nextInt(); // Number of activities
            int start = in.nextInt();
            int end = in.nextInt();

            // Assign the first activity to Cameron
            Arrays.fill(cameronSchedule, start, end + 1, true);

            for (int j = 2; j <= n; j++) {
                boolean canAssignToCameron = true;
                boolean canAssignToJamie = true;

                start = in.nextInt();
                end = in.nextInt();

                if (possible) {
                    // Check if Cameron can take this activity
                    for (int k = start + 1; k <= end; k++) {
                        if (cameronSchedule[k]) {
                            canAssignToCameron = false;
                            break;
                        }
                    }

                    if (canAssignToCameron) {
                        Arrays.fill(cameronSchedule, start, end + 1, true);
                        result.append("C");
                    } else {
                        // Check if Jamie can take this activity
                        for (int k = start + 1; k <= end; k++) {
                            if (jamieSchedule[k]) {
                                canAssignToJamie = false;
                                break;
                            }
                        }

                        if (canAssignToJamie) {
                            Arrays.fill(jamieSchedule, start, end + 1, true);
                            result.append("J");
                        }
                    }

                    if (!canAssignToCameron && !canAssignToJamie) {
                        result = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}