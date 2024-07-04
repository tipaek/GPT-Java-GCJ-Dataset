import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            boolean[] cAvailability = new boolean[1440];
            boolean[] jAvailability = new boolean[1440];
            String result = "";

            boolean possible = true;

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (int k = start; k < end; k++) {
                    if (cAvailability[k]) {
                        canAssignC = false;
                    }
                    if (jAvailability[k]) {
                        canAssignJ = false;
                    }
                }

                if (canAssignC) {
                    Arrays.fill(cAvailability, start, end, true);
                    result += "C";
                } else if (canAssignJ) {
                    Arrays.fill(jAvailability, start, end, true);
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + i + ": " + result);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}