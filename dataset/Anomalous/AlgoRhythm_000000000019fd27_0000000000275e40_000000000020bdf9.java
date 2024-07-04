import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int intervals = scanner.nextInt();
            int[] jamieSchedule = new int[1440];
            int[] cameronSchedule = new int[1440];
            Arrays.fill(jamieSchedule, 0);
            Arrays.fill(cameronSchedule, 0);
            StringBuilder result = new StringBuilder();

            boolean impossible = false;

            for (int i = 0; i < intervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (impossible) continue;

                boolean canAssignToJamie = true;
                for (int j = start; j < end; j++) {
                    if (jamieSchedule[j] == 1) {
                        canAssignToJamie = false;
                        break;
                    }
                }

                if (canAssignToJamie) {
                    Arrays.fill(jamieSchedule, start, end, 1);
                    result.append('C');
                } else {
                    boolean canAssignToCameron = true;
                    for (int j = start; j < end; j++) {
                        if (cameronSchedule[j] == 1) {
                            canAssignToCameron = false;
                            break;
                        }
                    }

                    if (canAssignToCameron) {
                        Arrays.fill(cameronSchedule, start, end, 1);
                        result.append('J');
                    } else {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        impossible = true;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}