import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];
            StringBuilder result = new StringBuilder();
            boolean possible = true;

            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                boolean canAssignToCameron = true;
                boolean canAssignToJamie = true;

                // Check Cameron's schedule
                for (int k = start; k < end; k++) {
                    if (cameronSchedule[k]) {
                        canAssignToCameron = false;
                        break;
                    }
                }

                // Check Jamie's schedule if Cameron's is not possible
                if (!canAssignToCameron) {
                    for (int k = start; k < end; k++) {
                        if (jamieSchedule[k]) {
                            canAssignToJamie = false;
                            break;
                        }
                    }
                }

                // Assign the task to Cameron or Jamie
                if (canAssignToCameron) {
                    for (int k = start; k < end; k++) {
                        cameronSchedule[k] = true;
                    }
                    result.append('C');
                } else if (canAssignToJamie) {
                    for (int k = start; k < end; k++) {
                        jamieSchedule[k] = true;
                    }
                    result.append('J');
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}