import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];
            boolean possible = true;
            StringBuilder result = new StringBuilder("C");

            int activities = in.nextInt();
            int start = in.nextInt();
            int end = in.nextInt();

            for (int j = start; j <= end; j++) {
                cameronSchedule[j] = true;
            }

            for (int j = 2; j <= activities; j++) {
                boolean cameronAvailable = true;
                boolean jamieAvailable = true;

                start = in.nextInt();
                end = in.nextInt();

                for (int k = start + 1; k <= end; k++) {
                    if (cameronSchedule[k]) {
                        cameronAvailable = false;
                        break;
                    }
                }

                if (cameronAvailable) {
                    for (int k = start; k <= end; k++) {
                        cameronSchedule[k] = true;
                    }
                    result.append("C");
                } else {
                    for (int k = start + 1; k <= end; k++) {
                        if (jamieSchedule[k]) {
                            jamieAvailable = false;
                            break;
                        }
                    }

                    if (jamieAvailable) {
                        for (int k = start; k <= end; k++) {
                            jamieSchedule[k] = true;
                        }
                        result.append("J");
                    }
                }

                if (!cameronAvailable && !jamieAvailable) {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}